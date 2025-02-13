package iescamp.tienda;


import iescamp.tienda.modelo.Articulos.*;

import iescamp.tienda.modelo.Pedidos.LineaPedido;
import iescamp.tienda.modelo.Pedidos.Pedido;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {

        Material material1 = new Material(1, "Algodón");
        Chaqueta chaqueta1 = new Chaqueta( material1, 1, true,  "azul", "mklsvkdslndkl" , "chaqueta azul", 10, "alba", "chaqueta guccci de alba", 10, "cremallera", "cremallera", true);

        Pedido pedido1 = new Pedido(1, LocalDate.now(), "en proceso", "camp"  );
        LineaPedido lnpedido1 = new LineaPedido(1 , chaqueta1, 1);
        pedido1.AddLineaPedido(lnpedido1);
        System.out.println(pedido1);


    }
}
