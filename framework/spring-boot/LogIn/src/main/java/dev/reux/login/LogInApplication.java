package dev.reux.login;

import dev.reux.login.repository.Repos_Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogInApplication implements CommandLineRunner{
    //inyeccion de dependencia del repositorio
    @Autowired
    private Repos_Usuarios repository;

	public static void main(String[] args) {
		SpringApplication.run(LogInApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("APP RUNNING SUCCESSFULLY");
    }
}
