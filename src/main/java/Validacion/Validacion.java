package Validacion;

import java.util.Scanner;

public class Validacion {

    static Scanner sc;

    public static String validateName(String frase){
        sc=new Scanner(System.in);
        String nombre= "";
        do {
            System.out.println(frase);
            nombre = sc.nextLine();
            if (!nombre.matches("^[A-Za-z ]*$")) {
                nombre = "";
                System.out.println("No ha ingresado naada o ingresó un nombre no valido");
            }
        }
        while (nombre.equals(""));
        return nombre;
    }

    public static String validateOption(String frase){
        sc=new Scanner(System.in);
        String opcion= "";
        do {
            System.out.println(frase);
            opcion = sc.nextLine();
            if (!opcion.matches("[a-b-c-d-e]")) {
                opcion = "";
                System.out.println("Ingrese solo un de las opciones que puede escoger (a,b,c,d,e)");
            }
        }
        while (opcion.equals(""));
        return opcion;
    }

    public static String validateContinuity(String frase){
        sc=new Scanner(System.in);
        String opcion= "";
        do {
            System.out.println(frase);
            opcion = sc.nextLine();
            if (!opcion.matches("[1-2]")) {
                opcion = "";
                System.out.println("Ingrese solo un de las opciones que puede escoger (1 o 2)");
            }
        }
        while (opcion.equals(""));
        return opcion;
    }



}
