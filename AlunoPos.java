package sistemaAcademico;

import java.time.LocalDate;
import java.util.Scanner;

public class AlunoPos extends Aluno implements InterfaceAcademico {
	private String tituloTese;

	AlunoPos(String nome, String login, LocalDate DataDeNascimento, int matriculaUNIRIO, String curso,
			int periodoEntrada, Professor profOrientador, String tituloTese) {
		super(nome, login, DataDeNascimento, matriculaUNIRIO, curso, periodoEntrada, profOrientador);
		this.tituloTese = tituloTese;
	}

	public String getTituloTese() {
		return tituloTese;
	}

	public void setTituloTese(String tituloTese) {
		this.tituloTese = tituloTese;
	}

	public boolean podeSerMonitor(Disciplina disciplina) {
		boolean permissao;
		if (getOrientador() == disciplina.getResponsavel()) {
			permissao = true;
		} else {
			permissao = false;
		}
		return permissao;
	}

	public static void cadastrarAlunoPos() {
		Scanner in = new Scanner(System.in);
		String nome, tituloTese, curso, login;
		int dia, mes, ano, matriculaUNIRIO, periodoEntrada, profOrientador;
		AlunoPos alunoPos;
		Professor orientador = null;

		System.out.println("Insira o nome do aluno de pós graduação.");
		nome = in.nextLine();
		// Curso se refere a qual pós ele está fazendo. Ex.: Pós-Graduação em
		// >Informática<.
		System.out.println("Insira em qual pós o aluno está matriculado.");
		curso = in.nextLine();
		System.out.println("Insira o login do aluno de pós graduação.");
		login = in.nextLine();
		System.out.println("Insira o dia, mês e ano de nascimento do aluno de pós graduação.");
		dia = in.nextInt();
		mes = in.nextInt();
		ano = in.nextInt();
		System.out.println("Insira a matrícula do aluno de pós graduação.");
		matriculaUNIRIO = in.nextInt();
		System.out.println("Insira o período de entrada do aluno de pós graduação.");
		periodoEntrada = in.nextInt();
		System.out.println("Insira o título da tese do aluno.");
		tituloTese = in.nextLine();
		System.out.println("Insira a matrícula do professor orientador do aluno.");
		profOrientador = in.nextInt();

		if (tituloTese == null || tituloTese == "") {
			System.out.println("Precisa ser inserido o título da tese.");
			tituloTese = in.nextLine();
		}

		if (Professor.buscar(profOrientador) == null) {
			System.out.println("Professor orientador não encontrado. Digite a matrícula novamente.");
			profOrientador = in.nextInt();
		}

		orientador = Professor.buscar(profOrientador);

		alunoPos = new AlunoPos(nome, login, LocalDate.of(ano, mes, dia), matriculaUNIRIO, curso, periodoEntrada,
				orientador, tituloTese);
	}
}