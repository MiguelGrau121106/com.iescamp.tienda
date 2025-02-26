package iescamp.tienda.modelo.Pedidos;


import iescamp.tienda.modelo.Usuarios.Cliente;

import javax.sound.sampled.Line;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido {
    private int NumeroPedido;
    private LocalDate FechaPedido;
    private EstadoPedido estado;
    private String DireccionEntrega;
    private int metodoPago;
    private ArrayList<LineaPedido> lineasPedido = new ArrayList<>();
    private Cliente cliente;

    // getter y setter

    public int getNumeroPedido() {
        return NumeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        NumeroPedido = numeroPedido;
    }

    public LocalDate getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        FechaPedido = fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getDireccionEntrega() {
        return DireccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        DireccionEntrega = direccionEntrega;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(ArrayList<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //metodo adicional
    public void addLineaPedido(LineaPedido lineaPedido) {
        lineasPedido.add(lineaPedido);
    }

    // equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return NumeroPedido == pedido.NumeroPedido && metodoPago == pedido.metodoPago && Objects.equals(FechaPedido, pedido.FechaPedido) && estado == pedido.estado && Objects.equals(DireccionEntrega, pedido.DireccionEntrega) && Objects.equals(lineasPedido, pedido.lineasPedido) && Objects.equals(cliente, pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NumeroPedido, FechaPedido, estado, DireccionEntrega, metodoPago, lineasPedido, cliente);
    }


    // constructor

    public Pedido(int numeroPedido, LocalDate fechaPedido, EstadoPedido estado, String direccionEntrega, int metodoPago, ArrayList<LineaPedido> lineasPedido, Cliente cliente) {
        NumeroPedido = numeroPedido;
        FechaPedido = fechaPedido;
        this.estado = estado;
        DireccionEntrega = direccionEntrega;
        this.metodoPago = metodoPago;
        this.lineasPedido = lineasPedido;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "NumeroPedido=" + NumeroPedido +
                ", FechaPedido=" + FechaPedido +
                ", estado=" + estado +
                ", DireccionEntrega='" + DireccionEntrega + '\'' +
                ", metodoPago=" + metodoPago +
                ", lineasPedido=" + lineasPedido +
                ", cliente=" + cliente +
                '}';
    }

    public String MostrarPedido(){
        return  "Pedido{" +
                "NumeroPedido=" + NumeroPedido +
                ", FechaPedido=" + FechaPedido +
                ", estado='" + estado + '\'' +
                ", DireccionEntrega='" + DireccionEntrega + '\'' +
                ", metodoPago=" + metodoPago +
                ", lineasPedido=" + lineasPedido +
                ", cliente=" + cliente +
                '}';
    }

    public double CalcularTotal(){
        double total = 0;

        for (LineaPedido Ln : lineasPedido){
            int cantidad = Ln.getCantidad();
            double precio = Ln.getArticulo().getPrecio();

            total = total + (cantidad * precio);
        }

        return total;
    }

}
