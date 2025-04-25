package iescamp.tienda.modelo.dao;

// Importación de clases del modelo
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Pedidos.LineaPedido;
import iescamp.tienda.modelo.Pedidos.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO que maneja las operaciones CRUD para la tabla 'linea_pedido'.
 */
public class LineaPedidoDAO implements GenericDAO<LineaPedido, Integer> {

    /**
     * Inserta una nueva línea de pedido en la base de datos.
     */
    @Override
    public void insertar(LineaPedido lineaPedido) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO linea_pedido (num_pedido, cod_art) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, lineaPedido.getPedido().getNumeroPedido()); // Número del pedido
            pstmt.setInt(2, lineaPedido.getArticulo().getCod_art());    // Código del artículo

            pstmt.executeUpdate(); // Ejecuta la inserción
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Devuelve una línea de pedido por su ID (si la tabla lo tuviera).
     */
    @Override
    public LineaPedido obtenerPorId(Integer id) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM linea_pedido WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return construirDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Devuelve todas las líneas de pedido de la base de datos.
     */
    @Override
    public List<LineaPedido> obtenerTodos() {
        List<LineaPedido> lineasPedido = new ArrayList<>();
        String sql = "SELECT * FROM linea_pedido";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lineasPedido.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lineasPedido;
    }

    /**
     * Actualiza una línea de pedido (aunque normalmente las líneas no cambian).
     * Ojo: está actualizando la línea basándose en el mismo num_pedido, puede que necesites usar un ID si la tabla lo tiene.
     */
    @Override
    public void actualizar(LineaPedido lineaPedido) {
        String sql = "UPDATE linea_pedido SET num_pedido = ?, cod_art = ? WHERE num_pedido = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, lineaPedido.getPedido().getNumeroPedido()); // Nuevo número de pedido (aunque sea el mismo)
            pstmt.setInt(2, lineaPedido.getArticulo().getCod_art());    // Nuevo código de artículo
            pstmt.setInt(3, lineaPedido.getPedido().getNumeroPedido()); // WHERE por número de pedido
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina todas las líneas de un pedido por su número.
     */
    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM linea_pedido WHERE num_pedido = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id); // Elimina por número de pedido
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Construye una línea de pedido a partir de un ResultSet.
     */
    @Override
    public LineaPedido construirDesdeResultSet(ResultSet rs) throws SQLException {
        Articulo articulo = new ArticuloDAO().obtenerPorId(rs.getInt("cod_art")); // Obtiene el artículo asociado
        Pedido pedido = new PedidoDAO().obtenerPorId(rs.getInt("num_pedido"));    // Obtiene el pedido asociado
        return new LineaPedido(
                articulo,
                pedido
        );
    }

    /**
     * Obtiene todas las líneas de un pedido específico.
     */
    public List<LineaPedido> obtenerLineasPedidoPorPedido(int numeroPedido) {
        List<LineaPedido> lineasPedido = new ArrayList<>();
        String sql = "SELECT * FROM linea_pedido WHERE num_pedido = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numeroPedido); // Número de pedido por el que buscar
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lineasPedido.add(construirDesdeResultSet(rs)); // Añade cada línea a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lineasPedido;
    }
}
