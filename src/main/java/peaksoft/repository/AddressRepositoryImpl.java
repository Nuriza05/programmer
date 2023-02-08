package peaksoft.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Address;
import peaksoft.entity.Country;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public class AddressRepositoryImpl implements AddressRepository, AutoCloseable{
        private  EntityManagerFactory  entityManagerFactory ;
        public AddressRepositoryImpl(){
            this.entityManagerFactory=HibernateConfig.getEntityManager();
        }
    @Override
    public Address saveAddress(Address address, Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country country = entityManager.createQuery("select l from Country l where l.id =: id", Country.class).setParameter("id",id).getSingleResult();
        address.setCountryId(country);
        entityManager.merge(address);
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        entityManager.close();
        return address;
    }

    @Override
    public String saveAddresses(List<Address> addresses, Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Address address : addresses) {
            Country country = entityManager.createQuery("select l from Country l where l.id =: id", Country.class).setParameter("id", id).getSingleResult();
            address.setCountryId(country);
            entityManager.persist(address);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Addresses are successfully saved!";
    }

    @Override
    public List<Address> getAllAddresses() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Address> fromAddress = entityManager.createQuery("from Address", Address.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return fromAddress;
    }

    @Override
    public Address findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address id1 = entityManager.createQuery("select l from Address l where l.id =: id", Address.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public String removeById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address id1 = entityManager.createQuery("select l from Address l where l.id =: id", Address.class).setParameter("id", id).getSingleResult();
        entityManager.remove(id1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Address is successfully deleted!";
    }

    @Override
    public String removeAllAddresses() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate table addresses cascade", Address.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Addresses are successfully deleted!";
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address id1 = entityManager.createQuery("select l from Address l where l.id=:id", Address.class).setParameter("id", id).getSingleResult();
        id1.setStreet(address.getStreet());
        id1.setHomeNumber(address.getHomeNumber());
        id1.setRegionName(address.getRegionName());
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
