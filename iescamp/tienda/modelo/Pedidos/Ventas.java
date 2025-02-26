package iescamp.tienda.modelo.Pedidos;

import iescamp.tienda.modelo.Usuarios.Cliente;

import java.util.ArrayList;


public class Ventas {
    ArrayList<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void ActualizarPedido(Pedido pedido){
        for (Pedido p: pedidos) {
            if (p.equals(pedido)){
                p.setEstado(pedido.getEstado());
            }
        }
    }

    public void EliminarPedido(Pedido pedido){
        pedidos.remove(pedido);
    }

    public Pedido BuscarPedido(int numeroPedido){
        for (Pedido p: pedidos) {
            if (p.getNumeroPedido() == numeroPedido){
                return p;
            }
        }
        return null;
    }

    public void MostrarPedidos(){
        for (Pedido p: pedidos) {
            System.out.println(p);
        }
    }

    public void BuscarPedidoPorEstado(String estado){
        for (Pedido p: pedidos) {
            if (p.getEstado().equals(estado)){
                System.out.println(p);
            }
        }
    }

    public ArrayList<Pedido> BuscarPedidoPorCliente(Cliente cliente){
        ArrayList<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido p: pedidos) {
            if (p.getCliente().equals(cliente)){
                pedidosCliente.add(p);
            }
        }
        return pedidosCliente;
    }


}
