package pl.coderslab.team2.dao;

import pl.coderslab.team2.entity.Client;
import pl.coderslab.team2.services.DbService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    public static int saveToDb(Client client) {
        int result = 0;
        String query = "insert into clients values(null, ?, ?, ?, ?);";
        List<String> params = new ArrayList<>();
        params.add(client.getFirstName());
        params.add(client.getLastName());
        params.add(client.getBirthDate());
        try {
            result = DbService.insertIntoDatabase(query, params);
        } catch (SQLException e) {
            //TODO redirect to empty client form with info "operation failed"
            e.printStackTrace();
        }
        return result;
    }

    public static int updateUserDataInDb(Client client) {
        int result = 0;
        String query = "update clients set firstName = ?, lastName = ?, birthDate = ? where id = ?;";
        List<String> params = new ArrayList<>();
        params.add(client.getFirstName());
        params.add(client.getLastName());
        params.add(client.getBirthDate());
        params.add(String.valueOf(client.getId()));
        try {
            result = DbService.executeQuery(query, params);
        } catch (SQLException e) {
            //TODO redirect to empty client form with info "operation failed"
            e.printStackTrace();
        }
        return result;
    }

    public static List<Client> loadAll() {
        String query = "select * from clients;";
        List<Client> clients = new ArrayList<>();
        List<String[]> allClients = new ArrayList<>();
        try {
            allClients = DbService.getData(query, null);
        } catch (SQLException e) {
            //TODO redirect to empty client form with info "operation failed"
            e.printStackTrace();
        }

        for (String[] clientList : allClients
        ) {
            Client client = new Client();
            client.setId(Integer.parseInt(clientList[0]));
            client.setFirstName(clientList[1]);
            client.setLastName(clientList[2]);
            client.setBirthDate(clientList[3]);
            clients.add(client);
        }
        return clients;
    }


    public static Client findById(int id) {
        String query = "select * from clients where id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<String[]> clientListFromDb = new ArrayList<>();
        try {
            clientListFromDb = DbService.getData(query, params);
        } catch (SQLException e) {
            //TODO redirect to empty client form with info "client doesn't exist"
            e.printStackTrace();
        }
        String[] clientList = clientListFromDb.get(0);
        Client client = new Client();
        client.setId(Integer.parseInt(clientList[0]));
        client.setFirstName(clientList[1]);
        client.setLastName(clientList[2]);
        client.setBirthDate(clientList[3]);
        return client;
    }

    public static int delete(int id) {
        String query = "delete from clients where id = ?";
        List<String> params = new ArrayList<>();
        int result = 0;
        params.add(String.valueOf(id));
        try {
            result = DbService.executeQuery(query, params);
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO redirect to empty client form with info "operation failed"
        }
        return result;
    }

}
