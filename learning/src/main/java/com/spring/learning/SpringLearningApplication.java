package com.spring.learning; // this is the base package where @SpringBootApplication will scan all the Components

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // this annotation is only applied on main class
public class SpringLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningApplication.class, args);
	}

//	@Bean
//	public PlatformTransactionManager transactionManager(MongoDatabaseFactory dbFactory){
//		return new MongoTransactionManager(dbFactory); // this requires MongoDatabaseFactory as parameter
//	}
	// we can also put this in a separate package with separate class

}


