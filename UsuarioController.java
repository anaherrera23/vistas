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

import edu.unimagdaelna.ajax.entities.Usuario;
import edu.unimagdaelna.ajax.repositories.UsuarioRespository;
@RestController
@RequestMapping("/user/")
public class UsuarioController {

	@Autowired
	private UsuarioRespository usuarioRepository; 
	
	@GetMapping("/Usuarios")
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	@PostMapping("/Usuarios")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	@GetMapping("/Usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		Optional<Usuario> Usuario = usuarioRepository.findById(id);
		if(!Usuario.isPresent()) {
			throw new EntityNotFoundException("No se encontro el Usuario con id "+id);
		}
				
		return Usuario.get();
	}

	@PutMapping("/Usuarios")
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	@DeleteMapping("/Usuarios/{id}")
	public void eliminar(@PathVariable Long id) {
		Usuario alu = usuarioRepository.getOne(id);
		usuarioRepository.delete(alu);
	}
	
	
	
	
}
