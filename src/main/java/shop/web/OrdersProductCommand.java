package shop.web;

import shop.domain.Orders;
import shop.domain.OrdersProduct;
import shop.domain.Product;

/**
 * Created by enikin on 06.12.2014.
 */
public class OrdersProductCommand {
    private int quantity;
    private Product product;
    private Orders orders;

    public OrdersProductCommand() {
    }

    public OrdersProductCommand(Product product, Orders orders, int quantity) {
        this.quantity = quantity;
        this.product = product;
        this.orders = orders;
    }

    public OrdersProduct toOrdersProduct(){
        OrdersProduct ordersProduct = new OrdersProduct();
        ordersProduct.setQuntity(quantity);
        ordersProduct.setOrders(orders);
        ordersProduct.setProduct(product);
        return ordersProduct;

    }

    public static OrdersProductCommand fromOrdersProduct(OrdersProduct op){
        return new OrdersProductCommand(op.getProduct(), op.getOrders(), op.getQuntity());
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
