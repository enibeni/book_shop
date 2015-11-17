package shop.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Enibeni on 30.10.2014.
 */
@NamedQueries({
        @NamedQuery(name = "getAllOrders", query = "select o from Orders o")
})
@Entity
@Table(name = "ORDERS")
public class Orders implements java.io.Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID", nullable = true)
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.orders")
    private Set<OrdersProduct> ordersProducts = new HashSet<OrdersProduct>();

//    public Orders() {
//    }

//    public Orders(Customer customer) {
//        this.customer = customer;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrdersProduct> getOrdersProducts() {
        return ordersProducts;
    }

    public void setOrdersProducts(Set<OrdersProduct> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }
}
