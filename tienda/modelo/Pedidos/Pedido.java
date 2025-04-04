package iescamp.tienda.tienda.modelo.Pedidos;




import iescamp.tienda.modelo.Pedidos.EstadoPedido;
import iescamp.tienda.modelo.Pedidos.LineaPedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private int NumeroPedido;
    private LocalDate FechaPedido;

    private iescamp.tienda.modelo.Pedidos.EstadoPedido estado;
    private String DireccionEntrega;
    private int metodoPago;

    private ArrayList<iescamp.tienda.modelo.Pedidos.LineaPedido> lineasPedido = new ArrayList<>();
    private String DNI;

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


    public iescamp.tienda.modelo.Pedidos.EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(iescamp.tienda.modelo.Pedidos.EstadoPedido estado) {

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

    public ArrayList<iescamp.tienda.modelo.Pedidos.LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(ArrayList<iescamp.tienda.modelo.Pedidos.LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    //metodo adicional
    public void addLineaPedido(iescamp.tienda.modelo.Pedidos.LineaPedido lineaPedido) {
        lineasPedido.add(lineaPedido);
    }

    // equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return NumeroPedido == pedido.NumeroPedido && metodoPago == pedido.metodoPago && Objects.equals(FechaPedido, pedido.FechaPedido) && estado == pedido.estado && Objects.equals(DireccionEntrega, pedido.DireccionEntrega) && Objects.equals(lineasPedido, pedido.lineasPedido) && Objects.equals(DNI, pedido.DNI);

    }

    @Override
    public int hashCode() {

        return Objects.hash(NumeroPedido, FechaPedido, estado, DireccionEntrega, metodoPago, lineasPedido, DNI);
    }


    // constructor

    public Pedido(int numeroPedido, LocalDate fechaPedido, EstadoPedido estado, String direccionEntrega, int metodoPago, String DNI) {

        NumeroPedido = numeroPedido;
        FechaPedido = fechaPedido;
        this.estado = estado;
        DireccionEntrega = direccionEntrega;

        this.metodoPago = metodoPago;

        this.DNI = DNI;
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
                ", cliente=" + DNI +
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
                ", cliente=" + DNI +
                '}';
    }

    public double CalcularTotal(){
        double total = 0;

        for (LineaPedido Ln : lineasPedido){

            double precio = Ln.getArticulo().getPrecio();

            total += precio;
        }

        return total;
    }

}
