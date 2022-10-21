import services.IService;

public class App {
    public static void main(String[] args) throws Exception {

        IService service = ServiceLocator.getService("ServiceOne");
        service.execute();
  
        service = ServiceLocator.getService("ServiceTwo");
        service.execute();
  
        service = ServiceLocator.getService("ServiceOne");
        service.execute();
  
        service = ServiceLocator.getService("ServiceTwo");
        service.execute();

        System.out.println("### ServiceThree ###");
        service = ServiceLocator.getService("ServiceThree");
        service.execute();
        service = ServiceLocator.getService("ServiceThree");
        service.execute();
        service = ServiceLocator.getService("ServiceThree");
        service.execute();
    }
}
