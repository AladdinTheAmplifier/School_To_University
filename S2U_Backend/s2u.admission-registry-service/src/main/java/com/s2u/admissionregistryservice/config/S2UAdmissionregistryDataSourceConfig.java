
package com.s2u.admissionregistryservice.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource("classpath:application.properties") 
@EnableJpaRepositories(basePackages = "com.s2u.admissionregistryservice.repository")
public class S2UAdmissionregistryDataSourceConfig {

	private static final Logger log = LoggerFactory.getLogger(S2UAdmissionregistryDataSourceConfig.class);

	@Autowired
	Environment env;

	@Bean
	@Primary 
	@ConfigurationProperties(prefix="s2u.admission-registry-service.datasource")
	public DataSource myDataSource() {
	    return DataSourceBuilder.create().build();
	}
}
