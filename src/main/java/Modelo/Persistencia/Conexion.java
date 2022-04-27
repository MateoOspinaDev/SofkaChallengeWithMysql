package Modelo.Persistencia;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class Conexion {

    public static HashMap<String,String> getProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("config.properties"));
        HashMap<String, String> allProperties = new HashMap<>();
        allProperties.put("host",properties.getProperty("host"));
        allProperties.put("port",properties.getProperty("port"));
        allProperties.put("password",properties.getProperty("password"));
        allProperties.put("user",properties.getProperty("user"));
        allProperties.put("dbName",properties.getProperty("dbName"));
        return  allProperties;
    }

    public static Connection connect() throws IOException {
        Connection con = null;//objeto del tipo Connection, para administrar la conexión
        HashMap <String,String> properties = getProperties();
        String host = properties.get("host");
        String port = properties.get("port");
        String password = properties.get("password");
        String user = properties.get("user");
        String dbName = properties.get("dbName");
        String url = "jdbc:mysql://"+host+":"+port+"/"+dbName+"?user=" + user
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