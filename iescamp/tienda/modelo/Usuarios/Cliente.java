package iescamp.tienda.modelo.Usuarios;

import java.time.LocalDate;

public class Cliente extends Usuario{
    private int Id;
    private String direccionEnvio;
    private float saldoCuenta;
    private boolean tieneTarjetaFidelidad;
    private int numeroPedidosRealizados;

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

    public void setTieneTarjetaFidelidad(boolean tieneTarjetaFidelidad) {
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
    }

    public int getNumeroPedidosRealizados() {
        return numeroPedidosRealizados;
    }

    public void setNumeroPedidosRealizados(int numeroPedidosRealizados) {
        this.numeroPedidosRealizados = numeroPedidosRealizados;
    }


    public Cliente(String DNI, String nombre, String apellidos, String direccion, String correoElectronico, String telefono, LocalDate fechaNacimiento, String pass, boolean activo, String direccionEnvio, float saldoCuenta, boolean tieneTarjetaFidelidad, int numeroPedidosRealizados) {
        super(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fechaNacimiento, pass, activo);
        this.direccionEnvio = direccionEnvio;
        this.saldoCuenta = saldoCuenta;
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
        this.numeroPedidosRealizados = numeroPedidosRealizados;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Cliente{" +
                "direccionEnvio='" + direccionEnvio + '\'' +
                ", saldoCuenta=" + saldoCuenta +
                ", tieneTarjetaFidelidad=" + tieneTarjetaFidelidad +
                ", numeroPedidosRealizados=" + numeroPedidosRealizados +
                '}';
    }
}
