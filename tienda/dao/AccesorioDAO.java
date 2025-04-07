package iescamp.tienda.dao;

import iescamp.tienda.modelo.Articulos.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccesorioDAO implements GenericDAO<Accesorio, Integer> {

    @Override
    public void insertar(Accesorio accesorio) {
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            ArticuloDAO Adao = new ArticuloDAO();
            Adao.insertar(accesorio);
            String sql = "INSERT INTO accesorio (cod_art, estilo, personalizado, tipo_cierre_bolso, capacidad, talla_zapato, tipo_suela, tipo_accesorio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accesorio.getCod_art());
            pstmt.setString(2, accesorio.getEstilo());
            pstmt.setBoolean(3, accesorio.getEsPersonalizado());

            if (accesorio instanceof Bolso) {
                pstmt.setString(4, ((Bolso) accesorio).getTipoCierre());
                pstmt.setInt(5, ((Bolso) accesorio).getCapacidad());
                pstmt.setNull(6, Types.INTEGER);
                pstmt.setNull(7, Types.VARCHAR);
                pstmt.setString(8, "Bolso");
            } else if (accesorio instanceof Zapatos) {
                pstmt.setNull(4, Types.VARCHAR);
                pstmt.setNull(5, Types.VARCHAR);
                pstmt.setInt(6, ((Zapatos) accesorio).getTallaZapatos());
                pstmt.setString(7, ((Zapatos) accesorio).getTipoSuela());
                pstmt.setString(8, "Zapatos");
            } else {
                pstmt.setNull(4, Types.VARCHAR);
                pstmt.setNull(5, Types.VARCHAR);
                pstmt.setNull(6, Types.INTEGER);
                pstmt.setNull(7, Types.VARCHAR);
                pstmt.setString(8, "Accesorio");
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Accesorio obtenerPorId(Integer id) {
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
            String sql = "SELECT * FROM accesorio, articulo WHERE accesorio.cod_art = articulo.cod_art AND accesorio.cod_art = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return construirDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Accesorio> obtenerTodos() {
        List<Accesorio> accesorioList = new ArrayList<>();
        String sql = "SELECT * FROM accesorio, articulo WHERE accesorio.cod_art = articulo.cod_art";
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                accesorioList.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accesorioList;
    }

    @Override
    public void actualizar(Accesorio accesorio) {
        ArticuloDAO Adao = new ArticuloDAO();
        Adao.actualizar(accesorio);
        String sql = "UPDATE accesorio SET estilo = ?, personalizado = ?, tipo_cierre_bolso = ?, capacidad = ?, talla_zapato = ?, tipo_suela = ?, tipo_accesorio = ? WHERE cod_art = ?";
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accesorio.getEstilo());
            pstmt.setBoolean(2, accesorio.getEsPersonalizado());

            if (accesorio instanceof Bolso) {
                pstmt.setString(3, ((Bolso) accesorio).getTipoCierre());
                pstmt.setInt(4, ((Bolso) accesorio).getCapacidad());
                pstmt.setNull(5, Types.INTEGER);
                pstmt.setNull(6, Types.VARCHAR);
                pstmt.setString(7, "Bolso");
            } else if (accesorio instanceof Zapatos) {
                pstmt.setNull(3, Types.VARCHAR);
                pstmt.setNull(4, Types.VARCHAR);
                pstmt.setInt(5, ((Zapatos) accesorio).getTallaZapatos());
                pstmt.setString(6, ((Zapatos) accesorio).getTipoSuela());
                pstmt.setString(7, "Zapatos");
            } else {
                pstmt.setNull(3, Types.VARCHAR);
                pstmt.setNull(4, Types.VARCHAR);
                pstmt.setNull(5, Types.INTEGER);
                pstmt.setNull(6, Types.VARCHAR);
                pstmt.setString(7, "Accesorio");
            }

            pstmt.setInt(8, accesorio.getCod_art());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer id) {
        ArticuloDAO Adao = new ArticuloDAO();
        Adao.eliminar(id);
        String sql = "DELETE FROM accesorio WHERE cod_art = ?";
        try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Accesorio construirDesdeResultSet(ResultSet rs) throws SQLException {
        MaterialDAO materialDAO = new MaterialDAO();
        // Obtener los datos del ResultSet
        Material material = materialDAO.obtenerPorId(rs.getInt("material"));
        String nombre = rs.getString("nombre");
        String imagen = rs.getString("imagen");
        double precio = rs.getDouble("precio");
        String marca = rs.getString("marca");
        String descripcion = rs.getString("descripcion");


        boolean activo = rs.getBoolean("activo");
        String color = rs.getString("color");


        int cod_art = rs.getInt("cod_art");



        String estilo = rs.getString("estilo");
        boolean esPersonalizado = rs.getBoolean("personalizado");
        String tipoAccesorio = rs.getString("tipo_accesorio");

        if ("Bolso".equals(tipoAccesorio)) {
            String tipoCierre = rs.getString("tipo_cierre_bolso");
            int capacidad = rs.getInt("capacidad");
            return new Bolso(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, estilo, esPersonalizado, tipoCierre, capacidad);
        } else if ("Zapatos".equals(tipoAccesorio)) {
            int tallaZapatos = rs.getInt("talla_zapato");
            String tipoSuela = rs.getString("tipo_suela");
            return new Zapatos(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, estilo, esPersonalizado, tallaZapatos, tipoSuela);
        } else {
            return new Accesorio(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, estilo, esPersonalizado, TipoAccesorio.DesdeString(tipoAccesorio));
        }
    }
    public List<Accesorio> obtenerPorTipo(String tipo) {
        List<Accesorio> accesorioList = new ArrayList<>();
        String sql = "SELECT * FROM accesorio, articulo WHERE accesorio.cod_art = articulo.cod_art AND tipo_accesorio = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipo.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                accesorioList.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accesorioList;
    }
}
