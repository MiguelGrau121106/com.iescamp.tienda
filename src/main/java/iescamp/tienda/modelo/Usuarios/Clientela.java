package iescamp.tienda.modelo.Usuarios;

import java.util.ArrayList;

/**
 * Clase que gestiona la lista de clientes de la tienda.
 * Permite realizar operaciones CRUD sobre los clientes.
 */
public class Clientela implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    // Lista de clientes de la tienda.
    private ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * Añade un nuevo cliente a la lista.
     *
     * @param cliente El cliente que se va a añadir.
     */
    // Create
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Establece una nueva lista de clientes.
     *
     * @param clientes La lista de clientes a establecer.
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Obtiene la lista completa de clientes.
     *
     * @return La lista de clientes.
     */
    // Read
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Busca un cliente por su DNI.
     *
     * @param DNI El DNI del cliente que se desea buscar.
     * @return El cliente con el DNI especificado, o null si no se encuentra.
     */
    public Cliente getClienteByDNI(String DNI) {
        for (Cliente c : clientes) {
            if (c.getDNI().equals(DNI)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Actualiza los datos de un cliente existente en la lista.
     * Si el cliente no existe (basado en el DNI), no realiza cambios.
     *
     * @param cliente El cliente con los nuevos valores.
     * @return true si el cliente fue actualizado, false si no se encontró.
     */
    // Update
    public boolean updateCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDNI().equals(cliente.getDNI())) {
                Cliente existingCliente = clientes.get(i);
                existingCliente.setNombre(cliente.getNombre());
                existingCliente.setApellidos(cliente.getApellidos());
                existingCliente.setDireccion(cliente.getDireccion());
                existingCliente.setCorreoElectronico(cliente.getCorreoElectronico());
                existingCliente.setTelefono(cliente.getTelefono());
                existingCliente.setFechaNacimiento(cliente.getFechaNacimiento());
                existingCliente.setPass(cliente.getPass());
                existingCliente.setActivo(cliente.isActivo());
                existingCliente.setDireccionEnvio(cliente.getDireccionEnvio());
                existingCliente.setSaldoCuenta(cliente.getSaldoCuenta());
                existingCliente.setTieneTarjetaFidelidad(cliente.isTieneTarjetaFidelidad());
                existingCliente.setNumeroPedidosRealizados(cliente.getNumeroPedidosRealizados());
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un cliente de la lista basado en su DNI.
     *
     * @param DNI El DNI del cliente a eliminar.
     * @return true si el cliente fue eliminado, false si no se encontró.
     */
    // Delete
    public boolean removeCliente(String DNI) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDNI().equals(DNI)) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca clientes por su nombre.
     *
     * @param nombre El nombre del cliente que se desea buscar.
     * @return Una lista de clientes con el nombre especificado.
     */
    public ArrayList<Cliente> getClientesByNombre(String nombre) {
        ArrayList<Cliente> clientesByNombre = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) {
                clientesByNombre.add(c);
            }
        }
        return clientesByNombre;
    }

    /**
     * Genera una cadena con la representación en texto de todos los clientes.
     *
     * @return Una cadena de texto con los detalles de los clientes.
     */
    public String listarClientes() {
        String lista = "";
        for (Cliente c : clientes) {
            lista += c.toString() + "\n";
        }
        return lista;
    }

    /**
     * Busca un cliente por su DNI.
     *
     * @param DNI El DNI del cliente que se desea buscar.
     * @return El cliente con el DNI especificado, o null si no se encuentra.
     */
    public Cliente buscarbyDNI(String DNI) {
        for (Cliente c : clientes) {
            if (c.getDNI().equals(DNI)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Busca un cliente por su número de teléfono.
     *
     * @param Telefono El número de teléfono del cliente que se desea buscar.
     * @return El cliente con el teléfono especificado, o null si no se encuentra.
     */
    public Cliente buscarbyTelefono(String Telefono) {
        for (Cliente c : clientes) {
            if (c.getTelefono().equals(Telefono)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Busca un cliente por su correo electrónico.
     *
     * @param correoElectronico El correo electrónico del cliente que se desea buscar.
     * @return El cliente con el correo electrónico especificado, o null si no se encuentra.
     */
    public Cliente buscarbycorreoElectronico(String correoElectronico) {
        for (Cliente c : clientes) {
            if (c.getCorreoElectronico().equals(correoElectronico)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Busca clientes por su tarjeta de fidelidad (si la tienen o no).
     *
     * @param tarjetaFidelidad true si se buscan clientes con tarjeta de fidelidad, false si no la tienen.
     * @return Una lista de clientes con o sin tarjeta de fidelidad según el parámetro.
     */
    public ArrayList<Cliente> getClientesbytarjetaFidelidad(boolean tarjetaFidelidad) {
        ArrayList<Cliente> clientesByTarjetaFidelidad = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.isTieneTarjetaFidelidad() == tarjetaFidelidad) {
                clientesByTarjetaFidelidad.add(c);
            }
        }
        return clientesByTarjetaFidelidad;
    }

    /**
     * Busca clientes según su estado de actividad (activo o inactivo).
     *
     * @param activo El estado de actividad del cliente que se desea buscar.
     * @return Una lista de clientes con el estado de actividad especificado.
     */
    public ArrayList<Cliente> getClientesbyActivo(boolean activo) {
        ArrayList<Cliente> clientesByActivo = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.isActivo() == activo) {
                clientesByActivo.add(c);
            }
        }
        return clientesByActivo;
    }

    /**
     * Busca clientes según su método de pago preferido.
     *
     * @param metodoPago El método de pago que se desea buscar.
     * @return Una lista de clientes con el método de pago especificado.
     */
    public ArrayList<Cliente> getClientesbyMetodoPago(MetodoPago metodoPago) {
        ArrayList<Cliente> clientesByMetodoPago = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getMetodoPago().equals(metodoPago)) {
                clientesByMetodoPago.add(c);
            }
        }
        return clientesByMetodoPago;
    }
}
