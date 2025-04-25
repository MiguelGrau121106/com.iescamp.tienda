package iescamp.tienda.modelo.dao;

import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Articulos.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para manejar operaciones CRUD sobre la tabla 'articulo' en la base de datos.
 */
public class ArticuloDAO implements GenericDAO<Articulo, Integer> {

    @Override
    public void insertar(Articulo articulo) {
        // Inserta un nuevo artículo en la base de datos
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
        // Busca un artículo por su ID
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM articulo WHERE cod_art = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cod_art);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Construye el objeto a partir del resultado
                return construirDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Articulo> obtenerTodos() {
        // Obtiene todos los artículos de la tabla
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
        // Actualiza un artículo existente
        String sql = "UPDATE articulo SET nombre = ?, precio = ?, marca = ?, descripcion = ?, activo = ?, imagen = ?, color = ?, material = ? WHERE cod_art = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, articulo.getNombre());
            stmt.setDouble(2, articulo.getPrecio());
            stmt.setString(3, articulo.getMarca());
            stmt.setString(4, articulo.getDescripcion());
            stmt.setBoolean(5, articulo.isActivo());
            stmt.setString(6, articulo.getImagen());
            stmt.setString(7, articulo.getColor());
            stmt.setInt(8, articulo.getMaterial().getCodigo());
            stmt.setInt(9, articulo.getCod_art());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer cod_art) {
        // Elimina un artículo por su ID
        String sql = "DELETE FROM articulo WHERE cod_art = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cod_art);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método auxiliar que obtiene un objeto Material desde su código (clave primaria).
     */
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
    public Articulo construirDesdeResultSet(ResultSet rs) throws SQLException {
        // Este método debe construir y devolver un objeto Articulo desde un ResultSet
        // Esta sin implementar por que Articulo es una clase abstracta

        return null;
    }
}
