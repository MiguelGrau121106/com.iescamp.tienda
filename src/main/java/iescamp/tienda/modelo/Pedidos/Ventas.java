package iescamp.tienda.modelo.Pedidos;

import java.util.ArrayList;

/**
 * Clase que gestiona las ventas y los pedidos asociados a ellas.
 * Permite realizar operaciones CRUD sobre los pedidos.
 */
public class Ventas implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    // Lista de pedidos asociados a la venta.
    ArrayList<Pedido> pedidos = new ArrayList<>();

    /**
     * Añade un nuevo pedido a la lista de pedidos.
     *
     * @param pedido El pedido que se va a añadir.
     */
    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    /**
     * Obtiene la lista completa de pedidos.
     *
     * @return La lista de pedidos.
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Actualiza un pedido existente en la lista.
     * Si el pedido ya existe (basado en la comparación de objetos), se actualizan sus atributos.
     *
     * @param pedido El pedido con los nuevos valores.
     */
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

    /**
     * Elimina un pedido de la lista.
     *
     * @param pedido El pedido que se va a eliminar.
     */
    public void EliminarPedido(Pedido pedido){
        pedidos.remove(pedido);
    }

    /**
     * Busca un pedido en la lista por su número de pedido.
     *
     * @param numeroPedido El número del pedido que se desea buscar.
     * @return El pedido con el número especificado, o null si no se encuentra.
     */
    public Pedido BuscarPedido(int numeroPedido){
        for (Pedido p: pedidos) {
            if (p.getNumeroPedido() == numeroPedido){
                return p;
            }
        }
        return null;
    }

    /**
     * Muestra todos los pedidos en la lista.
     * Si no hay pedidos, devuelve false.
     *
     * @return true si se han mostrado los pedidos, false si no hay pedidos.
     */
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

    /**
     * Busca y muestra los pedidos por estado.
     *
     * @param estado El estado de los pedidos que se van a buscar.
     */
    public void BuscarPedidoPorEstado(EstadoPedido estado){
        for (Pedido p: pedidos) {
            if (p.getEstado().equals(estado)){
                System.out.println(p);
            }
        }
    }

    /**
     * Busca los pedidos de un cliente específico por su DNI.
     *
     * @param string El DNI del cliente.
     * @return Una lista de pedidos del cliente con el DNI especificado.
     */
    public ArrayList<Pedido> BuscarPedidoByCliente(String string){
        ArrayList<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido p: pedidos) {
            if (p.getDNI().equals(string)){
                pedidosCliente.add(p);
            }
        }
        return pedidosCliente;
    }

    /**
     * Genera una cadena con la representación en texto de todos los pedidos en la lista.
     *
     * @return Una cadena de texto con los detalles de los pedidos.
     */
    public String listarPedidos() {
        String lista = "";
        for (Pedido p: pedidos) {
            lista += p.toString() + "\n";
        }
        return lista;
    }
}
