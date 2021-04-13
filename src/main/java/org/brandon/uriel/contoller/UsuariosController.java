package org.brandon.uriel.contoller;

import java.util.List;

import org.brandon.uriel.model.Categoria;
import org.brandon.uriel.model.Usuario;
import org.brandon.uriel.service.IntUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
	@GetMapping("/index")
	public String mostarIndex(Model model) {
		
		List<Usuario> lista = usuariosService.obtenerTodas();
		for(Usuario u : lista) {
			System.out.println(u);
		}
		model.addAttribute("usuarios", lista);
		return "usuarios/listaUsuarios";
	}
	

}
