package me.dio.academiadigital.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AlunoForm;
import me.dio.academiadigital.entity.form.AlunoUpdateForm;
import me.dio.academiadigital.infra.utils.JavaTimeUtils;
import me.dio.academiadigital.repository.AlunoRepository;
import me.dio.academiadigital.repository.AvaliacaoFisicaRepository;
import me.dio.academiadigital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		return repository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		return null;
	}

	@Override
	public List<Aluno> getAll() {
		return repository.findAll();
	}

	public List<Aluno> getAll(String dataDeNascimento) {
		if (dataDeNascimento == null || dataDeNascimento.equals("")) {
			return getAll();
		}
		try {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return repository.findByDataDeNascimento(localDate);
		} catch (DateTimeParseException e) {
			throw new RuntimeException("Data inválida! Inserir no formato dd/MM/yyyy");
		}
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long idAluno) {
		Aluno aluno = repository.findById(idAluno).orElse(null);
		if (aluno != null) {
			return avaliacaoFisicaRepository.findAllByAluno(aluno);
//			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//			CriteriaQuery<AvaliacaoFisica> cr = cb.createQuery(AvaliacaoFisica.class);
//			Root<AvaliacaoFisica> root = cr.from(AvaliacaoFisica.class);
//			cr.select(root).where(root.get("aluno").equals(aluno));
//			return avaliacaoFisicaRepository.findAllByAluno(aluno);
		}
		return null;
	}

}
