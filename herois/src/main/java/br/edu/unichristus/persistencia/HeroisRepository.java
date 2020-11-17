package br.edu.unichristus.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.entidades.Heroi;

public interface HeroisRepository extends JpaRepository<Heroi, Long> {

}
