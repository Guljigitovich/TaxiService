import classes.Client;
import classes.Driver;
import classes.License;
import classes.Taxi;
import enums.Gender;
import enums.TaxiType;
import service.classesImpl.ClientImpl;
import service.classesImpl.DriverImpl;
import service.classesImpl.TaxiServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(1L, "Azamatov Aktan", LocalDate.of(2001, 10, 21), "0505505505", BigDecimal.valueOf(15000));
        Client client1 = new Client(2L, "Samatova Aijan", LocalDate.of(1999, 7, 12), "0503500500", BigDecimal.valueOf(18000));
        Client client2 = new Client(3L, "Petrov Andrei", LocalDate.of(2000, 8, 15), "0777777777", BigDecimal.valueOf(14000));
        Client client3 = new Client(4L, "Adam Jonson", LocalDate.of(1997, 11, 1), "0778787878", BigDecimal.valueOf(20000));
        Client client4 = new Client(5L, "Balanchaev Tukuncho", LocalDate.of(2004, 10, 28), "0555565758", BigDecimal.valueOf(12000));
        ArrayList<Client> clientArrayList = new ArrayList<>(
                Arrays.asList(client1, client2, client4, client3, client)
        );
        Taxi taxi1 = new Taxi(1L, "E211", "01kg001ADI", "black", LocalDate.of(2020, 20, 20), TaxiType.BUSINESS);
        Taxi taxi2 = new Taxi(2L, "Camry", "02kg002GDJ", "white", LocalDate.of(2015, 15, 15), TaxiType.COMFORT);
        Taxi taxi3 = new Taxi(3L, "Fit", "03kg003LRT", "silver", LocalDate.of(2010, 10, 10), TaxiType.STANDART);
        Taxi taxi4 = new Taxi(4L, "Ist", "04kg004HKT", "black", LocalDate.of(2005, 5, 5), TaxiType.STANDART);
        List<Taxi> taxiList = new ArrayList<>(List.of(taxi1, taxi2, taxi3, taxi4));

        License license = new License(1L,LocalDate.of(2011,11,13),LocalDate.of(2020,10,23));
        License license1 = new License(2L,LocalDate.of(2012,9,15),LocalDate.of(2019,8,22));
        ArrayList<License>licenseArrayList = new ArrayList<>(
                Arrays.asList(license1,license)
        );

        Driver driver = new Driver(1L," Aman","Amanov", Gender.MALE,"0999999897",license,BigDecimal.valueOf(20000),taxi1 );
        Driver driver1 = new Driver(2L," Kanat","Kanatov", Gender.MALE,"0777999897",license1,BigDecimal.valueOf(18000),taxi2 );
        ArrayList<Driver>driverArrayList = new ArrayList<>(
                Arrays.asList(driver,driver1)
        );

        ClientImpl client5 = new ClientImpl();
        TaxiServiceImpl taxiService = new TaxiServiceImpl();
        DriverImpl driver2 = new DriverImpl();

        while (true) {
            System.out.println("""
                    Press 1 add client .
                    Press 2 add clients .
                    Press 3 get client by name .
                    Press 4 remove client by id .
                    Press 5 universal sorting .
                    Press 6 get client age .
                    Press 7 order taxi .
                    Press 8 add taxi .
                    Press 9 add taxis .
                    Press 10 find by initial letter taxi.
                    Press 11 grouping taxi .
                    Press 12 filter by taxi type .
                    Press 13 update taxi .
                    Press 14 add driver .
                    Press 15 add drivers .
                    Press 16 find by  id .
                    Press 17 find by name .
                    """);
            try {
                System.out.println("Write the number !");
                int number = new Scanner(System.in).nextInt();
                switch (number) {
                    case 1 -> System.out.println(client5.addClient(client));
                    case 2 -> System.out.println(client5.addClient(clientArrayList));
                    case 3 -> {
                        System.out.println("Write the client name : ");
                        String clientName = new Scanner(System.in).nextLine();
                        System.out.println(client5.getClientByName(clientName));
                    }
                    case 4 -> {
                        System.out.println("Write the client id : ");
                        Long clientId = new Scanner(System.in).nextLong();
                        System.out.println(client5.removeClientById(clientId));
                    }
                    case 5 -> {
                        System.out.println("Write the sorted world : ");
                        String world = new Scanner(System.in).nextLine();
                        client5.universalSorting(world);
                    }
                    case 6 -> System.out.println(client5.getClientAge());
                    case 7 -> {
                        System.out.println("Write the client id : ");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Write the client taxi type : ");
                        String type = new Scanner(System.in).nextLine();
                        System.out.println(client5.orderTaxi(id, type));
                    }
                    case 8 -> System.out.println(taxiService.add(taxi1));
                    case 9 -> System.out.println(taxiService.add(taxiList));
                    case 10 -> {
                        System.out.println("Write the model taxi : ");
                        String modelName = new Scanner(System.in).nextLine();
                        System.out.println(taxiService.findByInitialLetter(modelName));
                    }
                    case 11 -> System.out.println(taxiService.grouping());
                    case 12 -> {
                        System.out.println("Write the taxi type : ");
                        String typeTaxi = new Scanner(System.in).nextLine();
                        System.out.println(taxiService.filterByTaxiType(typeTaxi));
                    }
                    case 13 -> {
                        System.out.println("Write the taxi id : ");
                        Long idTaxi = new Scanner(System.in).nextLong();
                        taxiService.update(idTaxi);
                    }
                    case 14 -> System.out.println(driver2.add(driver));
                    case 15 -> System.out.println(driver2.add(driverArrayList));
                    case 16 -> {
                        System.out.println("Write the driver id : ");
                        Long idDriver = new Scanner(System.in).nextLong();
                        System.out.println(driver2.findById(idDriver));
                    }
                    case 17 -> {
                        System.out.println("Write the driver name : ");
                        String driverName = new Scanner(System.in).nextLine();
                        System.out.println(driver2.findByName(driverName));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("You must write a number not a word");

            }
        }
    }
}