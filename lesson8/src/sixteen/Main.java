package sixteen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            Client client1 = new Client(13,"Альжапаровa", "Альбинa", "+79510336740");
            ClientDAO clientDAO = new ClientRealisation(connection);
            try {
                clientDAO.deleteClient(13);
                Client createdClient = clientDAO.createClient(client1);
                System.out.println("Создан: " + createdClient.getFirstName());
            } catch (ClientAlreadyExistsException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            Client foundClient = clientDAO.findClient(13);
            if (foundClient != null) {
                System.out.println("Найден: " + foundClient.getFirstName());
                System.out.println("Информация о клиенте до обновления: " + foundClient.getFirstName());

                foundClient.setFirstName("Алла");
                foundClient.setLastName("Пугачева");
                foundClient.setPhoneNumber("+79998887766");

                clientDAO.updateClient(foundClient);
                foundClient = clientDAO.findClient(13);

                System.out.println("Информация о клиенте после обновления: " + foundClient.getFirstName());
            }
            Client client2 = new Client(14,"Пугачев", "Анатолий", "+79510554540");
            //clientDAO.deleteClient(13);
            //System.out.println("Клиент был удален");

            PetDAO petDAO = new PetRealisation(connection);
            // я доделаю






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
