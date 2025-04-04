package iescamp.tienda.tienda.dao;

import iescamp.tienda.dao.DBUtil;
import iescamp.tienda.dao.GenericDAO;
import iescamp.tienda.modelo.Usuarios.Cliente;
import iescamp.tienda.modelo.Usuarios.Departamento;
import iescamp.tienda.modelo.Usuarios.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements GenericDAO<Empleado, String> {
    @Override
    public void insertar(Empleado obj) {
        try(Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO empleado (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, activo, pass, saldo_cuenta, cum_pedidos, dir_envio, tarjeta_fidelizacion, m_pago) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getDNI());
            pstmt.setString(2,  obj.getNombre());
            pstmt.setString(3, obj.getApellidos());
            pstmt.setString(4, obj.getTelefono());
            pstmt.setDate(5, Date.valueOf(obj.getFechaNacimiento()));
            pstmt.setString(6, obj.getDireccion());
            pstmt.setString(7, obj.getCorreoElectronico());
            pstmt.setBoolean(8, obj.isActivo());
            pstmt.setString(9, obj.getPass());
            pstmt.setBoolean(10, obj.isPrivilegio());
            pstmt.setString(11, obj.getDepartamento().toString());


            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se a insertado el empleado correctamente.");
            } else {
                System.out.println("No se insertó ningún empleado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Empleado obtenerPorId(String DNI) {
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM empleado WHERE DNI = ?");
            pstmt.setString(1, DNI);
            ResultSet rs = pstmt.executeQuery();
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
    public java.util.List<Empleado> obtenerTodos() {
        List<Empleado> pedido = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
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
    public void actualizar(Empleado obj) {
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE empleado SET DNI = ?, nombre = ?, apellidos = ?, telefono = ?, f_nacimiento = ?, direccion = ?, email = ?, activo = ?, pass = ?, tiene_privilegios = ?, dpto = ? WHERE DNI = ?");
            pstmt.setString(1, obj.getDNI());
            pstmt.setString(2,  obj.getNombre());
            pstmt.setString(3, obj.getApellidos());
            pstmt.setString(4, obj.getTelefono());
            pstmt.setDate(5, Date.valueOf(obj.getFechaNacimiento()));
            pstmt.setString(6, obj.getDireccion());
            pstmt.setString(7, obj.getCorreoElectronico());
            pstmt.setBoolean(8, obj.isActivo());
            pstmt.setString(9, obj.getPass());
            pstmt.setBoolean(10, obj.isPrivilegio());
            pstmt.setString(11, obj.getDepartamento().toString());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se a actualizado el empleado correctamente.");
            } else {
                System.out.println("No se actualizado ningún empleado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(String DNI) {
        try  (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM cliente WHERE DNI = ?");
            pstmt.setString(1, DNI);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se ha eliminado el empleado correctamente.");
            } else {
                System.out.println("No se ha eliminado ningún empleado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public Empleado construirDesdeResultSet(ResultSet rs) throws SQLException {
        Departamento departamento = new DepartamentoDAO().obtenerPorId(rs.getInt("dpto"));

        return new Empleado(
                rs.getString("DNI"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("direccion"),
                rs.getString("email"),
                rs.getString("telefono"),
                rs.getDate("f_nacimiento").toLocalDate(),
                rs.getString("pass"),


                rs.getBoolean("activo"),
                rs.getBoolean("tiene_privilegios"),
                departamento
        );
    }
    public Empleado obtenerPorEmail(String email) {
        try (var conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("SELECT * FROM empleado WHERE email = ?");
            pstmt.setString(1, email);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                return construirDesdeResultSet(rs);
            } else {
                return null;
            }
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Empleado autenticarEmpleado(String email, String pass) {
        try (var conn = DBUtil.getConnection()) {
            var pstmt = conn.prepareStatement("SELECT * FROM empleado WHERE email = ? AND pass = ?");
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                return construirDesdeResultSet(rs);
            } else {
                return null;
            }
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
