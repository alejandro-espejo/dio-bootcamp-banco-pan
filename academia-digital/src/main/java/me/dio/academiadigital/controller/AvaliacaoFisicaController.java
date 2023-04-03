package me.dio.academiadigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaForm;
import me.dio.academiadigital.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping(path = "/avaliacoes")
public class AvaliacaoFisicaController {

	@Autowired
	private AvaliacaoFisicaServiceImpl service;

	@PostMapping
	public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}
}
