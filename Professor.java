package sistemaAcademico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Academico implements InterfaceAcademico {
	public static ArrayList<Professor> professores = new ArrayList<>();
	private int matriculaSIAPE;
	private String departamento;
	private Aluno orientando;

	Professor(String nome, String login, LocalDate DataDeNascimento, int matriculaSIAPE, String departamento,
			Aluno alunoOrientando) {
		super(nome, DataDeNascimento, login);
		this.matriculaSIAPE = matriculaSIAPE;
		this.departamento = departamento;
		orientando = alunoOrientando;
	}

	public int getMatriculaSIAPE() {
		return matriculaSIAPE;
	}

	public void setMatriculaSIAPE(int matriculaSIAPE) {
		this.matriculaSIAPE = matriculaSIAPE;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Aluno getOrientando() {
		return orientando;
	}

	public void setOrientando(Aluno orientando) {
		this.orientando = orientando;
	}

	public static Professor buscar(int matricula) {
		for (int cont = 0; cont < professores.size(); cont++) {
			if (professores.get(cont).getMatriculaSIAPE() == matricula) {
				return professores.get(cont);
			}
		}
		return null;
	}

	public boolean podeSerMonitor(Disciplina disciplina) {
		boolean permissao;
		if (disciplina.getResponsavel() != this) {
			permissao = true;
		} else {
			permissao = false;
		}
		return permissao;
	}

	public static void cadastrarProfessor() {
		Scanner in = new Scanner(System.in);
		String nome, login, departamento, opcao;
		int dia, mes, ano, matricula, orientando;
		Aluno alunoOrientando = null;

		System.out.println("Insira o nome do professor.");
		nome = in.nextLine();
		System.out.println("Insira o login do professor.");
		login = in.nextLine();
		System.out.println("Insira o dia, mês e ano de nascimento do professor.");
		dia = in.nextInt();
		mes = in.nextInt();
		ano = in.nextInt();
		System.out.println("Insira a matrícula SIAPE do professor.");
		matricula = in.nextInt();
		System.out.println("Insira o departamento do professor.");
		departamento = in.nextLine();
		System.out.println("O professor é orientador de algum aluno? Insira S para Sim e N para Não.");
		opcao = in.nextLine();

		if (opcao == "S") {
			System.out.println("Insira a matrícula do aluno orientando pelo professor.");
			orientando = in.nextInt();

			alunoOrientando = Aluno.buscar(orientando);
		}

		Professor professor = new Professor(nome, login, LocalDate.of(ano, mes, dia), matricula, departamento,
				alunoOrientando);
		professores.add(professor);
		academicos.add(professor);
	}

	public static void imprimirProfessores() {
		for (Professor professor : professores) {
			System.out.println(professor.getNome() + " - " + professor.getMatriculaSIAPE());
		}
	}
}