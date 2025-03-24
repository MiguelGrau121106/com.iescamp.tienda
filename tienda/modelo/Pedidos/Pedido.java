package iescamp.tienda.modelo.Pedidos;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private int NumeroPedido;
    private LocalDate FechaPedido;

    private EstadoPedido estado;
    private String DireccionEntrega;
    private int metodoPago;

    private ArrayList<LineaPedido> lineasPedido = new ArrayList<>();
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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
    public java.lang.String toString() {
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

    public java.lang.String MostrarPedido(){
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
