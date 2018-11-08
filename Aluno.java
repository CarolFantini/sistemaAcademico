package sistemaAcademico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Academico {
	public static ArrayList<Aluno> alunos = new ArrayList<>();
	private int matriculaUNIRIO;
	private String curso;
	private int periodoEntrada;
	private Professor orientador;
	private ArrayList<Turma> disciplinasMatriculadas;

	Aluno(String nome, String login, LocalDate DataDeNascimento, int matriculaUNIRIO, String curso, int periodoEntrada,
			Professor profOrientador) {
		super(nome, DataDeNascimento, login);
		this.matriculaUNIRIO = matriculaUNIRIO;
		this.curso = curso;
		this.periodoEntrada = periodoEntrada;
		orientador = profOrientador;
		disciplinasMatriculadas = new ArrayList<>();
	}

	public int getMatriculaUNIRIO() {
		return matriculaUNIRIO;
	}

	public void setMatriculaUNIRIO(int matriculaUNIRIO) {
		this.matriculaUNIRIO = matriculaUNIRIO;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getPeriodoEntrada() {
		return periodoEntrada;
	}

	public void setPeriodoEntrada(int periodoEntrada) {
		this.periodoEntrada = periodoEntrada;
	}

	public Professor getOrientador() {
		return orientador;
	}

	public void setOrientador(Professor orientador) {
		this.orientador = orientador;
	}

	public static Aluno buscar(int matricula) {
		for (int cont = 0; cont < alunos.size(); cont++) {
			if (alunos.get(cont).getMatriculaUNIRIO() == matricula) {
				return alunos.get(cont);
			}
		}
		return null;
	}

	public void matricularNaDisciplina(Turma turma) {
		if (getPeriodoEntrada() >= turma.getPeriodoDeOferta()) {
			if (!disciplinasMatriculadas.contains(turma)) {
				disciplinasMatriculadas.add(turma);
			}
		}
	}

	public static void cadastrarAluno() {
		Scanner in = new Scanner(System.in);
		String nome, login, curso, opcao;
		int dia, mes, ano, periodoEntrada, orientador;
		Professor profOrientador = null;

		System.out.println("Insira o nome do aluno.");
		nome = in.nextLine();
		System.out.println("Insira o dia, mês e ano de nascimento do aluno.");
		dia = in.nextInt();
		mes = in.nextInt();
		ano = in.nextInt();
		System.out.println("Insira o login do aluno.");
		login = in.nextLine();
		System.out.println("Insira a matrícula do aluno.");
		int matricula = in.nextInt();
		System.out.println("Insira o curso do aluno.");
		curso = in.nextLine();
		System.out.println("Insira o período de ingresso do aluno.");
		periodoEntrada = in.nextInt();
		System.out.println("O aluno tem orientador? Insira S para Sim e N para Não.");
		opcao = in.nextLine();

		if (opcao == "S") {
			System.out.println("Insira a matrícula do professor orientador do aluno.");
			orientador = in.nextInt();

			profOrientador = Professor.buscar(orientador);
		}

		Aluno aluno = new Aluno(nome, login, LocalDate.of(ano, mes, dia), matricula, curso, periodoEntrada,
				profOrientador);
		alunos.add(aluno);
		academicos.add(aluno);
	}

	public static void imprimirAlunos() {
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome() + " - " + aluno.getLogin());
		}
	}
}