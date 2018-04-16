package db.neo4japi;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableNeo4jRepositories("db.neo4japi")
//@EnableTransactionManagement
////@ComponentScan("com.example.demo")
//public class Neo4jConfig {
//
//
//    public SessionFactory getSessionFactory() {
//        return new SessionFactory("db.neo4japi");
//    }
//}


@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "db.neo4japi")
//@ComponentScan(basePackageClasses = UserService.class)
public class Neo4jConfig{

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri("http://neo4j:19288446@localhost:7474")
//                .credentials("neo4j", "19288446")
                .build();
        return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }


    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "db.neo4japi" );
    }
}