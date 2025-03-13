package iescamp.tienda.test;

import iescamp.tienda.modelo.Articulos.Camisa;
import iescamp.tienda.modelo.Articulos.Catalogo;
import iescamp.tienda.modelo.Articulos.Material;
import iescamp.tienda.modelo.Pedidos.Ventas;

import iescamp.tienda.modelo.Usuarios.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TiendaConsola {
    static Ventas ventas = new Ventas();
    static Catalogo catalogo = new Catalogo();
    static Clientela clientela = new Clientela();
    static Plantilla plantilla = new Plantilla();
    static ArrayList<Departamento> departamentos = new ArrayList<>();
    static ArrayList<Material> materiales = new ArrayList<>();
    static ArrayList<MetodoPago> metodosPago = new ArrayList<>();




    public static void main(String[] args) {

        catalogo.addArticulo(ConsoleUtil.crearCamisa(ConsoleUtil.crearMaterial()));

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Serializar Persona");
            System.out.println("2. Deserializar Persona");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = ConsoleReader.readInt();

            switch (opcion) {
                case 1:
                    serializarCatalogo();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Saliendo...");

                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }

        //mostrarMenu();




    }



    private static void mostrarMenu() {
        System.out.println("Menu" + "\n");
        System.out.println("1. Plantilla");
        System.out.println("2. Clientela");
        System.out.println("3. Catalogo");
        System.out.println("4. Ventas");
        System.out.println("5. Salir");

        System.out.println("Introduce una opcion: ");
        int opcion = ConsoleReader.readInt();

        switch (opcion) {
            case 1:
                menuPlantilla();
                break;
            case 2:
                menuClientela();
                break;
            case 3:
                menuCatalogo();
                break;
            case 4:

                break;
            case 5:
                System.out.println("Hasta luego");
                break;
            default:
                System.out.println("Opcion no valida");
                mostrarMenu();
        }
    }

    private static void menuPlantilla() {
        System.out.println("Menu Plantilla" + "\n");
        System.out.println("1. Listar empleados");
        System.out.println("2. Añadir empleado");

        System.out.println("3. Volver al menu principal");
        System.out.println("Introduce una opcion: ");

        int opcion = ConsoleReader.readInt();

        switch (opcion) {
            case 1:
                if (plantilla.getEmpleados().isEmpty()) {
                    System.out.println("No hay empleados todavía");
                    menuPlantilla();
                }
                plantilla.listarEmpleados();
                break;
            case 2:

                System.out.println("1. Crear departamento tambien \n2. Añadir a un departamento ya existente");
                opcion = ConsoleReader.readInt();
                if (opcion == 1) {
                    Departamento departamento = ConsoleUtil.crearDepartamento();
                    departamentos.add(departamento);
                    plantilla.addEmpleado(ConsoleUtil.crearEmpleado(departamento));
                    menuPlantilla();
                } else if (opcion == 2) {
                    if (departamentos.isEmpty()) {
                        System.out.println("No hay departamentos todavía");
                        menuPlantilla();
                    }
                    int codigoDepartamento = ConsoleReader.readInt("Introduce el codigo del departamento");
                    for (Departamento departamento : departamentos) {
                        if (departamento.getCodigo() == codigoDepartamento) {
                            plantilla.addEmpleado(ConsoleUtil.crearEmpleado(departamento));
                            menuPlantilla();
                        }
                    }

                }



                break;

            case 3:
                mostrarMenu();
                break;
            default:
                System.out.println("Opcion no valida");
                menuPlantilla();
        }

    }


    private static void menuClientela() {
        System.out.println("Menu Clientela" + "\n");
        System.out.println("1. Listar clientes");
        System.out.println("2. Añadir cliente");
        System.out.println("3. Volver al menu principal");
        System.out.println("Introduce una opcion: ");
        int opcion = ConsoleReader.readInt();
        switch (opcion) {
            case 1:
                if (clientela.getClientes().isEmpty()) {
                    System.out.println("No hay clientes todavía");
                    menuClientela();
                }
                clientela.listarClientes();
                break;
            case 2:

                System.out.println("1. Crear metodo de pago tambien \n2. Añadir a un metodo de pago ya existente");
                opcion = ConsoleReader.readInt();
                if (opcion == 1) {
                    MetodoPago metodoPago = ConsoleUtil.crearMetodoPago();
                    metodosPago.add(metodoPago);
                    clientela.addCliente(ConsoleUtil.crearCliente(metodoPago));
                } else if (opcion == 2) {
                    if (metodosPago.isEmpty()) {
                        System.out.println("No hay metodos de pago todavía");
                        menuClientela();
                    }
                    int codigoMetodoPago = ConsoleReader.readInt("Introduce el id del metodo de pago");
                    for (MetodoPago metodoPago : metodosPago) {
                        if (metodoPago.getCodigo() == codigoMetodoPago) {
                            clientela.addCliente(ConsoleUtil.crearCliente(metodoPago));
                            menuClientela();
                        }
                    }

                }
                clientela.addCliente(ConsoleUtil.crearCliente(ConsoleUtil.crearMetodoPago()));
                    menuClientela();

                break;
            case 3:
                mostrarMenu();
                break;
            default:
                System.out.println("Opcion no valida");
                menuClientela();
        }
    }


    private static void menuCatalogo() {
        System.out.println("Menu Catalogo" + "\n");
        System.out.println("1. Listar articulos");
        System.out.println("2. Añadir articulo");
        System.out.println("3. Volver al menu principal");
        System.out.println("Introduce una opcion: ");
        int opcion = ConsoleReader.readInt();
        switch (opcion) {
            case 1:
                System.out.println(catalogo.ListarArticulos());
                break;
            case 2:
                int opcion_tipo = ConsoleReader.readInt("Introduce el tipo de articulo: \n1. Camisa \n2. Chaqueta \n3. Pantalon \n4. Zapato \n5. Bolso \n6. Salir"   );
                switch(opcion_tipo) {
                    case 1:
                        CrearCamisa();
                        break;
                    case 2:
                        CrearChaqueta();
                        break;
                    case 3:
                        CrearPantalon();
                        break;
                    case 4:
                        CrearZapato();
                        break;
                    case 5:
                        CrearBolso();
                        break;
                        case 6:
                        menuCatalogo();
                }

            case 3:
                mostrarMenu();
                break;
            default:
                System.out.println("Opcion no valida");
                menuCatalogo();
        }
    }

    private static void CrearCamisa(){
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearCamisa(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearCamisa(material));
                    menuCatalogo();
                }
            }
        }


    }


    private static void CrearChaqueta(){
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearChaqueta(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearChaqueta(material));
                    menuCatalogo();
                }
            }
        }


    }

    private static void CrearPantalon(){
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearPantalon(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearPantalon(material));
                    menuCatalogo();
                }
            }
        }


    }

    private static void CrearZapato(){
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearZapato(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearZapato(material));
                    menuCatalogo();
                }
            }
        }


    }


    private static void CrearBolso(){
        int opcion_CrearMaterial = ConsoleReader.readInt("1.Crear el material tambien \n2.Añadir material existente");

        if (opcion_CrearMaterial == 1) {
            Material material = ConsoleUtil.crearMaterial();
            materiales.add(material);
            catalogo.addArticulo(ConsoleUtil.crearBolso(material));
            menuCatalogo();
        } else if (opcion_CrearMaterial == 2) {
            if (materiales.isEmpty()) {
                System.out.println("No hay materiales todavía");
                menuCatalogo();
            }
            int codigoMaterial = ConsoleReader.readInt("Introduce el codigo del material");
            for (Material material : materiales) {
                if (material.getCodigo() == codigoMaterial) {
                    catalogo.addArticulo(ConsoleUtil.crearBolso(material));
                    menuCatalogo();
                }
            }
        }


    }


    public static void serializarCatalogo() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream("prueba.dat"))) {
            oos.writeObject(catalogo);
            System.out.println("Objeto serializado");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
