package br.edu.unichristus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.controladores.FilmesController;
import br.edu.unichristus.controladores.HeroiController;
import br.edu.unichristus.entidades.Filme;
import br.edu.unichristus.entidades.Heroi;
import br.edu.unichristus.persistencia.FilmesRepository;
import br.edu.unichristus.persistencia.HeroisRepository;

@SpringBootApplication
public class HeroisApplication implements CommandLineRunner {
	
	@Autowired
	private HeroisRepository repoHerois;
	
	@Autowired
	private FilmesRepository repoFilmes;
	
	public static void main(String[] args) {
		SpringApplication.run(HeroisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Heroi homemFerro = new Heroi("Homem de Ferro");
		Heroi capitaoAmerica = new Heroi("Capitão América");
		Heroi volverine = new Heroi ("Volverine");
		Heroi aranha = new Heroi ("Homem Aranha");
		
		Filme vingadores = new Filme("Vingadores", 2000);
		Filme xmen = new Filme("XMen", 2001);
		Filme homemAranha = new Filme("Homem Aranha", 2005);
		
		List<Heroi> heroisVingadores = new ArrayList<>();
		heroisVingadores.add(homemFerro);
		heroisVingadores.add(capitaoAmerica);
		
		vingadores.setHerois(heroisVingadores);
		
		List<Heroi> heroiXmen = new ArrayList<>();
		heroiXmen.add(volverine);
		xmen.setHerois(heroiXmen);
		
		List<Heroi> heroiHomemAranha = new ArrayList<>();
		heroiHomemAranha.add(aranha);
		
		homemAranha.setHerois(heroiHomemAranha);
		
		repoHerois.save(homemFerro);
		repoHerois.save(capitaoAmerica);
		repoHerois.save(volverine);
		repoHerois.save(aranha);
		
		repoFilmes.save(vingadores);
		repoFilmes.save(xmen);
		repoFilmes.save(homemAranha);
		
		
	}

}
