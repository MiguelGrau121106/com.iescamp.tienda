package com.iescamp.tienda.test;

import com.iescamp.tienda.modelo.Cliente;
import com.iescamp.tienda.modelo.Empleado;
import com.iescamp.tienda.modelo.Usuario;

import java.time.LocalDate;

public class TestUtil {



    public static Cliente crearCliente() {
        System.out.println("Introduce los datos del cliente:");

        // Crear un objeto Cliente directamente
        System.out.print("DNI: ");
        String DNI = ConsoleReader.readString();

        System.out.print("Nombre: ");
        String nombre = ConsoleReader.readString();

        System.out.print("Apellidos: ");
        String apellidos = ConsoleReader.readString();

        System.out.print("Dirección: ");
        String direccion = ConsoleReader.readString();

        System.out.print("Correo electrónico: ");
        String correoElectronico = ConsoleReader.readString();

        System.out.print("Teléfono: ");
        String telefono = ConsoleReader.readString();

        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
        String fechaStr = ConsoleReader.readString();
        LocalDate fecha = LocalDate.parse(fechaStr);

        System.out.print("Contraseña: ");
        String pass = ConsoleReader.readString();

        System.out.print("¿Está activo? (true/false): ");
        boolean activo = ConsoleReader.readBoolean();

        System.out.print("Dirección de envío: ");
        String direccionEnvio = ConsoleReader.readString();

        System.out.print("Saldo de la cuenta: ");
        float saldoCuenta = ConsoleReader.readFloat();

        System.out.print("¿Tiene tarjeta de fidelidad? (true/false): ");
        boolean fidelidad = ConsoleReader.readBoolean();

        System.out.print("Número de pedidos realizados: ");
        int pedidos = ConsoleReader.readInt();

        // Crear y devolver el objeto Cliente
        return new Cliente(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fecha, pass, activo, direccionEnvio, saldoCuenta, fidelidad, pedidos);
    }

    public static Empleado crearEmpleado(){
        System.out.println("Introduce los datos del empleado:");

        System.out.print("DNI: ");
        String DNI = ConsoleReader.readString();

        System.out.print("Nombre: ");
        String nombre = ConsoleReader.readString();

        System.out.print("Apellidos: ");
        String apellidos = ConsoleReader.readString();

        System.out.print("Dirección: ");
        String direccion = ConsoleReader.readString();

        System.out.print("Correo electrónico: ");
        String correoElectronico = ConsoleReader.readString();

        System.out.print("Teléfono: ");
        String telefono = ConsoleReader.readString();

        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
        String fechaStr = ConsoleReader.readString();
        LocalDate fecha = LocalDate.parse(fechaStr);

        System.out.print("Contraseña: ");
        String pass = ConsoleReader.readString();

        System.out.print("¿Está activo? (true/false): ");
        boolean activo = ConsoleReader.readBoolean();

        System.out.println("tiene privilegios? (true/false): ");
        boolean privilegios = ConsoleReader.readBoolean();

        return new Empleado(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fecha, pass, activo, privilegios);
    }
}
