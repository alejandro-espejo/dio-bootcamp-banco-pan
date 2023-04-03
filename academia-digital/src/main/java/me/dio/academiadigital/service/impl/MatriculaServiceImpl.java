package me.dio.academiadigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.Matricula;
import me.dio.academiadigital.entity.form.MatriculaForm;
import me.dio.academiadigital.repository.AlunoRepository;
import me.dio.academiadigital.repository.MatriculaRepository;
import me.dio.academiadigital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private MatriculaRepository repository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public Matricula create(MatriculaForm form) {
		Matricula matricula = new Matricula();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		matricula.setAluno(aluno);
		return repository.save(matricula);
	}

	@Override
	public Matricula get(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Matricula> getAll(String bairro) {
		if (bairro == null) {
			return repository.findAll();
		}
		return repository.findAlunosMatriculadosBairro(bairro);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
