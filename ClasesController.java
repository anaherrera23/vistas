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

import edu.unimagdaelna.ajax.entities.Clase;
import edu.unimagdaelna.ajax.repositories.ClaseRepository;

@RestController
@RequestMapping("/cl/")
public class ClasesController {
	
	@Autowired
	private ClaseRepository claseRepository; 
	
	@GetMapping("/clases")
	public List<Clase> getClases(){
		return claseRepository.findAll();
	}
	@PostMapping("/clases")
	public Clase crearClase(@RequestBody Clase clase) {
		return claseRepository.save(clase);
	}
	@GetMapping("/clases/{id}")
	public Clase getClase(@PathVariable Long id) {
		Optional<Clase> clase = claseRepository.findById(id);
		if(!clase.isPresent()) {
			throw new EntityNotFoundException("No se encontro el alumno con id "+id);
		}
				
		return clase.get();
	}

	@PutMapping("/clases")
	public Clase updateClase(@RequestBody Clase clase) {
		return claseRepository.save(clase);
	}
	@DeleteMapping("/clases/{id}")
	public void eliminar(@PathVariable Long id) {
		Clase cla = claseRepository.getOne(id);
		claseRepository.delete(cla);
	}
	
	
	
	
	
	
}
