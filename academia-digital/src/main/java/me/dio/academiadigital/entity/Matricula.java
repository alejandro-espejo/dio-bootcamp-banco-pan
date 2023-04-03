package me.dio.academiadigital.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matricula", nullable = false)
	private Long id;

	@JoinColumn(name = "aluno_id", referencedColumnName = "id_aluno", nullable = false)
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Aluno aluno;

	@Column(name = "data_da_matricula", nullable = false)
	private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
