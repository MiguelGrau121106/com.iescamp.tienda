package ClaseComposicion;

import java.util.Objects;

public class MetodoPago {
    private int codigo;
    private String descripcion;

    // getter y setter

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Equals

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MetodoPago that = (MetodoPago) object;
        return codigo == that.codigo && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descripcion);
    }

    // Constructor

    public MetodoPago(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
