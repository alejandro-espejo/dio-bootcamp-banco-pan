package me.dio.academiadigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.dio.academiadigital.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	/**
	 * 
	 * @param bairro - referência para o filtro
	 * @return lista de alunos matriculados que residem no bairro passado como
	 *         parâmetro.
	 */
	@Query(value = "SELECT * FROM tb_matriculas m INNER JOIN tb_alunos a "
			+ "ON m.aluno_id = a.id_aluno WHERE a.bairro = :pBairro", nativeQuery = true)
	//@Query(value = "FROM Matricula m WHERE m.aluno.bairro = :pBairro")
	List<Matricula> findAlunosMatriculadosBairro(@Param(value = "pBairro") String bairro);

	List<Matricula> findByAlunoBairro(String bairro);
}
