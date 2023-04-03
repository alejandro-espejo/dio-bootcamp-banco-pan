package me.dio.academiadigital.service;

import java.util.List;

import me.dio.academiadigital.entity.Matricula;
import me.dio.academiadigital.entity.form.MatriculaForm;

public interface IMatriculaService {

	/**
	 * Cria uma Matricula e salva no banco de dados.
	 * 
	 * @param form - Formulário referente aos dados para criação da Matrícula no
	 *             banco de dados.
	 * @return - Matrícula recém-criada.
	 */
	Matricula create(MatriculaForm form);

	/**
	 * Retorna ua Matrícula que está no banco de dados de acordo com seu Id.
	 * 
	 * @param id - id da Matricula que será exibida
	 * @return - Matrícula de acordo com o Id fornecido.
	 */
	Matricula get(Long id);

	/**
	 * Retorna todas as Matrículas que estão no banco de dados.
	 * 
	 * @return a list with all Enrollment who are save in DB.
	 */
	List<Matricula> getAll(String bairro);

	/**
	 * Remove a specific Enrollment
	 * 
	 * @param id - id of Enrollment that will be removed.
	 */
	void delete(Long id);
}
