package shop.domain;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by Enibeni on 05.12.2014.
 */

@Embeddable
public class OrdersProductId implements java.io.Serializable {
    private Product product;
    private Orders orders;

    @ManyToOne//(fetch = FetchType.EAGER)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int result;
        result = (product != null ? product.hashCode() : 0);
        result = 17 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof OrdersProductId))
            return false;
        OrdersProductId other = (OrdersProductId) obj;
        if (orders == null) {
            if (other.orders != null)
                return false;
        } else if (!orders.equals(other.orders))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }


}
