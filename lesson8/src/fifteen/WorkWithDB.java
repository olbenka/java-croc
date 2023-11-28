package fifteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class WorkWithDB {
    public static void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS client(" +
                "client_id INT PRIMARY KEY, " +
                "last_name VARCHAR(255), " +
                "first_name VARCHAR(255), " +
                "phone_number VARCHAR(15)" +
                ")");
        statement.execute("CREATE TABLE IF NOT EXISTS pets (" +
                "pet_id INT PRIMARY KEY, " +
                "client_id INT," +
                "pet_name VARCHAR(255)," +
                "age INT," +
                "FOREIGN KEY (client_id) REFERENCES client(client_id)" +
                ")");
    }


    public static void importData(Connection connection, String csvFilePath) {
        String insertClientSQL = "INSERT INTO client VALUES (?, ?, ?, ?)";
        String insertPetSQL = "INSERT INTO pets VALUES (?, ?, ?, ?)";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath));
             PreparedStatement insertClientStatement = connection.prepareStatement(insertClientSQL);
             PreparedStatement insertPetStatement = connection.prepareStatement(insertPetSQL)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                int clientId = Integer.parseInt(data[0]);
                String lastName = data[1];
                String firstName = data[2];
                String phoneNumber = data[3];

                int petId = Integer.parseInt(data[4]);
                int petClientId = Integer.parseInt(data[0]);
                String petName = data[5];
                int petAge = Integer.parseInt(data[6]);

                if (!clientExists(connection, clientId)) {
                    insertClientStatement.setInt(1, clientId);
                    insertClientStatement.setString(2, lastName);
                    insertClientStatement.setString(3, firstName);
                    insertClientStatement.setString(4, phoneNumber);
                    insertClientStatement.executeUpdate();
                }

                if (!petExists(connection, petId)) {
                    insertPetStatement.setInt(1, petId);
                    insertPetStatement.setInt(2, petClientId);
                    insertPetStatement.setString(3, petName);
                    insertPetStatement.setInt(4, petAge);
                    insertPetStatement.executeUpdate();
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
        String checkPetSQL = "SELECT 1 FROM pets WHERE pet_id = ?";
        try (PreparedStatement checkPetStatement = connection.prepareStatement(checkPetSQL)) {
            checkPetStatement.setInt(1, petId);
            try (ResultSet resultSet = checkPetStatement.executeQuery()) {
                return  resultSet.next();
            }
        }
    }

    public static void printInfo(Connection connection) throws SQLException {
        System.out.println("client");
        Statement statement = connection.createStatement();
        try (ResultSet resultSet = statement.executeQuery("select * from client")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("client_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String phoneNumber = resultSet.getString("phone_number");
                System.out.println("ID: " + id + ", last name: " + lastName +
                        ", first name: " + firstName + ", phone number: " + phoneNumber);
            }
        }
        System.out.println("pets");
        try (ResultSet resultSet = statement.executeQuery("select * from pets")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("pet_id");
                int c_id = resultSet.getInt("client_id");
                String petName = resultSet.getString("pet_name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", client id: " + c_id +
                        ", name: " + petName + ", age: " + age);
            }
        }
    }
}

