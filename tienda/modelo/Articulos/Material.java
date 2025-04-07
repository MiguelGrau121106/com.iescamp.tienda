package iescamp.tienda.modelo.Articulos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @JsonCreator
    public Material(@JsonProperty("codigo") int codigo,@JsonProperty("denominacion") String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
