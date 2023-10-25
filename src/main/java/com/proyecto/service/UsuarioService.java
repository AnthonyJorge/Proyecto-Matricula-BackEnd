package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Opcion;
import com.proyecto.entity.Rol;
import com.proyecto.entity.Usuario;



public interface UsuarioService {

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);
}
