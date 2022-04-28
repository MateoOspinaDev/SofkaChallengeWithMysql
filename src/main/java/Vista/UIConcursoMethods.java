package Vista;
import Modelo.Clases.Categoria;
import Modelo.Clases.Concurso;
import Modelo.Clases.Pregunta;
import Modelo.Clases.Usuario;
import Modelo.Persistencia.PersistenciaUsuarioImpl;
import Preguntas.Preguntas;
import Validacion.Validacion;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UIConcursoMethods {

    static void showWelcome() {
        System.out.println("Bienvenido al concurso de preguntas de Sofka");
        System.out.println("Si desea jugar escriba 1 \nSi desea ver el histórico de puntajes escriba 2");
    }

     static void showLogicGame() {
        System.out.println("El concurso tiene la siguiente lógica:");
        System.out.println("Deberá responder cada pregunta escribiendo la opción a,b,c,d o e dependiendo la respuesta que considere correcta");
        System.out.println("Si la respuesta es correcta, obtendrá 1 punto y avanzará a la siguiente ronda");
        System.out.println("Si es incorrecta perderá el concurso.");
    }

     static void playConcurse(){
        String nombre = Validacion.validateName("Ingrese su nombre por favor: ");
        long puntaje = 0L;
        boolean flag = true;
        Concurso concurso = new Concurso(Preguntas.unirCategorias(),"Concurso de preguntas de Sofka");
        List<Categoria> categorias = concurso.getCategorias();
        while (flag) {
            for (Categoria categoria:categorias) {
                if (!flag){break;}
                System.out.println("Esta categoría es de " + categoria.getNombre() + " (nivel: " + categoria.getNivel() + ")");
                Pregunta pregunta = categoria.getPreguntas().get((int)(Math.random() * 4 + 0));
                System.out.println(pregunta.getEnunciado());
                pregunta.getOpciones().forEach((s, opcion) -> System.out.println(s+") "+opcion.getContenido()));
                String continuidad = Validacion.validateContinuity("De momento su puntaje es:"+puntaje+" ¿Desea continuar o desea retirarse y conservar el puntaje actual?\n" + "Escriba 1 para continuar y 2 para terminar el juego");
                if(continuidad.equals("2")){ flag = false;
                    System.out.println("Juego terminado. Su puntaje fue de "+puntaje);
                }
                else {
                    String response = Validacion.validateOption("¿Cuál es la respuesta de la pregunta?");
                    if (!pregunta.getOpciones().get(response).getContenido().equals(pregunta.getRespuestaCorrecta().getContenido())) {
                        puntaje = 0L;
                        flag = false;
                        System.out.println("Respuesta incorrecta, por lo tanto su puntaje es de: " + puntaje);
                        break;
                    }
                    puntaje++;
                    if(categoria.getNivel()==5){
                        System.out.println("¡Felicitaciones! Ha completado la totalidad del concurso. Por lo tanto su puntaje es de: "+puntaje);
                        flag=false;
                    }
                }
            }
        }
        PersistenciaUsuarioImpl dao = new PersistenciaUsuarioImpl();
        dao.saveUser(new Usuario(nombre, puntaje, Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now())));
    }


     static void showScoreHistory() {
        PersistenciaUsuarioImpl dao = new PersistenciaUsuarioImpl();
        List<Usuario> usuariosRegistrados = dao.getAllUsers();
        usuariosRegistrados.forEach(System.out::println);
    }

}
