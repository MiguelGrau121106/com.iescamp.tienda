package iescamp.tienda.tienda.modelo.Pedidos;
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Pedidos.Pedido;

import java.util.Objects;

public class LineaPedido implements java.io.Serializable {
    private static final long serialVersionUID = 1L;




    private Articulo articulo;
    private iescamp.tienda.modelo.Pedidos.Pedido pedido;


    public iescamp.tienda.modelo.Pedidos.Pedido getPedido() {
        return pedido;
    }

    public void setPedido(iescamp.tienda.modelo.Pedidos.Pedido pedido) {
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
