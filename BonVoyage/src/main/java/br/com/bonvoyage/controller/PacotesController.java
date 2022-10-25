package br.com.bonvoyage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.servlet.ModelAndView;


import br.com.bonvoyage.model.Pacotes;
import br.com.bonvoyage.repository.PacotesRepository;

@Controller
@RequestMapping("/pacotes")
public class PacotesController {

	@Autowired
	private PacotesRepository pacotesRepository;

// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("pacotes/listar.html");

		List<Pacotes> pacotes = pacotesRepository.findAll();
		modelAndView.addObject("pacotes", pacotes);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("pacotes/cadastro");

		modelAndView.addObject("pacotes", new Pacotes());

		return modelAndView;
	}

	
	

	
	 @GetMapping("/{id_pacote}")
	    public ModelAndView detalhar(@PathVariable Long id_pacote) {
	        ModelAndView modelAndView = new ModelAndView("pacotes/detalhar.html");

	        @SuppressWarnings("deprecation")
			Pacotes pacotes = pacotesRepository.getOne(id_pacote);
	        modelAndView.addObject("pacotes", pacotes);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id_pacote}/excluir")
	    public ModelAndView excluir(@PathVariable Long id_pacote) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");

	        pacotesRepository.deleteById(id_pacote);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id_pacote}/editar")
	    public ModelAndView editar(@PathVariable Long id_pacote) {
	        ModelAndView modelAndView = new ModelAndView("pacotes/edicao");

	        @SuppressWarnings("deprecation")
			Pacotes pacotes = pacotesRepository.getOne(id_pacote);
	        modelAndView.addObject("pacotes", pacotes);

	        return modelAndView;
	    }
	
	 
	 @PostMapping("/{id_pacote}/editar")
	    public ModelAndView editar(Pacotes pacotes) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");

	        pacotesRepository.save(pacotes);

	        return modelAndView;
	    }
	 
	 
}
