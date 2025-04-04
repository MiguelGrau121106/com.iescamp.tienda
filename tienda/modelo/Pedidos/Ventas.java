package iescamp.tienda.tienda.modelo.Pedidos;



import iescamp.tienda.modelo.Pedidos.EstadoPedido;
import iescamp.tienda.modelo.Pedidos.Pedido;

import java.util.ArrayList;


public class Ventas implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<iescamp.tienda.modelo.Pedidos.Pedido> pedidos = new ArrayList<>();

    public void addPedido(iescamp.tienda.modelo.Pedidos.Pedido pedido){
        pedidos.add(pedido);
    }

    public ArrayList<iescamp.tienda.modelo.Pedidos.Pedido> getPedidos() {
        return pedidos;
    }

    public void ActualizarPedido(iescamp.tienda.modelo.Pedidos.Pedido pedido){
        for (iescamp.tienda.modelo.Pedidos.Pedido p: pedidos) {
            if (p.equals(pedido)){
                p.setEstado(pedido.getEstado());
                p.setDNI(pedido.getDNI());
                p.setDireccionEntrega(pedido.getDireccionEntrega());
                p.setFechaPedido(pedido.getFechaPedido());
                p.setLineasPedido(pedido.getLineasPedido());
                p.setMetodoPago(pedido.getMetodoPago());
                p.setNumeroPedido(pedido.getNumeroPedido());
            }
        }
    }

    //CRUD -> Create, Read, Update, Delete

    public void EliminarPedido(iescamp.tienda.modelo.Pedidos.Pedido pedido){
        pedidos.remove(pedido);
    }

    public iescamp.tienda.modelo.Pedidos.Pedido BuscarPedido(int numeroPedido){
        for (iescamp.tienda.modelo.Pedidos.Pedido p: pedidos) {
            if (p.getNumeroPedido() == numeroPedido){
                return p;
            }
        }
        return null;
    }



    public boolean MostrarPedidos(){
        if (pedidos.isEmpty()){
            return false;
        }
        for (iescamp.tienda.modelo.Pedidos.Pedido p: pedidos) {
            System.out.println(p);
            return true;
        }
        return false;

    }

    public void BuscarPedidoPorEstado(EstadoPedido estado){
        for (iescamp.tienda.modelo.Pedidos.Pedido p: pedidos) {
            if (p.getEstado().equals(estado)){
                System.out.println(p);
            }
        }
    }

    public ArrayList<iescamp.tienda.modelo.Pedidos.Pedido> BuscarPedidoByCliente(String string){
        ArrayList<iescamp.tienda.modelo.Pedidos.Pedido> pedidosCliente = new ArrayList<>();
        for (iescamp.tienda.modelo.Pedidos.Pedido p: pedidos) {
            if (p.getDNI().equals(string)){
                pedidosCliente.add(p);
            }
        }
        return pedidosCliente;
    }

    public String listarPedidos() {
        String lista = "";
        for (Pedido p: pedidos) {
            lista += p.toString() + "\n";
        }
        return lista;
    }






}
