package com.trabalhofinal.demo.controller;

import com.trabalhofinal.demo.model.email.Mailler;
import com.trabalhofinal.demo.model.email.MensagemEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	Mailler mailler;


    @PostMapping
	public String enviarEmail(@RequestBody MensagemEmail email) {
				
		try {
			mailler.enviar(email);
			return "Deu certo";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Deu ruim";
		}
	}
}
