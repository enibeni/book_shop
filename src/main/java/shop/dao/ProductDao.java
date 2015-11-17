package shop.dao;

import shop.domain.Product;
import shop.exception.NotFoundException;

import java.util.List;

/**
 * Created by Enibeni on 31.10.2014.
 */
public interface ProductDao {
    void add(Product product);
    void addOrUpdate(Product product);
    Product findById(int id) throws NotFoundException;
    List<Product> getAll();

    void delete(int id) throws NotFoundException;

}