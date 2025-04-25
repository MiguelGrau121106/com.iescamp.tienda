package iescamp.tienda.modelo.Articulos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un catálogo de artículos.
 * Permite gestionar una colección de objetos de tipo Articulo y realizar operaciones CRUD sobre ellos.
 */
public class Catalogo implements Serializable {
    private static final long serialVersionUID = 1L;

    // Lista de artículos que contiene el catálogo.
    ArrayList<Articulo> articulos = new ArrayList<>();

    /**
     * Añade un nuevo artículo al catálogo.
     *
     * @param articulo El artículo que se va a añadir al catálogo.
     */
    public void addArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    /**
     * Obtiene la lista completa de artículos en el catálogo.
     *
     * @return La lista de artículos.
     */
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    /**
     * Establece una nueva lista de artículos en el catálogo.
     *
     * @param articulos La nueva lista de artículos.
     */
    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    /**
     * Genera una cadena con la representación en texto de todos los artículos en el catálogo.
     *
     * @return Una cadena de texto con los detalles de los artículos.
     */
    public String ListarArticulos() {
        String lista = "";
        for (Articulo articulo : articulos) {
            lista += articulo.toString() + "\n";
        }
        return lista;
    }

    /**
     * Actualiza un artículo existente en el catálogo.
     * Si el artículo ya existe (basado en su código), se actualizan sus valores.
     *
     * @param articulo El artículo con los nuevos valores.
     */
    public void updateArticulo(Articulo articulo) {
        for (Articulo existingArticulo : articulos) {
            if (existingArticulo.getCod_art() == articulo.getCod_art()) {
                existingArticulo.setMaterial(articulo.getMaterial());
                existingArticulo.setCod_art(articulo.getCod_art());
                existingArticulo.setActivo(articulo.isActivo());
                existingArticulo.setImagen(articulo.getImagen());
                existingArticulo.setNombre(articulo.getNombre());
                existingArticulo.setPrecio(articulo.getPrecio());
                existingArticulo.setMarca(articulo.getMarca());
                existingArticulo.setDescripcion(articulo.getDescripcion());
            }
        }
    }

    /**
     * Elimina un artículo del catálogo.
     *
     * @param articulo El artículo que se va a eliminar.
     */
    public void removeArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }

    /**
     * Filtra los artículos por color.
     *
     * @param color El color que se utilizará para filtrar los artículos.
     * @return Una lista de artículos que coinciden con el color especificado.
     */
    public ArrayList<Articulo> getArticulosByColor(String color) {
        ArrayList<Articulo> articulosByColor = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getColor().equals(color)) {
                articulosByColor.add(articulo);
            }
        }
        return articulosByColor;
    }

    /**
     * Filtra los artículos por marca.
     *
     * @param marca La marca que se utilizará para filtrar los artículos.
     * @return Una lista de artículos que coinciden con la marca especificada.
     */
    public ArrayList<Articulo> getArticulosByMarca(String marca) {
        ArrayList<Articulo> articulosByMarca = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getMarca().equals(marca)) {
                articulosByMarca.add(articulo);
            }
        }
        return articulosByMarca;
    }

    /**
     * Filtra los artículos por material.
     *
     * @param material El material que se utilizará para filtrar los artículos.
     * @return Una lista de artículos que coinciden con el material especificado.
     */
    public ArrayList<Articulo> getArticulosByMaterial(String material) {
        ArrayList<Articulo> articulosByMaterial = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getMaterial().equals(material)) {
                articulosByMaterial.add(articulo);
            }
        }
        return articulosByMaterial;
    }

    /**
     * Filtra los artículos por precio dentro de un rango especificado.
     *
     * @param min El precio mínimo.
     * @param max El precio máximo.
     * @return Una lista de artículos cuyo precio está dentro del rango indicado.
     */
    public ArrayList<Articulo> getArticulosByPrecio(double min, double max) {
        ArrayList<Articulo> articulosByPrecio = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getPrecio() >= min && articulo.getPrecio() <= max) {
                articulosByPrecio.add(articulo);
            }
        }
        return articulosByPrecio;
    }

    /**
     * Obtiene un artículo específico del catálogo basado en su código de artículo.
     *
     * @param cod_art El código del artículo que se desea obtener.
     * @return El artículo con el código especificado o null si no se encuentra.
     */
    public Articulo getArticulosByCod_art(int cod_art) {
        for (Articulo articulo : articulos) {
            if (articulo.getCod_art() == cod_art) {
                return articulo;
            }
        }
        return null;
    }

    /**
     * Filtra los artículos por su estado de activación (activo o inactivo).
     *
     * @param activo El estado de activación (true para activos, false para inactivos).
     * @return Una lista de artículos con el estado de activación especificado.
     */
    public ArrayList<Articulo> getArticulosByActivo(boolean activo) {
        ArrayList<Articulo> articulosByActivo = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.isActivo() == activo) {
                articulosByActivo.add(articulo);
            }
        }
        return articulosByActivo;
    }

    /**
     * Filtra los artículos de tipo Ropa por talla.
     *
     * @param talla La talla que se utilizará para filtrar los artículos de tipo Ropa.
     * @return Una lista de artículos de tipo Ropa que coinciden con la talla especificada.
     */
    public ArrayList<Ropa> getArticulosByTalla(String talla) {
        ArrayList<Ropa> articulosByTalla = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof Ropa) {
                Ropa ropa = (Ropa) articulo;
                if (ropa.getTalla().equals(talla)) {
                    articulosByTalla.add(ropa);
                }
            }
        }
        return articulosByTalla;
    }

    // Métodos adicionales para filtrar artículos de tipo Ropa, Chaqueta, Camisa, Pantalón, Zapatos, Accesorios, etc., según diferentes atributos.

}
