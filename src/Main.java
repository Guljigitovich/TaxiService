import classes.Client;
import classes.Taxi;
import enums.TaxiType;
import service.classesImpl.ClientImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(1L,"Azamatov Aktan", LocalDate.of(2001,10,21),"0505505505", BigDecimal.valueOf(15000));
        Client client1 = new Client(2L,"Samatova Aijan", LocalDate.of(1999,7,12),"0503500500", BigDecimal.valueOf(18000));
        Client client2 = new Client(3L,"Petrov Andrei", LocalDate.of(2000,8,15),"0777777777", BigDecimal.valueOf(14000));
        Client client3 = new Client(4L,"Adam Jonson", LocalDate.of(1997,11,1),"0778787878", BigDecimal.valueOf(20000));
        Client client4 = new Client(5L,"Balanchaev Tukuncho", LocalDate.of(2004,10,28),"0555565758", BigDecimal.valueOf(12000));
        ArrayList<Client>clientArrayList = new ArrayList<>(
                Arrays.asList(client1,client2,client4,client3,client)
        );
        Taxi taxi1 = new Taxi(1L,"E211","01kg001ADI","black",LocalDate.of(2020,20,20), TaxiType.BUSINESS);
        Taxi taxi2 = new Taxi(2L,"Camry","02kg002GDJ","white",LocalDate.of(2015,15,15), TaxiType.COMFORT);
        Taxi taxi3 = new Taxi(3L,"Fit","03kg003LRT","silver",LocalDate.of(2010,10,10), TaxiType.STANDART);
        Taxi taxi4 = new Taxi(4L,"Ist","04kg004HKT","black",LocalDate.of(2005,5,5), TaxiType.STANDART);
        List<Taxi> taxiList = new ArrayList<>(List.of(taxi1,taxi2,taxi3,taxi4));

        ClientImpl client5 = new ClientImpl();
        while (true){
            System.out.println("""
                    Press 1 add client .
                    Press 2 add clients .
                    Press 3 get client by name .
                    Press 4 remove client by id .
                    Press 5 universal sorting .
                    Press 6 get client age .
                    Press 7 order taxi .
                    """);
            System.out.println("Write the number !");
            int number = new Scanner(System.in).nextInt();
            switch (number){
                case 1->   System.out.println(client5.addClient(client));
                case 2 -> System.out.println(client5.addClient(clientArrayList));
                case 3 -> {System.out.println("Write the client name : ");
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
                case 6 ->     System.out.println(client5.getClientAge());
                case 7 -> {
                    System.out.println("Write the client id : ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write the client taxi type : ");
                    String type = new Scanner(System.in).nextLine();
                    System.out.println(client5.orderTaxi(id, type));
                }
            }
        }
    }
}