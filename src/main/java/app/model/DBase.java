package app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBase {
    private static DBase instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost/mydbase";
    private String username = "postgres";
    private String password = "root";

    private DBase() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Success!");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBase getInstance() throws SQLException {
        if (instance == null) {
           instance = new DBase();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBase();
        }

        return instance;
    }

}
