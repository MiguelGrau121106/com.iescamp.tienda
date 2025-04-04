package iescamp.tienda.tienda.modelo.Usuarios;

import iescamp.tienda.modelo.Usuarios.Departamento;
import iescamp.tienda.modelo.Usuarios.Empleado;

import java.util.ArrayList;

public class Plantilla implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> empleados = new ArrayList<>();

    // Crear
    public void addEmpleado(iescamp.tienda.modelo.Usuarios.Empleado empleado){
        empleados.add(empleado);
    }

    // Leer
    public ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> getEmpleados() {
        return empleados;
    }

    // Actualizar
    public void ActualizarEmpleado(iescamp.tienda.modelo.Usuarios.Empleado empleado){
        for (iescamp.tienda.modelo.Usuarios.Empleado e: empleados) {
            if (e.equals(empleado)){
                e.setActivo(empleado.isActivo());
                e.setNombre(empleado.getNombre());
                e.setApellidos(empleado.getApellidos());
                e.setDireccion(empleado.getDireccion());
                e.setTelefono(empleado.getTelefono());
                e.setPrivilegio(empleado.isPrivilegio());
                e.setActivo(empleado.isActivo());
            }
        }
    }
    public void setEmpleados(ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> empleados) {
        empleados =  empleados;
    }

    // Eliminar
    public void eliminarEmpleado(iescamp.tienda.modelo.Usuarios.Empleado empleado) {
        empleados.remove(empleado);
    }

    public ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> getEmpleadosByNombre(String nombre) {
        ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> empleadosByNombre = new ArrayList<>();
        for (iescamp.tienda.modelo.Usuarios.Empleado e : empleados) {
            if (e.getNombre().equals(nombre)) {
                empleadosByNombre.add(e);
            }
        }
        return empleadosByNombre;
    }

    public String listarEmpleados(){

        String lista = "";
        for (iescamp.tienda.modelo.Usuarios.Empleado e : empleados) {
            lista += e.toString() + "\n";
        }
        return lista;
    }

    public iescamp.tienda.modelo.Usuarios.Empleado buscarbyDNI(String DNI) {
        for (iescamp.tienda.modelo.Usuarios.Empleado e : empleados) {
            if (e.getDNI().equals(DNI)) {
                return e;
            }
        }
        return null;
    }
    public ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> getEmpleadosByPrivilegio(boolean privilegio) {
        ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> empleadosByPrivilegio = new ArrayList<>();
        for (iescamp.tienda.modelo.Usuarios.Empleado e : empleados) {
            if (e.isPrivilegio() == privilegio) {
                empleadosByPrivilegio.add(e);
            }
        }
        return empleadosByPrivilegio;
    }


    public iescamp.tienda.modelo.Usuarios.Empleado buscarbyTelefono(String Telefono) {
        for (iescamp.tienda.modelo.Usuarios.Empleado e : empleados) {
            if (e.getTelefono().equals(Telefono)) {
                return e;
            }
        }
        return null;
    }

    public iescamp.tienda.modelo.Usuarios.Empleado buscarbycorreoElectronico(String correoElectronico) {
        for (iescamp.tienda.modelo.Usuarios.Empleado e : empleados) {
            if (e.getCorreoElectronico().equals(correoElectronico)) {
                return e;
            }
        }
        return null;
    }

   public ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> getEmpleadosByActivo(boolean activo) {
        ArrayList<iescamp.tienda.modelo.Usuarios.Empleado> empleadosByActivo = new ArrayList<>();
        for (iescamp.tienda.modelo.Usuarios.Empleado e : empleados) {
            if (e.isActivo() == activo) {
                empleadosByActivo.add(e);
            }
        }
        return empleadosByActivo;
    }

    public iescamp.tienda.modelo.Usuarios.Empleado buscarbyDepartamento(Departamento departamento){
        for (Empleado e : empleados) {
            if (e.getDepartamento().equals(departamento)) {
                return e;
            }
        }
        return null;
    }


}
