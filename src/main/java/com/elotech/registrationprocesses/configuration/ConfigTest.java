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
        Processo processo2 = new Processo(null, 202020L, 2021, LocalDate.now(), list);
        Processo processo3 = new Processo(null, 303030L, 2021, LocalDate.now(), list);
        Processo processo4 = new Processo(null, 404040L, 2022, LocalDate.now(), list);
        Processo processo5 = new Processo(null, 505050L, 2020, LocalDate.now(), list);
        Processo processo6 = new Processo(null, 606060L, 2020, LocalDate.now(), list);
        Processo processo7 = new Processo(null, 707070L, 2019, LocalDate.now(), list);
        Processo processo8 = new Processo(null, 808080L, 2022, LocalDate.now(), list);
        Processo processo9 = new Processo(null, 909090L, 2022, LocalDate.now(), list);
        Processo processo10 = new Processo(null, 109910L, 2019, LocalDate.now(), list);

        processoRepository.save(processo1);
        processoRepository.save(processo2);
        processoRepository.save(processo3);
        processoRepository.save(processo4);
        processoRepository.save(processo5);
        processoRepository.save(processo6);
        processoRepository.save(processo7);
        processoRepository.save(processo8);
        processoRepository.save(processo9);
        processoRepository.save(processo10);

        Pessoa pessoa1 = new Pessoa(null, "Carlos Henrique", "14499445600", LocalDate.of(1996, 5, 9), LocalDate.now(), processo1);
        Pessoa pessoa2 = new Pessoa(null, "Marcelo Soares", "77455667800", LocalDate.of(1999, 1, 13), LocalDate.now(), processo8);
        Pessoa pessoa3 = new Pessoa(null, "Jair Bolsonaro", "00534112204", LocalDate.of(1956, 5, 18), LocalDate.now(), processo7);
        Pessoa pessoa4 = new Pessoa(null, "Ciro Gomes", "88600558950", LocalDate.of(1964, 8, 22), LocalDate.now(), processo8);
        Pessoa pessoa5 = new Pessoa(null, "Simone Tebete", "12200532890", LocalDate.of(1978, 11, 27), LocalDate.now(), processo5);
        Pessoa pessoa6 = new Pessoa(null, "Paulo Guedes", "09887655543", LocalDate.of(1955, 12, 28), LocalDate.now(), processo10);
        Pessoa pessoa7 = new Pessoa(null, "Jefferson Arantes", "00943595133", LocalDate.of(1991, 10, 19), LocalDate.now(), processo1);
        Pessoa pessoa8 = new Pessoa(null, "Julia Souza", "04213990132", LocalDate.of(2000, 3, 5), LocalDate.now(), processo1);
        Pessoa pessoa9 = new Pessoa(null, "Cristiano Araújo", "55900433788", LocalDate.of(1988, 10, 28), LocalDate.now(), processo7);
        Pessoa pessoa10 = new Pessoa(null, "Lorena Simas", "04301880035", LocalDate.of(1994, 6, 29), LocalDate.now(), processo10);
        Pessoa pessoa11 = new Pessoa(null, "Christopher dos Santos", "12332145665", LocalDate.of(2001, 4, 17), LocalDate.now(), processo8);
        Pessoa pessoa12 = new Pessoa(null, "Saulo Menezes", "99988877765", LocalDate.of(1996, 6, 11), LocalDate.now(), processo10);
        Pessoa pessoa13 = new Pessoa(null, "Silvio Santos", "76533267888", LocalDate.of(1930, 9, 15), LocalDate.now(), processo4);
        Pessoa pessoa14 = new Pessoa(null, "Tião Carreiro", "06969432100", LocalDate.of(1950, 10, 26), LocalDate.now(), processo10);
        Pessoa pessoa15 = new Pessoa(null, "José de Almeida Filho", "55678953211", LocalDate.of(1959, 8, 24), LocalDate.now(), processo5);
        Pessoa pessoa16 = new Pessoa(null, "Paulo Carvalho", "00977888755", LocalDate.of(1986, 1, 5), LocalDate.now(), processo2);
        Pessoa pessoa17 = new Pessoa(null, "Miranda Coosgrove", "12378998700", LocalDate.of(2002, 6, 25), LocalDate.now(), processo10);
        Pessoa pessoa18 = new Pessoa(null, "Ben-hur Filho", "55566942433", LocalDate.of(1995, 10, 10), LocalDate.now(), processo10);


        list.addAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, pessoa6, pessoa7, pessoa8, pessoa9, pessoa10, pessoa11, pessoa12, pessoa13, pessoa14, pessoa15, pessoa16, pessoa17, pessoa18));

        pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, pessoa6, pessoa7, pessoa8, pessoa9, pessoa10, pessoa11, pessoa12, pessoa13, pessoa14, pessoa15, pessoa16, pessoa17, pessoa18));









    }
}
