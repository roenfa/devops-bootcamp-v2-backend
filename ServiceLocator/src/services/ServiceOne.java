package services;

public class ServiceOne implements IService {

    @Override
    public String getName() {
        return "ServiceOne";
    }

    @Override
    public void execute() {
        System.out.println("Executing ServiceOne");
    }
    
}
