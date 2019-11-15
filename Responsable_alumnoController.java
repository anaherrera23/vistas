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

import edu.unimagdaelna.ajax.entities.Responsable_alumno;
import edu.unimagdaelna.ajax.repositories.Responsable_alumnoRepository;

@RestController
@RequestMapping("/re/")
public class Responsable_alumnoController {

	@Autowired
	private Responsable_alumnoRepository responsable_alumnoRepository; 
	
	@GetMapping("/responsable_alumno")
	public List<Responsable_alumno> getResponsable_alumnos(){
		return responsable_alumnoRepository.findAll();
	}
	@PostMapping("/responsable_alumno")
	public Responsable_alumno crearResponsable_alumno(@RequestBody Responsable_alumno responsable_alumno) {
		return responsable_alumnoRepository.save(responsable_alumno);
	}
	@GetMapping("/responsable_alumno/{id}")
	public Responsable_alumno getResponsable_alumno(@PathVariable Long id) {
		Optional<Responsable_alumno> responsable_alumno = responsable_alumnoRepository.findById(id);
		if(!responsable_alumno.isPresent()) {
			throw new EntityNotFoundException("No se encontro el alumno con id "+id);
		}
				
		return responsable_alumno.get();
	}

	@PutMapping("/responsable_alumno")
	public Responsable_alumno updateResponsable_alumno(@RequestBody Responsable_alumno responsable_alumno) {
		return responsable_alumnoRepository.save(responsable_alumno);
	}
	@DeleteMapping("/responsable_alumno/{id}")
	public void eliminar(@PathVariable Long id) {
		Responsable_alumno res = responsable_alumnoRepository.getOne(id);
		responsable_alumnoRepository.delete(res);
	}
	
	
	
	
}
