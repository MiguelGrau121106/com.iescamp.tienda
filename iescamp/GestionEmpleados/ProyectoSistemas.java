package com.iescamp.GestionEmpleados;

public class ProyectoSistemas extends Proyecto{

    private String sistemaoperativo;
    public enum Dificultad {BAJA, MEDIA, ALTA};
    private Dificultad dificultad;

    public ProyectoSistemas(String nombreProyecto, double presupuesto, String sistemaoperativo, Dificultad dificultad) {
        super(nombreProyecto, presupuesto);
        this.sistemaoperativo = sistemaoperativo;
        this.dificultad = dificultad;
    }

    public String getSistemaoperativo() {
        return sistemaoperativo;
    }

    public void setSistemaoperativo(String sistemaoperativo) {
        this.sistemaoperativo = sistemaoperativo;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public void mostrarDetallesSistemas(){
        System.out.println(super.toString());
        System.out.println("Sistema operativo: " + sistemaoperativo);
        System.out.println("Dificultad: " + getDificultad().toString());
    }
}
