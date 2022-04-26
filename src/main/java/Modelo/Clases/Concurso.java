package Modelo.Clases;


import java.util.ArrayList;
import java.util.List;

public class Concurso {
    String nombre;
    List<Categoria> categorias = new ArrayList<>();

    public Concurso(List<Categoria> categorias, String nombre) {
        this.categorias = categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
