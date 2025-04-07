package iescamp.tienda.modelo.Articulos;


import java.io.Serializable;
import java.util.ArrayList;

public class Catalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<Articulo> articulos = new ArrayList<>();

    // Create
    public void addArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    // Read
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public String ListarArticulos() {
        String lista = "";
        for (Articulo articulo : articulos) {
            lista += articulo.toString() + "\n";
        }
        return lista;
    }

    // Update
    public void updateArticulo(Articulo articulo) {
       for (Articulo existingArticulo : articulos) {
              if (existingArticulo.getCod_art() == articulo.getCod_art()) {
                existingArticulo.setMaterial(articulo.getMaterial());
                existingArticulo.setCod_art(articulo.getCod_art());
                existingArticulo.setActivo(articulo.isActivo());
                existingArticulo.setImagen(articulo.getImagen());
                existingArticulo.setNombre(articulo.getNombre());
                existingArticulo.setPrecio(articulo.getPrecio());
                existingArticulo.setMarca(articulo.getMarca());
                existingArticulo.setDescripcion(articulo.getDescripcion());
              }
       }
    }

    // Delete
    public void removeArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }

    public ArrayList<Articulo> getArticulosByColor(String color) {
        ArrayList<Articulo> articulosByColor = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getColor().equals(color)) {
                articulosByColor.add(articulo);
            }
        }
        return articulosByColor;
    }
    public ArrayList<Articulo> getArticulosByMarca(String marca) {
        ArrayList<Articulo> articulosByMarca = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getMarca().equals(marca)) {
                articulosByMarca.add(articulo);
            }
        }
        return articulosByMarca;
    }

    public ArrayList<Articulo> getArticulosByMaterial(String material) {
        ArrayList<Articulo> articulosByMaterial = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getMaterial().equals(material)) {
                articulosByMaterial.add(articulo);
            }
        }
        return articulosByMaterial;
    }

    public ArrayList<Articulo> getArticulosByPrecio(double min, double max) {
        ArrayList<Articulo> articulosByPrecio = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getPrecio() >= min && articulo.getPrecio() <= max) {
                articulosByPrecio.add(articulo);
            }
        }
        return articulosByPrecio;
    }

    public Articulo getArticulosByCod_art(int cod_art) {
        for (Articulo articulo : articulos) {
            if (articulo.getCod_art() == cod_art) {
                return articulo;
            }
        }
        return null;
    }
    public ArrayList<Articulo> getArticulosByActivo(boolean activo) {
        ArrayList<Articulo> articulosByActivo = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.isActivo() == activo) {
                articulosByActivo.add(articulo);
            }
        }
        return articulosByActivo;
    }

    public ArrayList<Ropa> getArticulosByTalla(String talla) {
        ArrayList<Ropa> articulosByTalla = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof Ropa) {
                Ropa ropa = (Ropa) articulo;
                if (ropa.getTalla().equals(talla) ) {
                    articulosByTalla.add(ropa);
                }
            }

        }
        return articulosByTalla;
    }

    public ArrayList<Ropa> getArticulosByTipoCierre(String tipoCierre) {
        ArrayList<Ropa> articulosByTipoCierre = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof Ropa) {
                Ropa ropa = (Ropa) articulo;
                if (ropa.getTipoCierre().equals(tipoCierre)) {
                    articulosByTipoCierre.add(ropa);
                }
            }

        }
        return articulosByTipoCierre;
    }

    public ArrayList<Chaqueta> getChaquetaByImpermeable(boolean impermeable) {
        ArrayList<Chaqueta> chaquetasByImpermeable = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof Chaqueta) {
                Chaqueta chaqueta = (Chaqueta) articulo;
                if (chaqueta.getImpermeable() == impermeable) {
                    chaquetasByImpermeable.add(chaqueta);
                }
            }

        }
        return chaquetasByImpermeable;
    }

    public ArrayList<iescamp.tienda.modelo.Articulos.Camisa> getCamisaByTipoManga(String tipoManga) {
        ArrayList<iescamp.tienda.modelo.Articulos.Camisa> camisasByTipoManga = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof iescamp.tienda.modelo.Articulos.Camisa) {
                iescamp.tienda.modelo.Articulos.Camisa camisa = (iescamp.tienda.modelo.Articulos.Camisa) articulo;
                if (camisa.getTipoManga().equals(tipoManga)) {
                    camisasByTipoManga.add(camisa);
                }
            }

        }
        return camisasByTipoManga;
    }

    public ArrayList<iescamp.tienda.modelo.Articulos.Camisa> getCamisaByEsEstampada(boolean esEstampada) {
        ArrayList<iescamp.tienda.modelo.Articulos.Camisa> camisasByEsEstampada = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof iescamp.tienda.modelo.Articulos.Camisa) {
                iescamp.tienda.modelo.Articulos.Camisa camisa = (Camisa) articulo;
                if (camisa.getEsEstampada() == esEstampada) {
                    camisasByEsEstampada.add(camisa);
                }
            }

        }
        return camisasByEsEstampada;
    }
    public ArrayList<iescamp.tienda.modelo.Articulos.Pantalon> getPantalonByTieneBolsillos(boolean tieneBolsillos) {
        ArrayList<iescamp.tienda.modelo.Articulos.Pantalon> pantalonesByTieneBolsillos = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof iescamp.tienda.modelo.Articulos.Pantalon) {
                iescamp.tienda.modelo.Articulos.Pantalon pantalon = (iescamp.tienda.modelo.Articulos.Pantalon) articulo;
                if (pantalon.getTieneBolsillos() == tieneBolsillos) {
                    pantalonesByTieneBolsillos.add(pantalon);
                }
            }

        }
        return pantalonesByTieneBolsillos;
    }

    public ArrayList<iescamp.tienda.modelo.Articulos.Pantalon> getPantalonByTipoPantalon(String tipoPantalon) {
        ArrayList<iescamp.tienda.modelo.Articulos.Pantalon> pantalonesByTipoPantalon = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof iescamp.tienda.modelo.Articulos.Pantalon) {
                iescamp.tienda.modelo.Articulos.Pantalon pantalon = (Pantalon) articulo;
                if (pantalon.getTipoPantalon().equals(tipoPantalon)) {
                    pantalonesByTipoPantalon.add(pantalon);
                }
            }

        }
        return pantalonesByTipoPantalon;
    }

    public ArrayList<iescamp.tienda.modelo.Articulos.Zapatos> getZapatoByTalla(int talla) {
        ArrayList<iescamp.tienda.modelo.Articulos.Zapatos> zapatosByTalla = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof iescamp.tienda.modelo.Articulos.Zapatos) {
                iescamp.tienda.modelo.Articulos.Zapatos zapato = (iescamp.tienda.modelo.Articulos.Zapatos) articulo;
                if (zapato.getTallaZapatos() == talla) {
                    zapatosByTalla.add(zapato);
                }
            }

        }
        return zapatosByTalla;
    }

    public ArrayList<iescamp.tienda.modelo.Articulos.Zapatos> getZapatoByTipoSuela(String tipoSuela) {
        ArrayList<iescamp.tienda.modelo.Articulos.Zapatos> zapatosByTipoSuela = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof iescamp.tienda.modelo.Articulos.Zapatos) {
                iescamp.tienda.modelo.Articulos.Zapatos zapato = (Zapatos) articulo;
                if (zapato.getTipoSuela().equals(tipoSuela)) {
                    zapatosByTipoSuela.add(zapato);
                }
            }

        }
        return zapatosByTipoSuela;
    }

    public ArrayList<iescamp.tienda.modelo.Articulos.Accesorio> getAccesorioByEstilo(String estilo) {
        ArrayList<iescamp.tienda.modelo.Articulos.Accesorio> accesoriosByEstilo = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof iescamp.tienda.modelo.Articulos.Accesorio) {
                iescamp.tienda.modelo.Articulos.Accesorio accesorio = (iescamp.tienda.modelo.Articulos.Accesorio) articulo;
                if (accesorio.getEstilo().equals(estilo)) {
                    accesoriosByEstilo.add(accesorio);
                }
            }

        }
        return accesoriosByEstilo;
    }

    public ArrayList<iescamp.tienda.modelo.Articulos.Accesorio> getAccesorioByEsPersonalizado(boolean esPersonalizado) {
        ArrayList<iescamp.tienda.modelo.Articulos.Accesorio> accesoriosByEsPersonalizado = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof iescamp.tienda.modelo.Articulos.Accesorio) {
                iescamp.tienda.modelo.Articulos.Accesorio accesorio = (Accesorio) articulo;
                if (accesorio.getEsPersonalizado() == esPersonalizado) {
                    accesoriosByEsPersonalizado.add(accesorio);
                }
            }

        }
        return accesoriosByEsPersonalizado;
    }

    public ArrayList<Bolso> getBolsoByTipoCierre(String tipoCierre) {
        ArrayList<Bolso> bolsosByTipoCierre = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof Bolso) {
                Bolso bolso = (Bolso) articulo;
                if (bolso.getTipoCierre().equals(tipoCierre)) {
                    bolsosByTipoCierre.add(bolso);
                }
            }

        }
        return bolsosByTipoCierre;
    }

    public ArrayList<Bolso> getBolsoByCapacidad(int capacidad) {
        ArrayList<Bolso> bolsosByCapacidad = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo instanceof Bolso) {
                Bolso bolso = (Bolso) articulo;
                if (bolso.getCapacidad() == capacidad) {
                    bolsosByCapacidad.add(bolso);
                }
            }

        }
        return bolsosByCapacidad;
    }








}

