package br.com.bonvoyage.controller;





import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	@GetMapping("/")
	public String Home() {
		return "home";
	}
	
		@GetMapping("/promocoes")
		public String Promocoes() {
			return "promocoes";
		}
		
		@GetMapping("/contatos")
		public String Contatos() {
			return "contatos";
		}
		
		@GetMapping("/destinos")
		public String Destino() {
			return "destino";
		}
		
		@GetMapping("/cadastro")
		public String Cadastro() {
			return "cadastro";
		}
		
		@GetMapping("/adm")
		public String Adm() {
			return "adm";
		}
		
		@GetMapping("/cadastrese")
		public String Cadastrese() {
			return "cadastro";
		}



	

	 
	 
}
