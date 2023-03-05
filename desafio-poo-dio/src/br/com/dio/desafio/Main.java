package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {

		Curso curso = new Curso();
		curso.setTitulo("Curso de Java");
		curso.setDescricao("Descrição de curso Java");
		curso.setCargaHoraria(8);

		Curso curso2 = new Curso();
		curso2.setTitulo("Curso de Javascript");
		curso2.setDescricao("Descrição de curso Javascript");
		curso2.setCargaHoraria(8);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Mentoria de Java");
		mentoria.setDescricao("Descrição mentoria de Java");
		mentoria.setData(LocalDate.now());

//		System.out.println(curso);
//		System.out.println(curso2);
//		System.out.println(mentoria);

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);

		Dev dev = new Dev();
		dev.setNome("Novo Dev");
		dev.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos Inscritos Dev" + dev.getConteudosInscritos());
		dev.progredir();
		dev.progredir();
		System.out.println("Conteúdos Inscritos Dev" + dev.getConteudosInscritos());
		System.out.println("Conteúdos Inscritos Dev" + dev.getConteudosConcluidos());
		System.out.println("XP: " + dev.calcularXp());

		System.out.println();
		Dev dev2 = new Dev();
		dev2.setNome("Novo Dev 2");
		dev2.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos Inscritos Dev2" + dev2.getConteudosInscritos());
		dev2.progredir();
		dev2.progredir();
		dev2.progredir();
		System.out.println("Conteúdos Inscritos Dev2" + dev2.getConteudosInscritos());
		System.out.println("Conteúdos Inscritos Dev2" + dev2.getConteudosConcluidos());
		System.out.println("XP: " + dev2.calcularXp());
	}
}
