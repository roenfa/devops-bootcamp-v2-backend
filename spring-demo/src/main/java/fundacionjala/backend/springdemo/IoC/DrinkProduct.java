package fundacionjala.backend.springdemo.IoC;

public class DrinkProduct implements Product {
    private final String description = "DRINK";

    @Override
    public String getDescription() {
        return this.description;
    }
}
