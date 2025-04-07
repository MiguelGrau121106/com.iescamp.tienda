package iescamp.tienda.dao;

import iescamp.tienda.modelo.Articulos.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class RopaDAO implements GenericDAO<Ropa, Integer> {

        @Override
        public void insertar(Ropa ropa) {
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {
                ArticuloDAO Adao = new ArticuloDAO();
                Adao.insertar(ropa);
                String sql = "INSERT INTO ropa (cod_art, talla_ropa, tipo_cierre, impermeable, tipo_manga, estampada, tipo_pantalon, tiene_bolsillos, tipo_ropa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, ropa.getCod_art());
                pstmt.setString(2, ropa.getTalla());
                pstmt.setString(3, ropa.getTipoCierre());

                if (ropa instanceof Chaqueta) {
                    pstmt.setBoolean(4, ((Chaqueta) ropa).getImpermeable());
                    pstmt.setNull(5, Types.VARCHAR);
                    pstmt.setNull(6, Types.BOOLEAN);
                    pstmt.setNull(7, Types.VARCHAR);
                    pstmt.setNull(8, Types.BOOLEAN);
                    pstmt.setString(9, "Chaqueta");
                } else if (ropa instanceof Camisa) {
                    pstmt.setNull(4, Types.BOOLEAN);
                    pstmt.setString(5, ((Camisa) ropa).getTipoManga());
                    pstmt.setBoolean(6, ((Camisa) ropa).getEsEstampada());
                    pstmt.setNull(7, Types.VARCHAR);
                    pstmt.setNull(8, Types.BOOLEAN);
                    pstmt.setString(9, "Camisa");
                } else if (ropa instanceof Pantalon) {
                    pstmt.setNull(4, Types.BOOLEAN);
                    pstmt.setNull(5, Types.VARCHAR);
                    pstmt.setNull(6, Types.BOOLEAN);
                    pstmt.setString(7, ((Pantalon) ropa).getTipoPantalon());
                    pstmt.setBoolean(8, ((Pantalon) ropa).getTieneBolsillos());
                    pstmt.setString(9, "Pantalon");
                } else {
                    pstmt.setNull(4, Types.BOOLEAN);
                    pstmt.setNull(5, Types.VARCHAR);
                    pstmt.setNull(6, Types.BOOLEAN);
                    pstmt.setNull(7, Types.VARCHAR);
                    pstmt.setNull(8, Types.BOOLEAN);
                    pstmt.setString(9, "Ropa");
                }

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Ropa obtenerPorId(Integer id) {

            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection()) {

                String sql = "SELECT * FROM ropa, articulo where ropa.cod_art = articulo.cod_art and ropa.cod_art = ?";
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
        public List<Ropa> obtenerTodos() {
            List<Ropa> ropaList = new ArrayList<>();
            String sql = "SELECT * FROM ropa, articulo where ropa.cod_art = articulo.cod_art";
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    ropaList.add(construirDesdeResultSet(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ropaList;
        }

        @Override
        public void actualizar(Ropa ropa) {
            ArticuloDAO Adao = new ArticuloDAO();
            Adao.actualizar(ropa);
            String sql = "UPDATE ropa SET talla_ropa = ?, tipo_cierre = ?, impermeable = ?, tipo_manga = ?, estampada = ?, tipo_pantalon = ?, tiene_bolsillos = ?, tipo_ropa = ? WHERE cod_art = ?";
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, ropa.getTalla());
                pstmt.setString(2, ropa.getTipoCierre());

                if (ropa instanceof Chaqueta) {
                    pstmt.setBoolean(3, ((Chaqueta) ropa).getImpermeable());
                    pstmt.setNull(4, Types.VARCHAR);
                    pstmt.setNull(5, Types.BOOLEAN);
                    pstmt.setNull(6, Types.VARCHAR);
                    pstmt.setNull(7, Types.BOOLEAN);
                    pstmt.setString(8, "Chaqueta");
                } else if (ropa instanceof Camisa) {
                    pstmt.setNull(3, Types.BOOLEAN);
                    pstmt.setString(4, ((Camisa) ropa).getTipoManga());
                    pstmt.setBoolean(5, ((Camisa) ropa).getEsEstampada());
                    pstmt.setNull(6, Types.VARCHAR);
                    pstmt.setNull(7, Types.BOOLEAN);
                    pstmt.setString(8, "Camisa");
                } else if (ropa instanceof Pantalon) {
                    pstmt.setNull(3, Types.BOOLEAN);
                    pstmt.setNull(4, Types.VARCHAR);
                    pstmt.setNull(5, Types.BOOLEAN);
                    pstmt.setString(6, ((Pantalon) ropa).getTipoPantalon());
                    pstmt.setBoolean(7, ((Pantalon) ropa).getTieneBolsillos());
                    pstmt.setString(8, "Pantalon");
                } else {
                    pstmt.setNull(3, Types.BOOLEAN);
                    pstmt.setNull(4, Types.VARCHAR);
                    pstmt.setNull(5, Types.BOOLEAN);
                    pstmt.setNull(6, Types.VARCHAR);
                    pstmt.setNull(7, Types.BOOLEAN);
                    pstmt.setString(8, "Ropa");
                }

                pstmt.setInt(9, ropa.getCod_art());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void eliminar(Integer id) {
            ArticuloDAO Adao = new ArticuloDAO();
            Adao.eliminar(id);
            String sql = "DELETE FROM ropa WHERE cod_art = ?";
            try (Connection conn = iescamp.tienda.dao.DBUtil.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

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


        public List<Ropa> obtenerPorTipo(String tipoRopa) {

            List<Ropa> ropaList = new ArrayList<>();
            String sql = "SELECT * FROM ropa, articulo where ropa.cod_art = articulo.cod_art and tipo_ropa = ?";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, tipoRopa);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    ropaList.add(construirDesdeResultSet(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ropaList;
        }
    }





