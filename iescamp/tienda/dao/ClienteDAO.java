package iescamp.tienda.dao;

import iescamp.tienda.modelo.Usuarios.Cliente;
import iescamp.tienda.modelo.Usuarios.MetodoPago;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente, String>{


    @Override
    public void insertar(Cliente obj) {
        try(Connection conn = DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cliente (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, activo, pass, saldo_cuenta, cum_pedidos, dir_envio, tarjeta_fidelizacion, m_pago) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, obj.getDNI());
            pstmt.setString(2,  obj.getNombre());
            pstmt.setString(3, obj.getApellidos());
            pstmt.setString(4, obj.getTelefono());
            pstmt.setDate(5, Date.valueOf(obj.getFechaNacimiento()));
            pstmt.setString(6, obj.getDireccion());
            pstmt.setString(7, obj.getCorreoElectronico());
            pstmt.setBoolean(8, obj.isActivo());
            pstmt.setString(9, obj.getPass());
            pstmt.setDouble(10, obj.getSaldoCuenta());
            pstmt.setInt(11, obj.getNumeroPedidosRealizados());
            pstmt.setString(12, obj.getDireccionEnvio());
            pstmt.setBoolean(13, obj.isTieneTarjetaFidelidad());
            pstmt.setInt(14, obj.getMetodoPago().getCodigo());


            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se a insertado el cliente correctamente.");
            } else {
                System.out.println("No se insertó ningún cliente.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cliente obtenerPorId(String DNI) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM cliente WHERE DNI = ?");
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
    public List<Cliente> obtenerTodos() {
        List<Cliente> cliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cliente.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }


    @Override
    public void actualizar(Cliente obj) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE cliente SET DNI = ?, nombre = ?, apellidos = ?, telefono = ?, f_nacimiento = ?, direccion = ?, email = ?, activo = ?, pass = ?, saldo_cuenta = ?, cum_pedidos = ?, dir_envio = ?, tarjeta_fidelizacion = ?, m_pago = ? WHERE DNI = ?");
            pstmt.setString(1, obj.getDNI());
            pstmt.setString(2,  obj.getNombre());
            pstmt.setString(3, obj.getApellidos());
            pstmt.setString(4, obj.getTelefono());
            pstmt.setDate(5, Date.valueOf(obj.getFechaNacimiento()));
            pstmt.setString(6, obj.getDireccion());
            pstmt.setString(7, obj.getCorreoElectronico());
            pstmt.setBoolean(8, obj.isActivo());
            pstmt.setString(9, obj.getPass());
            pstmt.setDouble(10, obj.getSaldoCuenta());
            pstmt.setInt(11, obj.getNumeroPedidosRealizados());
            pstmt.setString(12, obj.getDireccionEnvio());
            pstmt.setBoolean(13, obj.isTieneTarjetaFidelidad());
            pstmt.setInt(14, obj.getMetodoPago().getCodigo());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se a actualizado el cliente correctamente.");
            } else {
                System.out.println("No se actualizado ningún cliente.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void eliminar(String DNI) {
        try  (Connection conn = DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM cliente WHERE DNI = ?");
            pstmt.setString(1, DNI);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se ha eliminado el cliente correctamente.");
            } else {
                System.out.println("No se ha eliminado ningún cliente.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    private MetodoPago obtenerMPagoPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT * FROM metodo_pago WHERE codigo = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new MetodoPago(rs.getInt("codigo"), rs.getString("denominacion"));
            }
        }
        return null;
    }

    @Override
    public Cliente construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getString("DNI"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("telefono"),
                rs.getString("email"),
                rs.getString("direccion"),
                rs.getDate("f_nacimiento").toLocalDate(),
                rs.getString("pass"),
                rs.getBoolean("activo"),
                rs.getString("dir_envio"),
                rs.getInt("num_pedidos"),
                rs.getBoolean("tarjeta_fidelizacion"),
                (int) rs.getDouble("saldo_cuenta"),
                obtenerMPagoPorCodigo(rs.getInt("m_pago"))
        );
    }

    public Cliente autenticarCliente(String email, String pass) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM cliente WHERE email = ? AND pass = ?");
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
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

    public Cliente obtenerPorEmail(String email, String pass) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM cliente WHERE email = ? AND pass = ?");
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
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


}
