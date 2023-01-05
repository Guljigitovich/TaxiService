package service.classesImpl;

import classes.Client;
import classes.Taxi;
import dao.Database;
import service.ClientService;

import java.time.LocalDate;
import java.util.*;

public class ClientImpl implements ClientService {
    private Database database;
    @Override
    public String addClient(Client client) {
        this.database.clientSet.add(client);
        return "Successfully add client !";
    }

    @Override
    public String addClient(List<Client> clients) {
        this.database.clientSet.addAll(clients);
        return "Successfully add clients !";
    }

    @Override
    public List<Client> getClientByName(String name) {
        return database.clientSet.stream().filter(s->s.equals(name.toUpperCase())).toList();
    }

    @Override
    public Client removeClientById(Long id) {
        Client count = null;
        for (Client client : database.clientSet) {
            if(id.equals(client.getId())){
                count = client;
                database.clientSet.remove(count);
            }
        }
        return count;
    }

    @Override
    public Taxi orderTaxi(Long clientId, String taxiType) {
        Taxi taxi = null;
        for (Client c: database.clientSet) {
            for (Taxi t: database.taxis) {
            if(clientId.equals(c.getId())){
                if(taxiType.equals(t.getTaxiType().name())){
                    taxi = t;
                }
            }
            }
        }
        return taxi;
    }

    @Override
    public Map<Integer, Client> getClientAge() {
        Map<Integer,Client>clientMap = new HashMap<>();
        for (Client c: database.clientSet) {
            int age= c.getDateOfBirth().minusYears(LocalDate.now().getYear()).getYear();
            clientMap.put(age,c);
        }
        return clientMap;
    }

    @Override
    public void universalSorting(String word) {
        for (Client c : database.clientSet) {
            if (word.equals("Full name")){
                database.clientSet.stream().sorted(Comparator.comparing(Client::getFullName)).forEach(System.out::println);
            }if(word.equals("Id")){
                database.clientSet.stream().sorted(Comparator.comparing(Client::getId)).forEach(System.out::println);
            }if(word.equals("Phone number")){
                database.clientSet.stream().sorted(Comparator.comparing(Client::getPhoneNumber)).forEach(System.out::println);
            }if(word.equals("Money")){
                database.clientSet.stream().sorted(Comparator.comparing(Client::getMoney)).forEach(System.out::println);
            }if(word.equals("Date of birth")){
                database.clientSet.stream().sorted(Comparator.comparing(Client::getDateOfBirth)).forEach(System.out::println);
            }

        }
    }
}
