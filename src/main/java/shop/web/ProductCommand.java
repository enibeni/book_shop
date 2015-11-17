package shop.web;

import shop.domain.Product;

/**
 * Created by Enibeni on 18.11.2014.
 */
public class ProductCommand {
    private int productId;
    private String title;
    private float price;
    //private int quantity;

    public ProductCommand() {
    }

    public ProductCommand(int productId, String title, float price) {
        this.productId = productId;
        this.title = title;
        this.price = price;
        //this.quantity = quantity;
    }

    public Product toProduct() {
        Product product = new Product();
        product.setId(productId);
        product.setTitle(title);
        product.setPrice(price);
        //product.setQuantity(quantity);

        return product;
    }

    public static ProductCommand fromProduct(Product p) {
        return new ProductCommand(p.getId(), p.getTitle(), p.getPrice());
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
