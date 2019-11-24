package com.dgw.sgco.services.autenticacao;

import java.util.Optional;

import javax.transaction.Transactional;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.domain.enums.TipoFuncionario;
import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.dto.autenticacao.AlterarSenhaDTO;
import com.dgw.sgco.dto.autenticacao.UsuarioPerfilDTO;
import com.dgw.sgco.dto.pessoa.ContatoDTO;
import com.dgw.sgco.dto.pessoa.EnderecoDTO;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.repositories.pessoa.FuncionarioRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;
import com.dgw.sgco.services.exceptions.PasswordException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;
    @Autowired
    private FuncionarioRepository funcionarioRepo;
    @Autowired
    private BCryptPasswordEncoder pe;

    /**
     * Buscar Usuário por id
     * 
     * @param id - Integer
     * @return Usuário
     */
    public Usuario find(Integer id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    public void alterarSenha(AlterarSenhaDTO objDto) {
        Usuario user = repo.findByLogin(objDto.getEmail());

        if (user == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String novaSenha = objDto.getNova();
        String senhaConf = objDto.getConfirmacao();
        String senhaAntigaObj = objDto.getAntiga();

        if (!novaSenha.equals(senhaConf)) {
            throw new PasswordException("Nova senha e senha de confirmação não são iguais");
        }

        String senhaAntigaCryp = user.getSenha();

        if (!pe.matches(senhaAntigaObj, senhaAntigaCryp)) {
            throw new PasswordException("Senha antiga incorreta");
        }

        user.setSenha(pe.encode(objDto.getNova()));

        repo.save(user);
    }

    public UsuarioPerfilDTO findPerfil(String email) {
        UsuarioPerfilDTO objDTO = new UsuarioPerfilDTO();

        Usuario obj = repo.findByLogin(email);

        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Email: " + email + ", Tipo: " + Usuario.class.getName());
        }

        objDTO.setEmail(obj.getLogin());
        objDTO.setImagem(obj.getImagem());

        Funcionario funcionario = funcionarioRepo.findByUsuarioId(obj.getId());

        if (funcionario != null) {
            objDTO.setNome(funcionario.getNome());
            objDTO.setCpf(funcionario.getCpf());
            objDTO.setRg(funcionario.getRg());
            objDTO.setSexo(funcionario.getSexo());
            objDTO.setNascimento(funcionario.getNascimento());
            objDTO.setCrmCro(funcionario.getCrmCro());
            objDTO.setTipo(TipoFuncionario.toEnum(funcionario.getTipo()).getDescricao());

            objDTO.setEndereco(new EnderecoDTO(funcionario.getEndereco()));
            objDTO.setContato(new ContatoDTO(funcionario.getContato()));
        }

        return objDTO;
    }

    /**
     * Excluir um Usuário pelo id
     * 
     * @param id - Integer
     */
    @Transactional
    public void delete(Integer id) {
        find(id);

        Funcionario funcionario = this.funcionarioRepo.findByUsuarioId(id);

        if (funcionario != null) {
            funcionario.setUsuario(null);
        }

        repo.deleteById(id);
    }
}
