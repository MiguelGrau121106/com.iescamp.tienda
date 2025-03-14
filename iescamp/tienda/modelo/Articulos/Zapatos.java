package iescamp.tienda.modelo.Articulos;

import java.util.Objects;

public class Zapatos extends Accesorio {
    private int tallaZapatos;
    private String tipoSuela;
    //GETTER Y SETTER

    public int getTallaZapatos() {
        return tallaZapatos;
    }

    public void setTallaZapatos(int tallaZapatos) {
        this.tallaZapatos = tallaZapatos;
    }

    public String getTipoSuela() {
        return tipoSuela;
    }

    public void setTipoSuela(String tipoSuela) {
        this.tipoSuela = tipoSuela;
    }
    //CONSTRUCTOR

    public Zapatos(Material material, int cod_art, boolean activo, String color, String imagen, String nombre, double precio, String marca, String descripcion, String estilo, Boolean esPersonalizado, int tallaZapatos, String tipoSuela) {
        super(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, estilo, esPersonalizado, TipoAccesorio.ZAPATOS);
        this.tallaZapatos = tallaZapatos;
        this.tipoSuela = tipoSuela;
    }


    //TOSTRING

    @Override
    public String toString() {
        return "Zapatos{" +
                "tallaZapatos=" + tallaZapatos +
                ", tipoSuela='" + tipoSuela + '\'' +
                '}';
    }
    public String MostrarDetalles() {
        return super.toString() + "Zapatos{" +
                "tallaZapatos=" + tallaZapatos +
                ", tipoSuela='" + tipoSuela + '\'' +
                '}';
    }
    //EQUALS Y HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Zapatos zapatos = (Zapatos) o;
        return tallaZapatos == zapatos.tallaZapatos && Objects.equals(tipoSuela, zapatos.tipoSuela);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tallaZapatos, tipoSuela);
    }
}
