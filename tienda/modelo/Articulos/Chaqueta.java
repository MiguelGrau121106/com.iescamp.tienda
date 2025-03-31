package iescamp.tienda.modelo.Articulos;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;
public class Chaqueta extends Ropa implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean impermeable;
    //GETTER Y SETTER
    public boolean getImpermeable() {
        return impermeable;
    }

    public void setImpermeable(Boolean impermeable) {
        this.impermeable = impermeable;
    }
    //CONSTRUCTOR

    @JsonCreator
    public Chaqueta(
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
        @JsonProperty("impermeable") Boolean impermeable
    ) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, TipoRopa.CHAQUETA);
        this.impermeable = impermeable;
    }


    //mostrarDetalles

    @Override
    public String toString() {
        return "Chaqueta{" +
                "impermeable=" + impermeable +
                '}';
    }

    public String mostrarDetalles() {
        return super.toString() + "Chaqueta{" +
                "impermeable=" + impermeable +
                '}';
    }
    //EQUALS Y HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chaqueta chaqueta = (Chaqueta) o;
        return Objects.equals(impermeable, chaqueta.impermeable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), impermeable);
    }
}
