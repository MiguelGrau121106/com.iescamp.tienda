package iescamp.tienda.modelo.Usuarios;

import java.io.Serializable;
import java.util.Objects;

public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int codigo;
    private String nombre;

    // Getters y setter

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Equals

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Departamento that = (Departamento) object;
        return codigo == that.codigo && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }

    // Constructor

    public Departamento(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
