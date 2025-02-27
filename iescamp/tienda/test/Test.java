package iescamp.tienda.test;

import iescamp.tienda.modelo.Articulos.*;

public class Test {
    public static void main(String[] args) {
        Camisa camisa = new Camisa(null, 0, true, "Rojo", "imagen", "nombre", 24, "marca", "descripcion", 0, "color1", "tipoCierre", true);
        Bolso bolso = new Bolso(null, 0, true, "Rojo", "imagen", "nombre", 21, "marca", "descripcion", "estilo", false, "ess", "mucho");
        Camisa camisa2 = new Camisa(null, 0, true, "Rojo", "imagen", "nombre", 0.0, "marca", "descripcion", 1, "color1", "tipoCierre",  true);

        Catalogo catalogo1 = new Catalogo();
        catalogo1.addArticulo(camisa);
        catalogo1.addArticulo(bolso);
        catalogo1.addArticulo(camisa2);

        System.out.printf(catalogo1.getArticulosByTalla(0).toString());
        System.out.println(catalogo1.getArticulosByPrecio(20,30));

    }
}
