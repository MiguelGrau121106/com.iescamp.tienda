package iescamp.tienda.modelo;

public class Pantalon extends Ropa{
    private Boolean tieneBolsillos;
    private String tipoPantalon;

    //GETTER Y SETTERS

    public Boolean getTieneBolsillos() {
        return tieneBolsillos;
    }

    public void setTieneBolsillos(Boolean tieneBolsillos) {
        this.tieneBolsillos = tieneBolsillos;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }
    //CONSTRUCTOR

    public Pantalon(int talla, String color, String tipoCierre, Boolean tieneBolsillos, String tipoPantalon) {
        super(talla, color, tipoCierre);
        this.tieneBolsillos = tieneBolsillos;
        this.tipoPantalon = tipoPantalon;
    }
    //MOSTRARDETALLES

    @Override
    public String toString() {
        return "Pantalon{" +
                "tieneBolsillos=" + tieneBolsillos +
                ", tipoPantalon='" + tipoPantalon + '\'' +
                '}';
    }

    public String MostrarDetalles() {
        return super.toString() + "Pantalon{" +
                "tieneBolsillos=" + tieneBolsillos +
                ", tipoPantalon='" + tipoPantalon + '\'' +
                '}';
    }
}
