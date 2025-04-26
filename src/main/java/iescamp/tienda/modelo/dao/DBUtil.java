package iescamp.tienda.modelo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para gestionar conexiones a la base de datos.
 */
public class DBUtil {

    // URL de conexión a la base de datos MySQL que incluye el nombre de la base de datos.
    private static final String URL = "jdbc:mysql://localhost:3306/tienda_ropa";

    // Usuario y contraseña para acceder a la base de datos
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "monolito06";

    /**
     * Devuelve una nueva conexión a la base de datos.
     * @return conexión abierta
     * @throws SQLException si ocurre un error al conectar
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    /**
     * Cierra la conexión si no es null.
     * @param connection la conexión a cerrar
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                e.printStackTrace(); // Imprime el error si no se puede cerrar
            }
        }
    }
}
