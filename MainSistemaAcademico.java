package sistemaAcademico;

public class MainSistemaAcademico {

	public static void main(String[] args) {
		Aluno.cadastrarAluno();
		Aluno.imprimirAlunos();

		Professor.cadastrarProfessor();
		Professor.imprimirProfessores();

		Academico.imprimirAniversarios();

		Disciplina.cadastrarDisciplina();
		Disciplina.imprimirDisciplinas();

		Turma.criarTurma();
	}

}