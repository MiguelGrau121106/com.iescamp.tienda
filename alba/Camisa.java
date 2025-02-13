package iescamp.tienda.modelo;

import java.util.Objects;

public class Camisa extends Ropa{
    private String tipoManga;
    private Boolean esEstampada;
    //GETTER Y SETTER
    public String getTipoManga() {
        return tipoManga;
    }

    public void setTipoManga(String tipoManga) {
        this.tipoManga = tipoManga;
    }

    public Boolean getEsEstampada() {
        return esEstampada;
    }

    public void setEsEstampada(Boolean esEstampada) {
        this.esEstampada = esEstampada;
    }
    //CONSTRUCTOR
    public Camisa(int talla, String color, String tipoCierre, String tipoManga, Boolean esEstampada) {
        super(talla, color, tipoCierre);
        this.tipoManga = tipoManga;
        this.esEstampada = esEstampada;
    }
    //MOSTRAR DETALLES

    @Override
    public String toString() {
        return "Camisa{" +
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
