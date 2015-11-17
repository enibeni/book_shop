package shop.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.Customer;
import shop.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Enibeni on 24.10.2014.
 */
public class CustomerDaoImpl implements CustomerDao{
    @PersistenceContext(unitName="messagerPersistence")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void addOrUpdate(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Customer> getAll() {
        return entityManager.createNamedQuery("getAll", Customer.class).getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Customer findById(int id) throws NotFoundException {
        Customer customer = entityManager.find(Customer.class, id);
        if (customer == null){
            throw new NotFoundException();
        }
        return customer;
    }
}