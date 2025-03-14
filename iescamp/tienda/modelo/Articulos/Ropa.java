package iescamp.tienda.modelo.Articulos;

import java.util.Objects;



   
    
    //Getter y Setter

public class Ropa extends Articulo {
    private String talla;
    private String tipoCierre;
    private TipoRopa tipoRopa;

    public TipoRopa getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(TipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }


    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    public Ropa(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, String talla, String tipoCierre, TipoRopa tipoRopa) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion);
        this.talla = talla;
        this.tipoCierre = tipoCierre;
        this.tipoRopa = tipoRopa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Ropa ropa = (Ropa) o;
        return talla == ropa.talla && Objects.equals(tipoCierre, ropa.tipoCierre) && tipoRopa == ropa.tipoRopa;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(talla);
        result = 31 * result + Objects.hashCode(tipoCierre);
        result = 31 * result + Objects.hashCode(tipoRopa);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Ropa{" +
                "talla=" + talla +
                ", tipoCierre='" + tipoCierre + '\'' +
                ", tipoRopa=" + tipoRopa +
                '}';
    }
}
