package iescamp.tienda.tienda.modelo.Usuarios;

import com.fasterxml.jackson.annotation.*;
import iescamp.tienda.modelo.Usuarios.Departamento;
import iescamp.tienda.modelo.Usuarios.Usuario;

import java.time.LocalDate;
public class Empleado extends Usuario implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private boolean tienePrivilegios;
    private iescamp.tienda.modelo.Usuarios.Departamento departamento;


    public iescamp.tienda.modelo.Usuarios.Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(iescamp.tienda.modelo.Usuarios.Departamento departamento) {
        this.departamento = departamento;
    }

    public boolean isPrivilegio() {
        return tienePrivilegios;
    }

    public void setPrivilegio(boolean privilegio) {
        this.tienePrivilegios = privilegio;
    }

    @JsonCreator
    public Empleado(@JsonProperty("DNI") String DNI,
                    @JsonProperty("nombre") String nombre,
                    @JsonProperty("apellidos") String apellidos,
                    @JsonProperty("direccion") String direccion,
                    @JsonProperty("correoElectronico") String correoElectronico,
                    @JsonProperty("telefono") String telefono,
                    @JsonProperty("fechaNacimiento") LocalDate fechaNacimiento,
                    @JsonProperty("pass") String pass,
                    @JsonProperty("activo") boolean activo,
                    @JsonProperty("tienePrivilegios") boolean tienePrivilegios,
                    @JsonProperty("departamento") Departamento departamento) {
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
