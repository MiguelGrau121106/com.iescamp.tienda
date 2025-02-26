package iescamp.tienda.modelo.Articulos;

import java.util.Objects;

public class Accesorio extends Articulo {
    private String estilo;
    private Boolean esPersonalizado;

    //GETTER Y SETTER

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


    public Accesorio(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, String estilo, Boolean esPersonalizado) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion);
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    //TOSTRING
    @Override
    public String toString() {
        return super.toString() + "Accesorio{" +
                "estilo='" + estilo + '\'' +
                ", esPersonalizado=" + esPersonalizado +
                '}';
    }
    //EQUALS Y HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accesorio accesorio = (Accesorio) o;
        return Objects.equals(estilo, accesorio.estilo) && Objects.equals(esPersonalizado, accesorio.esPersonalizado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estilo, esPersonalizado);
    }
}
