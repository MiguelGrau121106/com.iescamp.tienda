package com.iescamp.tienda.modelo;

import java.time.LocalDate;


public abstract class Usuario {
    private String DNI;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String pass;
    private boolean activo;

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Usuario(String DNI, String nombre, String apellidos, String direccion, String correoElectronico, String telefono, LocalDate fechaNacimiento, String pass, boolean activo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.pass = pass;
        this.activo = activo;
    }

    public Usuario(String DNI, String nombre, String apellidos, String direccion, String correoElectronico, String telefono, LocalDate fechaNacimiento, String pass) {
        this(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fechaNacimiento, pass, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        return DNI.equals(usuario.DNI);
    }

    @Override
    public int hashCode() {
        return DNI.hashCode();
    }

    @Override
    public  String toString() {
        return "Usuario{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", pass='" + pass + '\'' +
                ", activo=" + activo +
                '}';
    }
}