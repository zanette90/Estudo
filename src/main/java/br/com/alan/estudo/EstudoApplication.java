package br.com.alan.estudo;

import br.com.alan.estudo.model.DadosSerie;
import br.com.alan.estudo.services.ConsumoApi;
import br.com.alan.estudo.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EstudoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EstudoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto spring sem web");
		//ConsumoApi consumoapi = new ConsumoApi();
		var consumoapi = new ConsumoApi();
		var json = consumoapi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey");
		//var json = consumoapi.obterDados("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
