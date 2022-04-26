package Modelo.Clases;


import java.util.ArrayList;
import java.util.List;

public class Categoria {
    List<Pregunta> preguntas = new ArrayList<>();
    private String nombre;
    private int nivel;

    public Categoria(String nombre, List<Pregunta> preguntas, int nivel) {
        this.nombre = nombre;
        this.preguntas=preguntas;
        this.nivel=nivel;
    }

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
    
}

