package service.classesImpl;

import classes.Taxi;
import dao.Database;
import enums.TaxiType;
import service.TaxiService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaxiServiceImpl implements TaxiService {
    Database database;

    @Override
    public StringBuilder add(Taxi taxi) {
        List<Taxi> taxis = new ArrayList<>();
        for (Taxi taxi1 : database.taxis) {
            if (taxi1.getYear().isAfter(LocalDate.of(2010, 12,31))){
                taxis.add(taxi);
                database.taxis.addAll(taxis);
            }
        }
        return new StringBuilder("Successfully");
    }

    @Override
    public StringBuilder add(List<Taxi> taxis) {
        database.taxis.addAll(taxis);
        return new StringBuilder("Successfully");
    }

    @Override
    public List<Taxi> findByInitialLetter(String model) {
        return database.taxis.stream().filter(t -> t.getModel().equals(model)).findFirst().stream().toList();
    }

    @Override
    public Map<TaxiType, List<Taxi>> grouping() {
        return database.taxis.stream().collect(Collectors.groupingBy(Taxi::getTaxiType));
    }

    @Override
    public List<Taxi> filterByTaxiType(String taxiType) {
        return database.taxis.stream().filter(t -> t.getTaxiType().name().equals(taxiType)).toList();
    }

    @Override
    public void update(Long id) {
        for (Taxi taxi : database.taxis) {
            if (taxi.getId()==id.longValue()){
                System.out.print("""
                        1. Refactor id:
                        2. Refactor model:
                        3. Refactor number:
                        4. Refactor colour;
                        5. Refactor year:
                        6. Refactor TaxiType:
                        
                        Write a command:""");
                int number = new Scanner(System.in).nextInt();
                switch (number) {
                    case 1 -> taxi.setId(new Scanner(System.in).nextLong());
                    case 2 -> taxi.setModel(new Scanner(System.in).nextLine());
                    case 3 -> taxi.setNumber(new Scanner(System.in).nextLine());
                    case 4 -> taxi.setColour(new Scanner(System.in).nextLine());
                    case 5 -> {
                        int num1 = new Scanner(System.in).nextInt();
                        int num2 = new Scanner(System.in).nextInt();
                        int num3 = new Scanner(System.in).nextInt();
                        taxi.setYear(LocalDate.of(num1, num2, num3));
                    }
                    case 6 -> {
                        String taxiType = new Scanner(System.in).nextLine();
                        taxi.setTaxiType(TaxiType.valueOf(taxiType));
                    }
                }
            }
        }
    }
}