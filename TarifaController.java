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

import edu.unimagdaelna.ajax.entities.Tarifa;
import edu.unimagdaelna.ajax.repositories.TarifaRepository;
@RestController
@RequestMapping("/ta/")
public class TarifaController {

	@Autowired
	private TarifaRepository tarifaRepository; 
	
	@GetMapping("/Tarifas")
	public List<Tarifa> getTarifas(){
		return tarifaRepository.findAll();
	}
	@PostMapping("/Tarifas")
	public Tarifa crearTarifa(@RequestBody Tarifa Tarifa) {
		return tarifaRepository.save(Tarifa);
	}
	@GetMapping("/Tarifas/{id}")
	public Tarifa getTarifa(@PathVariable Long id) {
		Optional<Tarifa> Tarifa = tarifaRepository.findById(id);
		if(!Tarifa.isPresent()) {
			throw new EntityNotFoundException("No se encontro el Tarifa con id "+id);
		}
				
		return Tarifa.get();
	}

	@PutMapping("/Tarifas")
	public Tarifa updateTarifa(@RequestBody Tarifa Tarifa) {
		return tarifaRepository.save(Tarifa);
	}
	@DeleteMapping("/Tarifas/{id}")
	public void eliminar(@PathVariable Long id) {
		Tarifa alu = tarifaRepository.getOne(id);
		tarifaRepository.delete(alu);
	}
}
