package iescamp.tienda.modelo.Articulos;

import java.util.Objects;

public class Accesorio extends Articulo {
    private String estilo;
    private Boolean esPersonalizado;
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

    public Boolean getEsPersonalizado() {
        return esPersonalizado;
    }

    public void setEsPersonalizado(Boolean esPersonalizado) {
        this.esPersonalizado = esPersonalizado;
    }

    //CONSTRUCTOR


    public Accesorio(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, String estilo, Boolean esPersonalizado, TipoAccesorio tipoAccesorio) {
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
