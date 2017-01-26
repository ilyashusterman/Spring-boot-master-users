package com.ilya.shusterman;

import com.ilya.shusterman.repository.MongoDataBaseHandler;
import com.ilya.shusterman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class MasterUsersAdminSystemApplication implements CommandLineRunner {

	@Value("${mongoTextFile}")
	public String mongoTextFileLocation;
	@Autowired
	private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(MasterUsersAdminSystemApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.deleteAll();
		MongoDataBaseHandler.readFromFile(repository,new File(mongoTextFileLocation));

	}
}
