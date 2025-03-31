package iescamp.tienda.modelo.Articulos;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;

public class Camisa extends Ropa implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String tipoManga;
    private boolean esEstampada;
    //GETTER Y SETTER
    public String getTipoManga() {
        return tipoManga;
    }

    public void setTipoManga(String tipoManga) {
        this.tipoManga = tipoManga;
    }

    public boolean getEsEstampada() {
        return esEstampada;
    }

    public void setEsEstampada(Boolean esEstampada) {
        this.esEstampada = esEstampada;
    }
    //CONSTRUCTOR

    @JsonCreator
    public Camisa(
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
        @JsonProperty("tipoManga") String tipoManga,
        @JsonProperty("esEstampada") Boolean esEstampada
    ) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, TipoRopa.CAMISA);
        this.tipoManga = tipoManga;
        this.esEstampada = esEstampada;
    }


    //MOSTRAR DETALLES

    @Override
    public String toString() {
        return super.toString() + "Camisa{" +
                "tipoManga='" + tipoManga + '\'' +
                ", esEstampada=" + esEstampada +
                '}';
    }

    public String MostrarDetalles() {
        return super.toString() +"Camisa{" +
                "tipoManga='" + tipoManga + '\'' +
                ", esEstampada=" + esEstampada +
                '}';
    }

    //EQUALS Y HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Camisa camisa = (Camisa) o;
        return Objects.equals(tipoManga, camisa.tipoManga) && Objects.equals(esEstampada, camisa.esEstampada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoManga, esEstampada);
    }
}
