package com.dgw.sgco;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.domain.agendamento.Procedimento;
import com.dgw.sgco.domain.enums.StatusAgendamento;
import com.dgw.sgco.repositories.agendamento.AgendamentoRepository;
import com.dgw.sgco.repositories.agendamento.ProcedimentoRepository;

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

	public static void main(String[] args) {
		SpringApplication.run(SgcoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Procedimento proc1 = new Procedimento(null, "Tratamento de Canal", new BigDecimal(1200), true);
		Procedimento proc2 = new Procedimento(null, "Extração de Dentes", new BigDecimal(200), true);
		Procedimento proc3 = new Procedimento(null, "Raio-X", new BigDecimal(100), false);

		Agendamento a1 = new Agendamento(null, "Dor de dente", "Dente inflamado", null, null, new Date(), new Date(), "Teste", StatusAgendamento.CONFIRMADO);

		procedimentoRepository.saveAll(Arrays.asList(proc1, proc2, proc3));
		agendamentoRepository.saveAll(Arrays.asList(a1));

	}

}
