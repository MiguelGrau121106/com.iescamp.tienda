package iescamp.tienda.modelo.Usuarios;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
public class Empleado extends Usuario implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
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
