package iescamp.tienda.modelo.Articulos;

import iescamp.tienda.modelo.Pedidos.Pedido;


import java.util.ArrayList;


import java.util.ArrayList;

public class Catalogo {
    ArrayList<Articulo> articulos = new ArrayList<>();

    // Create
    public void addArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    // Read
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    // Update
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

    // Delete
    public void removeArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }
}

