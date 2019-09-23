package com.dgw.sgco;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.domain.agendamento.Procedimento;
import com.dgw.sgco.domain.agendamento.ProcedimentoAgendado;
import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.domain.enums.Permissao;
import com.dgw.sgco.domain.enums.StatusAgendamento;
import com.dgw.sgco.domain.enums.StatusMovimentacao;
import com.dgw.sgco.domain.enums.StatusParcela;
import com.dgw.sgco.domain.enums.TipoConta;
import com.dgw.sgco.domain.enums.TipoFuncionario;
import com.dgw.sgco.domain.enums.TipoMovimentacao;
import com.dgw.sgco.domain.financeiro.Conta;
import com.dgw.sgco.domain.financeiro.Movimentacao;
import com.dgw.sgco.domain.financeiro.Parcela;
import com.dgw.sgco.domain.pessoa.Anotacao;
import com.dgw.sgco.domain.pessoa.Cidade;
import com.dgw.sgco.domain.pessoa.Contato;
import com.dgw.sgco.domain.pessoa.Endereco;
import com.dgw.sgco.domain.pessoa.Estado;
import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.domain.pessoa.Paciente;
import com.dgw.sgco.domain.pessoa.Pais;
import com.dgw.sgco.repositories.agendamento.AgendamentoRepository;
import com.dgw.sgco.repositories.agendamento.ProcedimentoAgendadoRepository;
import com.dgw.sgco.repositories.agendamento.ProcedimentoRepository;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.repositories.financeiro.ContaRepository;
import com.dgw.sgco.repositories.financeiro.MovimentacaoRepository;
import com.dgw.sgco.repositories.financeiro.ParcelaRepository;
import com.dgw.sgco.repositories.pessoa.AnotacaoRepository;
import com.dgw.sgco.repositories.pessoa.CidadeRepository;
import com.dgw.sgco.repositories.pessoa.ContatoRepository;
import com.dgw.sgco.repositories.pessoa.EnderecoRepository;
import com.dgw.sgco.repositories.pessoa.EstadoRepository;
import com.dgw.sgco.repositories.pessoa.FuncionarioRepository;
import com.dgw.sgco.repositories.pessoa.PacienteRepository;
import com.dgw.sgco.repositories.pessoa.PaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
public class SgcoApplication implements CommandLineRunner, WebMvcConfigurer {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ContatoRepository contatoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private AnotacaoRepository anotacaoRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private ParcelaRepository parcelaRepository;
	@Autowired
	private ProcedimentoAgendadoRepository procedimentoAgendadoRepository;

	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SpecificationArgumentResolver());
    }

	public static void main(String[] args) {
		SpringApplication.run(SgcoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Calendar calendario = new GregorianCalendar();

		Procedimento proc1 = new Procedimento(null, "Tratamento de Canal", new BigDecimal(1200), true);
		Procedimento proc2 = new Procedimento(null, "Extração de Dentes", new BigDecimal(200), true);
		Procedimento proc3 = new Procedimento(null, "Raio-X", new BigDecimal(100), false);

		Usuario user1 = new Usuario(null, "geovaninieswald@gmail.com", "sfadssadas", true, "sadhsajkdhsajk");
		user1.getPermissoes().addAll(Arrays.asList(Permissao.DENTISTA));

		Pais p1 = new Pais(1, "Brasil", "BR");

		Estado e1 = new Estado(null, "Rio Grande do Sul", "RS", p1);
		Estado e2 = new Estado(null, "Santa Catarina", "SC", p1);

		Cidade c1 = new Cidade(null, "Santa Rosa", e1);
		Cidade c2 = new Cidade(null, "Ubiretama", e1);
		Cidade c3 = new Cidade(null, "Brusque", e2);

		p1.getEstados().addAll(Arrays.asList(e1, e2));
		e1.getCidades().addAll(Arrays.asList(c1, c2));
		e2.getCidades().addAll(Arrays.asList(c3));

		Endereco end1 = new Endereco(null, "Rua Roberto Jesse", "Timbaúva", "200", "98781416", "Casa da esquerda", c1);
		Endereco end2 = new Endereco(null, "Rua Roberto Jesse", "Timbaúva", "200", "98781416", "Casa da esquerda", c1);

		Contato cont1 = new Contato(null, "geovaninieswald@gmail.com", "(55) 99624-6352");
		Contato cont2 = new Contato(null, "geovaninieswald@gmail.com", "(55) 99624-6352");

		calendario.set(1996, 4, 30);
		Paciente pac1 = new Paciente(null, "Geovani Alex Nieswald", "036.084.580-00", "M", calendario.getTime(), cont1, end1);

		Map<String, Object> odontograma = new HashMap<>();
		odontograma.put("teste", 10);

		Anotacao an1 = new Anotacao(null, "Teste de anotação", pac1);

		pac1.getAnotacoes().addAll(Arrays.asList(an1));
		pac1.setOdontograma(odontograma);

		Funcionario f1 = new Funcionario(null, "Geovani Alex Nieswald", "036.084.580-00", "9111083532", "M", calendario.getTime(), true, TipoFuncionario.DENTISTA, "RED", "9999", cont2, end2, user1);

		Agendamento a1 = new Agendamento(null, "Dor de dente", "Dente inflamado", new Date(), new Date(), "Teste", StatusAgendamento.CONFIRMADO, pac1, f1);

		Conta co1 = new Conta(null, "NuBank", TipoConta.CARTAO, true);

		Movimentacao mov1 = new Movimentacao(null, "Agendamento 1", TipoMovimentacao.CONTA_RECEBER, StatusMovimentacao.CRIADA, co1, a1);

		Parcela pa1 = new Parcela(null, new Date(), new BigDecimal(200), StatusParcela.CRIADA, mov1);

		mov1.getParcelas().addAll(Arrays.asList(pa1));
		a1.getMovimentacoes().addAll(Arrays.asList(mov1));

		ProcedimentoAgendado procAgen1 = new ProcedimentoAgendado(proc1, a1, proc1.getValor(), new BigDecimal(1), BigDecimal.ZERO);
		ProcedimentoAgendado procAgen2 = new ProcedimentoAgendado(proc2, a1, proc2.getValor(), new BigDecimal(1), BigDecimal.ZERO);

		a1.getProcedimentos().addAll(Arrays.asList(procAgen1, procAgen2));

		proc1.getProcedimentos().addAll(Arrays.asList(procAgen1));
		proc2.getProcedimentos().addAll(Arrays.asList(procAgen2));

		procedimentoRepository.saveAll(Arrays.asList(proc1, proc2, proc3));
		usuarioRepository.saveAll(Arrays.asList(user1));
		paisRepository.saveAll(Arrays.asList(p1));
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		contatoRepository.saveAll(Arrays.asList(cont1, cont2));
		pacienteRepository.saveAll(Arrays.asList(pac1));
		anotacaoRepository.saveAll(Arrays.asList(an1));
		funcionarioRepository.saveAll(Arrays.asList(f1));
		agendamentoRepository.saveAll(Arrays.asList(a1));

		contaRepository.saveAll(Arrays.asList(co1));
		movimentacaoRepository.saveAll(Arrays.asList(mov1));
		parcelaRepository.saveAll(Arrays.asList(pa1));

		procedimentoAgendadoRepository.saveAll(Arrays.asList(procAgen1, procAgen2));

	}
}
