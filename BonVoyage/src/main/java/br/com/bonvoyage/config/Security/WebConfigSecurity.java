package br.com.bonvoyage.config.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




//Mapeia URL, endereços, autoriza ou bloqueia acesso a URL
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	//Configura as solicitações de acesso por HTTP
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.httpBasic()
	.and()
	.authorizeHttpRequests()
	.anyRequest().authenticated()
	.and()
	.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("recode")
		.password(passwordEncoder().encode("050505"))
		.roles("ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
