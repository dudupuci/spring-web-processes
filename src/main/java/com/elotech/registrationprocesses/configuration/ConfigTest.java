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
        Pessoa pessoa = new Pessoa(null, "Carlos Henrique", "14499445600", LocalDate.of(1996, 5, 9), LocalDate.now());
        Pessoa pessoa2 = new Pessoa(null, "Bruno Fávaro", "06744189802", LocalDate.of(1995, 8, 22), LocalDate.now());
        Pessoa pessoa3 = new Pessoa(null, "Marcelo Soares", "77455667800", LocalDate.of(1999, 1, 13), LocalDate.now());
        list.addAll(Arrays.asList(pessoa, pessoa2, pessoa3));

        Processo processo = new Processo(null,101010L,2022, LocalDate.now(),list);
        processoRepository.save(processo);
        pessoaRepository.saveAll(Arrays.asList(pessoa, pessoa2, pessoa3));





    }
}
