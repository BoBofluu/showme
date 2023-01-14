package showme.config.database;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"showme.repositories"},
        entityManagerFactoryRef = "jpaEntityManagerFactory",
        transactionManagerRef = "jpaTransactionManager")
public class PostgresConfig {

    private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = {"showme.models.entites"};

    @Autowired
    private ConnectionProperties connectionProperties;

    @Bean("dataSource")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().url(connectionProperties.getUrl()).username(connectionProperties.getUserName())
                .password(connectionProperties.getPassword()).driverClassName(connectionProperties.getDriverClassName()).build();
    }

    private HibernateJpaVendorAdapter jpaVendorAdaptor() {
        HibernateJpaVendorAdapter jpaVendorAdaptor = new HibernateJpaVendorAdapter();
        return jpaVendorAdaptor;
    }

    @Bean("jpaEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean jpaEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdaptor());
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(addProperties());

        return entityManagerFactoryBean;
    }

    @Bean("jpaTransactionManager")
    @Primary
    public PlatformTransactionManager jpaTransactionManager(
            @Qualifier("jpaEntityManagerFactory") LocalContainerEntityManagerFactoryBean jpaEntityManagerFactory) {
        return new JpaTransactionManager(jpaEntityManagerFactory.getObject());
    }

    private Properties addProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "false");
        return properties;
    }
}
