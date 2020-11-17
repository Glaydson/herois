package br.edu.unichristus.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.Data;

@Entity
@Table(name = "TB_FILMES")
@Data
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@Size(min = 3, max = 50, message = "O título deve ter entre 3 e 50 caracteres")
	private String titulo;

	@Max(value = 2020, message = "O ano de produção deve ser anterior a 2020")
	private int anoProducao;
	
	@ManyToMany
	@JoinTable(name = "TB_FILMES_HEROIS")
	private List<Heroi> herois;
	
	public Filme() {}
	
	public Filme(String titulo, int anoProducao) {
		this.titulo = titulo;
		this.anoProducao = anoProducao;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", anoProducao=" + anoProducao + "]";
	}
	
	

}
