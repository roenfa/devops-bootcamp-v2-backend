package fundacionjala.backend.springdemo.IoC;

public class Store {
    private Product product;
//    private String description;

    public Store(Product p) {
        this.product = p;
    }

    public Product getProduct() {
        return product;
    }
}
