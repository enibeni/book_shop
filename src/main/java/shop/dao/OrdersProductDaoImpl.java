package shop.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.OrdersProduct;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by enikin on 06.12.2014.
 */
@Transactional(propagation = Propagation.REQUIRED)
public class OrdersProductDaoImpl implements OrdersProductDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(OrdersProduct ordersProduct) {
    entityManager.merge(ordersProduct);
    }
}
