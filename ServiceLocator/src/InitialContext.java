import services.ServiceOne;
import services.ServiceThree;
import services.ServiceTwo;

public class InitialContext {
    public Object lookup(String name){
        if (name.equalsIgnoreCase("ServiceOne")) {
            System.out.println("Creating a new ServiceOne object");
            return new ServiceOne();
        }
        else if (name.equalsIgnoreCase("ServiceTwo")) {
            System.out.println("Creating a new ServiceTwo object");
            return new ServiceTwo();
        }
        else if (name.equalsIgnoreCase("ServiceThree")) {
            System.out.println("Creating a new ServiceThree object");
            return new ServiceThree();
        }
        return null;
    }
}
