package me.dio.academiadigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AlunoForm;
import me.dio.academiadigital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

	@Autowired
	private AlunoServiceImpl service;

	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}

	@GetMapping(path = "/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable(name = "id") Long id) {
		return service.getAllAvaliacaoFisicaId(id);
	}

	@GetMapping
	public List<Aluno> getAll(@RequestParam(name = "dataDeNascimento", required = false) String dataDeNascimento) {
		return service.getAll(dataDeNascimento);
	}

}
