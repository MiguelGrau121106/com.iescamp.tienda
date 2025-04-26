package iescamp.tienda.modelo.dao;

import iescamp.tienda.modelo.Usuarios.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para manejar operaciones CRUD sobre la tabla 'departamento'.
 */
public class DepartamentoDAO implements GenericDAO<Departamento, Integer> {

    /**
     * Inserta un nuevo departamento en la base de datos.
     */
    @Override
    public void insertar(Departamento departamento) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO departamento (codigo, nombre) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, departamento.getCodigo());   // Establece el código del departamento
            pstmt.setString(2, departamento.getNombre()); // Establece el nombre del departamento
            pstmt.executeUpdate(); // Ejecuta la inserción
        } catch (SQLException e) {
            e.printStackTrace(); // Muestra errores si ocurren
        }
    }

    /**
     * Devuelve un departamento por su código.
     */
    @Override
    public Departamento obtenerPorId(Integer codigo) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM departamento WHERE codigo = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigo); // Establece el valor del parámetro en la consulta
            ResultSet rs = pstmt.executeQuery(); // Ejecuta la consulta
            if (rs.next()) {
                return construirDesdeResultSet(rs); // Si se encuentra, construye y devuelve el objeto
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Devuelve null en caso de error
        }
        return null; // Devuelve null si no encuentra nada
    }

    /**
     * Obtiene todos los departamentos de la base de datos.
     */
    @Override
    public List<Departamento> obtenerTodos() {
        List<Departamento> departamento = new ArrayList<>();
        String sql = "SELECT * FROM departamento";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                departamento.add(construirDesdeResultSet(rs)); // Añade cada departamento a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamento; // Devuelve la lista completa
    }

    /**
     * Actualiza un departamento existente en la base de datos.
     */
    @Override
    public void actualizar(Departamento departamento) {
        String sql = "UPDATE departamento SET nombre = ? WHERE codigo = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, departamento.getNombre()); // Establece el nuevo nombre
            stmt.setInt(2, departamento.getCodigo());    // Establece el código del departamento
            stmt.executeUpdate(); // Ejecuta la actualización
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un departamento por su código.
     */
    @Override
    public void eliminar(Integer codigo) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "DELETE FROM departamento WHERE codigo = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigo); // Establece el código a eliminar
            pstmt.executeUpdate(); // Ejecuta la eliminación
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Construye un objeto Departamento a partir de un ResultSet.
     */
    @Override
    public Departamento construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new Departamento(
                rs.getInt("codigo"),  // Extrae el código del departamento
                rs.getString("nombre") // Extrae el nombre del departamento
        );
    }
}
