package fundacionjala.backend.springdemo.IoC;

public class Main {
    public static void main(String args[]) {
        Store s = new Store(new FoodProduct());
        System.out.println(s.getProduct().getDescription());
    }
}
