package service.classesImpl;

import classes.Driver;
import dao.Database;
import service.DriverService;

import java.util.List;

public class DriverImpl implements DriverService {
    Database database = new Database();
    @Override
    public Driver add(Driver driver) {
        this.database.drivers.add(driver);
        return null;
    }

    @Override
    public List<Driver> add(List<Driver> drivers) {
        this.database.drivers.addAll(drivers);
        return null;
    }

    @Override
    public Driver findById(Long id) {
        return (Driver) database.drivers.stream().filter(s->id.equals(s.getId())).toList();
    }

    @Override
    public List<Driver> findByName(String name) {
        return database.drivers.stream().filter(s->name.equals(s.getName())).toList();
    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
        return null;
    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        return null;
    }

    @Override
    public List<Driver> getDriverByTaxiModel(String model) {
        return null;
    }

    @Override
    public void update(String driverName) {

    }
}
