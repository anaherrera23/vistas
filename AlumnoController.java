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

import edu.unimagdaelna.ajax.entities.Alumno;
import edu.unimagdaelna.ajax.repositories.AlumnoRepository;

@RestController
@RequestMapping("/al/")
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository alumnoRepository; 
	
	@GetMapping("/alumnos")
	public List<Alumno> getAlumnos(){
		return alumnoRepository.findAll();
	}
	@PostMapping("/alumnos")
	public Alumno crearAlumno(@RequestBody Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	@GetMapping("/alumnos/{id}")
	public Alumno getAlumno(@PathVariable Long id) {
		Optional<Alumno> alumno = alumnoRepository.findById(id);
		if(!alumno.isPresent()) {
			throw new EntityNotFoundException("No se encontro el alumno con id "+id);
		}
				
		return alumno.get();
	}

	@PutMapping("/alumnos")
	public Alumno updateAlumno(@RequestBody Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	@DeleteMapping("/alumnos/{id}")
	public void eliminar(@PathVariable Long id) {
		Alumno alu = alumnoRepository.getOne(id);
		alumnoRepository.delete(alu);
	}
	
	
	
	
	
}
