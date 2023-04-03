package me.dio.academiadigital.entity.form;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateForm {

	private String nome;
	private String bairro;
	private LocalDate dataDeNascimento;
}
