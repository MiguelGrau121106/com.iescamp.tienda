package iescamp.tienda.modelo.Usuarios;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente extends Usuario{
    private int Id;
    private String direccionEnvio;
    private float saldoCuenta;
    private boolean tieneTarjetaFidelidad;
    private int numeroPedidosRealizados;
    private MetodoPago metodoPago;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public float getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(float saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public boolean isTieneTarjetaFidelidad() {
        return tieneTarjetaFidelidad;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setTieneTarjetaFidelidad(boolean tieneTarjetaFidelidad) {
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
    }

    public int getNumeroPedidosRealizados() {
        return numeroPedidosRealizados;
    }

    public void setNumeroPedidosRealizados(int numeroPedidosRealizados) {
        this.numeroPedidosRealizados = numeroPedidosRealizados;
    }

    public Cliente(String DNI, String nombre, String apellidos, String direccion, String correoElectronico, String telefono, LocalDate fechaNacimiento, String pass, MetodoPago metodoPago, int numeroPedidosRealizados, boolean tieneTarjetaFidelidad, float saldoCuenta, String direccionEnvio, int id) {
        super(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fechaNacimiento, pass);
        this.metodoPago = metodoPago;
        this.numeroPedidosRealizados = numeroPedidosRealizados;
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
        this.saldoCuenta = saldoCuenta;
        this.direccionEnvio = direccionEnvio;
        Id = id;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente{" +
                "Id=" + Id +
                ", direccionEnvio='" + direccionEnvio + '\'' +
                ", saldoCuenta=" + saldoCuenta +
                ", tieneTarjetaFidelidad=" + tieneTarjetaFidelidad +
                ", numeroPedidosRealizados=" + numeroPedidosRealizados +
                ", metodoPago=" + metodoPago +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Id == cliente.Id && Float.compare(saldoCuenta, cliente.saldoCuenta) == 0 && tieneTarjetaFidelidad == cliente.tieneTarjetaFidelidad && numeroPedidosRealizados == cliente.numeroPedidosRealizados && Objects.equals(direccionEnvio, cliente.direccionEnvio) && Objects.equals(metodoPago, cliente.metodoPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Id, direccionEnvio, saldoCuenta, tieneTarjetaFidelidad, numeroPedidosRealizados, metodoPago);
    }
}
