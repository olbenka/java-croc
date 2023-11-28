package fifteen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static fifteen.WorkWithDB.*;

public class VetClinicApp {
    public static void main(String[] args) {
        String csvFilePath = args[0];
        //String csvFilePath = "src/fifthteen/info.csv";
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            createTables(connection);
            importData(connection, csvFilePath);
            printInfo(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
