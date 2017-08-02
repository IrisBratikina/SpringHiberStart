package org.itstep.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories("org.itstep.dao")
@EnableTransactionManagement
@EntityScan("org.itstep")
public class PostgreConfig extends HikariConfig {

	@Value(value = "${spring.datasource.hikari.username}")
	private String username;

	@Value(value = "${spring.datasource.hikari.password}")
	private String password;

	@Value(value = "${spring.datasource.hikari.data-source-class-name}")
	private String dataSourceClassName;

	@Value(value = "${spring.datasource.hikari.database-name}")
	private String databaseName;

	@Value(value = "${spring.datasource.hikari.driver-type}")
	private Integer driverType;

	@Value(value = "${spring.datasource.hikari.url}")
	private String url;

	@Value(value = "${spring.datasource.hikari.schema}")
	private String schema;

	@Value(value = "${spring.datasource.hikari.hbm2ddl.auto}")
	private String hbm2Ddl;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "org.itstep" });
		em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", hbm2Ddl);
		return properties;
	}

	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDataSourceClassName(dataSourceClassName);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		return new HikariDataSource(hikariConfig);
	}
}
