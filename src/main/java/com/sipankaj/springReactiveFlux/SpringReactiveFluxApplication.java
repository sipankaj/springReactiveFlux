package com.sipankaj.springReactiveFlux;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;


@EnableR2dbcRepositories
@SpringBootApplication
public class SpringReactiveFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveFluxApplication.class, args);
	}

	@Bean
	ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		var databasePopulator = new CompositeDatabasePopulator();
		databasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("init.sql")));
	//	databasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("feed.sql")));
		initializer.setDatabasePopulator(databasePopulator);
		return initializer;
	}
}
