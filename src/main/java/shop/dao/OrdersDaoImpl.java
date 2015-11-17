package shop.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.Orders;
import shop.domain.Product;
import shop.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Enibeni on 31.10.2014.
 */
@Transactional(propagation = Propagation.REQUIRED)
public class OrdersDaoImpl implements OrdersDao{
    @PersistenceContext
    private EntityManager entityManager;

    private ProductDao productDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(Orders order) {
        entityManager.persist(order);
        //entityManager.flush();

    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void addOrder(int orderId, int productId) throws NotFoundException {
//        Product product = entityManager.find(Product.class, productId);
//        Orders order = findById(orderId);
//        if (order == null){
//            throw new NotFoundException();
//        }
//        order.getProduct().add(product);
//        order.getOrdersProducts().getProduct
//    }

    @Override
    public void addOrUpdate(Orders orders) {
        entityManager.merge(orders);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Orders findById(int id) throws NotFoundException {
        Orders order = entityManager.find(Orders.class, id);
        if (order == null){
            throw new NotFoundException();
        }
        return order;
    }


    @Override
    public List<Orders> getAll() {
        return entityManager.createNamedQuery("getAllOrders", Orders.class).getResultList();
    }

}
