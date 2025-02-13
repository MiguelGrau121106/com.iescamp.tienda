package com.iescamp.GestionEmpleados;

public class ProyectoSoftware extends Proyecto {
    private String lenguaje_de_programacion;
    public enum Dificultad {BAJA, MEDIA, ALTA};
    private Dificultad dificultad;

    public ProyectoSoftware(String nombreProyecto, double presupuesto, String lenguaje_de_programacion, Dificultad dificultad) {
        super(nombreProyecto, presupuesto);
        this.lenguaje_de_programacion = lenguaje_de_programacion;
        this.dificultad = dificultad;
    }

    public String getLenguaje_de_programacion() {
        return lenguaje_de_programacion;
    }

    public void setLenguaje_de_programacion(String lenguaje_de_programacion) {
        this.lenguaje_de_programacion = lenguaje_de_programacion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public void mostrarDetallesSoftware(){
        System.out.println(super.toString());
        System.out.println("Lenguaje de programación: " + lenguaje_de_programacion);
        System.out.println("Dificultad: " + getDificultad().toString());
    }
}
