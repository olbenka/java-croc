package fifteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DbCreator {

    private DbCreator() {
        throw new AssertionError("Instantiation not allowed");
    }

    public static void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        statement.execute("CREATE TABLE IF NOT EXISTS client(" +
                "client_id INT PRIMARY KEY, " +
                "last_name VARCHAR(255), " +
                "first_name VARCHAR(255), " +
                "phone_number VARCHAR(15)" +
                ")");
        statement.execute("CREATE TABLE IF NOT EXISTS pet (" +
                "pet_id INT PRIMARY KEY, " +
                "pet_name VARCHAR(255)," +
                "age INT" +
                ")");
        statement.execute("CREATE TABLE IF NOT EXISTS client_pet (" +
                "client_id INT," +
                "pet_id INT," +
                "PRIMARY KEY (client_id, pet_id)," +
                "FOREIGN KEY (client_id) REFERENCES client(client_id)," +
                "FOREIGN KEY (pet_id) REFERENCES pet(pet_id)" +
                ")");
    }

    public static void importData(Connection connection, String csvFilePath) {
        String insertClientSQL = "INSERT INTO client VALUES (?, ?, ?, ?)";
        String insertPetSQL = "INSERT INTO pet VALUES (?, ?, ?)";
        String insertClientPetSQL = "INSERT INTO client_pet VALUES (?, ?)";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath));
             PreparedStatement insertClientStatement = connection.prepareStatement(insertClientSQL);
             PreparedStatement insertPetStatement = connection.prepareStatement(insertPetSQL);
             PreparedStatement insertClientPetStatement = connection.prepareStatement(insertClientPetSQL)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                int clientId = Integer.parseInt(data[0]);
                String lastName = data[1];
                String firstName = data[2];
                String phoneNumber = data[3];

                int petId = Integer.parseInt(data[4]);
                String petName = data[5];
                int petAge = Integer.parseInt(data[6]);

                if (clientId <= 0 || lastName == null || firstName == null || phoneNumber == null) {
                    System.out.println("Неправильные данные о клиенте: " + line);
                    continue;
                }

                if (petId <= 0 || petName == null) {
                    System.out.println("Неправильные данные о питомце: " + line);
                    continue;
                }

                if (!clientExists(connection, clientId)) {
                    insertClientStatement.setInt(1, clientId);
                    insertClientStatement.setString(2, lastName);
                    insertClientStatement.setString(3, firstName);
                    insertClientStatement.setString(4, phoneNumber);
                    insertClientStatement.executeUpdate();
                }

                if (!petExists(connection, petId)) {
                    insertPetStatement.setInt(1, petId);
                    insertPetStatement.setString(2, petName);
                    insertPetStatement.setInt(3, petAge);
                    insertPetStatement.executeUpdate();
                }

                if (!clientPetExists(connection, clientId, petId)) {
                    insertClientPetStatement.setInt(1, clientId);
                    insertClientPetStatement.setInt(2, petId);
                    insertClientPetStatement.executeUpdate();
                }

            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean clientExists(Connection connection, int clientId) throws SQLException {
        String checkClientSQL = "SELECT 1 FROM client WHERE client_id = ?";
        try (PreparedStatement checkClientStatement = connection.prepareStatement(checkClientSQL)) {
            checkClientStatement.setInt(1, clientId);
            try (ResultSet resultSet = checkClientStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    private static boolean petExists(Connection connection, int petId) throws SQLException {
        String checkPetSQL = "SELECT 1 FROM pet WHERE pet_id = ?";
        try (PreparedStatement checkPetStatement = connection.prepareStatement(checkPetSQL)) {
            checkPetStatement.setInt(1, petId);
            try (ResultSet resultSet = checkPetStatement.executeQuery()) {
                return  resultSet.next();
            }
        }
    }

    private static boolean clientPetExists(Connection connection, int clientId, int petId) throws SQLException {
        String checkClientPetSQL = "SELECT 1 FROM CLIENT_PET WHERE CLIENT_ID = ? AND PET_ID = ?";
        try (PreparedStatement checkClientPetStatement = connection.prepareStatement(checkClientPetSQL)) {
            checkClientPetStatement.setInt(1, clientId);
            checkClientPetStatement.setInt(2, petId);
            try (ResultSet resultSet = checkClientPetStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }


    public static void printInfo(Connection connection) throws SQLException {
        System.out.println("client");
        Statement statement = connection.createStatement();
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM client")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("client_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String phoneNumber = resultSet.getString("phone_number");
                System.out.println("ID: " + id + ", last name: " + lastName +
                        ", first name: " + firstName + ", phone number: " + phoneNumber);

                printAssociatedPets(connection, id);
            }
        }
    }

    private static void printAssociatedPets(Connection connection, int clientId) throws SQLException {
        String selectPetsSQL = "SELECT pet.pet_id, pet.pet_name, pet.age " +
                "FROM pet " +
                "JOIN client_pet ON pet.pet_id = client_pet.pet_id " +
                "WHERE client_pet.client_id = ?";
        try (PreparedStatement selectPetsStatement = connection.prepareStatement(selectPetsSQL)) {
            selectPetsStatement.setInt(1, clientId);
            try (ResultSet petResultSet = selectPetsStatement.executeQuery()) {
                while (petResultSet.next()) {
                    int petId = petResultSet.getInt("pet_id");
                    String petName = petResultSet.getString("pet_name");
                    int petAge = petResultSet.getInt("age");
                    System.out.println("   Pet ID: " + petId + ", name: " + petName + ", age: " + petAge);
                }
            }
        }
    }
}

