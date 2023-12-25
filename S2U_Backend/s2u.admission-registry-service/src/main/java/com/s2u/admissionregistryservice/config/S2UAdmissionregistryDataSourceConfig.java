package com.s2u.admissionregistryservice.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "com.s2u.admissionregistryservice.repository", entityManagerFactoryRef = "s2uEntityManager", transactionManagerRef = "s2uTransactionManager")
public class S2UAdmissionregistryDataSourceConfig {

	private static final Logger log = LoggerFactory.getLogger(S2UAdmissionregistryDataSourceConfig.class);

	@Autowired
	Environment env;

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean s2uEntityManager() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(s2uAdmissionregistryDataSourceConfig());
		em.setPackagesToScan("com.s2u.admissionregistryservice.entity");
		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		final HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
		properties.put("spring.jpa.database-platform", env.getProperty("spring.jpa.database-platform"));
		em.setJpaPropertyMap(properties);
		log.debug("Custom datasource initialized {}", em.getJpaPropertyMap());
		return em;
	}

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "s2u.admission-registry-service.datasource")
	public DataSource s2uAdmissionregistryDataSourceConfig() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("s2u.admission-registry-service.datasource.driverClassName"));
		dataSource.setUrl(env.getProperty("s2u.admission-registry-service.datasource.url"));
		dataSource.setUsername(env.getProperty("s2u.admission-registry-service.datasource.username"));
		dataSource.setPassword(env.getProperty("s2u.admission-registry-service.datasource.password"));
		// return DataSourceBuilder.create().build();
		return dataSource;
	}

	@Primary
	@Bean
	public PlatformTransactionManager s2uTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(s2uEntityManager().getObject());
		return transactionManager;
	}

}