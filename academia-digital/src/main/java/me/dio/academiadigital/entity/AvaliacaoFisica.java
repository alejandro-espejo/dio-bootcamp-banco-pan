package me.dio.academiadigital.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY) // , cascade = CascadeType.ALL - Retirei por conta do erro Detached Entity Passed to Persist” Error
	@JoinColumn(name = "aluno_id", referencedColumnName = "id_aluno", nullable = false)
	private Aluno aluno;

	@Column(name = "data_da_avaliacao", nullable = false)
	private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

	@Column(name = "peso_atual", nullable = false)
	private double peso;

	@Column(name = "altura_atual", nullable = false)
	private double altura;

}
