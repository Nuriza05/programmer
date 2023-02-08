package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Address;
import peaksoft.entity.Country;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public class CountryRepositoryImpl implements CountryRepository , AutoCloseable{
    private final EntityManagerFactory entityManagerFactory =  HibernateConfig.getEntityManager();
    @Override
    public Country saveCountry(Country country) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return country;
    }

    @Override
    public String saveCountries(List<Country> countries) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Country country : countries) {
            entityManager.persist(country);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Countries are successfully saved!";
    }

    @Override
    public List<Country> getAllCountries() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Country> fromCountry = entityManager.createQuery(" select l from Country l", Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return fromCountry;
    }

    @Override
    public Country findCountryById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country singleResult = entityManager.createQuery("select l from Country l where l.id =: id", Country.class).setParameter("id",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public String deleteCountryById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country singleResult = entityManager.createQuery("select l from Country l where l.id =: id", Country.class).setParameter("id",id).getSingleResult();
        entityManager.remove(singleResult);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Country is successfully deleted!";
    }

    @Override
    public String removeAllCountries() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate table countries cascade ", Country.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Countries are successfully deleted!";
    }

    @Override
    public List<Country> findTheLongestDescription() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Country> countries = entityManager.createQuery("select c from Country c order by length(description) desc limit 1", Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return countries;
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country singleResult = entityManager.createQuery("select l from Country l where l.id =: id", Country.class).setParameter("id",id).getSingleResult();
        singleResult.setCountry(country.getCountry());
        singleResult.setDescription(country.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public int CountProgrammerInSameCountry(peaksoft.enums.Country countryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Country> query = entityManager.createQuery(" select p from Country p  where p.country =: c ", Country.class).setParameter("c",countryName).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return query.size();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
