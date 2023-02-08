package peaksoft.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.entity.Address;
import peaksoft.entity.Country;
import peaksoft.entity.Programmer;
import peaksoft.entity.Project;

import static org.hibernate.cfg.AvailableSettings.*;

/**
 * @created : Lenovo Nuriza
 **/
public class HibernateConfig {
    public static EntityManagerFactory getEntityManager() {
        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "postgres");
        configuration.setProperty(HBM2DDL_AUTO, "update");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty(SHOW_SQL, "true");
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Project.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);

    }
}
