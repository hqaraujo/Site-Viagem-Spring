package br.com.bonvoyage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import br.com.bonvoyage.model.Login;
import br.com.bonvoyage.repository.LoginRepository;

@Controller
@RequestMapping("/loginn")
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

// Lista todos os dados do banco cliente
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("login/listar.html");

		List<Login> login = loginRepository.findAll();
		modelAndView.addObject("login", login);

		return modelAndView;
	}

// Chama a view cadastrar e passa um objeto vazio
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("login/cadastro.html");

		modelAndView.addObject("login", new Login());

		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
    public ModelAndView cadastrar(Login login )  {



      
       ModelAndView modelAndView = new ModelAndView("redirect:/loginn");



       loginRepository.save(login);



       return modelAndView;
    }

	


	 @GetMapping("/{id_login}")
	    public ModelAndView detalhar(@PathVariable Long id_login) {
	        ModelAndView modelAndView = new ModelAndView("login/detalhar.html");

	        @SuppressWarnings("deprecation")
			Login login = loginRepository.getOne(id_login);
	        modelAndView.addObject("login", login);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id_login}/excluir")
	    public ModelAndView excluir(@PathVariable Long id_login) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/loginn");

	        loginRepository.deleteById(id_login);

	        return modelAndView;
	    }
	 
	 @GetMapping("/{id_login}/editar")
	    public ModelAndView editar(@PathVariable Long id_login) {
	        ModelAndView modelAndView = new ModelAndView("login/edicao.html");

	        @SuppressWarnings("deprecation")
			Login login = loginRepository.getOne(id_login);
	        modelAndView.addObject("login", login);

	        return modelAndView;
	    }
	
	 
	 @PostMapping("/{id_login}/editar")
	    public ModelAndView editar(Login login) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/loginn");

	        loginRepository.save(login);

	        return modelAndView;
	    }
	 
	 
}
