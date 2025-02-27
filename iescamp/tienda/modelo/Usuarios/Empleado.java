package iescamp.tienda.modelo.Usuarios;

import java.time.LocalDate;


public class Empleado extends Usuario{
    private boolean tienePrivilegios;
    private Departamento departamento;


    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public boolean isPrivilegio() {
        return tienePrivilegios;
    }

    public void setPrivilegio(boolean privilegio) {
        this.tienePrivilegios = privilegio;
    }

    public Empleado(String DNI, String nombre, String apellidos, String direccion, String correoElectronico, String telefono, LocalDate fechaNacimiento, String pass, boolean activo, boolean tienePrivilegios, Departamento departamento) {
        super(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fechaNacimiento, pass, activo);
        this.tienePrivilegios = tienePrivilegios;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" +
                "tienePrivilegios=" + tienePrivilegios +
                ", departamento=" + departamento +
                '}';
    }
}
