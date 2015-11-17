package shop.dao;

import shop.domain.Customer;
import shop.exception.NotFoundException;

import java.util.List;

/**
 * Created by Enibeni on 24.10.2014.
 */
public interface CustomerDao {
    void addCustomer (Customer customer);
    void addOrUpdate(Customer customer);
    List<Customer> getAll();
    Customer findById(int id) throws NotFoundException;

}
