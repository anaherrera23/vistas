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

import edu.unimagdaelna.ajax.entities.Hora_semanal;
import edu.unimagdaelna.ajax.repositories.Hora_semanalRepository;

@RestController
@RequestMapping("/hs/")
public class Hora_semanalesController {

	@Autowired
	private Hora_semanalRepository hora_semanalRepository; 
	
	@GetMapping("/horas_semanales")
	public List<Hora_semanal> getHora_semanals(){
		return hora_semanalRepository.findAll();
	}
	@PostMapping("/horas_semanales")
	public Hora_semanal crearHora_semanal(@RequestBody Hora_semanal hora_semanal) {
		return hora_semanalRepository.save(hora_semanal);
	}
	@GetMapping("/horas_semanales/{id}")
	public Hora_semanal getHora_semanal(@PathVariable Long id) {
		Optional<Hora_semanal> hora_semanal = hora_semanalRepository.findById(id);
		if(!hora_semanal.isPresent()) {
			throw new EntityNotFoundException("No se encontro el alumno con id "+id);
		}
				
		return hora_semanal.get();
	}

	@PutMapping("/horas_semanales")
	public Hora_semanal updateHora_semanal(@RequestBody Hora_semanal hora_semanal) {
		return hora_semanalRepository.save(hora_semanal);
	}
	@DeleteMapping("/horas_semanales/{id}")
	public void eliminar(@PathVariable Long id) {
		Hora_semanal hora = hora_semanalRepository.getOne(id);
		hora_semanalRepository.delete(hora);
	}
	
	
	
	
}
