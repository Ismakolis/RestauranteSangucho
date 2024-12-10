package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //declaramos e inicializamos 3 parametros
    //para la conexion  a la base de datos.
    //static una variable que no va a cambiar
    private static String url="jdbc:mysql://localhost:3306/restaurante?useTimezone=ture&serveltTimezone=UTC";
    private static String username="root";
    private static String password="";

    //implementamosun metodo para obtener la conexion mediante una variable public static.
    /*
    Public por que se va a utilizar en toda la aplicacion
    */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}


