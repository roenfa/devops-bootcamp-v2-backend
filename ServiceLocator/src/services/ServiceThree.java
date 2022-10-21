package services;

public class ServiceThree implements IService {

    @Override
    public String getName() {
        return "ServiceThree";
    }

    @Override
    public void execute() {
        System.out.println("Executing ServiceThree");
    }
    
}
