package me.dio.academiadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.dio.academiadigital.entity.Matricula;
import me.dio.academiadigital.entity.form.MatriculaForm;
import me.dio.academiadigital.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping(path = "/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaServiceImpl service;

	@PostMapping
	public Matricula create(@Valid @RequestBody MatriculaForm form) {
		return service.create(form);
	}

	@GetMapping
	public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
		return service.getAll(bairro);
	}
}
