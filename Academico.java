package sistemaAcademico;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Academico {

	public static ArrayList<Academico> academicos = new ArrayList<>();
	private String nome;
	private LocalDate dataDeNascimento;
	private String login;

	Academico(String nome, LocalDate DataDeNascimento, String login) {
		this.nome = nome;
		this.dataDeNascimento = DataDeNascimento;
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return dataDeNascimento;
	}

	public void setNascimento(LocalDate DataDeNascimento) {
		this.dataDeNascimento = DataDeNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login + "@uniriotec.br";
	}

	public static void imprimirAniversarios() {
		ArrayList<Academico> academicosOrdenados = academicos;
		Academico aux;

		// Organizando mês de aniverário
		for (int cont = 0; cont < academicosOrdenados.size(); cont++) {
			for (int posicao = 1; posicao < academicosOrdenados.size() - cont; posicao++) {
				if (academicosOrdenados.get(posicao).dataDeNascimento
						.getMonthValue() < academicosOrdenados.get(posicao - 1).dataDeNascimento.getMonthValue()) {
					aux = academicosOrdenados.get(posicao - 1);
					academicosOrdenados.set(posicao - 1, academicosOrdenados.get(posicao));
					academicosOrdenados.set(posicao, aux);
				}
			}
		}

		// Organizando dia de aniverário
		for (int xpto = 0; xpto < academicosOrdenados.size(); xpto++) {
			for (int posicao = 1; posicao < academicosOrdenados.size() - xpto; posicao++) {
				if (academicosOrdenados.get(posicao).dataDeNascimento
						.getMonthValue() == academicosOrdenados.get(posicao - 1).dataDeNascimento.getMonthValue()
						&& academicosOrdenados.get(posicao).dataDeNascimento
								.getDayOfMonth() < academicosOrdenados.get(posicao - 1).dataDeNascimento.getDayOfMonth()) {
					aux = academicosOrdenados.get(posicao - 1);
					academicosOrdenados.set(posicao - 1, academicosOrdenados.get(posicao));
					academicosOrdenados.set(posicao, aux);
				}
			}
		}

		for (Academico academico : academicosOrdenados) {
			System.out.println(academico.getNome() + " " + academico.dataDeNascimento.getDayOfMonth() + "/"
					+ academico.dataDeNascimento.getMonthValue());
		}
	}
}