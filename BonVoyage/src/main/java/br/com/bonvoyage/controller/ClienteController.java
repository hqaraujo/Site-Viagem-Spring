package br.com.bonvoyage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import br.com.bonvoyage.model.Cliente;
import br.com.bonvoyage.repository.ClienteRepository;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	

// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cliente/listar.html");

		List<Cliente> cliente = clienteRepository.findAll();
		modelAndView.addObject("cliente", cliente);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cliente/cadastro");

		modelAndView.addObject("cliente", new Cliente());

		return modelAndView;
	}

	
	
	 @GetMapping("/{id_cliente}")
	    public ModelAndView detalhar(@PathVariable Long id_cliente) {
	        ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");

	        @SuppressWarnings("deprecation")
			Cliente cliente = clienteRepository.getOne(id_cliente);
	        modelAndView.addObject("cliente", cliente); 
	        
	       
	        return modelAndView;
	    }
	 
	 @GetMapping("/{id_cliente}/excluir")
	    public ModelAndView excluir(@PathVariable Long id_cliente) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

	        clienteRepository.deleteById(id_cliente);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id_cliente}/editar")
	    public ModelAndView editar(@PathVariable Long id_cliente) {
	        ModelAndView modelAndView = new ModelAndView("cliente/edicao");

	        @SuppressWarnings("deprecation")
			Cliente cliente = clienteRepository.getOne(id_cliente);
	        modelAndView.addObject("cliente", cliente);

	        return modelAndView;
	    }
	
	 
	 @PostMapping("/{id_cliente}/editar")
	    public ModelAndView editar(Cliente cliente) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

	        clienteRepository.save(cliente);

	        return modelAndView;
	    }

	
	 
}
