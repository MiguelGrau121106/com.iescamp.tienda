package iescamp.tienda.dao;

import iescamp.tienda.modelo.Usuarios.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente, String>{


    @Override
    public void insertar(Cliente obj) {
        try(Connection conn = DBUtil.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cliente (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, activo, pass, saldo_cuenta, cum_pedidos, dir_envio, tarjeta_fidelizacion, m_pago) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
            pstmt.setString(1, obj.getDNI());
            pstmt.setString(2,  obj.getNombre());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Bien hecho chaval! Libro insertado correctamente.");
            } else {
                System.out.println("No se insertó ningún libro.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cliente obtenerPorId(String id) {
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Cliente obj) {

    }

    @Override
    public void eliminar(String id) {

    }

    @Override
    public Cliente construirDesdeResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
