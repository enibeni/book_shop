package shop.presentation;

import org.springframework.dao.DataAccessException;
import shop.dao.CustomerDao;
import shop.dao.OrdersDao;
import shop.dao.OrdersProductDao;
import shop.dao.ProductDao;
import shop.domain.Customer;
import shop.domain.Orders;
import shop.domain.OrdersProduct;
import shop.domain.Product;
import shop.exception.NotFoundException;

import java.util.List;

/**
 * Created by Enibeni on 10.11.2014.
 */
public class ShopServiceBean implements ShopService {
    private ProductDao productDao;
    private CustomerDao customerDao;
    private OrdersDao ordersDao;
    private OrdersProductDao ordersProductDao;


    @Override
    public List<Product> getAll() throws ApplicationException {
        try{
            return productDao.getAll();
        }catch (DataAccessException e){
            throw new ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersDao.getAll();
    }

    @Override
    public void saveProduct(Product product) {
    productDao.addOrUpdate(product);
    }

    @Override
    public Product findProductById(int id) {
        try {
            return productDao.findById(id);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findCustomerById(int id) {
        try {
            return customerDao.findById(id);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        productDao.delete(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {//вот сдесь появляется валидный id
    customerDao.addCustomer(customer);
    return customer;
    }


    @Override
    public Orders saveOrder(Orders orders) {
    ordersDao.add(orders);
    return orders;
    }

    @Override
    public void saveOrdersProduct(OrdersProduct ordersProduct) {
        ordersProductDao.add(ordersProduct);
    }


    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public void setOrdersProductDao(OrdersProductDao ordersProductDao) {
        this.ordersProductDao = ordersProductDao;
    }
}
