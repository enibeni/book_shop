package shop.web;

import shop.domain.Customer;
import shop.domain.Orders;
import shop.domain.Product;

import java.util.List;

/**
 * Created by Enibeni on 02.12.2014.
 */
public class OrderCommand {
    private int id;
    private Customer customer;
    //TODO Date


    public OrderCommand() {
    }

    public OrderCommand(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public Orders toOrders(){
        Orders orders = new Orders();
        orders.setId(id);
        orders.setCustomer(customer);

        return orders;
    }

    public static OrderCommand fromOrder(Orders o) {
        return new OrderCommand(o.getId(), o.getCustomer());
    }


//
//    public static ProductCommand fromProduct(Product p) {
//        return new ProductCommand(p.getId(), p.getTitle(), p.getPrice());
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


