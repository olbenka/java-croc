package sixteen;

import java.sql.SQLException;
import java.util.List;

public interface PetDAO {
    Pet createPet(String name, Integer age, List<Client> clients) throws SQLException;
    Pet findPet(Integer medicalCardNumber);
    Pet updatePet(Pet pet);
    void deletePet(Integer medicalCardNumber);
}
