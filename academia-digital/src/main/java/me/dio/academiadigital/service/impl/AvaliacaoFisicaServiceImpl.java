package me.dio.academiadigital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaForm;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academiadigital.repository.AlunoRepository;
import me.dio.academiadigital.repository.AvaliacaoFisicaRepository;
import me.dio.academiadigital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository repository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Optional<Aluno> aluno = alunoRepository.findById(form.getAlunoId());
		if (aluno.isPresent()) {
			avaliacaoFisica.setAluno(aluno.get());
			avaliacaoFisica.setAltura(form.getAltura());
			avaliacaoFisica.setPeso(form.getPeso());
		} else {
			throw new RuntimeException("Aluno não encontrado!");
		}
		return repository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		
		return null;
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		
		return null;
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		
		return null;
	}

	@Override
	public void delete(Long id) {
		
	}

}
