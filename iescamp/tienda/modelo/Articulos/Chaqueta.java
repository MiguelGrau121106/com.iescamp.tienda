package iescamp.tienda.modelo.Articulos;

import java.util.Objects;

public class Chaqueta extends Ropa{
    private Boolean impermeable;
    //GETTER Y SETTER
    public Boolean getImpermeable() {
        return impermeable;
    }

    public void setImpermeable(Boolean impermeable) {
        this.impermeable = impermeable;
    }
    //CONSTRUCTOR

    public Chaqueta(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, int talla, String tipoCierre, Boolean impermeable) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre);
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
