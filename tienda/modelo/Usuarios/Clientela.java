package iescamp.tienda.modelo.Usuarios;

import java.util.ArrayList;

public class Clientela implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> clientes = new ArrayList<>();

    // Create
    public void addCliente(iescamp.tienda.modelo.Usuarios.Cliente cliente) {
        clientes.add(cliente);
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Read
    public ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> getClientes() {
        return clientes;
    }

    public iescamp.tienda.modelo.Usuarios.Cliente getClienteByDNI(String DNI) {
        for (iescamp.tienda.modelo.Usuarios.Cliente c : clientes) {
            if (c.getDNI().equals(DNI)) {
                return c;
            }
        }
        return null;
    }


    // Update
    public boolean updateCliente(iescamp.tienda.modelo.Usuarios.Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDNI().equals(cliente.getDNI())) {
                iescamp.tienda.modelo.Usuarios.Cliente existingCliente = clientes.get(i);
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
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDNI().equals(DNI)) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> getClientesByNombre(String nombre) {
        ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> clientesByNombre = new ArrayList<>();
        for (iescamp.tienda.modelo.Usuarios.Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) {
                clientesByNombre.add(c);
            }
        }
        return clientesByNombre;
    }

    public String listarClientes() {
        String lista="";
        for (iescamp.tienda.modelo.Usuarios.Cliente c : clientes) {
            lista += c.toString() + "\n";
        }
        return lista;
    }

    public iescamp.tienda.modelo.Usuarios.Cliente buscarbyDNI(String DNI) {
        for (iescamp.tienda.modelo.Usuarios.Cliente c : clientes) {
            if (c.getDNI().equals(DNI)) {
                return c;
            }
        }
        return null;
    }

    public iescamp.tienda.modelo.Usuarios.Cliente buscarbyTelefono(String Telefono) {
        for (iescamp.tienda.modelo.Usuarios.Cliente c : clientes) {
            if (c.getTelefono().equals(Telefono)) {
                return c;
            }
        }
        return null;
    }

    public iescamp.tienda.modelo.Usuarios.Cliente buscarbycorreoElectronico(String correoElectronico) {
        for (iescamp.tienda.modelo.Usuarios.Cliente c : clientes) {
            if (c.getCorreoElectronico().equals(correoElectronico)) {
                return c;
            }
        }
        return null;
    }



    public ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> getClientesbytarjetaFidelidad(boolean tarjetaFidelidad) {
        ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> clientesByTarjetaFidelidad = new ArrayList<>();
        for (iescamp.tienda.modelo.Usuarios.Cliente c : clientes) {
            if (c.isTieneTarjetaFidelidad() == tarjetaFidelidad) {
                clientesByTarjetaFidelidad.add(c);
            }
        }
        return clientesByTarjetaFidelidad;
    }


    public ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> getClientesbyActivo(boolean activo) {
        ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> clientesByActivo = new ArrayList<>();
        for (iescamp.tienda.modelo.Usuarios.Cliente c : clientes) {
            if (c.isActivo() == activo) {
                clientesByActivo.add(c);
            }
        }
        return clientesByActivo;
    }

    public ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> getClientesbyMetodoPago(MetodoPago metodoPago) {
        ArrayList<iescamp.tienda.modelo.Usuarios.Cliente> clientesByMetodoPago = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getMetodoPago().equals(metodoPago)) {
                clientesByMetodoPago.add(c);
            }
        }
        return clientesByMetodoPago;
}
}
