package services;

public class ServiceTwo implements IService {

    @Override
    public String getName() {
        return "ServiceTwo";
    }

    @Override
    public void execute() {
        System.out.println("Executing ServiceTwo");
    }
    
}
