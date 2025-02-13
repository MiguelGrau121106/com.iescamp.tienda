package com.iescamp.GestionEmpleados;

public class Empresa {

    public static void main(String[] args) {
        ProyectoSoftware proyecto1 = new ProyectoSoftware("Proyecto 1", 1000, "Java", ProyectoSoftware.Dificultad.BAJA);
        ProyectoSistemas proyecto2 = new ProyectoSistemas("Proyecto 2", 2000, "Windows", ProyectoSistemas.Dificultad.MEDIA);
        Proyecto proyecto3 = new Proyecto("Proyecto 3", 3000);
        Gerente gerente = new Gerente("Juan", 30, 3000);


        gerente.asignarProyecto(proyecto1);
        gerente.asignarProyecto(proyecto2);
        gerente.asignarProyecto(proyecto3);
        gerente.mostrarProyectos();
    }
}