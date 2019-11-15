package edu.unimagdaelna.ajax.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unimagdaelna.ajax.entities.Asignatura;
import edu.unimagdaelna.ajax.repositories.AsignaturaRepository;

@RestController
@RequestMapping("/as/")
public class AsignaturaController {
	
	@Autowired
	private AsignaturaRepository asignaturaRepository; 
	
	@GetMapping("/asignatura")
	public List<Asignatura> getAsignaturas(){
		return asignaturaRepository.findAll();
	}
	@PostMapping("/asignatura")
	public Asignatura crearAsignatura(@RequestBody Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}
	@GetMapping("/asignatura/{id}")
	public Asignatura getAsignatura(@PathVariable Long id) {
		Optional<Asignatura> asignatura = asignaturaRepository.findById(id);
		if(!asignatura.isPresent()) {
			throw new EntityNotFoundException("No se encontro el alumno con id "+id);
		}
				
		return asignatura.get();
	}

	@PutMapping("/asignatura")
	public Asignatura updateAsignatura(@RequestBody Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}
	@DeleteMapping("/asignatura/{id}")
	public void eliminar(@PathVariable Long id) {
		Asignatura asi = asignaturaRepository.getOne(id);
		asignaturaRepository.delete(asi);
	}
	
	
	
	

}
