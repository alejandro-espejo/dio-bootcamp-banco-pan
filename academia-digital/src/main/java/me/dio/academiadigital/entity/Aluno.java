package me.dio.academiadigital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@Proxy(lazy = false)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "cpf", unique = true, nullable = false)
	private String cpf;
	
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	@Column(name = "data_de_nascimento", nullable = false)
	private LocalDate dataDeNascimento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno")
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
}
