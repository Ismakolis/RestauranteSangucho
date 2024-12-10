package services;

import models.Usuarios;

import java.util.List;

public interface UsuariosService {
    //Generamos una liosta para los usuarios y poder traer los usuarios
    List<Usuarios> listarUsuarios();

}
