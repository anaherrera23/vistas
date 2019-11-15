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

import edu.unimagdaelna.ajax.entities.Curso;
import edu.unimagdaelna.ajax.repositories.CursoRepository;

@RestController
@RequestMapping("/cu/")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository; 
	
	@GetMapping("/curso")
	public List<Curso> getCursos(){
		return cursoRepository.findAll();
	}
	@PostMapping("/curso")
	public Curso crearCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	@GetMapping("/curso/{id}")
	public Curso getCurso(@PathVariable Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		if(!curso.isPresent()) {
			throw new EntityNotFoundException("No se encontro el alumno con id "+id);
		}
				
		return curso.get();
	}

	@PutMapping("/curso")
	public Curso updateCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	@DeleteMapping("/curso/{id}")
	public void eliminar(@PathVariable Long id) {
		Curso cur = cursoRepository.getOne(id);
		cursoRepository.delete(cur);
	}
	
	
	
	
}
