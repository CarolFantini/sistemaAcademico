package sistemaAcademico;

import java.util.ArrayList;
import java.util.Scanner;

public class Disciplina {
	public static ArrayList<Disciplina> disciplinas = new ArrayList<>();
	private String nome;
	private String codigo;
	private String ementa;
	private int cargaHorariaSemanal;
	private Professor responsavel;

	Disciplina(String nome, String codigo, String ementa, int cargaHoraria, Professor responsavel) {
		this.nome = nome;
		this.codigo = codigo;
		this.ementa = ementa;
		cargaHorariaSemanal = cargaHoraria;
		this.responsavel = responsavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public int getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}

	public Professor getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Professor responsavel) {
		this.responsavel = responsavel;
	}

	public static Disciplina buscar(String disciplina) {
		for (int cont = 0; cont < disciplinas.size(); cont++) {
			if (disciplinas.get(cont).getNome() == disciplina) {
				return disciplinas.get(cont);
			}
		}
		return null;
	}

	public static void cadastrarDisciplina() {
		Scanner in = new Scanner(System.in);
		String nome, codigo, ementa;
		int matriculaResponsavel, cargaHoraria;

		System.out.println("Insira o nome da disciplina.");
		nome = in.nextLine();
		System.out.println("Insira o código da disciplina.");
		codigo = in.nextLine();
		System.out.println("Insira a ementa da disciplina.");
		ementa = in.nextLine();
		System.out.println("Insira a carga horária da disciplina.");
		cargaHoraria = in.nextInt();
		System.out.println("Insira a matrícula SIAPE do professor responsável.");
		matriculaResponsavel = in.nextInt();

		Professor responsavel = Professor.buscar(matriculaResponsavel);
		Disciplina disciplina = new Disciplina(nome, codigo, ementa, cargaHoraria, responsavel);
		disciplinas.add(disciplina);
	}

	public static void imprimirDisciplinas() {
		for (Disciplina disciplina : disciplinas) {
			System.out.println(disciplina.getNome() + " - " + disciplina.responsavel.getNome());
		}
	}
}