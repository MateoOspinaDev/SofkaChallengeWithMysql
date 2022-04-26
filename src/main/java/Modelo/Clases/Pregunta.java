package Modelo.Clases;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Pregunta {
	LinkedHashMap<String,Opcion> opciones;
    private String enunciado;
    private Categoria categoria;
    private Opcion respuestaCorrecta;
    public Pregunta(LinkedHashMap<String,Opcion> opciones, String enunciado, Opcion respuestaCorrecta) {
        this.opciones = opciones;
        this.enunciado=enunciado;
        this.respuestaCorrecta=respuestaCorrecta;
    }

	public LinkedHashMap<String,Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(LinkedHashMap<String,Opcion> opciones) {
		this.opciones = opciones;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Opcion getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(Opcion respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
    
}
