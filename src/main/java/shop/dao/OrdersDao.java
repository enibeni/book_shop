package shop.dao;

import shop.domain.Orders;
import shop.exception.NotFoundException;

import java.util.List;

/**
 * Created by Enibeni on 31.10.2014.
 */
public interface OrdersDao {
    void add(Orders order);
   // void addOrder(int orderId, int productId) throws NotFoundException;
    void addOrUpdate(Orders orders);
    Orders findById(int id) throws NotFoundException;
    //void addProduct(int orderId, int productId) throws NotFoundException;
    List<Orders> getAll();
}
