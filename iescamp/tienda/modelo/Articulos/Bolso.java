package iescamp.tienda.modelo.Articulos;

import java.util.Objects;

public class Bolso extends Accesorio {
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

    public Bolso(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, String estilo, Boolean esPersonalizado, String tipoCierre, String capacidad) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, estilo, esPersonalizado);
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
