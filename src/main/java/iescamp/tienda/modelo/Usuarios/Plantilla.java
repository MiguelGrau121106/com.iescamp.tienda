package iescamp.tienda.modelo.Usuarios;

import java.util.ArrayList;

/**
 * Clase que gestiona la plantilla de empleados de la tienda.
 * Permite realizar operaciones CRUD sobre los empleados.
 */
public class Plantilla implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    // Lista de empleados en la plantilla.
    private ArrayList<Empleado> empleados = new ArrayList<>();

    /**
     * Añade un nuevo empleado a la plantilla.
     *
     * @param empleado El empleado que se va a añadir.
     */
    // Crear
    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    /**
     * Obtiene la lista completa de empleados.
     *
     * @return La lista de empleados.
     */
    // Leer
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Actualiza los datos de un empleado existente en la plantilla.
     * Si el empleado ya existe (basado en la comparación de objetos), se actualizan sus atributos.
     *
     * @param empleado El empleado con los nuevos valores.
     */
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

    /**
     * Establece una nueva lista de empleados.
     *
     * @param empleados La lista de empleados a establecer.
     */
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Elimina un empleado de la plantilla.
     *
     * @param empleado El empleado que se va a eliminar.
     */
    // Eliminar
    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    /**
     * Busca empleados por su nombre.
     *
     * @param nombre El nombre del empleado que se desea buscar.
     * @return Una lista de empleados con el nombre especificado.
     */
    public ArrayList<Empleado> getEmpleadosByNombre(String nombre) {
        ArrayList<Empleado> empleadosByNombre = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.getNombre().equals(nombre)) {
                empleadosByNombre.add(e);
            }
        }
        return empleadosByNombre;
    }

    /**
     * Genera una cadena con la representación en texto de todos los empleados en la plantilla.
     *
     * @return Una cadena de texto con los detalles de los empleados.
     */
    public String listarEmpleados(){
        String lista = "";
        for (Empleado e : empleados) {
            lista += e.toString() + "\n";
        }
        return lista;
    }

    /**
     * Busca un empleado por su DNI.
     *
     * @param DNI El DNI del empleado que se desea buscar.
     * @return El empleado con el DNI especificado, o null si no se encuentra.
     */
    public Empleado buscarbyDNI(String DNI) {
        for (Empleado e : empleados) {
            if (e.getDNI().equals(DNI)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Busca empleados por su privilegio.
     *
     * @param privilegio El privilegio del empleado que se desea buscar.
     * @return Una lista de empleados con el privilegio especificado.
     */
    public ArrayList<Empleado> getEmpleadosByPrivilegio(boolean privilegio) {
        ArrayList<Empleado> empleadosByPrivilegio = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.isPrivilegio() == privilegio) {
                empleadosByPrivilegio.add(e);
            }
        }
        return empleadosByPrivilegio;
    }

    /**
     * Busca un empleado por su número de teléfono.
     *
     * @param Telefono El número de teléfono del empleado que se desea buscar.
     * @return El empleado con el teléfono especificado, o null si no se encuentra.
     */
    public Empleado buscarbyTelefono(String Telefono) {
        for (Empleado e : empleados) {
            if (e.getTelefono().equals(Telefono)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Busca un empleado por su correo electrónico.
     *
     * @param correoElectronico El correo electrónico del empleado que se desea buscar.
     * @return El empleado con el correo electrónico especificado, o null si no se encuentra.
     */
    public Empleado buscarbycorreoElectronico(String correoElectronico) {
        for (Empleado e : empleados) {
            if (e.getCorreoElectronico().equals(correoElectronico)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Busca empleados por su estado de actividad (activo o inactivo).
     *
     * @param activo El estado de actividad del empleado que se desea buscar.
     * @return Una lista de empleados con el estado de actividad especificado.
     */
    public ArrayList<Empleado> getEmpleadosByActivo(boolean activo) {
        ArrayList<Empleado> empleadosByActivo = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.isActivo() == activo) {
                empleadosByActivo.add(e);
            }
        }
        return empleadosByActivo;
    }

    /**
     * Busca un empleado por su departamento.
     *
     * @param departamento El departamento del empleado que se desea buscar.
     * @return El empleado del departamento especificado, o null si no se encuentra.
     */
    public Empleado buscarbyDepartamento(Departamento departamento){
        for (Empleado e : empleados) {
            if (e.getDepartamento().equals(departamento)) {
                return e;
            }
        }
        return null;
    }
}
