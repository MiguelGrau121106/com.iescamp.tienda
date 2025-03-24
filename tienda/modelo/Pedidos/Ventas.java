package iescamp.tienda.modelo.Pedidos;



import java.util.ArrayList;


public class Ventas implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
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



    public boolean MostrarPedidos(){
        if (pedidos.isEmpty()){
            return false;
        }
        for (Pedido p: pedidos) {
            System.out.println(p);
            return true;
        }
        return false;

    }

    public void BuscarPedidoPorEstado(EstadoPedido estado){
        for (Pedido p: pedidos) {
            if (p.getEstado().equals(estado)){
                System.out.println(p);
            }
        }
    }

    public ArrayList<Pedido> BuscarPedidoByCliente(String string){
        ArrayList<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido p: pedidos) {
            if (p.getDNI().equals(string)){
                pedidosCliente.add(p);
            }
        }
        return pedidosCliente;
    }

    public java.lang.String listarPedidos() {
        java.lang.String lista = "";
        for (Pedido p: pedidos) {
            lista += p.toString() + "\n";
        }
        return lista;
    }






}
