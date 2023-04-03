package me.dio.academiadigital.service;

import java.util.List;

import me.dio.academiadigital.entity.Aluno;
import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AlunoForm;
import me.dio.academiadigital.entity.form.AlunoUpdateForm;

public interface IAlunoService {

	/**
	 * Cria um Aluno e salva no banco de dados
	 * 
	 * @param form - formulário referente aos dados para criação de um Aluno no
	 *             banco de dados.
	 * @return Aluno.
	 */
	Aluno create(AlunoForm form);

	/**
	 * Retorna um Aluno que está no banco de dados de acordo com seu id.
	 * 
	 * @param id - id do Aluno que será exibido
	 * @return Aluno de acordo com o Id fornecido.
	 */
	Aluno get(Long id);

	/**
	 * Retorna todos os Alunos que estão no banco de dados.
	 * 
	 * @return Uma lista de Alunos que estão salvos no DB.
	 */
	List<Aluno> getAll();

	List<Aluno> getAll(String dataDeNascimento);

	/**
	 * 
	 * @param id
	 * @param formUpdate
	 * @return
	 */
	Aluno update(Long id, AlunoUpdateForm formUpdate);

	/**
	 * Deleta um Aluno específico.
	 * 
	 * @param id - id do Aluno que será removido.
	 */
	void delete(Long id);

	List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long idAluno);
}
