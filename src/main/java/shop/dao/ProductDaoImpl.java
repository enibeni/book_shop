package shop.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.Product;
import shop.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Enibeni on 31.10.2014.
 */
@Transactional(propagation = Propagation.REQUIRED)
public class ProductDaoImpl implements ProductDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addOrUpdate(Product product) {
        entityManager.merge(product);
    }


    @Override
    @Transactional
    public void add(Product product) {
        //addOrUpdate(product);
        entityManager.persist(product);
        //entityManager.flush();
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Product findById(int id) throws NotFoundException {
        Product product = entityManager.find(Product.class, id);
        if (product == null){
            throw new NotFoundException();
        }
        return product;
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        return entityManager.createNamedQuery("getAllProducts", Product.class).getResultList();
    }

    @Override
    @Transactional
    public void delete(int id) throws NotFoundException {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
    }
}
