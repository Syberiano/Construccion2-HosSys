package APP.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class JpaConfig {

    @Autowired
    private JpaProperties jpaProperties;
    
    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("APP");
        
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        
        // Get Hibernate properties
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
            jpaProperties.getProperties(),
            new HibernateSettings()
        );
        
        // Set MySQL 8.0 dialect
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        
        // Ensure we're using the correct connection pool settings
        properties.put("hibernate.hikari.connectionTimeout", "20000");
        properties.put("hibernate.hikari.minimumIdle", "10");
        properties.put("hibernate.hikari.maximumPoolSize", "20");
        properties.put("hibernate.hikari.idleTimeout", "30000");
        
        em.setJpaPropertyMap(properties);
        
        return em;
    }
}
