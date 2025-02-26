package iescamp.tienda.modelo.Pedidos;
import iescamp.tienda.modelo.Articulos.Articulo;

import java.util.Objects;

public class LineaPedido {



    private int idLinea;
    private Articulo articulo;
    private int cantidad;
    private Pedido pedido;



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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "idLinea=" + idLinea +
                ", articulo=" + articulo +
                ", cantidad=" + cantidad +

                ", pedido=" + pedido +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineaPedido that = (LineaPedido) o;
        return idLinea == that.idLinea && cantidad == that.cantidad && Objects.equals(articulo, that.articulo) && Objects.equals(pedido, that.pedido);

    }

    @Override
    public int hashCode() {

        return Objects.hash(idLinea, articulo, cantidad, pedido);
    }

    public LineaPedido(int idLinea, Articulo articulo, int cantidad, Pedido pedido) {
        this.idLinea = idLinea;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.pedido = pedido;

    }
}
