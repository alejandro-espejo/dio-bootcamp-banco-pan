package me.dio.academiadigital.repository;

import java.util.List;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;

public interface AvaliacaoFisicaRepositoryCustom {

	List<AvaliacaoFisica> findAllByAluno( Aluno aluno);
}
