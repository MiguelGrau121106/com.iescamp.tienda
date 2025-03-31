package iescamp.tienda.DAO;

import iescamp.tienda.modelo.Pedidos.LineaPedido;
import iescamp.tienda.modelo.Articulos.Articulo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  abstract class LineaPedidoDAO implements GenericDAO<LineaPedido, Integer> {
    public List<LineaPedido> obtenerLineasPedidoPorPedido(int num_pedido) {
        List<LineaPedido> lineasPedido = new ArrayList<>();
        String sql = "SELECT * FROM linea_pedido WHERE num_pedido = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, num_pedido);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Articulo articulo = new ArticuloDAO().obtenerPorId(rs.getInt("cod_art"));
                LineaPedido lineaPedido = new LineaPedido(articulo);
                lineasPedido.add(lineaPedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lineasPedido;
    }

}