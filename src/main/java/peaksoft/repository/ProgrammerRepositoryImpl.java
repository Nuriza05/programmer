package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Address;
import peaksoft.entity.Country;
import peaksoft.entity.Programmer;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public class ProgrammerRepositoryImpl implements ProgrammerRepository ,AutoCloseable{
    EntityManagerFactory entityManagerFactory =  HibernateConfig.getEntityManager();
    @Override
    public Programmer saveProgrammer(Programmer programmer, Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address address = entityManager.find( Address.class,id);
        programmer.setLocation(address);
        entityManager.persist(programmer);
        entityManager.getTransaction().commit();
        entityManager.close();
        return programmer;
    }
    @Override
    public String saveProgrammers(List<Programmer> programmers, Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Programmer programmer : programmers) {
            Address address = entityManager.find( Address.class,id);
            programmer.setLocation(address);
            entityManager.merge(programmer);
            entityManager.persist(programmer);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Programmers are successfully saved!";
    }

    @Override
    public void addConstraintToEmail() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("alter table programmers add constraint email unique (email)", Programmer.class).executeUpdate();
        System.out.println("Constraint unique is successfully added!");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Programmer> fromProgrammer = entityManager.createQuery("from Programmer ", Programmer.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return fromProgrammer;
    }

    @Override
    public Programmer findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("select l from Programmer l where l.id =: id", Programmer.class).setParameter("id",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public String deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("select l from Programmer l where l.id =: id", Programmer.class).getSingleResult();
        entityManager.remove(singleResult);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Programmer is successfully deleted!";
    }

    @Override
    public String deleteAllProgrammers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate table programmers cascade ", Programmer.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Programmers are successfully deleted!";
    }

    @Override
    public Programmer updateProgrammer(Long id, Programmer programmer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("select l from Programmer l where l.id =: id", Programmer.class).setParameter("id",id).getSingleResult();
        singleResult.setFullName(programmer.getFullName());
        singleResult.setDateOfBirth(programmer.getDateOfBirth());
        singleResult.setStatus(programmer.getStatus());
        singleResult.setEmail(programmer.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public int getProgrammersWithSameCountry(peaksoft.enums.Country countryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Country> name = entityManager.createQuery("select l from Country l where l.country =: c ",Country.class).setParameter("c",countryName).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return name.size();
    }

    @Override
    public Programmer findTheYoungestProgrammer() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("select p from Programmer p order by dateOfBirth limit 1", Programmer.class ).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public Programmer findTheOldestProgrammer() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("select p from Programmer p order by dateOfBirth desc limit 1", Programmer.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
