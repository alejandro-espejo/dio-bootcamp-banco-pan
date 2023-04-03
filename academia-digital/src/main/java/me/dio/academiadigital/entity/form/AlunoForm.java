package me.dio.academiadigital.entity.form;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String nome;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@CPF(message = "'${validatedValue}' é inválido!")
	private String cpf;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String bairro;
	
	@NotNull(message = "Preencha o campo corretamente")
	@Past(message = "Data '${validatedValue}' é inválida.")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataDeNascimento;
}
