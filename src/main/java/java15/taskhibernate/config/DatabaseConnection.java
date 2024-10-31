package java15.taskhibernate.config;
import jakarta.persistence.EntityManagerFactory;
import java15.taskhibernate.entity.UserDetails;
import java15.taskhibernate.entity.UserProfile;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DatabaseConnection {
    public static EntityManagerFactory getEntityManager() {
        Properties properties = new Properties();
        properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD, "postgres");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.FORMAT_SQL, "true");

        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(UserDetails.class);
        configuration.addAnnotatedClass(UserProfile.class);
        return configuration.buildSessionFactory().unwrap(SessionFactory.class);
    }
}
