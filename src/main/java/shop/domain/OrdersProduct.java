package shop.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Enibeni on 05.12.2014.
 */
@Entity
@Table(name = "order_product")
@AssociationOverrides({
        @AssociationOverride(name = "pk.product",
                joinColumns = @JoinColumn(name = "PRODUCT_ID")),
        @AssociationOverride(name = "pk.orders",
                joinColumns = @JoinColumn(name = "ORDER_ID")) })
public class OrdersProduct implements java.io.Serializable {
    private OrdersProductId pk = new OrdersProductId();
    private int quntity;

    @EmbeddedId
    public OrdersProductId getPk() {
        return pk;
    }

    @Transient
    public Product getProduct(){
        return getPk().getProduct();
    }

    public void setProduct(Product product){
        getPk().setProduct(product);
    }

    @Transient
    public Orders getOrders(){
        return getPk().getOrders();
    }

    public void setOrders(Orders orders){
        getPk().setOrders(orders);
    }

    public void setPk(OrdersProductId pk) {
        this.pk = pk;
    }

    @Column(name = "QUANTUTY", nullable = false)
    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }


    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof OrdersProduct))
            return false;
        OrdersProduct other = (OrdersProduct) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        if (quntity == 0) {
            if (other.quntity != 0)
                return false;
        } else if (quntity != other.quntity)
            return false;
        return true;
    }



}
