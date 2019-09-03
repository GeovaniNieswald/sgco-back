package com.dgw.sgco;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.domain.agendamento.Procedimento;
import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.domain.enums.Permissao;
import com.dgw.sgco.domain.enums.StatusAgendamento;
import com.dgw.sgco.domain.pessoa.Cidade;
import com.dgw.sgco.domain.pessoa.Estado;
import com.dgw.sgco.domain.pessoa.Pais;
import com.dgw.sgco.repositories.agendamento.AgendamentoRepository;
import com.dgw.sgco.repositories.agendamento.ProcedimentoRepository;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.repositories.pessoa.CidadeRepository;
import com.dgw.sgco.repositories.pessoa.EstadoRepository;
import com.dgw.sgco.repositories.pessoa.PaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SgcoApplication implements CommandLineRunner {

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

	public static void main(String[] args) {
		SpringApplication.run(SgcoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// agendamento
		Procedimento proc1 = new Procedimento(null, "Tratamento de Canal", new BigDecimal(1200), true);
		Procedimento proc2 = new Procedimento(null, "Extração de Dentes", new BigDecimal(200), true);
		Procedimento proc3 = new Procedimento(null, "Raio-X", new BigDecimal(100), false);

		Agendamento a1 = new Agendamento(null, "Dor de dente", "Dente inflamado", new Date(), new Date(), "Teste",
				StatusAgendamento.CONFIRMADO);

		procedimentoRepository.saveAll(Arrays.asList(proc1, proc2, proc3));
		agendamentoRepository.saveAll(Arrays.asList(a1));

		// autenticacao
		Usuario user1 = new Usuario(null, "geovaninieswald@gmail.com", "sfadssadas", true, "sadhsajkdhsajk");
		user1.getPermissoes().addAll(Arrays.asList(Permissao.DESENVOLVEDOR, Permissao.ADMINISTRADOR));

		usuarioRepository.saveAll(Arrays.asList(user1));

		// pessoa
		Pais p1 = new Pais(1, "Brasil", "BR");

		Estado e1 = new Estado(null, "Rio Grande do Sul", "RS", p1);
		Estado e2 = new Estado(null, "Santa Catarina", "SC", p1);

		Cidade c1 = new Cidade(null, "Santa Rosa", e1);
		Cidade c2 = new Cidade(null, "Ubiretama", e1);
		Cidade c3 = new Cidade(null, "Brusque", e2);

		p1.getEstados().addAll(Arrays.asList(e1, e2));
		e1.getCidades().addAll(Arrays.asList(c1, c2));
		e2.getCidades().addAll(Arrays.asList(c3));

		paisRepository.saveAll(Arrays.asList(p1));
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

	}
}
