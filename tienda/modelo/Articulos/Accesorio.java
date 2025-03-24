package iescamp.tienda.modelo.Articulos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
public class Accesorio extends Articulo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String estilo;
    private boolean esPersonalizado;
    private TipoAccesorio tipoAccesorio;

    //GETTER Y SETTER

    public TipoAccesorio getTipoAccesorio() {
        return tipoAccesorio;
    }

    public void setTipoAccesorio(TipoAccesorio tipoAccesorio) {
        this.tipoAccesorio = tipoAccesorio;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public boolean getEsPersonalizado() {
        return esPersonalizado;
    }

    public void setEsPersonalizado(boolean esPersonalizado) {
        this.esPersonalizado = esPersonalizado;
    }

    //CONSTRUCTOR


    @JsonCreator
    public Accesorio(
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
            @JsonProperty("esPersonalizado") boolean esPersonalizado,
            @JsonProperty("tipoAccesorio") TipoAccesorio tipoAccesorio
    ) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion);
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
        this.tipoAccesorio = tipoAccesorio;
    }

    @Override
    public String toString() {
        return super.toString() + "Accesorio{" +
                "estilo='" + estilo + '\'' +
                ", esPersonalizado=" + esPersonalizado +
                ", tipoAccesorio=" + tipoAccesorio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Accesorio accesorio = (Accesorio) o;
        return Objects.equals(estilo, accesorio.estilo) && Objects.equals(esPersonalizado, accesorio.esPersonalizado) && tipoAccesorio == accesorio.tipoAccesorio;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(estilo);
        result = 31 * result + Objects.hashCode(esPersonalizado);
        result = 31 * result + Objects.hashCode(tipoAccesorio);
        return result;
    }
}
