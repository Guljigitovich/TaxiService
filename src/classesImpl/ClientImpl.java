package classesImpl;

import classes.Client;
import dao.Database;
import service.ClientService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        return null;
    }

    @Override
    public Map<Integer, Client> getClientAge() {
        Client count = null;
        for (Client c: database.clientSet) {
            c.getDateOfBirth().minusYears(LocalDate.now().getDayOfYear());
            count = c;
        }
        return null;
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
