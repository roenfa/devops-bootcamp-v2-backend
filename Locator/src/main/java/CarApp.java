import helper.CarSelection;
import services.CarServiceLocator;
import services.ICarService;

public class CarApp {

    public static void main(String[] args) {
        ICarService carService = new CarServiceLocator().getService(CarSelection.ELECTRIC_CAR);
        System.out.println(carService.getType());

        carService = new CarServiceLocator().getService(CarSelection.GAS_CAR);
        System.out.println(carService.getType());

    }

}
