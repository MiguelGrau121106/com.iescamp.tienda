package iescamp.tienda.test;

import iescamp.tienda.modelo.Articulos.*;
import iescamp.tienda.modelo.Pedidos.LineaPedido;
import iescamp.tienda.modelo.Pedidos.Pedido;
import iescamp.tienda.modelo.Usuarios.*;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ConsoleUtil {
    public static Departamento crearDepartamento(){
        int id;
        String nombre;

        id = ConsoleReader.readInt("Dime el código de departamento");
        nombre = ConsoleReader.readString("Dime el nombre del departamento");


        return new Departamento(id, nombre);

    }

    public static Zapatos crearZapato(Material material) {
        System.out.println("Creando un Zapato...");
        int cod_art = ConsoleReader.readInt("Código del artículo: ");
        String nombre = ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(ConsoleReader.readDouble("Precio: "));
        String marca = ConsoleReader.readString("Marca: ");
        String descripcion = ConsoleReader.readString("Descripción: ");
        String imagen = ConsoleReader.readString("Imagen: ");
        String color = ConsoleReader.readString("Color: ");
        String estilo = ConsoleReader.readString("Estilo: ");
        boolean personalizado = ConsoleReader.readBoolean("¿Es personalizado? ");
        String tipoSuela = ConsoleReader.readString("Tipo de suela: ");
        int tallaZapato = ConsoleReader.readInt("Talla del zapato: ");
        boolean activo = ConsoleReader.readBoolean("¿Está activo el zapato?");

        return new Zapatos(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, estilo, personalizado, tallaZapato, tipoSuela);
    }

    public static Bolso crearBolso(Material material){
        System.out.println("Creando un Bolso...");
        int cod_art = ConsoleReader.readInt("Código del artículo: ");
        String nombre = ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(ConsoleReader.readDouble("Precio: "));
        String marca = ConsoleReader.readString("Marca: ");
        String descripcion = ConsoleReader.readString("Descripción: ");
        String imagen = ConsoleReader.readString("Imagen: ");
        String color = ConsoleReader.readString("Color: ");
        String estilo = ConsoleReader.readString("Estilo: ");
        boolean personalizado = ConsoleReader.readBoolean("¿Es personalizado? ");
        String tipoCierre = ConsoleReader.readString("Tipo de cierre: ");
        int capacidad = ConsoleReader.readInt("Capacidad: ");
        boolean activo = ConsoleReader.readBoolean("¿Está activo el bolso?");

        return new Bolso(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, estilo, personalizado, tipoCierre, capacidad);
    }

    public static Camisa crearCamisa(Material material){
        System.out.println("Creando una Camisa...");
        int cod_art = ConsoleReader.readInt("Código del artículo: ");
        String nombre = ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(ConsoleReader.readDouble("Precio: "));
        String marca = ConsoleReader.readString("Marca: ");
        String descripcion = ConsoleReader.readString("Descripción: ");
        String imagen = ConsoleReader.readString("Imagen: ");
        String color = ConsoleReader.readString("Color: ");
        String estilo = ConsoleReader.readString("Estilo: ");
        boolean personalizado = ConsoleReader.readBoolean("¿Es personalizado? ");
        String talla = ConsoleReader.readString("Talla: ");
        String tipoManga = ConsoleReader.readString("Tipo de manga: ");
        boolean activo = ConsoleReader.readBoolean("¿Está activa la camisa?");

        return new Camisa(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, estilo, tipoManga, talla, personalizado);
    }

    public static Pantalon crearPantalon(Material material){
        System.out.println("Creando un Pantalón...");
        int cod_art = ConsoleReader.readInt("Código del artículo: ");
        String nombre = ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(ConsoleReader.readDouble("Precio: "));
        String marca = ConsoleReader.readString("Marca: ");
        String descripcion = ConsoleReader.readString("Descripción: ");
        String imagen = ConsoleReader.readString("Imagen: ");
        String color = ConsoleReader.readString("Color: ");
        String estilo = ConsoleReader.readString("Estilo: ");
        boolean personalizado = ConsoleReader.readBoolean("¿Es personalizado? ");
        String talla = ConsoleReader.readString("Talla: ");
        String tipoPantalon = ConsoleReader.readString("Tipo de pantalón: ");
        boolean activo = ConsoleReader.readBoolean("¿Está activo el pantalón?");

        return new Pantalon(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, estilo, talla, personalizado, tipoPantalon);
    }

    public static Chaqueta crearChaqueta(Material material){
        System.out.println("Creando una Chaqueta...");
        int cod_art = ConsoleReader.readInt("Código del artículo: ");
        String nombre = ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(ConsoleReader.readDouble("Precio: "));
        String marca = ConsoleReader.readString("Marca: ");
        String descripcion = ConsoleReader.readString("Descripción: ");
        String imagen = ConsoleReader.readString("Imagen: ");
        String color = ConsoleReader.readString("Color: ");
        String talla = ConsoleReader.readString("Talla: ");
        String tipoCierre = ConsoleReader.readString("Tipo de cierre: ");
        boolean impermeable = ConsoleReader.readBoolean("¿Es impermeable? ");
        boolean activo = ConsoleReader.readBoolean("¿Está activa la chaqueta?");

        return new Chaqueta(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, talla, tipoCierre, impermeable);
    }

    public static MetodoPago crearMetodoPago(){
        int id;
        String nombre;

        id = ConsoleReader.readInt("Dime el código del método de pago");
        nombre = ConsoleReader.readString("Dime el nombre del método de pago");


        return new MetodoPago(id, nombre);
    }

    public static Cliente crearCliente(MetodoPago metodoPago){
        System.out.println("Creando un Cliente...");
        String DNI = ConsoleReader.readString("Dime el DNI del cliente");
        String nombre = ConsoleReader.readString("Dime el nombre del cliente");
        String apellidos = ConsoleReader.readString("Dime los apellidos del cliente");
        String correoElectronico = ConsoleReader.readString("Dime el email del cliente");
        String direccion = ConsoleReader.readString("Dime la dirección del cliente");
        String telefono = ConsoleReader.readString("Dime el teléfono del cliente");
        String direccionEnvio = ConsoleReader.readString("Dime la dirección de envío del cliente");
        LocalDate fechaNacimiento = LocalDate.of(ConsoleReader.readInt("Dime el año de nacimiento del Cliente"), ConsoleReader.readInt("Dime el mes de nacimiento del cliente"), ConsoleReader.readInt("Dime el día de nacimiento del cliente"));
        String pass = ConsoleReader.readString("Dime la contraseña del cliente");
        boolean activo = ConsoleReader.readBoolean("¿Está activo el cliente?");
        float saldoCuenta = ConsoleReader.readFloat("Dime el saldo de la cuenta del cliente");
        int numeroPedidosRealizados = ConsoleReader.readInt("Dime el número de pedidos realizados por el cliente");
        boolean tieneTarjetaFidelidad = ConsoleReader.readBoolean("¿Tiene tarjeta de fidelidad el cliente?");

        return new Cliente(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fechaNacimiento, pass, activo, direccionEnvio, saldoCuenta, tieneTarjetaFidelidad, numeroPedidosRealizados, metodoPago);
    }

    public static LineaPedido crearLineaPedido(Articulo articulo, Pedido pedido){
        System.out.println("Creando una linea de pedido...");

        return new LineaPedido(articulo, pedido);
    }

    public static Material crearMaterial(){
        System.out.println("Creando un Material...");
        int codigo = ConsoleReader.readInt("Dime el código del material");
        String denominacion = ConsoleReader.readString("Dime el nombre del material");

        return new Material(codigo, denominacion);
    }

    public static Empleado crearEmpleado(Departamento departamento){
        System.out.println("Creando un Empleado...");
        String DNI = ConsoleReader.readString("Dime el DNI del empleado");
        String nombre = ConsoleReader.readString("Dime el nombre del empleado");
        String apellidos = ConsoleReader.readString("Dime los apellidos del empleado");
        String correoElectronico = ConsoleReader.readString("Dime el email del empleado");
        String direccion = ConsoleReader.readString("Dime la dirección del empleado");
        String telefono = ConsoleReader.readString("Dime el teléfono del empleado");
        LocalDate fechaNacimiento = LocalDate.of(ConsoleReader.readInt("Dime el año de nacimiento del empleado"), ConsoleReader.readInt("Dime el mes de nacimiento del empleado"), ConsoleReader.readInt("Dime el día de nacimiento del empleado"));
        String pass = ConsoleReader.readString("Dime la contraseña del empleado");
        boolean activo = ConsoleReader.readBoolean("¿Está activo el empleado?");
        boolean privilegios = ConsoleReader.readBoolean("¿Tiene privilegios el empleado?");

        return new Empleado(DNI, nombre, apellidos, correoElectronico, direccion, telefono, fechaNacimiento, pass, activo, privilegios, departamento);
}


}
