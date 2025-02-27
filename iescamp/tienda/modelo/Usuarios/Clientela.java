package iescamp.tienda.modelo.Usuarios;

import java.util.ArrayList;
import java.util.Optional;

public class Clientela {
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
}