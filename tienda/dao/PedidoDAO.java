package iescamp.tienda.dao;

import iescamp.tienda.modelo.Pedidos.EstadoPedido;
import iescamp.tienda.modelo.Pedidos.Pedido;
import iescamp.tienda.modelo.Usuarios.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements GenericDAO<Pedido, Integer> {

    @Override
    public void insertar(Pedido pedido) {
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            String sql = "INSERT INTO pedido (numero, fecha, dir_envio, estado, m_pago, DNI_cliente) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pedido.getNumeroPedido());
            pstmt.setDate(2, Date.valueOf(pedido.getFechaPedido()));
            pstmt.setString(3, pedido.getDireccionEntrega());
            pstmt.setString(4, pedido.getEstado().getDescripcion());
            pstmt.setInt(5, pedido.getMetodoPago());
            pstmt.setString(6, pedido.getDNI());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido obtenerPorId(Integer numero) {
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            String sql = "SELECT * FROM pedido WHERE numero = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, numero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return construirDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;

    }

    @Override
    public List<Pedido> obtenerTodos() {
        List<Pedido> pedido = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pedido.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }


    @Override
    public void actualizar(Pedido pedido) {
        String sql = "UPDATE pedido SET fecha = ?, dir_envio = ?, estado = ?, m_pago = ? WHERE numero = ?";

        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(pedido.getFechaPedido())); //
            stmt.setString(2, pedido.getDireccionEntrega());
            stmt.setString(3, pedido.getEstado().getDescripcion());
            stmt.setInt(4, pedido.getMetodoPago());
            stmt.setInt(5, pedido.getNumeroPedido());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//int o integer
    @Override
    public void eliminar (Integer numero){
        String sql = "DELETE FROM pedido WHERE numero = ?";
        try {
            Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, numero);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido construirDesdeResultSet (ResultSet rs) throws SQLException {
        return new Pedido(
                rs.getInt("numero"),
                rs.getDate("fecha").toLocalDate(),
                EstadoPedido.DesdeString(rs.getString("estado")),
                rs.getString("dir_envio"),
                rs.getInt("m_pago"),
                rs.getString("DNI_cliente")

        );
    }

    public List<Pedido> obtenerPedidosPorCliente(Cliente cliente) throws SQLException {
        String sql = "SELECT * FROM pedido WHERE DNI_cliente = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getDNI());
            ResultSet rs = stmt.executeQuery();
            List<Pedido> pedidos = new ArrayList<>();
            while (rs.next()) {
                pedidos.add(construirDesdeResultSet(rs));
            }
            return pedidos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}



