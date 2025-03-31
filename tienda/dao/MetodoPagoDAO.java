package iescamp.tienda.dao;


import iescamp.tienda.modelo.Usuarios.MetodoPago;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MetodoPagoDAO implements GenericDAO<MetodoPago, String>{

    @Override
    public void insertar(MetodoPago obj) {
     try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("INSERT INTO metodo_pago (codigo, descripcion) VALUES (?, ?)");
            pstmt.setInt(1, obj.getCodigo());
            pstmt.setString(2, obj.getDescripcion());
            pstmt.executeUpdate();

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se ha insertado el metodo de pago correctamente.");
            } else {
                System.out.println("No se insertó ningun metodo de pago.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public MetodoPago obtenerPorId(String codigo) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("SELECT * FROM metodo_pago WHERE codigo = ?");
            pstmt.setString(1, codigo);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                return construirDesdeResultSet(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MetodoPago> obtenerTodos() {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("SELECT * FROM metodo_pago");
            var rs = pstmt.executeQuery();
            List<MetodoPago> metodosPago = new java.util.ArrayList<>();
            while (rs.next()) {
                metodosPago.add(construirDesdeResultSet(rs));
            }
            return metodosPago;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(MetodoPago obj) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("UPDATE metodo_pago SET descripcion = ? WHERE codigo = ?");
            pstmt.setString(1, obj.getDescripcion());
            pstmt.setInt(2, obj.getCodigo());
            pstmt.executeUpdate();

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se ha actualizado el metodo de pago correctamente.");
            } else {
                System.out.println("No se actualizó ningun metodo de pago.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(String id) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("DELETE FROM metodo_pago WHERE codigo = ?");
            pstmt.setString(1, id);
            var filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se ha eliminado el metodo de pago correctamente.");
            } else {
                System.out.println("No se ha eliminado ningun metodo de pago.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MetodoPago construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new MetodoPago(
                rs.getInt("codigo"),
                rs.getString("descripcion")
        );
    }

    public MetodoPago obtenerPorDescripcion(String descripcion) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("SELECT * FROM metodo_pago WHERE descripcion = ?");
            pstmt.setString(1, descripcion);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                return construirDesdeResultSet(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
