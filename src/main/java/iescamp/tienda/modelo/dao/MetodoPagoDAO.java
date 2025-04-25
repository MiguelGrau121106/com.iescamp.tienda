package iescamp.tienda.modelo.dao;

import iescamp.tienda.modelo.Usuarios.MetodoPago;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO para la tabla metodo_pago.
 */
public class MetodoPagoDAO implements GenericDAO<MetodoPago, Integer> {

    /**
     * Inserta un nuevo método de pago.
     */
    @Override
    public void insertar(MetodoPago obj) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("INSERT INTO metodo_pago (codigo, descripcion) VALUES (?, ?)");
            pstmt.setInt(1, obj.getCodigo());
            pstmt.setString(2, obj.getDescripcion());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se ha insertado el método de pago correctamente.");
            } else {
                System.out.println("No se insertó ningún método de pago.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene un método de pago por su código.
     */
    @Override
    public MetodoPago obtenerPorId(Integer codigo) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("SELECT * FROM metodo_pago WHERE codigo = ?");
            pstmt.setInt(1, codigo);
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

    /**
     * Obtiene todos los métodos de pago.
     */
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

    /**
     * Actualiza un método de pago existente.
     */
    @Override
    public void actualizar(MetodoPago obj) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("UPDATE metodo_pago SET descripcion = ? WHERE codigo = ?");
            pstmt.setString(1, obj.getDescripcion());
            pstmt.setInt(2, obj.getCodigo());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se ha actualizado el método de pago correctamente.");
            } else {
                System.out.println("No se actualizó ningún método de pago.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Elimina un método de pago por su código.
     */
    @Override
    public void eliminar(Integer codigo) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("DELETE FROM metodo_pago WHERE codigo = ?");
            pstmt.setInt(1, codigo);
            var filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se ha eliminado el método de pago correctamente.");
            } else {
                System.out.println("No se ha eliminado ningún método de pago.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Construye un objeto MetodoPago desde un ResultSet.
     */
    @Override
    public MetodoPago construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new MetodoPago(
                rs.getInt("codigo"),
                rs.getString("descripcion")
        );
    }

    /**
     * Método auxiliar para buscar un método de pago por su descripción.
     */
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
