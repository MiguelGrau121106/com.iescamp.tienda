package iescamp.tienda.modelo.dao;

import iescamp.tienda.modelo.Pedidos.EstadoPedido;
import iescamp.tienda.modelo.Pedidos.Pedido;
import iescamp.tienda.modelo.Usuarios.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO que maneja las operaciones CRUD para la tabla 'pedido'.
 */
public class PedidoDAO implements GenericDAO<Pedido, Integer> {

    /**
     * Inserta un nuevo pedido en la base de datos.
     *
     * @param pedido Objeto de tipo Pedido que será insertado en la base de datos.
     */
    @Override
    public void insertar(Pedido pedido) {
        try (Connection conn = DBUtil.getConnection()) {  // Establece la conexión con la base de datos
            String sql = "INSERT INTO pedido (numero, fecha, dir_envio, estado, m_pago, DNI_cliente) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);  // Prepara la consulta SQL
            pstmt.setInt(1, pedido.getNumeroPedido());  // Establece el número del pedido
            pstmt.setDate(2, Date.valueOf(pedido.getFechaPedido()));  // Establece la fecha del pedido
            pstmt.setString(3, pedido.getDireccionEntrega());  // Establece la dirección de envío
            pstmt.setString(4, pedido.getEstado().getDescripcion());  // Establece el estado del pedido
            pstmt.setInt(5, pedido.getMetodoPago());  // Establece el método de pago
            pstmt.setString(6, pedido.getDNI());  // Establece el DNI del cliente
            pstmt.executeUpdate();  // Ejecuta la inserción en la base de datos
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre una excepción, la imprime
        }
    }

    /**
     * Devuelve un pedido por su número de identificación.
     *
     * @param numero Número de identificación del pedido.
     * @return El objeto Pedido correspondiente o null si no se encuentra.
     */
    @Override
    public Pedido obtenerPorId(Integer numero) {
        try (Connection conn = DBUtil.getConnection()) {  // Establece la conexión con la base de datos
            String sql = "SELECT * FROM pedido WHERE numero = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);  // Prepara la consulta SQL
            pstmt.setInt(1, numero);  // Establece el número del pedido
            ResultSet rs = pstmt.executeQuery();  // Ejecuta la consulta y obtiene los resultados
            if (rs.next()) {  // Si se encuentra un resultado
                return construirDesdeResultSet(rs);  // Construye el objeto Pedido desde el ResultSet
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre una excepción, la imprime
        }
        return null;  // Si no se encuentra el pedido, devuelve null
    }

    /**
     * Devuelve todos los pedidos de la base de datos.
     *
     * @return Lista de todos los pedidos.
     */
    @Override
    public List<Pedido> obtenerTodos() {
        List<Pedido> pedido = new ArrayList<>();  // Lista para almacenar los pedidos
        String sql = "SELECT * FROM pedido";
        try (Connection conn = DBUtil.getConnection();  // Establece la conexión con la base de datos
             Statement stmt = conn.createStatement();  // Crea un Statement para ejecutar la consulta
             ResultSet rs = stmt.executeQuery(sql)) {  // Ejecuta la consulta
            while (rs.next()) {  // Itera sobre los resultados obtenidos
                pedido.add(construirDesdeResultSet(rs));  // Agrega el pedido a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre una excepción, la imprime
        }
        return pedido;  // Devuelve la lista de pedidos
    }

    /**
     * Actualiza los datos de un pedido existente.
     *
     * @param pedido El objeto Pedido con los nuevos datos.
     */
    @Override
    public void actualizar(Pedido pedido) {
        String sql = "UPDATE pedido SET fecha = ?, dir_envio = ?, estado = ?, m_pago = ? WHERE numero = ?";
        try (Connection conn = DBUtil.getConnection();  // Establece la conexión con la base de datos
             PreparedStatement stmt = conn.prepareStatement(sql)) {  // Prepara la consulta de actualización
            stmt.setDate(1, Date.valueOf(pedido.getFechaPedido()));  // Establece la nueva fecha del pedido
            stmt.setString(2, pedido.getDireccionEntrega());  // Establece la nueva dirección de envío
            stmt.setString(3, pedido.getEstado().getDescripcion());  // Establece el nuevo estado del pedido
            stmt.setInt(4, pedido.getMetodoPago());  // Establece el nuevo método de pago
            stmt.setInt(5, pedido.getNumeroPedido());  // Establece el número del pedido para identificarlo
            stmt.executeUpdate();  // Ejecuta la actualización en la base de datos
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre una excepción, la imprime
        }
    }

    /**
     * Elimina un pedido de la base de datos por su número de identificación.
     *
     * @param numero Número de identificación del pedido a eliminar.
     */
    @Override
    public void eliminar(Integer numero) {
        String sql = "DELETE FROM pedido WHERE numero = ?";
        try (Connection conn = DBUtil.getConnection();  // Establece la conexión con la base de datos
             PreparedStatement stmt = conn.prepareStatement(sql)) {  // Prepara la consulta de eliminación
            stmt.setInt(1, numero);  // Establece el número del pedido para identificarlo
            stmt.executeUpdate();  // Ejecuta la eliminación del pedido
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre una excepción, la imprime
        }
    }

    /**
     * Construye un objeto Pedido desde un ResultSet.
     *
     * @param rs El ResultSet con los datos del pedido.
     * @return El objeto Pedido construido con los datos del ResultSet.
     * @throws SQLException Si ocurre un error al leer los datos del ResultSet.
     */
    @Override
    public Pedido construirDesdeResultSet(ResultSet rs) throws SQLException {
        // Crea un objeto Pedido a partir de los datos del ResultSet
        return new Pedido(
                rs.getInt("numero"),
                rs.getDate("fecha").toLocalDate(),  // Convierte la fecha SQL a LocalDate
                EstadoPedido.DesdeString(rs.getString("estado")),  // Obtiene el estado del pedido
                rs.getString("dir_envio"),  // Dirección de envío
                rs.getInt("m_pago"),  // Método de pago
                rs.getString("DNI_cliente")  // DNI del cliente
        );
    }

    /**
     * Devuelve todos los pedidos realizados por un cliente específico.
     *
     * @param cliente El cliente cuyas líneas de pedido queremos obtener.
     * @return Lista de pedidos realizados por el cliente.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public List<Pedido> obtenerPedidosPorCliente(Cliente cliente) throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();  // Lista para almacenar los pedidos del cliente
        String sql = "SELECT * FROM pedido WHERE DNI_cliente = ?";
        try (Connection conn = DBUtil.getConnection();  // Establece la conexión con la base de datos
             PreparedStatement stmt = conn.prepareStatement(sql)) {  // Prepara la consulta SQL
            stmt.setString(1, cliente.getDNI());  // Establece el DNI del cliente
            ResultSet rs = stmt.executeQuery();  // Ejecuta la consulta y obtiene los resultados
            while (rs.next()) {  // Itera sobre los resultados obtenidos
                pedidos.add(construirDesdeResultSet(rs));  // Agrega cada pedido a la lista
            }
            return pedidos;  // Devuelve la lista de pedidos
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre una excepción, la imprime
            return null;  // Si ocurre un error, devuelve null
        }
    }
}
