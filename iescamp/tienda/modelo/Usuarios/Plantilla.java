package iescamp.tienda.modelo.Usuarios;

import java.util.ArrayList;



import java.util.ArrayList;

public class Plantilla {
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
                e.setDNI(empleado.getDNI());
                e.setDireccion(empleado.getDireccion());
                e.setTelefono(empleado.getTelefono());
                e.setPrivilegio(empleado.isPrivilegio());
                e.setActivo(empleado.isActivo());
            }
        }
    }

    // Eliminar
    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

}
