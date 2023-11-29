package sixteen;

import java.sql.*;
import java.util.List;

public class ClientRealisation implements ClientDAO {
    private Connection connection;

    public ClientRealisation(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Client createClient(Client client) throws ClientAlreadyExistsException, SQLException {
        if (clientExists(client.getPhoneNumber())) {
            throw new ClientAlreadyExistsException("Client with phone number " + client.getPhoneNumber() + " already exists.");
        }

        String insertClientSQL = "INSERT INTO client (client_id, last_name, first_name, phone_number) VALUES (?, ?, ?, ?)";

        try (PreparedStatement insertClientStatement = connection.prepareStatement(insertClientSQL)) {
            insertClientStatement.setInt(1, client.getId());
            insertClientStatement.setString(2, client.getLastName());
            insertClientStatement.setString(3, client.getFirstName());
            insertClientStatement.setString(4, client.getPhoneNumber());
            insertClientStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return client;
    }

    private boolean clientExists(String phoneNumber) throws SQLException {
        String checkClientSQL = "SELECT 1 FROM client WHERE phone_number = ?";
        try (PreparedStatement checkClientStatement = connection.prepareStatement(checkClientSQL)) {
            checkClientStatement.setString(1, phoneNumber);
            try (ResultSet resultSet = checkClientStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    @Override
    public Client findClient(Integer id) {
        String findClientSQL = "SELECT * FROM client WHERE client_id = ?";
        Client client = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(findClientSQL)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    client = new Client(resultSet.getInt("client_id"),
                            resultSet.getString("last_name"),
                            resultSet.getString("first_name"),
                            resultSet.getString("phone_number"));
                } else {
                    System.out.println("Клиент с id " + id + " не найден.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return client;
    }
    @Override
    public Client updateClient(Client client) throws SQLException {
        String updateClientSQL = "UPDATE client SET last_name = ?, first_name = ?, phone_number = ? WHERE client_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateClientSQL)) {
            preparedStatement.setString(1, client.getLastName());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setInt(4, client.getId());

            preparedStatement.executeUpdate();
        }

        return client;
    }

    @Override
    public void deleteClient(Integer id) {
        String deleteClientSQL = "DELETE FROM client WHERE client_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteClientSQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> findClientPhoneNumbersBy(Pet pet) {
        return null;
    }

    @Override
    public List<Pet> getAllPetsOf(Client client) {
        return null;
    }
}
