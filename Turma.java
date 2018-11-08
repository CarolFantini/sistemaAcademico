package sistemaAcademico;

import java.util.ArrayList;
import java.util.Scanner;

public class Turma {
	private int periodoDeOferta;
	private int minimoAlunos;
	private Disciplina disciplina;
	private Academico monitor;
	public ArrayList<Aluno> alunosMatriculados;
	private Professor professor;

	Turma(int minimoAlunos, int periodoDeOferta, Professor professor, Disciplina disciplina, Academico nomeMonitor) {
		this.periodoDeOferta = periodoDeOferta;
		this.disciplina = disciplina;
		monitor = nomeMonitor;
		alunosMatriculados = new ArrayList<>();
		this.professor = professor;
		this.minimoAlunos = minimoAlunos;
	}

	public int getMinimoAlunos() {
		return minimoAlunos;
	}

	public void setMinimoAlunos(int minimoAlunos) {
		this.minimoAlunos = minimoAlunos;
	}

	public int getPeriodoDeOferta() {
		return periodoDeOferta;
	}

	public void setPeriodoDeOferta(int periodoDeOferta) {
		this.periodoDeOferta = periodoDeOferta;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Academico getMonitor() {
		return monitor;
	}

	public void setMonitor(Academico monitor) {
		this.monitor = monitor;
	}

	public Academico getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void associarMonitor(Academico academico) {
		if (((InterfaceAcademico) academico).podeSerMonitor(getDisciplina())) {
			setMonitor(academico);
		} else {
			System.out.println("Monitor não pode ser associado.");
		}
	}

	public static void criarTurma() {
		Scanner in = new Scanner(System.in);
		int minimoAlunos, monitor, periodoDeOferta, profMatricula;
		String nomeDisciplina;
		Turma turma;
		Disciplina disciplina = null;
		Professor professor = null;
		Academico nomeMonitor = null;

		System.out.println("Insira o número mínimo de alunos para a turma ser criada.");
		minimoAlunos = in.nextInt();
		System.out.println("Insira o período que a turma será ofertada.");
		periodoDeOferta = in.nextInt();
		System.out.println("Insira o nome da disciplina da turma.");
		nomeDisciplina = in.nextLine();
		System.out.println("Insira a matrícula do monitor da turma.");
		monitor = in.nextInt();
		System.out.println("Insira a matrícula do professor da turma.");
		profMatricula = in.nextInt();

		if (Professor.buscar(monitor) != null) {
			nomeMonitor = Professor.buscar(monitor);
		} else {
			nomeMonitor = Aluno.buscar(monitor);
		}

		professor = Professor.buscar(profMatricula);
		disciplina = Disciplina.buscar(nomeDisciplina);

		turma = new Turma(minimoAlunos, periodoDeOferta, professor, disciplina, nomeMonitor);
	}
}