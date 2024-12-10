package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import utils.Conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

//Implementamos una anotacion, esta an otacion me sirve para poder utilizar la conexion
//en cualquier parte de mi app
@WebFilter("/*")
public class ConexionFilter implements Filter {

    /*
    Una clase filter en javaq es una objeto que realiza un filtrado en las solicitudes de un clñioente,
    respuestas  de un serevidor a un recurso. Los filtros se pueden ejecutar los servidores web
    compatibles con jakarta EE. Los filtroas interceptan solicitudes y respouestas de manera dinamica
    para trasformarlos o utilizar la informacion que contiene. El filtro se realiza  en el metodo
    doFilter
    */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {
    /*
    request: peticiones del cliente al servidor
    response: respuesta del servidor
    filterChain: es un a clase filtro quie representa el flujo de procersamiento llamando al metodo
    chain.doFilter(request y response ), dentro de un filtro pasa la solicitud al siguiente filtro
    o al recurso destino(servlet o un jsp)
    */
        try (Connection conn = Conexion.getConnection()) {
         /*
         Verificamos si la conexion realiza un autocommit(configuracion automatica para cada instruccion
         sql)
         */
            if (conn.getAutoCommit()) {
                //Si esta activa descativamos el autocommit.
                conn.setAutoCommit(false);
            }
            try {
                //aggregamos la conexion connn un atributop en la solicitud
                //esto permite que otros componentes(servlets o DAOS)puiedan acceder a la conexion
                //desde el objeto request
                request.setAttribute("conn", conn);
                //pasa la solicitud y la respuesta al siguienbte filtro del recurso o destino (servlet o jsp)
                Chain.doFilter(request, response);
                //Si el procesamiento se realizo correctamente sin lanzar ninguna excepcion,
                //se confirma la solicitud, se aplica los cambios a la base de datos
                conn.commit();

                //si ocurre alguna excepcion se lanza dicha excepcion y no se cambia la bd
            } catch (Exception e) {
                //se desacen los cambion con un rollback y de esa forma se mantiene la integridad de los datos
                conn.rollback();
                //Se envia un c+odigo de error HTTP 500 al cliente, indicando un problema interno en el servidor
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
                e.printStackTrace();

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
