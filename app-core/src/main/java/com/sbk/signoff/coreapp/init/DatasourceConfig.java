package com.sbk.signoff.coreapp.init;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
	@Bean
	public DataSource datasource() {
		return DataSourceBuilder.create()
				.driverClassName("org.h2.Driver")
				.url("jdbc:h2:mem:testdb")
				.username("sa")
				.password("")
				.build();
	}
}

//spring.datasource.driver-class-name=org.h2.Driver
//spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
//spring.datasource.username=sa
//spring.datasource.password=
