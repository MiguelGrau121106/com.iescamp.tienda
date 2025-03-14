package iescamp.tienda.test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import iescamp.tienda.modelo.Usuarios.Cliente;
import iescamp.tienda.modelo.Usuarios.Empleado;
import iescamp.tienda.modelo.Usuarios.Departamento;
import iescamp.tienda.modelo.Usuarios.MetodoPago;
import iescamp.tienda.modelo.Articulos.Articulo;
import iescamp.tienda.modelo.Articulos.Material;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class fileUtil {

    // Empleados
    public static void guardarEmpleadosEnCsv(List<Empleado> empleados, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"DNI", "Nombre", "Apellidos", "Dirección", "Correo Electrónico", "Teléfono", "Fecha Nacimiento", "Contraseña", "Activo", "Privilegios", "Departamento"});
            for (Empleado e : empleados) {
                writer.writeNext(new String[]{
                        e.getDNI(), e.getNombre(), e.getApellidos(), e.getDireccion(), e.getCorreoElectronico(),
                        e.getTelefono(), e.getFechaNacimiento().toString(), e.getPass(),
                        String.valueOf(e.isActivo()), String.valueOf(e.isPrivilegio()),
                        e.getDepartamento().getNombre()
                });
            }
        }
    }

    public static List<Empleado> leerEmpleadosDesdeCsv(String filePath) throws IOException, CsvException {
        List<Empleado> empleados = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {
                Empleado empleado = new Empleado(
                        fila[0], fila[1], fila[2], fila[3], fila[4], fila[5],
                        LocalDate.parse(fila[6]), fila[7], Boolean.parseBoolean(fila[8]),
                        Boolean.parseBoolean(fila[9]), new Departamento(0, fila[10])
                );
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    // Clientes
    public static void guardarClientesEnCsv(List<Cliente> clientes, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"DNI", "Nombre", "Apellidos", "Dirección", "Correo Electrónico", "Teléfono", "Fecha Nacimiento", "Contraseña", "Activo", "Dirección Envío", "Saldo Cuenta", "Tarjeta Fidelidad", "Pedidos Realizados", "Código Método Pago", "Descripción Método Pago"});
            for (Cliente c : clientes) {
                writer.writeNext(new String[]{
                        c.getDNI(), c.getNombre(), c.getApellidos(), c.getDireccion(), c.getCorreoElectronico(),
                        c.getTelefono(), c.getFechaNacimiento().toString(), c.getPass(),
                        String.valueOf(c.isActivo()), c.getDireccionEnvio(), String.valueOf(c.getSaldoCuenta()),
                        String.valueOf(c.isTieneTarjetaFidelidad()), String.valueOf(c.getNumeroPedidosRealizados()),
                        String.valueOf(c.getMetodoPago().getCodigo()), c.getMetodoPago().getDescripcion()
                });
            }
        }
    }

    public static List<Cliente> leerClientesDesdeCsv(String filePath) throws IOException, CsvException {
        List<Cliente> clientes = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {
                Cliente cliente = new Cliente(
                        fila[0], fila[1], fila[2], fila[3], fila[4], fila[5],
                        LocalDate.parse(fila[6]), fila[7], Boolean.parseBoolean(fila[8]),
                        fila[9], Float.parseFloat(fila[10]), Boolean.parseBoolean(fila[11]),
                        Integer.parseInt(fila[12]), new MetodoPago(Integer.parseInt(fila[13]), fila[14])
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Articulos
    public static void guardarArticulosEnCsv(List<Articulo> articulos, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"Código", "Nombre", "Descripción", "Marca", "Precio", "Color", "Imagen", "Activo", "Código Material", "Denominación Material"});
            for (Articulo a : articulos) {
                writer.writeNext(new String[]{
                        String.valueOf(a.getCod_art()), a.getNombre(), a.getDescripcion(),
                        a.getMarca(), String.valueOf(a.getPrecio()), a.getColor(),
                        a.getImagen(), String.valueOf(a.isActivo()),
                        String.valueOf(a.getMaterial().getCodigo()), a.getMaterial().getDenominacion()
                });
            }
        }
    }

    public static List<Articulo> leerArticulosDesdeCsv(String filePath) throws IOException, CsvException {
        List<Articulo> articulos = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {
                Articulo articulo = new Articulo(
                        new Material(Integer.parseInt(fila[8]), fila[9]),
                        Integer.parseInt(fila[0]), Boolean.parseBoolean(fila[7]), fila[5],
                        fila[6], fila[1], Double.parseDouble(fila[4]), fila[3], fila[2]
                );
                articulos.add(articulo);
            }
        }
        return articulos;
    }
}
