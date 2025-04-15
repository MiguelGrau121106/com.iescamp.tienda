package iescamp.tienda.modelo.Pedidos;
import iescamp.tienda.modelo.Articulos.Articulo;

import java.util.Objects;

public class LineaPedido implements java.io.Serializable {
    private static final long serialVersionUID = 1L;




    private Articulo articulo;
    private Pedido pedido;


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LineaPedido that = (LineaPedido) o;
        return Objects.equals(articulo, that.articulo) && Objects.equals(pedido, that.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articulo, pedido);
    }

    public LineaPedido(Articulo articulo, Pedido pedido) {
        this.articulo = articulo;
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "articulo=" + articulo +
                ", pedido=" + pedido +
                '}';
    }
}
