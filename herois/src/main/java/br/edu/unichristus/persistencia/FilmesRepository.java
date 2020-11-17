package br.edu.unichristus.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.entidades.Filme;

public interface FilmesRepository extends JpaRepository<Filme, Long> {
	
	

}
