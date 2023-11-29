package sixteen;

import java.sql.*;
import java.util.List;

public class PetRealisation implements PetDAO {
    Connection connection;

    public PetRealisation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Pet createPet(String name, Integer age, List<Client> clients) {
        return null;
    }

    @Override
    public Pet findPet(Integer medicalCardNumber) {
        return null;
    }

    @Override
    public Pet updatePet(Pet pet) {
        return null;
    }

    @Override
    public void deletePet(Integer medicalCardNumber) {

    }
}
