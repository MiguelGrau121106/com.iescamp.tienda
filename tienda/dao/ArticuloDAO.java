package iescamp.tienda.tienda.dao;

import iescamp.tienda.dao.DBUtil;
import iescamp.tienda.dao.GenericDAO;
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Articulos.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO implements GenericDAO<Articulo, Integer> {

    @Override
    public void insertar(Articulo articulo) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO articulo (cod_art, nombre, precio, marca, descripcion, activo, imagen, color, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, articulo.getCod_art());
            pstmt.setString(2, articulo.getNombre());
            pstmt.setDouble(3, articulo.getPrecio());
            pstmt.setString(4, articulo.getMarca());
            pstmt.setString(5, articulo.getDescripcion());
            pstmt.setBoolean(6, articulo.isActivo());
            pstmt.setString(7, articulo.getImagen());
            pstmt.setString(8, articulo.getColor());
            pstmt.setInt(9, articulo.getMaterial().getCodigo());
            pstmt.executeUpdate();




        } catch (SQLException e) {
            e.printStackTrace();
        }





    }

    @Override
    public Articulo obtenerPorId(Integer cod_art) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM articulo WHERE cod_art = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cod_art);
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
    public List<Articulo> obtenerTodos() {
        List<Articulo> articulo = new ArrayList<>();
        String sql = "SELECT * FROM articulo";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                articulo.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articulo;
    }


    @Override
    public void actualizar(Articulo articulo) {
        String sql = "UPDATE articulo SET nombre = ?, precio = ?, marca = ?, descripcion = ?, activo = ?, imagen = ?, color = ?, material= ? WHERE cod_art = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, articulo.getNombre());
            stmt.setDouble(2,articulo.getPrecio());
            stmt.setString(3, articulo.getMarca());
            stmt.setString(4, articulo.getDescripcion());
            stmt.setBoolean(5, articulo.isActivo());
            stmt.setString(6,articulo.getImagen());
            stmt.setString(7, articulo.getColor());
            stmt.setInt(8, articulo.getMaterial().getCodigo());
            stmt.setInt(9, articulo.getCod_art());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void eliminar (Integer cod_art){
        String sql = "DELETE FROM articulo WHERE cod_art = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cod_art);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //metodo auxiliar para poder obtener material desde su codigo.
    private Material obtenerMaterialPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT * FROM material WHERE codigo = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Material(rs.getInt("codigo"), rs.getString("denominacion"));
            }
        }
        return null;
    }

    @Override
    public Articulo construirDesdeResultSet (ResultSet rs) throws SQLException {
        return null;
    }
}
