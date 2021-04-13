package org.brandon.uriel.service;


import java.util.LinkedList;
import java.util.List;

import org.brandon.uriel.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServiceImp implements IntCategoriasService{
	private List<Categoria> lista= null;
	
	public CategoriasServiceImp(){
		lista = new LinkedList<Categoria>();
		
			
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Ventas");
			c1.setDescripcion("Referente a ventas");
			lista.add(c1);
			
			
			Categoria c2 = new Categoria();
			c2.setId(2);
			c2.setNombre("Contabilidad");
			c2.setDescripcion("Referente a contabilidad");
			lista.add(c2);
			
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("Transporte");
			c3.setDescripcion("Referente a transporte");
			lista.add(c3);
			
			Categoria c4 = new Categoria();
			c4.setId(4);
			c4.setNombre("Informatica");
			c4.setDescripcion("Referente a computación");
			lista.add(c4);
			
			Categoria c5 = new Categoria();
			c5.setId(5);
			c5.setNombre("Construccion");
			c5.setDescripcion("Referente a construcción");
			lista.add(c5);
			
			
		
	}

	@Override
	public List<Categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		for( Categoria categoria : obtenerTodas()) {
			if (categoria.getId() == idCategoria) {
				return categoria;
			}
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		lista.add(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
