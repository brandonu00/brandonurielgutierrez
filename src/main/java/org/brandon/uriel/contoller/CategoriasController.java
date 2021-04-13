package org.brandon.uriel.contoller;

import java.util.List;

import org.brandon.uriel.model.Categoria;
import org.brandon.uriel.service.IntCategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
//Anotacion @RequestMapping a nivel de la clase
@RequestMapping(value="/categorias")
public class CategoriasController {
	@Autowired
	private IntCategoriasService categoriasService;
	
	
	@RequestMapping(value="/indexPaginado",method=RequestMethod.GET)
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Categoria>lista = categoriasService.buscarTodas(page);
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	@RequestMapping(value="/editar",method=RequestMethod.GET)
	public String editar(@RequestParam("id")int idCategoria,
			Model model) {
		Categoria categoria = 
				categoriasService.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value="/eliminar",method=RequestMethod.GET)
	public String eliminar(@RequestParam("id")int idCategoria,
			RedirectAttributes attributes) {
		categoriasService.eliminar(idCategoria);
		attributes.addFlashAttribute("msg","Categoria Eliminada");
		return "redirect:/categorias/indexPaginado";
	}
	
	//anotacion anterior para solicitar peticiones
	
	//@GetMapping(/index)
	//RequestMapping a nivel del metodo
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> lista = categoriasService.obtenerTodas();
		for(Categoria c : lista) {
			System.out.println(c);
		}
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	
	//@GetMapping(/crear)
	@RequestMapping(value="/crear",method=RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(Categoria categoria, RedirectAttributes attributes) {
		//categoria.setId(categoriasService.obtenerTodas().size()+1);
		categoriasService.guardar(categoria);
		attributes.addFlashAttribute("msg","La categoria se guardo");
		return "redirect:/categorias/index";
	}
	
	//@PostMapping("/guardar")
		//@RequestMapping(value="/guardar",method=RequestMethod.POST)
		//Hace la vinculacion de los elementos de formulario con 
		//Las variables quereciben los parametros (Data Biding)
		/*public String guardar(@RequestParam("nombre")String nombre,
							  @RequestParam("descripcion")String descripcion) {		
			System.out.println("Nombre: " + nombre);
			System.out.println("Descripcion: " + descripcion);
			return "categorias/listaCategorias";
		}*/
}
