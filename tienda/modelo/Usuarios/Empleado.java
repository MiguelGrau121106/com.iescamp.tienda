package iescamp.tienda.modelo.Usuarios;

import java.time.LocalDate;


public class Empleado extends Usuario{
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
}
