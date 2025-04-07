package iescamp.tienda.modelo.Articulos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pantalon extends Ropa {
    private boolean tieneBolsillos;
    private String tipoPantalon;

    //GETTER Y SETTERS

    public boolean getTieneBolsillos() {
        return tieneBolsillos;
    }

    public void setTieneBolsillos(Boolean tieneBolsillos) {
        this.tieneBolsillos = tieneBolsillos;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }
    //CONSTRUCTOR

    //public Pantalon(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, String talla, String tipoCierre, Boolean tieneBolsillos, String tipoPantalon) {
     //   super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, TipoRopa.PANTALON);
     //   this.tieneBolsillos = tieneBolsillos;
     //   this.tipoPantalon = tipoPantalon;
    //}

    @JsonCreator
    public Pantalon(
            @JsonProperty("material") Material material,
            @JsonProperty("cod_art") int cod_art,
            @JsonProperty("activo") boolean activo,
            @JsonProperty("color") String color,
            @JsonProperty("imagen") String imagen,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("precio") double precio,
            @JsonProperty("marca") String marca,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("talla") String talla,
            @JsonProperty("tipoCierre") String tipoCierre,
            @JsonProperty("tieneBolsillos") Boolean tieneBolsillos,
            @JsonProperty("tipoPantalon") String tipoPantalon
    ) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, TipoRopa.PANTALON);
        this.tieneBolsillos = tieneBolsillos;
        this.tipoPantalon = tipoPantalon;
    }


    //MOSTRARDETALLES

    @Override
    public String toString() {
        return super.toString() + "Pantalon{" +
                "tieneBolsillos=" + tieneBolsillos +
                ", tipoPantalon='" + tipoPantalon + '\'' +
                '}';
    }

    public String MostrarDetalles() {
        return super.toString() + "Pantalon{" +
                "tieneBolsillos=" + tieneBolsillos +
                ", tipoPantalon='" + tipoPantalon + '\'' +
                '}';
    }
}
