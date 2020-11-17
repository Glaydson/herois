package br.edu.unichristus.controladores;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unichristus.entidades.Filme;
import br.edu.unichristus.persistencia.FilmesRepository;

@RestController
@RequestMapping("/filmes")
public class FilmesController {
	
	@Autowired
	private FilmesRepository repo;
	
	@GetMapping("/todos")
	public List<Filme> buscarTodos() {
		return this.repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Filme buscarPeloID(@PathVariable Long id) {
		return this.repo.findById(id).get();
	}
	
	@PostMapping("/novo")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Filme filme) {
		Filme filmeSalvo = this.repo.save(filme);
		URI local = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(filmeSalvo.getId()).toUri();
		return ResponseEntity.created(local).build();
	}

}
