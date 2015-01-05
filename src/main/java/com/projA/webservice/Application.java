package com.projA.webservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.util.ClassUtils;

import com.projA.jpa.example.Test;

@Configuration
@ComponentScan("com.projA")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Import(com.projA.jpa.Application.class)
@ImportResource("classpath:/com/projA/webservice/rest/rest-context.xml")
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
        Test test = ctx.getBean(Test.class);

        test.cleanDB();
        test.testPersist();
	}
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean cemf() {
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setPersistenceUnitName("projA-java-jpa-test");
//		// Not needed but to be specific which LoadTimeWeaver is used
//		em.setLoadTimeWeaver(new org.springframework.context.weaving.DefaultContextLoadTimeWeaver(ClassUtils.getDefaultClassLoader()));
//		em.setPackagesToScan(new String[] { "com.projA.jpa.testmodel" });
//  		return em;
//  }
//	
//	@Bean
//	public JpaTransactionManager transactionManager() {
//		JpaTransactionManager tm = new JpaTransactionManager();
//		return tm;
//	}
}
