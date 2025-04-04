package iescamp.tienda.tienda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/tienda_ropa";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "MySQL24-25";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


