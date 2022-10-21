package services;

import helper.CarSelection;
import services.ElectricCar;
import services.GasCar;
import services.ICarService;

public class CarFactory {
    //Generate factory metho

    public ICarService getCar(CarSelection carType) {

        switch (carType) {
            case GAS_CAR:
                return new GasCar();

            case ELECTRIC_CAR:
                return new ElectricCar();
        }
        return null;
    }

}
