package br.edu.unichristus.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TB_HEROIS")
@Data
public class Heroi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String nome;

	
	private List<Filme> filmes;

	public Heroi() {
	}

	public Heroi(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Heroi [id=" + id + ", nome=" + nome + ", filmes=" + filmes + "]";
	}

}
