package iescamp.tienda.modelo.Pedidos;
import iescamp.tienda.modelo.Articulos.Articulo;

import java.util.Objects;

public class LineaPedido {

    private int idLinea;
    private Articulo articulo;
    private int cantidad;



    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "idLinea=" + idLinea +
                ", articulo=" + articulo +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineaPedido that = (LineaPedido) o;
        return idLinea == that.idLinea && cantidad == that.cantidad && Objects.equals(articulo, that.articulo);
    }

    @Override
    public int hashCode() {
        int result = idLinea;
        result = 31 * result + Objects.hashCode(articulo);
        result = 31 * result + cantidad;
        return result;
    }

    public LineaPedido(int idLinea, Articulo articulo, int cantidad) {
        this.idLinea = idLinea;
        this.articulo = articulo;
        this.cantidad = cantidad;
    }
}
