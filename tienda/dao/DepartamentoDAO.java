package iescamp.tienda.dao;

import iescamp.tienda.modelo.Usuarios.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements GenericDAO<Departamento, Integer> {

    @Override
    public void insertar(Departamento departamento) {
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            String sql = "INSERT INTO departamento (codigo, nombre) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, departamento.getCodigo());
            pstmt.setString(2, departamento.getNombre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Departamento obtenerPorId(Integer codigo) {
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            String sql = "SELECT * FROM departamento WHERE codigo = ?";
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
    public List<Departamento> obtenerTodos() {
        List<Departamento> departamento = new ArrayList<>();
        String sql = "SELECT * FROM departamento";
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                departamento.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamento;
    }

    @Override
    public void actualizar(Departamento departamento) {
        String sql = "UPDATE departamento SET nombre = ? WHERE codigo = ?";
        try {
            Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, departamento.getNombre());
            stmt.setInt(2, departamento.getCodigo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer codigo) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "DELETE FROM departamento WHERE codigo = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Departamento construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new Departamento(
                rs.getInt("codigo"),
                rs.getString("nombre")
        );
    }
}
