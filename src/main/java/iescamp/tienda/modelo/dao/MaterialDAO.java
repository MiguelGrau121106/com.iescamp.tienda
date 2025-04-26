package iescamp.tienda.modelo.dao;

// Importa la clase Material del modelo
import iescamp.tienda.modelo.Articulos.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para acceder a los datos de la tabla 'material'.
 */
public class MaterialDAO implements GenericDAO<Material, Integer> {

    /**
     * Inserta un nuevo material en la base de datos.
     */
    @Override
    public void insertar(Material material) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO material (codigo, denominacion) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, material.getCodigo());             // Establece el código
            pstmt.setString(2, material.getDenominacion());    // Establece la denominación
            pstmt.executeUpdate();                             // Ejecuta la inserción
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene un material por su código (clave primaria).
     */
    @Override
    public Material obtenerPorId(Integer codigo) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM material WHERE codigo = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigo);
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

    /**
     * Devuelve todos los materiales almacenados en la base de datos.
     */
    @Override
    public List<Material> obtenerTodos() {
        List<Material> material = new ArrayList<>();
        String sql = "SELECT * FROM material";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                material.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }

    /**
     * Actualiza los datos de un material existente.
     */
    @Override
    public void actualizar(Material material) {
        String sql = "UPDATE material SET denominacion = ? WHERE codigo = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, material.getDenominacion()); // 1º: denominación nueva
            stmt.setInt(2, material.getCodigo());          // 2º: código que queremos actualizar

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un material por su código.
     */
    @Override
    public void eliminar(Integer codigo) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "DELETE FROM material WHERE codigo = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Construye un objeto Material a partir de un ResultSet.
     */
    @Override
    public Material construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new Material(
                rs.getInt("codigo"),
                rs.getString("denominacion")
        );
    }

    /**
     * Busca un material por su denominación (texto).
     */
    public Material obtenerPorDenominacion(String denominacion) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM material WHERE denominacion = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, denominacion);
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
}