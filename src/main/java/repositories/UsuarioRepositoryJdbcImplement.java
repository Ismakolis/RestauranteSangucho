package repositories;

import models.Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryJdbcImplement implements Repository<Usuarios>{
    private Connection conn;

    public UsuarioRepositoryJdbcImplement(Connection conn) {
        conn = this.conn;
    }

    @Override
    public List<Usuarios> listar() throws SQLException {
        List<Usuarios> listarUsuarios = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from Usuarios")) {
            while (rs.next()){
                Usuarios u = getUsuarios(rs);
                listarUsuarios.add(u);
            }
        }
        return listarUsuarios;
    }

    @Override
    public Usuarios porId(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Usuarios usuarios) throws SQLException {

    }

    @Override
    public void eliminar(Long idProducto) throws SQLException {
    }

    private static Usuarios getUsuarios(ResultSet rs) throws SQLException {
        Usuarios u = new Usuarios();
         u.setCedulaUsuario(rs.getInt("idUsuarios"));
         u.setNombreUsuario(rs.getString("nombreUsuario"));
         u.setCorreoUsuario(rs.getString("cooreoUusario"));
         u.setContrasenaUsuario(rs.getInt("contrasenaUsuario"));
         u.setRolUsuario(rs.getString("rolUsuario"));
         u.setCedulaUsuario(rs.getInt("cedulaUsuario"));

        return u;
    }



}
