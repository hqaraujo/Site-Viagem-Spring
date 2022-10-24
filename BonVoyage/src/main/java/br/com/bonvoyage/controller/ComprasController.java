package br.com.bonvoyage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.bonvoyage.model.Compras;


import br.com.bonvoyage.repository.ComprasRepository;




@Controller
@RequestMapping("/compras")
public class ComprasController {

	@Autowired
	private ComprasRepository comprasRepository;
	
	
	

// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("compras/listar.html");

		List<Compras> compras = comprasRepository.findAll();
		modelAndView.addObject("compras", compras);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("compras/cadastro");

		modelAndView.addObject("compras", new Compras());

		return modelAndView;
	}

	

	 @GetMapping("/{id_compras}")
	    public ModelAndView detalhar(@PathVariable Long id_compras) {
	        ModelAndView modelAndView = new ModelAndView("compras/detalhar.html");

	        @SuppressWarnings("deprecation")
			Compras compras = comprasRepository.getOne(id_compras);
	        modelAndView.addObject("compras", compras); 
	        
	       
			
			

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id_compras}/excluir")
	    public ModelAndView excluir(@PathVariable Long id_compras) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/compras");

	        comprasRepository.deleteById(id_compras);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id_compras}/editar")
	    public ModelAndView editar(@PathVariable Long id_compras) {
	        ModelAndView modelAndView = new ModelAndView("compras/edicao");

	        @SuppressWarnings("deprecation")
			Compras compras = comprasRepository.getOne(id_compras);
	        modelAndView.addObject("compras", compras);

	        return modelAndView;
	    }
	
	 
	 @PostMapping("/{id_compras}/editar")
	    public ModelAndView editar(Compras compras) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/compras");

	        comprasRepository.save(compras);

	        return modelAndView;
	    }

	
	 
	 
}
