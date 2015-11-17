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
        @NamedQuery(name="getAllProducts", query = "select p from Product p")// left join fetch p.id left join fetch p.title")// left join fetch p.id left join fetch p.title")
})
@Entity
@Table(name = "PRODUCT")
public class Product implements java.io.Serializable{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PRICE")
    private float price;

    private int quantity = 1;

    @OneToMany(mappedBy = "pk.product")
    private Set<OrdersProduct> ordersProducts = new HashSet<OrdersProduct>(0);

//    public Product() {
//    }
//
//    public Product(float price, String title) {
//        this.price = price;
//        this.title = title;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //    public Set<OrdersProduct> getOrdersProducts() {
//        return ordersProducts;
//    }
//
//    public void setOrdersProducts(Set<OrdersProduct> ordersProducts) {
//        this.ordersProducts = ordersProducts;
//    }
}
