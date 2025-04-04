package iescamp.tienda.tienda.dao;

import iescamp.tienda.dao.DBUtil;
import iescamp.tienda.dao.GenericDAO;
import iescamp.tienda.dao.PedidoDAO;
import iescamp.tienda.modelo.Pedidos.LineaPedido;
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Pedidos.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class LineaPedidoDAO implements GenericDAO<LineaPedido, Integer> {


        @Override
        public void insertar(LineaPedido lineaPedido) {
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
                String sql = "INSERT INTO linea_pedido (num_pedido, cod_art) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, lineaPedido.getPedido().getNumeroPedido());
                pstmt.setInt(2, lineaPedido.getArticulo().getCod_art());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public LineaPedido obtenerPorId(Integer id) {
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
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

        @Override
        public List<LineaPedido> obtenerTodos() {
            List<LineaPedido> lineasPedido = new ArrayList<>();
            String sql = "SELECT * FROM linea_pedido";
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
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

        @Override
        public void actualizar(LineaPedido lineaPedido) {
            String sql = "UPDATE linea_pedido SET num_pedido = ?, cod_art = ? WHERE num_pedido = ?";
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, lineaPedido.getPedido().getNumeroPedido());
                pstmt.setInt(2, lineaPedido.getArticulo().getCod_art());

                pstmt.setInt(3, lineaPedido.getPedido().getNumeroPedido());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void eliminar(Integer id) {
            String sql = "DELETE FROM linea_pedido WHERE num_pedido = ?";
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public LineaPedido construirDesdeResultSet(ResultSet rs) throws SQLException {
            Articulo articulo = new ArticuloDAO().obtenerPorId(rs.getInt("cod_art"));
            Pedido pedido = new PedidoDAO().obtenerPorId(rs.getInt("num_pedido"));
            return new LineaPedido(
                    articulo,
                    pedido

            );
        }


            public List<LineaPedido> obtenerLineasPedidoPorPedido(int numeroPedido) {

                List<LineaPedido> lineasPedido = new ArrayList<>();
                String sql = "SELECT * FROM linea_pedido WHERE num_pedido = ?";
                try (Connection conn = DBUtil.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, numeroPedido);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        lineasPedido.add(construirDesdeResultSet(rs));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return lineasPedido;
            }
    }


