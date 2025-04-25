package iescamp.tienda.modelo.dao;

import iescamp.tienda.modelo.Articulos.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO que maneja las operaciones CRUD para la tabla 'ropa'.
 */
public class RopaDAO implements GenericDAO<Ropa, Integer> {

    /**
     * Inserta un nuevo objeto de tipo Ropa en la base de datos.
     * La inserción se realiza en dos pasos: primero se inserta el artículo en la tabla 'articulo'
     * y luego se inserta en la tabla 'ropa', utilizando el código de artículo.
     *
     * @param ropa Objeto de tipo Ropa que será insertado en la base de datos.
     */
    @Override
    public void insertar(Ropa ropa) {
        try (Connection conn = DBUtil.getConnection()) {
            ArticuloDAO Adao = new ArticuloDAO();
            Adao.insertar(ropa);  // Inserta primero el artículo general
            String sql = "INSERT INTO ropa (cod_art, talla_ropa, tipo_cierre, impermeable, tipo_manga, estampada, tipo_pantalon, tiene_bolsillos, tipo_ropa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ropa.getCod_art());  // Establece el código del artículo
            pstmt.setString(2, ropa.getTalla());  // Establece la talla de la ropa
            pstmt.setString(3, ropa.getTipoCierre());  // Establece el tipo de cierre

            // Dependiendo del tipo de ropa (Chaqueta, Camisa, Pantalón, o Ropa general), se asignan los valores correspondientes
            if (ropa instanceof Chaqueta) {
                pstmt.setBoolean(4, ((Chaqueta) ropa).getImpermeable());  // Especifica si es impermeable
                pstmt.setNull(5, Types.VARCHAR);  // No aplica para chaquetas
                pstmt.setNull(6, Types.BOOLEAN);  // No aplica para chaquetas
                pstmt.setNull(7, Types.VARCHAR);  // No aplica para chaquetas
                pstmt.setNull(8, Types.BOOLEAN);  // No aplica para chaquetas
                pstmt.setString(9, "Chaqueta");
            } else if (ropa instanceof Camisa) {
                pstmt.setNull(4, Types.BOOLEAN);  // No aplica para camisas
                pstmt.setString(5, ((Camisa) ropa).getTipoManga());  // Tipo de manga de la camisa
                pstmt.setBoolean(6, ((Camisa) ropa).getEsEstampada());  // Indica si la camisa es estampada
                pstmt.setNull(7, Types.VARCHAR);  // No aplica para camisas
                pstmt.setNull(8, Types.BOOLEAN);  // No aplica para camisas
                pstmt.setString(9, "Camisa");
            } else if (ropa instanceof Pantalon) {
                pstmt.setNull(4, Types.BOOLEAN);  // No aplica para pantalones
                pstmt.setNull(5, Types.VARCHAR);  // No aplica para pantalones
                pstmt.setNull(6, Types.BOOLEAN);  // No aplica para pantalones
                pstmt.setString(7, ((Pantalon) ropa).getTipoPantalon());  // Tipo de pantalón
                pstmt.setBoolean(8, ((Pantalon) ropa).getTieneBolsillos());  // Indica si tiene bolsillos
                pstmt.setString(9, "Pantalon");
            } else {
                pstmt.setNull(4, Types.BOOLEAN);  // No aplica para ropa general
                pstmt.setNull(5, Types.VARCHAR);  // No aplica para ropa general
                pstmt.setNull(6, Types.BOOLEAN);  // No aplica para ropa general
                pstmt.setNull(7, Types.VARCHAR);  // No aplica para ropa general
                pstmt.setNull(8, Types.BOOLEAN);  // No aplica para ropa general
                pstmt.setString(9, "Ropa");
            }

            pstmt.executeUpdate();  // Ejecuta la inserción en la base de datos
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre un error, lo imprime
        }
    }

    /**
     * Obtiene un objeto Ropa a partir de su código de artículo.
     *
     * @param id Código de artículo único que identifica la ropa.
     * @return El objeto Ropa correspondiente o null si no se encuentra.
     */
    @Override
    public Ropa obtenerPorId(Integer id) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM ropa, articulo where ropa.cod_art = articulo.cod_art and ropa.cod_art = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);  // Establece el código del artículo
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return construirDesdeResultSet(rs);  // Construye el objeto Ropa desde el ResultSet
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre un error, lo imprime
        }
        return null;  // Si no se encuentra, devuelve null
    }

    /**
     * Devuelve todos los objetos Ropa de la base de datos.
     *
     * @return Lista de todos los objetos Ropa.
     */
    @Override
    public List<Ropa> obtenerTodos() {
        List<Ropa> ropaList = new ArrayList<>();
        String sql = "SELECT * FROM ropa, articulo where ropa.cod_art = articulo.cod_art";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ropaList.add(construirDesdeResultSet(rs));  // Agrega cada Ropa a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre un error, lo imprime
        }
        return ropaList;  // Devuelve la lista de ropa
    }

    /**
     * Actualiza los datos de un objeto Ropa existente en la base de datos.
     *
     * @param ropa Objeto Ropa con los nuevos datos.
     */
    @Override
    public void actualizar(Ropa ropa) {
        ArticuloDAO Adao = new ArticuloDAO();
        Adao.actualizar(ropa);  // Actualiza primero el artículo general
        String sql = "UPDATE ropa SET talla_ropa = ?, tipo_cierre = ?, impermeable = ?, tipo_manga = ?, estampada = ?, tipo_pantalon = ?, tiene_bolsillos = ?, tipo_ropa = ? WHERE cod_art = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ropa.getTalla());  // Establece la talla de la ropa
            pstmt.setString(2, ropa.getTipoCierre());  // Establece el tipo de cierre

            // Dependiendo del tipo de ropa (Chaqueta, Camisa, Pantalón, o Ropa general), se asignan los valores correspondientes
            if (ropa instanceof Chaqueta) {
                pstmt.setBoolean(3, ((Chaqueta) ropa).getImpermeable());  // Especifica si es impermeable
                pstmt.setNull(4, Types.VARCHAR);  // No aplica para chaquetas
                pstmt.setNull(5, Types.BOOLEAN);  // No aplica para chaquetas
                pstmt.setNull(6, Types.VARCHAR);  // No aplica para chaquetas
                pstmt.setNull(7, Types.BOOLEAN);  // No aplica para chaquetas
                pstmt.setString(8, "Chaqueta");
            } else if (ropa instanceof Camisa) {
                pstmt.setNull(3, Types.BOOLEAN);  // No aplica para camisas
                pstmt.setString(4, ((Camisa) ropa).getTipoManga());  // Tipo de manga de la camisa
                pstmt.setBoolean(5, ((Camisa) ropa).getEsEstampada());  // Indica si la camisa es estampada
                pstmt.setNull(6, Types.VARCHAR);  // No aplica para camisas
                pstmt.setNull(7, Types.BOOLEAN);  // No aplica para camisas
                pstmt.setString(8, "Camisa");
            } else if (ropa instanceof Pantalon) {
                pstmt.setNull(3, Types.BOOLEAN);  // No aplica para pantalones
                pstmt.setNull(4, Types.VARCHAR);  // No aplica para pantalones
                pstmt.setNull(5, Types.BOOLEAN);  // No aplica para pantalones
                pstmt.setString(6, ((Pantalon) ropa).getTipoPantalon());  // Tipo de pantalón
                pstmt.setBoolean(7, ((Pantalon) ropa).getTieneBolsillos());  // Indica si tiene bolsillos
                pstmt.setString(8, "Pantalon");
            } else {
                pstmt.setNull(3, Types.BOOLEAN);  // No aplica para ropa general
                pstmt.setNull(4, Types.VARCHAR);  // No aplica para ropa general
                pstmt.setNull(5, Types.BOOLEAN);  // No aplica para ropa general
                pstmt.setNull(6, Types.VARCHAR);  // No aplica para ropa general
                pstmt.setNull(7, Types.BOOLEAN);  // No aplica para ropa general
                pstmt.setString(8, "Ropa");
            }

            pstmt.setInt(9, ropa.getCod_art());  // Establece el código de artículo
            pstmt.executeUpdate();  // Ejecuta la actualización
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre un error, lo imprime
        }
    }

    /**
     * Elimina un objeto Ropa de la base de datos mediante su código de artículo.
     *
     * @param id Código de artículo que identifica la ropa a eliminar.
     */
    @Override
    public void eliminar(Integer id) {
        ArticuloDAO Adao = new ArticuloDAO();
        Adao.eliminar(id);  // Elimina primero el artículo general
        String sql = "DELETE FROM ropa WHERE cod_art = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);  // Establece el código del artículo a eliminar
            pstmt.executeUpdate();  // Ejecuta la eliminación
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre un error, lo imprime
        }
    }

    /**
     * Construye un objeto Ropa desde un ResultSet.
     *
     * @param rs ResultSet que contiene los datos de la base de datos.
     * @return El objeto Ropa construido con los datos del ResultSet.
     */
    @Override
    public Ropa construirDesdeResultSet(ResultSet rs) throws SQLException {
        // Crear una instancia de MaterialDAO
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
        String talla = rs.getString("talla_ropa");
        String tipoCierre = rs.getString("tipo_cierre");
        String tipoRopa = rs.getString("tipo_ropa");

        // Dependiendo del tipo de ropa (Chaqueta, Camisa, Pantalón, o Ropa general), se construye el objeto correspondiente
        if ("Chaqueta".equals(tipoRopa)) {
            Boolean impermeable = rs.getBoolean("impermeable");
            return new Chaqueta(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, impermeable);
        } else if ("Camisa".equals(tipoRopa)) {
            String tipoManga = rs.getString("tipo_manga");
            Boolean esEstampada = rs.getBoolean("estampada");
            return new Camisa(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, tipoManga, esEstampada);
        } else if ("Pantalon".equals(tipoRopa)) {
            String tipoPantalon = rs.getString("tipo_pantalon");
            Boolean tieneBolsillos = rs.getBoolean("tiene_bolsillos");
            return new Pantalon(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, tieneBolsillos, tipoPantalon);
        } else {
            return new Ropa(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, TipoRopa.DesdeString(tipoRopa));
        }
    }

    /**
     * Obtiene todas las prendas de ropa de un tipo específico.
     *
     * @param tipoRopa Tipo de ropa que se desea obtener (e.g., "Chaqueta", "Camisa", "Pantalon").
     * @return Lista de objetos Ropa del tipo solicitado.
     */
    public List<Ropa> obtenerPorTipo(String tipoRopa) {
        List<Ropa> ropaList = new ArrayList<>();
        String sql = "SELECT * FROM ropa, articulo where ropa.cod_art = articulo.cod_art and tipo_ropa = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoRopa);  // Establece el tipo de ropa en la consulta
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ropaList.add(construirDesdeResultSet(rs));  // Agrega cada Ropa a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Si ocurre un error, lo imprime
        }
        return ropaList;  // Devuelve la lista de ropa de ese tipo
    }
}
