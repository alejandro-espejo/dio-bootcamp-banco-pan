package me.dio.academiadigital.entity.form;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaForm {

	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "O Id do aluno precisa ser positivo.")
	private Long alunoId;
	
	@NotNull(message = "Preencha o campo corretamente")
	@Positive(message = "'${validatedValue}' precisa ser positivo.")
	private double peso;
	
	@NotNull(message = "Preencha o campo corretamente")
	@Positive(message = "'${validatedValue}' precisa ser positivo.")
	@DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
	private double altura;
}
