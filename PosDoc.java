package sistemaAcademico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PosDoc extends Academico implements InterfaceAcademico {
	private int matricula;
	public ArrayList<String> linhaDePesquisa;
	public static ArrayList<PosDoc> posDoutores = new ArrayList<>();

	PosDoc(String nome, LocalDate DataDeNascimento, String login, int matricula) {
		super(nome, DataDeNascimento, login);
		this.matricula = matricula;
		linhaDePesquisa = new ArrayList<>();
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public static PosDoc buscar(int matricula) {
		for (int cont = 0; cont < posDoutores.size(); cont++) {
			if (posDoutores.get(cont).getMatricula() == matricula) {
				return posDoutores.get(cont);
			}
		}
		return null;
	}

	public boolean podeSerMonitor(Disciplina disciplina) {
		return true;
	}

	public static void cadastrarPosDoc() {
		Scanner in = new Scanner(System.in);
		int matricula, dia, mes, ano;
		String nome, login, linhaDePesquisa = null;
		PosDoc posDoc = null;

		System.out.println("Insira a matrícula do(a) pesquisador(a) de pós-doutorado.");
		matricula = in.nextInt();
		System.out.println("Insira o dia, mês e ano do(a) pesquisador(a) de pós-doutorado.");
		dia = in.nextInt();
		mes = in.nextInt();
		ano = in.nextInt();
		System.out.println("Insira o nome do(a) pesquisador(a) de pós-doutorado.");
		nome = in.nextLine();
		System.out.println("Insira o login do(a) pesquisador(a) de pós-doutorado.");
		login = in.nextLine();

		posDoc = new PosDoc(nome, LocalDate.of(ano, mes, dia), login, matricula);

		System.out.println("Insira os tópicos de pesquisa do(a) pesquisador(a) de pós-doutorado.");
		System.out.println("Caso não deseje inserir mais digite FIM.");

		while (linhaDePesquisa != "FIM") {
			linhaDePesquisa = in.nextLine();
			posDoc.linhaDePesquisa.add(linhaDePesquisa);
		}
	}
}