package org.brandon.uriel.repository;

import java.util.List;

import org.brandon.uriel.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

	public List<Vacante> findByEstatus(String estatus);
	public List<Vacante> findByEstatusAndDestacado(String estatus, Integer destacado);
}
