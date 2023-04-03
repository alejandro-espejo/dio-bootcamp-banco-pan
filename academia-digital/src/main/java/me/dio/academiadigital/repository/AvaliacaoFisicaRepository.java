package me.dio.academiadigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;

@Repository
public interface AvaliacaoFisicaRepository
		extends JpaRepository<AvaliacaoFisica, Long> {

	@Query(value = "SELECT af FROM AvaliacaoFisica af WHERE af.aluno = :pAluno")
	List<AvaliacaoFisica> findAllByAluno(@Param(value = "pAluno") Aluno aluno);

}
