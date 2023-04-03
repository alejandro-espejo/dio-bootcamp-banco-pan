package me.dio.academiadigital.service;

import java.util.List;

import me.dio.academiadigital.entity.AvaliacaoFisica;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaForm;
import me.dio.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;

public interface IAvaliacaoFisicaService {

	/**
	 * Cria uma Avaliação Física e salva no banco de dados.
	 * 
	 * @param form - formulário referente aos dados para criação da Avaliação Física
	 *             no banco de dados
	 * @return Avaliação Física recém-criada.
	 */
	AvaliacaoFisica create(AvaliacaoFisicaForm form);

	/**
	 * Retorna uma Avaliação Física que está no banco de dados de acordo com seu Id.
	 * 
	 * @param id - id da AvaliacaoFisica de acordo com o Id fornecido
	 * @return Avaliação Física de acordo com o Id fornecido.
	 */
	AvaliacaoFisica get(Long id);

	/**
	 * Retorna todas as Avalições Físicas que estão no banco de dados.
	 * 
	 * @return uma lista com todas as avaliações Físicas que estão salvas no DB.
	 */
	List<AvaliacaoFisica> getAll();

	/**
	 * Atualiza a Avaliação Física.
	 * 
	 * @param id         - id da Avaliação Física que será atualizada.
	 * @param formUpdate - formulário referente aos dados necessários para
	 *                   atualização da Avaliação Física.
	 * @return - Avaliação Física recém-atualizada.
	 */
	AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

	/**
	 * Deleta uma avaliação Física específica.
	 * 
	 * @param id - id da Avaliação Física que será removida.
	 */
	void delete(Long id);
}
