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

		System.out.println("Insira o nome do aluno de p�s gradua��o.");
		nome = in.nextLine();
		// Curso se refere a qual p�s ele est� fazendo. Ex.: P�s-Gradua��o em
		// >Inform�tica<.
		System.out.println("Insira em qual p�s o aluno est� matriculado.");
		curso = in.nextLine();
		System.out.println("Insira o login do aluno de p�s gradua��o.");
		login = in.nextLine();
		System.out.println("Insira o dia, m�s e ano de nascimento do aluno de p�s gradua��o.");
		dia = in.nextInt();
		mes = in.nextInt();
		ano = in.nextInt();
		System.out.println("Insira a matr�cula do aluno de p�s gradua��o.");
		matriculaUNIRIO = in.nextInt();
		System.out.println("Insira o per�odo de entrada do aluno de p�s gradua��o.");
		periodoEntrada = in.nextInt();
		System.out.println("Insira o t�tulo da tese do aluno.");
		tituloTese = in.nextLine();
		System.out.println("Insira a matr�cula do professor orientador do aluno.");
		profOrientador = in.nextInt();

		if (tituloTese == null || tituloTese == "") {
			System.out.println("Precisa ser inserido o t�tulo da tese.");
			tituloTese = in.nextLine();
		}

		if (Professor.buscar(profOrientador) == null) {
			System.out.println("Professor orientador n�o encontrado. Digite a matr�cula novamente.");
			profOrientador = in.nextInt();
		}

		orientador = Professor.buscar(profOrientador);

		alunoPos = new AlunoPos(nome, login, LocalDate.of(ano, mes, dia), matriculaUNIRIO, curso, periodoEntrada,
				orientador, tituloTese);
	}
}