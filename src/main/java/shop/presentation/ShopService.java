package shop.presentation;

import shop.domain.Customer;
import shop.domain.Orders;
import shop.domain.OrdersProduct;
import shop.domain.Product;
import shop.exception.NotFoundException;

import java.util.List;

/**
 * Created by Enibeni on 10.11.2014.
 */
public interface ShopService {
    List<Product> getAll() throws ApplicationException;
    List<Product> getAllProducts();
    List<Orders> getAllOrders();


    Product findProductById(int id);

    Customer findCustomerById(int id);

    void delete(int id) throws NotFoundException;

    void saveProduct(Product product);

    Customer saveCustomer(Customer customer);

    Orders saveOrder(Orders orders);

    void saveOrdersProduct(OrdersProduct ordersProduct) throws NotFoundException;

//    void addProductToOrder(int orderId, int productId) throws NotFoundException;


}
