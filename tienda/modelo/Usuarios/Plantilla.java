package iescamp.tienda.modelo.Usuarios;

import java.util.ArrayList;

public class Plantilla implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Empleado> empleados = new ArrayList<>();

    // Crear
    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    // Leer
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    // Actualizar
    public void ActualizarEmpleado(Empleado empleado){
        for (Empleado e: empleados) {
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
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    // Eliminar
    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public ArrayList<Empleado> getEmpleadosByNombre(String nombre) {
        ArrayList<Empleado> empleadosByNombre = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.getNombre().equals(nombre)) {
                empleadosByNombre.add(e);
            }
        }
        return empleadosByNombre;
    }

    public String listarEmpleados(){

        String lista = "";
        for (Empleado e : empleados) {
            lista += e.toString() + "\n";
        }
        return lista;
    }

    public Empleado buscarbyDNI(String DNI) {
        for (Empleado e : empleados) {
            if (e.getDNI().equals(DNI)) {
                return e;
            }
        }
        return null;
    }
    public ArrayList<Empleado> getEmpleadosByPrivilegio(boolean privilegio) {
        ArrayList<Empleado> empleadosByPrivilegio = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.isPrivilegio() == privilegio) {
                empleadosByPrivilegio.add(e);
            }
        }
        return empleadosByPrivilegio;
    }


    public Empleado buscarbyTelefono(String Telefono) {
        for (Empleado e : empleados) {
            if (e.getTelefono().equals(Telefono)) {
                return e;
            }
        }
        return null;
    }

    public Empleado buscarbycorreoElectronico(String correoElectronico) {
        for (Empleado e : empleados) {
            if (e.getCorreoElectronico().equals(correoElectronico)) {
                return e;
            }
        }
        return null;
    }

   public ArrayList<Empleado> getEmpleadosByActivo(boolean activo) {
        ArrayList<Empleado> empleadosByActivo = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.isActivo() == activo) {
                empleadosByActivo.add(e);
            }
        }
        return empleadosByActivo;
    }

    public Empleado buscarbyDepartamento(Departamento departamento){
        for (Empleado e : empleados) {
            if (e.getDepartamento().equals(departamento)) {
                return e;
            }
        }
        return null;
    }


}
