package iescamp.tienda.tienda.modelo.Articulos;

import com.fasterxml.jackson.annotation.*;
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Articulos.Camisa;
import iescamp.tienda.modelo.Articulos.Chaqueta;
import iescamp.tienda.modelo.Articulos.Material;
import iescamp.tienda.modelo.Articulos.Pantalon;
import iescamp.tienda.modelo.Articulos.TipoRopa;

import java.util.Objects;



   @JsonSubTypes({
           @JsonSubTypes.Type(value = Camisa.class, name = "camisa"),
           @JsonSubTypes.Type(value = Pantalon.class, name = "pantalon"),
           @JsonSubTypes.Type(value = Chaqueta.class, name = "chaqueta")
   })
    
    //Getter y Setter

public class Ropa extends Articulo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String talla;
    private String tipoCierre;
    private iescamp.tienda.modelo.Articulos.TipoRopa tipoRopa;

    public iescamp.tienda.modelo.Articulos.TipoRopa getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(iescamp.tienda.modelo.Articulos.TipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }


    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    @JsonCreator
    public Ropa(
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
            @JsonProperty("tipoRopa") TipoRopa tipoRopa
    ) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion);
        this.talla = talla;
        this.tipoCierre = tipoCierre;
        this.tipoRopa = tipoRopa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Ropa ropa = (Ropa) o;
        return talla == ropa.talla && Objects.equals(tipoCierre, ropa.tipoCierre) && tipoRopa == ropa.tipoRopa;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(talla);
        result = 31 * result + Objects.hashCode(tipoCierre);
        result = 31 * result + Objects.hashCode(tipoRopa);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Ropa{" +
                "talla=" + talla +
                ", tipoCierre='" + tipoCierre + '\'' +
                ", tipoRopa=" + tipoRopa +
                '}';
    }
}
