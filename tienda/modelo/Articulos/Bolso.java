package iescamp.tienda.modelo.Articulos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.*;

public class Bolso extends Accesorio implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String tipoCierre;
    private String capacidad;
    //GETTER Y SETTER

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    //Constructor


    @JsonCreator
    public Bolso(
        @JsonProperty("material") Material material,
        @JsonProperty("cod_art") int cod_art,
        @JsonProperty("activo") boolean activo,
        @JsonProperty("color") String color,
        @JsonProperty("imagen") String imagen,
        @JsonProperty("nombre") String nombre,
        @JsonProperty("precio") double precio,
        @JsonProperty("marca") String marca,
        @JsonProperty("descripcion") String descripcion,
        @JsonProperty("estilo") String estilo,
        @JsonProperty("esPersonalizado") Boolean esPersonalizado,
        @JsonProperty("tipoCierre") String tipoCierre,
        @JsonProperty("capacidad") String capacidad
    ) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, estilo, esPersonalizado, TipoAccesorio.BOLSO);
        this.tipoCierre = tipoCierre;
        this.capacidad = capacidad;
    }


    //ToString

    @Override
    public String toString() {
        return "Bolso{" +
                "tipoCierre='" + tipoCierre + '\'' +
                ", capacidad='" + capacidad + '\'' +
                '}';
    }
    public String MostrarDetalles() {
        return super.toString() + "Bolso{" +
                "tipoCierre='" + tipoCierre + '\'' +
                ", capacidad='" + capacidad + '\'' +
                '}';
    }

    //EQUALS Y HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bolso bolso = (Bolso) o;
        return Objects.equals(tipoCierre, bolso.tipoCierre) && Objects.equals(capacidad, bolso.capacidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoCierre, capacidad);
    }
}
