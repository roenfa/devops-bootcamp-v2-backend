package services;

import helper.CarSelection;
import utils.Cache;


public class CarServiceLocator {
    private static Cache cache;

    static
    {
        cache = new Cache();
    }

    public static ICarService getService(CarSelection type) {
        ICarService service = cache.getService(type);

        if (service != null) {
            return service;
        }

        CarFactory factory = new CarFactory();
        ICarService carService = factory.getCar(type);
        cache.addService(carService);
        return carService;
    }
}
