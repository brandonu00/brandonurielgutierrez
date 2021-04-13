package org.brandon.uriel.service;

import java.util.List;

import org.brandon.uriel.model.Usuario;

public interface IntUsuariosService  {
	public List<Usuario> obtenerTodas();
	public Usuario buscarPorId(Integer idusuario);
	public void guardar(Usuario usuario);
	public void eliminar(Integer idUsuario);

}
