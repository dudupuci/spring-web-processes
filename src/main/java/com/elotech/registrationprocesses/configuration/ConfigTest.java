package com.elotech.registrationprocesses.configuration;

import com.elotech.registrationprocesses.entities.Pessoa;
import com.elotech.registrationprocesses.entities.Processo;
import com.elotech.registrationprocesses.entities.repositories.PessoaRepository;
import com.elotech.registrationprocesses.entities.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ProcessoRepository processoRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Pessoa> list = new ArrayList<>();

        Processo processo1 = new Processo(null, 101010L, 2022, LocalDate.now(), list);
        Pessoa pessoa1 = new Pessoa(null, "Carlos Henrique", "14499445600", LocalDate.of(1996, 5, 9), LocalDate.now(), processo1);
        Pessoa pessoa2 = new Pessoa(null, "Marcelo Soares", "77455667800", LocalDate.of(1999, 1, 13), LocalDate.now(), processo1);

        list.addAll(Arrays.asList(pessoa1, pessoa2));
        processoRepository.save(processo1);
        pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2));


        Pessoa pessoa3 = new Pessoa();
        Processo processo2 = new Processo(null, 202020L, 2022, LocalDate.now(), Arrays.asList(pessoa3));

        pessoa3.setId(null);
        pessoa3.setNome("Bruno Fávaro");
        pessoa3.setCpf("06744189802");
        pessoa3.setDataCadastro(LocalDate.now());
        pessoa3.setDataNascimento(LocalDate.of(1995, 8, 22));
        pessoa3.setProcesso(processo2);
        processoRepository.save(processo2);
        pessoaRepository.save(pessoa3);





    }
}
