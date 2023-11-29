package sixteen;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
    Client createClient(Client client) throws ClientAlreadyExistsException, SQLException;
    Client findClient(Integer id);
    Client updateClient(Client client) throws SQLException;
    void deleteClient(Integer id);
    List<String> findClientPhoneNumbersBy(Pet pet);
    List<Pet> getAllPetsOf(Client client);
}
