package Modelo.Persistencia;

import Modelo.Clases.Usuario;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaUsuarioImpl implements IPersistenciaUsuario {

    @Override
    public boolean saveUser(Usuario usuario) {
        boolean registrar = false;

        Statement stm= null;//La usamos para ejecutar las consultas a la base de datos, Consultas. Se obtiene un objeto de la clase ResultSet.
        Connection con=null;//inicializamos la conexion

        String sql="INSERT INTO usuarios values (NULL,'"+usuario.getNombre()+"','"+usuario.getPuntaje()+"','"+usuario.getFecha()+"','"+usuario.getHora()+"')";
        String sqlPS="INSERT INTO usuarios values (NULL,?,?,?,?)";

        try {
            con=Conexion.connect();//conectamos con la base de datos
            PreparedStatement preparedStatement = con.prepareStatement(sqlPS);//Crea un objeto PreparedStatement para enviar sentencias SQL parametrizadas a la base de datos.
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setLong(2, usuario.getPuntaje());
            preparedStatement.setDate(3, usuario.getFecha());
            preparedStatement.setTime(4, usuario.getHora());
            preparedStatement.executeUpdate();
            registrar=true;//Declaramos que ya se realizó la persistencia
            con.close();//cerramos el metodo

            /*con=Conexion.conectar();//conectamos con la base de datos
            //PreparedStatement preparedStatement = con.prepareStatement(sqlPS);
            stm= con.createStatement();//Crea un objeto PreparedStatement para enviar sentencias SQL parametrizadas a la base de datos.
            stm.execute(sql);//ejecutamos la consulta
            registrar=true;//Declaramos que ya se realizó la persistencia
            stm.close();//cerramos el metodo
            con.close();//cerramos el metodo*/

        } catch (SQLException | IOException e) {
            System.out.println("Error: Clase UsuarioDaoImpl, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    //Para obtener datos y procesarlos usamos Resultset
//    El objeto rs contiene las tuplas resultado de la consulta. Para acceder a ellas se
//    tiene el m´etodo next() que devuelve true si hay datos y false en otro caso.
//    Para extraer cada atributo de la tupla actual (la recuperada con next) se debe
//    usar un m´etodo getXXX de acuerdo al tipo del atributo.
    @Override
    public List<Usuario> getAllUsers() {
        Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM USUARIOs ORDER BY ID";

        List<Usuario> listaCliente= new ArrayList<Usuario>();

        try {
            co= Conexion.connect();//conectamos
            stm=co.createStatement();//preparamos para enviar consultas
            rs=stm.executeQuery(sql);//Recibimos lo que nos da la consulta en este objeto
            while (rs.next()) {
                Usuario c=new Usuario();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setPuntaje((long) rs.getInt(3));
                c.setFecha(rs.getDate(4));
                c.setHora(rs.getTime(5));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException | IOException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }

    @Override
    public Usuario getUserByName(String nombre) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String query = "SELECT * FROM USUARIOs WHERE id =" + nombre + "''" + "')";
        Usuario usuario = null;

        try {
            ResultSet result = stm.executeQuery(query);
            if (rs.next()) { //Para leer varias posibles filas se cambia el while por el if
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setPuntaje((long) rs.getInt(3));
                usuario.setFecha(rs.getDate(4));
                usuario.setHora(rs.getTime(5));
            }

            stm.close();
            rs.close();
            co.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtenerUsuarioPorNombre");
            e.printStackTrace();
        }
        return usuario;
    }




//    @Override
//    public boolean actualizar(Usuario usuario) {
//        Connection connect= null;
//        Statement stm= null;
//
//        boolean actualizar=false;
//
//        String sql="UPDATE CLIENTE SET cedula='"+cliente.getCedula()+"', nombres='"+cliente.getNombre()+"', apellidos='"+cliente.getApellido()+"'" +" WHERE ID="+cliente.getId();
//        try {
//            connect=Conexion.conectar();
//            stm=connect.createStatement();
//            stm.execute(sql);
//            actualizar=true;
//        } catch (SQLException e) {
//            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
//            e.printStackTrace();
//        }
//        return actualizar;
//    }

//    @Override
//    public boolean eliminar(Usuario usuario) {
//        Connection connect= null;
//        Statement stm= null;
//
//        boolean eliminar=false;
//
//        String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getId();
//        try {
//            connect=Conexion.conectar();
//            stm=connect.createStatement();
//            stm.execute(sql);
//            eliminar=true;
//        } catch (SQLException e) {
//            System.out.println("Error: Clase ClienteDaoImple, método eliminar");
//            e.printStackTrace();
//        }
//        return eliminar;
//    }
}
