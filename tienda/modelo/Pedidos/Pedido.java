package iescamp.tienda.modelo.Pedidos;


import javax.sound.sampled.Line;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido {
    private int NumeroPedido;
    private LocalDate FechaPedido;
    private String estado;
    private String DireccionEntrega;
    private ArrayList<LineaPedido> lineasPedido = new ArrayList<>();

    // getter y setter

    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void AddLineaPedido(LineaPedido lineaPedido){
        lineasPedido.add(lineaPedido);
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccionEntrega() {
        return DireccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        DireccionEntrega = direccionEntrega;
    }

    // equals

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pedido pedido = (Pedido) object;
        return NumeroPedido == pedido.NumeroPedido && Objects.equals(FechaPedido, pedido.FechaPedido) && Objects.equals(estado, pedido.estado) && Objects.equals(DireccionEntrega, pedido.DireccionEntrega);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NumeroPedido, FechaPedido, estado, DireccionEntrega);
    }

    // constructor

    public Pedido(int numeroPedido, LocalDate fechaPedido, String estado, String direccionEntrega) {
        NumeroPedido = numeroPedido;
        FechaPedido = fechaPedido;
        this.estado = estado;
        DireccionEntrega = direccionEntrega;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "NumeroPedido=" + NumeroPedido +
                ", FechaPedido=" + FechaPedido +
                ", estado='" + estado + '\'' +
                ", DireccionEntrega='" + DireccionEntrega + '\'' +
                '}';
    }

    public String mostrarpedido(){
        return  "Pedido{" +
                "NumeroPedido=" + NumeroPedido +
                ", FechaPedido=" + FechaPedido +
                ", estado='" + estado + '\'' +
                ", DireccionEntrega='" + DireccionEntrega + '\'' +
                ", lineasPedido=" + lineasPedido +
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
