package com.dgw.sgco.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * DBService
 */
@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder pe;
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

    /**
     * Método para instânciar dados no banco de dados
     * 
     * @throws ParseException
     */
    public void instantiateDatabase(boolean test) throws ParseException {
        SimpleDateFormat sdfData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfDataHora = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Procedimento procedimento1 = new Procedimento(null, "Tratamento de canal", new BigDecimal(1200), true);
        Procedimento procedimento2 = new Procedimento(null, "Extração de dente", new BigDecimal(200), true);
        Procedimento procedimento3 = new Procedimento(null, "Raio-X", new BigDecimal(100), false);
        Procedimento procedimento4 = new Procedimento(null, "Ortodontia", new BigDecimal(1000), true);
        Procedimento procedimento5 = new Procedimento(null, "Implante dentário", new BigDecimal(900), true);
        Procedimento procedimento6 = new Procedimento(null, "Clareamento", new BigDecimal(500), true);
        Procedimento procedimento7 = new Procedimento(null, "Periodontia", new BigDecimal(150), true);
        Procedimento procedimento8 = new Procedimento(null, "Prótese dentária móvel", new BigDecimal(6500), true);

        Pais brasil = new Pais(1, "Brasil", "BR");

        Estado rs = new Estado(23, "Rio Grande do Sul", "RS", brasil);
        Estado sc = new Estado(24, "Santa Catarina", "SC", brasil);
        Estado pr = new Estado(18, "Paraná", "PR", brasil);

        Cidade santaRosa = new Cidade(4216, "Santa Rosa", rs);
        Cidade ubiretama = new Cidade(4216, "Ubiretama", rs);
        Cidade brusque = new Cidade(4460, "Brusque", sc);
        Cidade patoBranco = new Cidade(3042, "Pato Branco", pr);

        if (test) {
            brasil.setId(null);

            rs.setId(null);
            sc.setId(null);
            pr.setId(null);

            santaRosa.setId(null);
            ubiretama.setId(null);
            brusque.setId(null);
            patoBranco.setId(null);
        }

        brasil.getEstados().addAll(Arrays.asList(rs, sc, pr));

        rs.getCidades().addAll(Arrays.asList(santaRosa, ubiretama));
        sc.getCidades().addAll(Arrays.asList(brusque));
        pr.getCidades().addAll(Arrays.asList(patoBranco));

        Endereco rRocco = new Endereco(null, "Rua Rocco Carpenedo", "Timbaúva", "233", "98781-538", "", santaRosa);
        Endereco rCaxias = new Endereco(null, "Rua Caxias", "Centro", "455", "98900-976", "", santaRosa);
        Endereco rRio = new Endereco(null, "Avenida Rio Branco", "Centro", "471", "98900-970", "", santaRosa);
        Endereco linha15 = new Endereco(null, "Linha 15 de Novembro", "Interior", "160", "98898-000", "", ubiretama);
        Endereco rAdolfo = new Endereco(null, "Rua Adolfo Schlosser", "Centro", "886", "88354-004", "", brusque);
        Endereco rValmor = new Endereco(null, "Rua Valmor Chioquetta", "São João", "696", "85509-564", "", patoBranco);

        Contato contato1 = new Contato(null, "geovaninieswald@gmail.com", "(55) 99624-6352");
        Contato contato2 = new Contato(null, "carlaterezaporto.porto@suplementototal.com.br", "(55) 98864-2589");
        Contato contato3 = new Contato(null, "ggiovannacristianeramos@jetstar.com.br", "(55) 99143-0857");
        Contato contato4 = new Contato(null, "", "(55) 99953-6225");
        Contato contato5 = new Contato(null, "geovani_alex@hotmail.com", "(47) 99143-0857");
        Contato contato6 = new Contato(null, "fatimaadrianamariagomes_@pibnet.com.br", "(47) 98836-1231");

        Paciente carla = new Paciente(null, "Carla Tereza Porto", "523.138.819-03", "F", sdfData.parse("1958-02-24"), contato2, rCaxias);
        Paciente valdemar = new Paciente(null, "Valdemar Nieswald", "861.733.319-77", "M", sdfData.parse("1949-03-02"), contato4, linha15);
        Paciente roberto = new Paciente(null, "Roberto Danilo Carvalho", "615.767.379-69", "M", sdfData.parse("1995-02-08"), contato5, rAdolfo);
        Paciente fatima = new Paciente(null, "Fátima Adriana Maria Gomes", "937.166.789-37", "F", sdfData.parse("1984-04-15"), contato6, rValmor);

        Map<String, Object> odontograma1 = new HashMap<>();
        odontograma1.put("d1", 1457);
        Map<String, Object> odontograma2 = new HashMap<>();
        odontograma2.put("d1", 1457);
        Map<String, Object> odontograma3 = new HashMap<>();
        odontograma3.put("d1", 1457);
        Map<String, Object> odontograma4 = new HashMap<>();
        odontograma4.put("d1", 1457);

        carla.setOdontograma(odontograma1);
        valdemar.setOdontograma(odontograma2);
        roberto.setOdontograma(odontograma3);
        fatima.setOdontograma(odontograma4);

        Anotacao anotacao1 = new Anotacao(null, "Teste de anotação Carla 1", carla);
        Anotacao anotacao2 = new Anotacao(null, "Teste de anotação Carla 2", carla);
        Anotacao anotacao3 = new Anotacao(null, "Teste de anotação Valdemar", valdemar);
        Anotacao anotacao4 = new Anotacao(null, "Teste de anotação Roberto 1", roberto);
        Anotacao anotacao5 = new Anotacao(null, "Teste de anotação Roberto 2", roberto);
        Anotacao anotacao6 = new Anotacao(null, "Teste de anotação Fátima", fatima);

        carla.getAnotacoes().addAll(Arrays.asList(anotacao1, anotacao2));
        valdemar.getAnotacoes().addAll(Arrays.asList(anotacao3));
        roberto.getAnotacoes().addAll(Arrays.asList(anotacao4, anotacao5));
        fatima.getAnotacoes().addAll(Arrays.asList(anotacao6));

        Usuario usuario1 = new Usuario(null, "geovaninieswald@gmail.com", pe.encode("123"), true, null);
        Usuario usuario2 = new Usuario(null, "wiliamfelber@gmail.com", pe.encode("123"), true, null);
        Usuario usuario3 = new Usuario(null, "daniel._.frey@hotmail.com", pe.encode("123"), true, null);

        usuario1.setPermissoes(new HashSet<>(Arrays.asList(Permissao.ADMINISTRADOR, Permissao.DENTISTA)));
        usuario2.setPermissoes(new HashSet<>(Arrays.asList(Permissao.ADMINISTRADOR)));
        usuario3.setPermissoes(new HashSet<>(Arrays.asList(Permissao.ADMINISTRADOR)));

        Funcionario geovani = new Funcionario(null, "Geovani Alex Nieswald", "036.084.580-00", "9111083532", "M", sdfData.parse("1996-05-30"), true, TipoFuncionario.DENTISTA, "#000000", "9999", contato1, rRocco, usuario1);
        Funcionario giovanna = new Funcionario(null, "Giovanna Cristiane Ramos", "925.006.289-30", "418034771", "F", sdfData.parse("1994-04-24"), true, TipoFuncionario.SECRETARIA, "#1C1C1C", null, contato3, rRio, null);

        Conta nuConta = new Conta(null, "nuConta", TipoConta.CONTA_CORRENTE, true);
        Conta cartaoNU = new Conta(null, "Cartão de Crédito NU", TipoConta.CARTAO, true);
        Conta caixa = new Conta(null, "Conta Caixa", TipoConta.POUPANCA, false);

        Agendamento agendamento1 = new Agendamento(null, "Dor de dente", "Inflamação", sdfDataHora.parse("2019-09-30 13:30"), sdfDataHora.parse("2019-09-30 14:00"), "Disse não ter alergias", StatusAgendamento.CONFIRMADO, valdemar, geovani);
        Agendamento agendamento2 = new Agendamento(null, "", "", sdfDataHora.parse("2019-09-30 14:00"), sdfDataHora.parse("2019-09-30 14:30"), "", StatusAgendamento.AGENDADO, roberto, geovani);
        Agendamento agendamento3 = new Agendamento(null, "", "", sdfDataHora.parse("2019-09-30 13:30"), sdfDataHora.parse("2019-09-30 14:00"), "Não vai poder vir por estar em viagem", StatusAgendamento.CANCELADO, fatima, geovani);

        Movimentacao movimentacao1 = new Movimentacao(null, "Agendamento 1", TipoMovimentacao.CONTA_RECEBER, StatusMovimentacao.CRIADA, nuConta, agendamento1);
        Movimentacao movimentacao2 = new Movimentacao(null, "Agendamento 2", TipoMovimentacao.CONTA_RECEBER, StatusMovimentacao.CRIADA, nuConta, agendamento2);
        Movimentacao movimentacao3 = new Movimentacao(null, "Agendamento 3", TipoMovimentacao.CONTA_RECEBER, StatusMovimentacao.CRIADA, nuConta, agendamento3);
        Movimentacao movimentacao4 = new Movimentacao(null, "Compra de Notebook", TipoMovimentacao.CONTA_PAGAR, StatusMovimentacao.PAGA, cartaoNU, null);

        Parcela parcela1 = new Parcela(null, sdfData.parse("2019-09-30"), BigDecimal.valueOf(200), StatusParcela.CRIADA, movimentacao1);
        Parcela parcela2 = new Parcela(null, sdfData.parse("2019-09-30"), BigDecimal.valueOf(3250), StatusParcela.CRIADA, movimentacao2);
        Parcela parcela3 = new Parcela(null, sdfData.parse("2019-10-30"), BigDecimal.valueOf(3250), StatusParcela.CRIADA, movimentacao2);
        Parcela parcela4 = new Parcela(null, sdfData.parse("2019-09-30"), BigDecimal.valueOf(1200), StatusParcela.CANCELADA, movimentacao3);
        Parcela parcela5 = new Parcela(null, sdfData.parse("2019-09-01"), BigDecimal.valueOf(3599.99), StatusParcela.PAGA, movimentacao4);

        parcela5.setData(sdfData.parse("2019-09-01"));

        movimentacao1.getParcelas().addAll(Arrays.asList(parcela1));
        movimentacao2.getParcelas().addAll(Arrays.asList(parcela2, parcela3));
        movimentacao3.getParcelas().addAll(Arrays.asList(parcela4));
        movimentacao4.getParcelas().addAll(Arrays.asList(parcela5));

        agendamento1.getMovimentacoes().addAll(Arrays.asList(movimentacao1));
        agendamento2.getMovimentacoes().addAll(Arrays.asList(movimentacao2));
        agendamento3.getMovimentacoes().addAll(Arrays.asList(movimentacao3));

        ProcedimentoAgendado procedimentoAgendado1 = new ProcedimentoAgendado(procedimento2, agendamento1, BigDecimal.valueOf(200), BigDecimal.ONE, BigDecimal.ZERO);
        ProcedimentoAgendado procedimentoAgendado2 = new ProcedimentoAgendado(procedimento8, agendamento2, BigDecimal.valueOf(6500), BigDecimal.ONE, BigDecimal.ZERO);
        ProcedimentoAgendado procedimentoAgendado3 = new ProcedimentoAgendado(procedimento1, agendamento3, BigDecimal.valueOf(1200), BigDecimal.ONE, BigDecimal.ZERO);

        agendamento1.getProcedimentos().addAll(Arrays.asList(procedimentoAgendado1));
        agendamento2.getProcedimentos().addAll(Arrays.asList(procedimentoAgendado2));
        agendamento3.getProcedimentos().addAll(Arrays.asList(procedimentoAgendado3));

        procedimento1.getProcedimentos().addAll(Arrays.asList(procedimentoAgendado3));
        procedimento2.getProcedimentos().addAll(Arrays.asList(procedimentoAgendado1));
        procedimento8.getProcedimentos().addAll(Arrays.asList(procedimentoAgendado2));

        // Salvar

        procedimentoRepository.saveAll(Arrays.asList(procedimento1, procedimento2, procedimento3, procedimento4, procedimento5, procedimento6, procedimento7, procedimento8));

        paisRepository.saveAll(Arrays.asList(brasil));
        estadoRepository.saveAll(Arrays.asList(rs, sc, pr));
        cidadeRepository.saveAll(Arrays.asList(santaRosa, ubiretama, brusque, patoBranco));

        enderecoRepository.saveAll(Arrays.asList(rRocco, rCaxias, rRio, linha15, rAdolfo, rValmor));
        contatoRepository.saveAll(Arrays.asList(contato1, contato2, contato3, contato4, contato5, contato6));

        pacienteRepository.saveAll(Arrays.asList(carla, valdemar, roberto, fatima));
        anotacaoRepository.saveAll(Arrays.asList(anotacao1, anotacao2, anotacao3, anotacao4, anotacao5, anotacao6));

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));
        funcionarioRepository.saveAll(Arrays.asList(geovani, giovanna));

        contaRepository.saveAll(Arrays.asList(nuConta, cartaoNU, caixa));

        agendamentoRepository.saveAll(Arrays.asList(agendamento1, agendamento2, agendamento3));
        movimentacaoRepository.saveAll(Arrays.asList(movimentacao1, movimentacao2, movimentacao3, movimentacao4));
        parcelaRepository.saveAll(Arrays.asList(parcela1, parcela2, parcela3, parcela4, parcela5));

        procedimentoAgendadoRepository.saveAll(Arrays.asList(procedimentoAgendado1, procedimentoAgendado2, procedimentoAgendado3));
    }
}
