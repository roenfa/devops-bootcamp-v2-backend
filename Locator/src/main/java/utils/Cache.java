package utils;

import helper.CarSelection;
import services.ICarService;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

public class Cache {

    private List<ICarService> services;

    public Cache() {
        services = new ArrayList<ICarService>();
    }

    public ICarService getService(CarSelection serviceName)
    {
        for (ICarService service : services) {
            if (service.getType().equalsIgnoreCase(String.valueOf(serviceName))) {
                System.out.println("Returning cached "
                        + serviceName + " object");
                return service;
            }
        }
        return null;
    }

    public void addService(ICarService newService)
    {
        boolean exists = false;
        for (ICarService service : services) {
            if (service.getType().equalsIgnoreCase(newService.getType())) {
                exists = true;
            }
        }
        if (!exists) {
            services.add(newService);
        }
    }


}
