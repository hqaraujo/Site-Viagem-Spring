package br.com.bonvoyage.config.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
 public static String encode(String senhaCliente) {
	 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
 return encoder.encode(senhaCliente);
 }
 
 public static boolean matches(String senhaCliente, String hash) {
	 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	 return encoder.matches(senhaCliente, hash);
 }
}
