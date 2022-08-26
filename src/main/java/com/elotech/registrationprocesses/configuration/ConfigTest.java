package com.elotech.registrationprocesses.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {




    }
}
