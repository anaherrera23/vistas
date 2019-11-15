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

import edu.unimagdaelna.ajax.entities.Profesor;
import edu.unimagdaelna.ajax.repositories.ProfesorRepository;


//@CrossOrigin(origins = "http://localhost:8080")

@RestController
@RequestMapping("/p/")
public class ProfesoresController {
	
	@Autowired
	private ProfesorRepository profesorRepository; 
	
	@GetMapping("/profesores")
	public List<Profesor> getProfesores(){
		return profesorRepository.findAll();
	}
	@PostMapping("/profesores")
	public Profesor crearProfesor(@RequestBody Profesor profesor) {
		return profesorRepository.save(profesor);
	}
	@GetMapping("/profesores/{id}")
	public Profesor getProfesor(@PathVariable Long id) {
		Optional<Profesor> profesor = profesorRepository.findById(id);
		if(!profesor.isPresent()) {
			throw new EntityNotFoundException("No se encontro el profesor con id "+id);
		}
				
		return profesor.get();
	}

	@PutMapping("/profesores")
	public Profesor updateProfesor(@RequestBody Profesor profesor) {
		return profesorRepository.save(profesor);
	}
	@DeleteMapping("/profesores/{id}")
	public void eliminar(@PathVariable Long id) {
		Profesor pro = profesorRepository.getOne(id);
		profesorRepository.delete(pro);
	}
	
	
	
	
	
}

