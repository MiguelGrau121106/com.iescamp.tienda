package iescamp.tienda.modelo.Pedidos;
import iescamp.tienda.modelo.Articulos.Articulo;

import java.util.Objects;

public class LineaPedido {




    private Articulo articulo;







    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }




    @Override
    public String toString() {
        return "LineaPedido{" +

                ", articulo=" + articulo +




                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineaPedido that = (LineaPedido) o;
        return Objects.equals(articulo, that.articulo);

    }

    @Override
    public int hashCode() {

        return Objects.hash(articulo);
    }

    public LineaPedido(Articulo articulo) {

        this.articulo = articulo;



    }
}
