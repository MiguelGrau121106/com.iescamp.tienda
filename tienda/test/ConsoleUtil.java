package iescamp.tienda.test;

import iescamp.tienda.modelo.Articulos.*;
import iescamp.tienda.modelo.Pedidos.LineaPedido;
import iescamp.tienda.modelo.Pedidos.Pedido;
import iescamp.tienda.modelo.Usuarios.Cliente;
import iescamp.tienda.modelo.Usuarios.Departamento;
import iescamp.tienda.modelo.Usuarios.Empleado;
import iescamp.tienda.modelo.Usuarios.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ConsoleUtil {
    public static Departamento crearDepartamento(){
        int id;
        String nombre;

        id = iescamp.tienda.test.ConsoleReader.readInt("Dime el código de departamento");
        nombre = iescamp.tienda.test.ConsoleReader.readString("Dime el nombre del departamento");


        return new Departamento(id, nombre);

    }

    public static Zapatos crearZapato(Material material) {
        System.out.println("Creando un Zapato...");
        int cod_art = iescamp.tienda.test.ConsoleReader.readInt("Código del artículo: ");
        String nombre = iescamp.tienda.test.ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(iescamp.tienda.test.ConsoleReader.readDouble("Precio: "));
        String marca = iescamp.tienda.test.ConsoleReader.readString("Marca: ");
        String descripcion = iescamp.tienda.test.ConsoleReader.readString("Descripción: ");
        String imagen = iescamp.tienda.test.ConsoleReader.readString("Imagen: ");
        String color = iescamp.tienda.test.ConsoleReader.readString("Color: ");
        String estilo = iescamp.tienda.test.ConsoleReader.readString("Estilo: ");
        boolean personalizado = iescamp.tienda.test.ConsoleReader.readBoolean("¿Es personalizado? ");
        String tipoSuela = iescamp.tienda.test.ConsoleReader.readString("Tipo de suela: ");
        int tallaZapato = iescamp.tienda.test.ConsoleReader.readInt("Talla del zapato: ");
        boolean activo = iescamp.tienda.test.ConsoleReader.readBoolean("¿Está activo el zapato?");

        return new Zapatos(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, estilo, personalizado, tallaZapato, tipoSuela);
    }

    public static Bolso crearBolso(Material material){
        System.out.println("Creando un Bolso...");
        int cod_art = iescamp.tienda.test.ConsoleReader.readInt("Código del artículo: ");
        String nombre = iescamp.tienda.test.ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(iescamp.tienda.test.ConsoleReader.readDouble("Precio: "));
        String marca = iescamp.tienda.test.ConsoleReader.readString("Marca: ");
        String descripcion = iescamp.tienda.test.ConsoleReader.readString("Descripción: ");
        String imagen = iescamp.tienda.test.ConsoleReader.readString("Imagen: ");
        String color = iescamp.tienda.test.ConsoleReader.readString("Color: ");
        String estilo = iescamp.tienda.test.ConsoleReader.readString("Estilo: ");
        boolean personalizado = iescamp.tienda.test.ConsoleReader.readBoolean("¿Es personalizado? ");
        String tipoCierre = iescamp.tienda.test.ConsoleReader.readString("Tipo de cierre: ");
        int capacidad = iescamp.tienda.test.ConsoleReader.readInt("Capacidad: ");
        boolean activo = iescamp.tienda.test.ConsoleReader.readBoolean("¿Está activo el bolso?");

        return new Bolso(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, estilo, personalizado, tipoCierre, capacidad);
    }

    public static Camisa crearCamisa(Material material){
        System.out.println("Creando una Camisa...");
        int cod_art = iescamp.tienda.test.ConsoleReader.readInt("Código del artículo: ");
        String nombre = iescamp.tienda.test.ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(iescamp.tienda.test.ConsoleReader.readDouble("Precio: "));
        String marca = iescamp.tienda.test.ConsoleReader.readString("Marca: ");
        String descripcion = iescamp.tienda.test.ConsoleReader.readString("Descripción: ");
        String imagen = iescamp.tienda.test.ConsoleReader.readString("Imagen: ");
        String color = iescamp.tienda.test.ConsoleReader.readString("Color: ");
        String estilo = iescamp.tienda.test.ConsoleReader.readString("Estilo: ");
        boolean personalizado = iescamp.tienda.test.ConsoleReader.readBoolean("¿Es personalizado? ");
        String talla = iescamp.tienda.test.ConsoleReader.readString("Talla: ");
        String tipoManga = iescamp.tienda.test.ConsoleReader.readString("Tipo de manga: ");
        boolean activo = iescamp.tienda.test.ConsoleReader.readBoolean("¿Está activa la camisa?");

        return new Camisa(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, estilo, tipoManga, talla, personalizado);
    }

    public static Pantalon crearPantalon(Material material){
        System.out.println("Creando un Pantalón...");
        int cod_art = iescamp.tienda.test.ConsoleReader.readInt("Código del artículo: ");
        String nombre = iescamp.tienda.test.ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(iescamp.tienda.test.ConsoleReader.readDouble("Precio: "));
        String marca = iescamp.tienda.test.ConsoleReader.readString("Marca: ");
        String descripcion = iescamp.tienda.test.ConsoleReader.readString("Descripción: ");
        String imagen = iescamp.tienda.test.ConsoleReader.readString("Imagen: ");
        String color = iescamp.tienda.test.ConsoleReader.readString("Color: ");
        String estilo = iescamp.tienda.test.ConsoleReader.readString("Estilo: ");
        boolean personalizado = iescamp.tienda.test.ConsoleReader.readBoolean("¿Es personalizado? ");
        String talla = iescamp.tienda.test.ConsoleReader.readString("Talla: ");
        String tipoPantalon = iescamp.tienda.test.ConsoleReader.readString("Tipo de pantalón: ");
        boolean activo = iescamp.tienda.test.ConsoleReader.readBoolean("¿Está activo el pantalón?");

        return new Pantalon(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, estilo, talla, personalizado, tipoPantalon);
    }

    public static Chaqueta crearChaqueta(Material material){
        System.out.println("Creando una Chaqueta...");
        int cod_art = iescamp.tienda.test.ConsoleReader.readInt("Código del artículo: ");
        String nombre = iescamp.tienda.test.ConsoleReader.readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(iescamp.tienda.test.ConsoleReader.readDouble("Precio: "));
        String marca = iescamp.tienda.test.ConsoleReader.readString("Marca: ");
        String descripcion = iescamp.tienda.test.ConsoleReader.readString("Descripción: ");
        String imagen = iescamp.tienda.test.ConsoleReader.readString("Imagen: ");
        String color = iescamp.tienda.test.ConsoleReader.readString("Color: ");
        String talla = iescamp.tienda.test.ConsoleReader.readString("Talla: ");
        String tipoCierre = iescamp.tienda.test.ConsoleReader.readString("Tipo de cierre: ");
        boolean impermeable = iescamp.tienda.test.ConsoleReader.readBoolean("¿Es impermeable? ");
        boolean activo = iescamp.tienda.test.ConsoleReader.readBoolean("¿Está activa la chaqueta?");

        return new Chaqueta(material, cod_art, activo, color, imagen, nombre, precio.doubleValue(), marca, descripcion, talla, tipoCierre, impermeable);
    }

    public static MetodoPago crearMetodoPago(){
        int id;
        String nombre;

        id = iescamp.tienda.test.ConsoleReader.readInt("Dime el código del método de pago");
        nombre = iescamp.tienda.test.ConsoleReader.readString("Dime el nombre del método de pago");


        return new MetodoPago(id, nombre);
    }

    public static Cliente crearCliente(MetodoPago metodoPago){
        System.out.println("Creando un Cliente...");
        String DNI = iescamp.tienda.test.ConsoleReader.readString("Dime el DNI del cliente");
        String nombre = iescamp.tienda.test.ConsoleReader.readString("Dime el nombre del cliente");
        String apellidos = iescamp.tienda.test.ConsoleReader.readString("Dime los apellidos del cliente");
        String correoElectronico = iescamp.tienda.test.ConsoleReader.readString("Dime el email del cliente");
        String direccion = iescamp.tienda.test.ConsoleReader.readString("Dime la dirección del cliente");
        String telefono = iescamp.tienda.test.ConsoleReader.readString("Dime el teléfono del cliente");
        String direccionEnvio = iescamp.tienda.test.ConsoleReader.readString("Dime la dirección de envío del cliente");
        LocalDate fechaNacimiento = LocalDate.of(iescamp.tienda.test.ConsoleReader.readInt("Dime el año de nacimiento del Cliente"), iescamp.tienda.test.ConsoleReader.readInt("Dime el mes de nacimiento del cliente"), iescamp.tienda.test.ConsoleReader.readInt("Dime el día de nacimiento del cliente"));
        String pass = iescamp.tienda.test.ConsoleReader.readString("Dime la contraseña del cliente");
        boolean activo = iescamp.tienda.test.ConsoleReader.readBoolean("¿Está activo el cliente?");
        float saldoCuenta = iescamp.tienda.test.ConsoleReader.readFloat("Dime el saldo de la cuenta del cliente");
        int numeroPedidosRealizados = iescamp.tienda.test.ConsoleReader.readInt("Dime el número de pedidos realizados por el cliente");
        boolean tieneTarjetaFidelidad = iescamp.tienda.test.ConsoleReader.readBoolean("¿Tiene tarjeta de fidelidad el cliente?");

        return new Cliente(DNI, nombre, apellidos, direccion, correoElectronico, telefono, fechaNacimiento, pass, activo, direccionEnvio, saldoCuenta, tieneTarjetaFidelidad, numeroPedidosRealizados, metodoPago);
    }

    public static LineaPedido crearLineaPedido(Articulo articulo, Pedido pedido){
        System.out.println("Creando una linea de pedido...");

        return new LineaPedido(articulo, pedido);
    }

    public static Material crearMaterial(){
        System.out.println("Creando un Material...");
        int codigo = iescamp.tienda.test.ConsoleReader.readInt("Dime el código del material");
        String denominacion = iescamp.tienda.test.ConsoleReader.readString("Dime el nombre del material");

        return new Material(codigo, denominacion);
    }

    public static Empleado crearEmpleado(Departamento departamento){
        System.out.println("Creando un Empleado...");
        String DNI = iescamp.tienda.test.ConsoleReader.readString("Dime el DNI del empleado");
        String nombre = iescamp.tienda.test.ConsoleReader.readString("Dime el nombre del empleado");
        String apellidos = iescamp.tienda.test.ConsoleReader.readString("Dime los apellidos del empleado");
        String correoElectronico = iescamp.tienda.test.ConsoleReader.readString("Dime el email del empleado");
        String direccion = iescamp.tienda.test.ConsoleReader.readString("Dime la dirección del empleado");
        String telefono = iescamp.tienda.test.ConsoleReader.readString("Dime el teléfono del empleado");
        LocalDate fechaNacimiento = LocalDate.of(iescamp.tienda.test.ConsoleReader.readInt("Dime el año de nacimiento del empleado"), iescamp.tienda.test.ConsoleReader.readInt("Dime el mes de nacimiento del empleado"), iescamp.tienda.test.ConsoleReader.readInt("Dime el día de nacimiento del empleado"));
        String pass = iescamp.tienda.test.ConsoleReader.readString("Dime la contraseña del empleado");
        boolean activo = iescamp.tienda.test.ConsoleReader.readBoolean("¿Está activo el empleado?");
        boolean privilegios = ConsoleReader.readBoolean("¿Tiene privilegios el empleado?");

        return new Empleado(DNI, nombre, apellidos, correoElectronico, direccion, telefono, fechaNacimiento, pass, activo, privilegios, departamento);
}


}
