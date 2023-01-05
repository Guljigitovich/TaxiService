package dao;

import classes.Client;
import classes.Driver;
import classes.Taxi;

import java.util.HashSet;
import java.util.Set;

public class Database {
    public Set<Taxi> taxis = new HashSet<>();
    public Set<Client>clientSet = new HashSet<>();
    public Set<Driver> drivers = new HashSet<>();
}
