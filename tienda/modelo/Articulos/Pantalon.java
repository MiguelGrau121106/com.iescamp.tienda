package iescamp.tienda.modelo.Articulos;

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

    public Pantalon(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, String talla, String tipoCierre, Boolean tieneBolsillos, String tipoPantalon) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, talla, tipoCierre, TipoRopa.PANTALON);
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
