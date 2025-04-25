package iescamp.tienda.modelo.dao;

import iescamp.tienda.modelo.Articulos.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para manejar operaciones de base de datos relacionadas con accesorios.
 * Implementa la interfaz GenericDAO.
 */
public class AccesorioDAO implements GenericDAO<Accesorio, Integer> {

    @Override
    public void insertar(Accesorio accesorio) {
        try (Connection conn = iescamp.tienda.modelo.dao.DBUtil.getConnection()) {
            // Inserta primero el artículo base
            ArticuloDAO Adao = new ArticuloDAO();
            Adao.insertar(accesorio);

            // Inserta en la tabla específica de accesorios
            String sql = "INSERT INTO accesorio (cod_art, estilo, personalizado, tipo_cierre_bolso, capacidad, talla_zapato, tipo_suela, tipo_accesorio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Atributos comunes
            pstmt.setInt(1, accesorio.getCod_art());
            pstmt.setString(2, accesorio.getEstilo());
            pstmt.setBoolean(3, accesorio.getEsPersonalizado());

            // Atributos específicos según el tipo de accesorio
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
        try (Connection conn = iescamp.tienda.modelo.dao.DBUtil.getConnection()) {
            // Consulta con JOIN para obtener datos del artículo y del accesorio
            String sql = "SELECT * FROM accesorio, articulo WHERE accesorio.cod_art = articulo.cod_art AND accesorio.cod_art = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Construye el objeto desde el ResultSet
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
        try (Connection conn = iescamp.tienda.modelo.dao.DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Recorre todos los resultados y construye los objetos correspondientes
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
        // Primero actualiza el artículo base
        ArticuloDAO Adao = new ArticuloDAO();
        Adao.actualizar(accesorio);

        String sql = "UPDATE accesorio SET estilo = ?, personalizado = ?, tipo_cierre_bolso = ?, capacidad = ?, talla_zapato = ?, tipo_suela = ?, tipo_accesorio = ? WHERE cod_art = ?";
        try (Connection conn = iescamp.tienda.modelo.dao.DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Atributos comunes
            pstmt.setString(1, accesorio.getEstilo());
            pstmt.setBoolean(2, accesorio.getEsPersonalizado());

            // Atributos específicos por tipo
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
        // Primero elimina el artículo base
        ArticuloDAO Adao = new ArticuloDAO();
        Adao.eliminar(id);

        // Luego elimina el accesorio
        String sql = "DELETE FROM accesorio WHERE cod_art = ?";
        try (Connection conn = iescamp.tienda.modelo.dao.DBUtil.getConnection();
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

        // Obtiene datos comunes desde el ResultSet
        Material material = materialDAO.obtenerPorId(rs.getInt("material"));
        String nombre = rs.getString("nombre");
        String imagen = rs.getString("imagen");
        double precio = rs.getDouble("precio");
        String marca = rs.getString("marca");
        String descripcion = rs.getString("descripcion");
        boolean activo = rs.getBoolean("activo");
        String color = rs.getString("color");
        int cod_art = rs.getInt("cod_art");

        // Datos específicos del accesorio
        String estilo = rs.getString("estilo");
        boolean esPersonalizado = rs.getBoolean("personalizado");
        String tipoAccesorio = rs.getString("tipo_accesorio");

        // Crea la instancia según el tipo
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

    /**
     * Devuelve una lista de accesorios según su tipo (por ejemplo: "Bolso", "Zapatos", etc.)
     */
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
