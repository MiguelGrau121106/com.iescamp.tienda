package iescamp.tienda.dao;

import iescamp.tienda.modelo.Articulos.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO implements GenericDAO<Material, Integer> {
    @Override
    public void insertar(Material material) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO material (codigo, denominacion) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, material.getCodigo());
            pstmt.setString(2, material.getDenominacion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    @Override
    public void actualizar(Material material) {
        String sql = "UPDATE material SET denominacion = ? WHERE codigo = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, material.getCodigo());
            stmt.setString(2, material.getDenominacion());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    @Override
    public Material construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new Material(
                rs.getInt("codigo"),
                rs.getString("denominacion")
        );
    }
}
