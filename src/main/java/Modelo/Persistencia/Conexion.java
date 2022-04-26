package Modelo.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection connect() {
        Connection con = null;//objeto del tipo Connection, para administrar la conexión

        String password = "";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3306/puntaje?user=" + usuario
                + "&password=" + password;

        try {
            con = DriverManager.getConnection(url);
            //El método getConnection() es un método estático de la clase DriverManager por esa razón es que se accede sin
            // crear un objeto, esta clase está disponible dentro del paquete java.sql, el cual debes importar para que no
            // te de error.
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
}