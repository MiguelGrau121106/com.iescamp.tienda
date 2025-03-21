package iescamp.tienda.modelo.Usuarios;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Cliente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String direccionEnvio;
    private float saldoCuenta;
    private boolean tieneTarjetaFidelidad;
    private int numeroPedidosRealizados;
    private MetodoPago metodoPago;

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

    public void setTieneTarjetaFidelidad(boolean tieneTarjetaFidelidad) {
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
    }

    public int getNumeroPedidosRealizados() {
        return numeroPedidosRealizados;
    }

    public void setNumeroPedidosRealizados(int numeroPedidosRealizados) {
        this.numeroPedidosRealizados = numeroPedidosRealizados;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Cliente(String DNI, String nombre, String apellidos, String direccion, String correoElectronico, String telefono, LocalDate fechaNacimiento, String pass, boolean activo, String direccionEnvio, float saldoCuenta, boolean tieneTarjetaFidelidad, int numeroPedidosRealizados, MetodoPago metodoPago) {
        super(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fechaNacimiento, pass, activo);
        this.direccionEnvio = direccionEnvio;
        this.saldoCuenta = saldoCuenta;
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
        this.numeroPedidosRealizados = numeroPedidosRealizados;
        this.metodoPago = metodoPago;
    }


    @Override
    public String toString() {
        return super.toString() + "Cliente{" +
                "direccionEnvio='" + direccionEnvio + '\'' +
                ", saldoCuenta=" + saldoCuenta +
                ", tieneTarjetaFidelidad=" + tieneTarjetaFidelidad +
                ", numeroPedidosRealizados=" + numeroPedidosRealizados +
                ", metodoPago=" + metodoPago +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cliente cliente = (Cliente) o;
        return Float.compare(saldoCuenta, cliente.saldoCuenta) == 0 && tieneTarjetaFidelidad == cliente.tieneTarjetaFidelidad && numeroPedidosRealizados == cliente.numeroPedidosRealizados && Objects.equals(direccionEnvio, cliente.direccionEnvio) && Objects.equals(metodoPago, cliente.metodoPago);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(direccionEnvio);
        result = 31 * result + Float.hashCode(saldoCuenta);
        result = 31 * result + Boolean.hashCode(tieneTarjetaFidelidad);
        result = 31 * result + numeroPedidosRealizados;
        result = 31 * result + Objects.hashCode(metodoPago);
        return result;
    }
}
