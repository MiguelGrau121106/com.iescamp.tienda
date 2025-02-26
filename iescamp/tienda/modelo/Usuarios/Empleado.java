package com.iescamp.tienda.modelo.Usuarios;

import java.time.LocalDate;
import java.util.Objects;


public class Empleado extends Usuario {
    private boolean tienePrivilegios;



    public boolean isPrivilegio() {
        return tienePrivilegios;
    }

    public void setPrivilegio(boolean privilegio) {
        this.tienePrivilegios = privilegio;
    }

    public Empleado(String DNI, String nombre, String apellidos, String direccion, String correoElectronico, String telefono, LocalDate fechaNacimiento, String pass, boolean activo, boolean privilegio) {
        super(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fechaNacimiento, pass, activo);
        this.tienePrivilegios = privilegio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return tienePrivilegios == empleado.tienePrivilegios;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tienePrivilegios);
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" +
                "tienePrivilegios=" + tienePrivilegios +
                '}';
    }
}
