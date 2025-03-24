package iescamp.tienda.modelo.Usuarios;

import java.util.ArrayList;
import java.util.Optional;

public class Clientela implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Create
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Read
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Optional<Cliente> getClienteByDNI(String DNI) {
        return clientes.stream().filter(c -> c.getDNI().equals(DNI)).findFirst();
    }

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


    // Delete
    public boolean removeCliente(String DNI) {
        return clientes.removeIf(c -> c.getDNI().equals(DNI));
    }

    public ArrayList<Cliente> getClientesByNombre(String nombre) {
        ArrayList<Cliente> clientesByNombre = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) {
                clientesByNombre.add(c);
            }
        }
        return clientesByNombre;
    }

    public String listarClientes() {
        String lista="";
        for (Cliente c : clientes) {
            lista += c.toString() + "\n";
        }
        return lista;
    }

    public Cliente buscarbyDNI(String DNI) {
        for (Cliente c : clientes) {
            if (c.getDNI().equals(DNI)) {
                return c;
            }
        }
        return null;
    }

    public Cliente buscarbyTelefono(String Telefono) {
        for (Cliente c : clientes) {
            if (c.getTelefono().equals(Telefono)) {
                return c;
            }
        }
        return null;
    }

    public Cliente buscarbycorreoElectronico(String correoElectronico) {
        for (Cliente c : clientes) {
            if (c.getCorreoElectronico().equals(correoElectronico)) {
                return c;
            }
        }
        return null;
    }



    public ArrayList<Cliente> getClientesbytarjetaFidelidad(boolean tarjetaFidelidad) {
        ArrayList<Cliente> clientesByTarjetaFidelidad = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.isTieneTarjetaFidelidad() == tarjetaFidelidad) {
                clientesByTarjetaFidelidad.add(c);
            }
        }
        return clientesByTarjetaFidelidad;
    }


    public ArrayList<Cliente> getClientesbyActivo(boolean activo) {
        ArrayList<Cliente> clientesByActivo = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.isActivo() == activo) {
                clientesByActivo.add(c);
            }
        }
        return clientesByActivo;
    }

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
