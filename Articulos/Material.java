package iescamp.tienda.modelo.Articulos;

import java.util.Objects;

public class Material {
    private int codigo;
    private String denominacion;
    // Getter y setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    // Equals
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Material material = (Material) object;
        return codigo == material.codigo && Objects.equals(denominacion, material.denominacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, denominacion);
    }

    // Constructor

    public Material(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
