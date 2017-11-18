
package com.luv2code.springsecurity.demo.bcrypto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("jan1"));
		System.out.println(encoder.encode("olek1"));
		System.out.println(encoder.encode("ula1"));
		
		
	}
}