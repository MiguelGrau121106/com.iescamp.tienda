package com.iescamp.tienda.modelo;

public class Test {

    public static void main(String[] args) {

        EstadoPedido x = EstadoPedido.EN_PROCESO;

        System.out.println(x.getDescripcion());

        String y = "Completado";

        EstadoPedido z = EstadoPedido.DesdeString(y);

        System.out.println(z.getDescripcion());

    }
}
