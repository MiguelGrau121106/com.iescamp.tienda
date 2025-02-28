package iescamp.tienda.test;

import iescamp.tienda.modelo.Articulos.*;
import iescamp.tienda.modelo.Pedidos.*;
import iescamp.tienda.modelo.Usuarios.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        // Crear materiales
        Material algodon = new Material(1, "Algodón");
        Material cuero = new Material(2, "Cuero");

        // Crear artículos
        Camisa camisa = new Camisa(algodon, 101, true, "Blanco", "imagen1.jpg", "Camisa Formal", 29.99, "Marca1", "Camisa de manga larga", 40, "Botones", "Larga", true);
        Pantalon pantalon = new Pantalon(algodon, 102, true, "Azul", "imagen2.jpg", "Pantalón Jeans", 49.99, "Marca2", "Pantalón de mezclilla", 32, "Cremallera", true, "Jeans");
        Zapatos zapatos = new Zapatos(cuero, 103, true, "Negro", "imagen3.jpg", "Zapatos de vestir", 79.99, "Marca3", "Zapatos de cuero", "Formal", false, 42, "Cuero");

        // Crear catálogo y añadir artículos
        Catalogo catalogo = new Catalogo();
        catalogo.addArticulo(camisa);
        catalogo.addArticulo(pantalon);
        catalogo.addArticulo(zapatos);

        // Crear cliente
        Cliente cliente = new Cliente("12345678A", "Juan", "Pérez", "Calle Falsa 123", "juan@example.com", "123456789", LocalDate.of(1990, 1, 1), "password", new MetodoPago(1, "Tarjeta de crédito"), 5, true, 100.0f, "Calle Falsa 123", 1);

        // Crear pedido
        Pedido pedido = new Pedido(1, LocalDate.now(), EstadoPedido.EN_PROCESO, "Calle Falsa 123", 1,  cliente);
        LineaPedido linea1 = new LineaPedido(1, camisa, 2);
        LineaPedido linea2 = new LineaPedido(2, pantalon, 1);
        pedido.addLineaPedido(linea1);
        pedido.addLineaPedido(linea2);

        // Crear ventas y añadir pedido
        Ventas ventas = new Ventas();
        ventas.addPedido(pedido);

        // Mostrar pedidos
        ventas.MostrarPedidos();

        // Calcular total del pedido
        System.out.println("Total del pedido: " + pedido.CalcularTotal());

        // Buscar pedido por estado
        ventas.BuscarPedidoPorEstado(EstadoPedido.EN_PROCESO);

        // Actualizar estado del pedido
        pedido.setEstado(EstadoPedido.COMPLETADO);
        ventas.ActualizarPedido(pedido);

        // Mostrar pedidos actualizados
        ventas.MostrarPedidos();

        // Buscar pedido por cliente
        System.out.println(ventas.BuscarPedidoByCliente(cliente));

        // Listar clientes
        Clientela clientela = new Clientela();
        clientela.addCliente(cliente);
        System.out.println(clientela.listarClientes());

        // Listar artículos del catálogo
        System.out.println(catalogo.getArticulos());
    }
}
