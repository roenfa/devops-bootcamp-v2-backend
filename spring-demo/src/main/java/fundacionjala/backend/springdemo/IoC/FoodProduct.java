package fundacionjala.backend.springdemo.IoC;

public class FoodProduct implements Product {
    private final String description = "FOOD";

    @Override
    public String getDescription() {
        return this.description;
    }
}
