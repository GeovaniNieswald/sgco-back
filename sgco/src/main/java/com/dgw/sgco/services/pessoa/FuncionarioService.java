package com.dgw.sgco.services.pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.domain.enums.Permissao;
import com.dgw.sgco.domain.enums.TipoFuncionario;
import com.dgw.sgco.domain.pessoa.Cidade;
import com.dgw.sgco.domain.pessoa.Contato;
import com.dgw.sgco.domain.pessoa.Endereco;
import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.dto.autenticacao.UsuarioDTO;
import com.dgw.sgco.dto.pessoa.FuncionarioDTO;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.repositories.pessoa.ContatoRepository;
import com.dgw.sgco.repositories.pessoa.EnderecoRepository;
import com.dgw.sgco.repositories.pessoa.FuncionarioRepository;
import com.dgw.sgco.resources.specifications.FuncionarioSpec;
import com.dgw.sgco.services.exceptions.DataIntegrityException;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FuncionarioService
 */
@Service
public class FuncionarioService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private FuncionarioRepository funcionarioRepo;
    @Autowired
    private EnderecoRepository enderecoRepo;
    @Autowired
    private ContatoRepository contatoRepo;
    @Autowired
    private UsuarioRepository usuarioRepo;


    /**
     * Inserir um novo Funcionario
     * 
     * @param obj - Funcionario
     * @return Funcionario inserido
     */
    @Transactional
    public Funcionario insert(Funcionario obj) {
        obj.setId(null);
        funcionarioRepo.save(obj);

        enderecoRepo.save(obj.getEndereco());
        contatoRepo.save(obj.getContato());
        usuarioRepo.save(obj.getUsuario());

        return obj;
    }

    /**
     * Alterar um Funcionario
     * 
     * @param obj - Funcionario
     * @return Funcionario alterado
     */
    @Transactional
    public Funcionario update(Funcionario obj) {
        find(obj.getId());

        funcionarioRepo.save(obj);
        contatoRepo.save(obj.getContato());
        usuarioRepo.save(obj.getUsuario());

        return obj;
    }

    /**
     * Excluir um Funcionario pelo id
     * 
     * @param id - Integer
     */
    @Transactional
    public void delete(Integer id) {
        Funcionario funcionario = find(id);

        try {
            funcionarioRepo.deleteById(id);

            enderecoRepo.deleteById(funcionario.getEndereco().getId());
            contatoRepo.deleteById(funcionario.getContato().getId());

            if (funcionario.getUsuario() != null) {
                usuarioRepo.deleteById(funcionario.getUsuario().getId());
            }
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityException("Não é possível excluir um Funcionario que já tenha algum agendamento!");
        }
    }

    /**
     * Buscar Funcionário por id
     * 
     * @param id - Integer
     * @return Funcionario
     */
    public Funcionario find(Integer id) {
        Optional<Funcionario> obj = funcionarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
    }

    /**
     * Buscar todos funcionários
     * 
     * @return List<Funcionario>
     */
    public List<Funcionario> findAll() {
        return funcionarioRepo.findAll();
    }

    /**
     * Buscar funcionários por filtro, de forma páginada
     * 
     * @return Page<Funcionario>
     */
    public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction, FuncionarioSpec funcionarioSpec) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return funcionarioRepo.findAll(funcionarioSpec, pageRequest);
    }

    /**
     * Metódo para converter um FuncionarioDTO em um Funcionario
     * 
     * @param objDTO - FuncionarioDTO
     * @return Funcionario
     * @throws ParseException
     */
    public Funcionario fromDTO(FuncionarioDTO objDTO) throws ParseException {
        Funcionario funcionario = new Funcionario(objDTO.getId(), objDTO.getNome(), objDTO.getCpf(), objDTO.getRg(), objDTO.getSexo(), sdf.parse(objDTO.getNascimento()), objDTO.isAtivo(), TipoFuncionario.toEnum(objDTO.getTipo()), objDTO.getCorAgenda(), objDTO.getCrmCro(), null, null, null);

        Contato contato = new Contato(objDTO.getContato().getId(), objDTO.getContato().getEmail(), objDTO.getContato().getTelefone1());

        if (objDTO.getContato().getTelefone2() != null) {
            contato.setTelefone2(objDTO.getContato().getTelefone2());
        }

        Cidade cidade = new Cidade();
        cidade.setId(objDTO.getEndereco().getIdCidade());

        Endereco endereco = new Endereco(objDTO.getEndereco().getId(), objDTO.getEndereco().getLogradouro(), objDTO.getEndereco().getBairro(), objDTO.getEndereco().getNumero(), objDTO.getEndereco().getCep(), objDTO.getEndereco().getComplemento(), cidade);

        if (objDTO.getUsuario() != null) {
            Usuario usuario = new Usuario(objDTO.getUsuario().getId(), objDTO.getUsuario().getLogin(), objDTO.getUsuario().getSenha(), objDTO.getUsuario().isAtivo(), objDTO.getUsuario().getImagem());

            for (Integer permissao : objDTO.getUsuario().getPermissoes()) {
                usuario.getPermissoes().add(Permissao.toEnum(permissao));
            }

            funcionario.setUsuario(usuario);
        }

        funcionario.setContato(contato);
        funcionario.setEndereco(endereco);

        return funcionario;
    }
}
