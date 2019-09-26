package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ArrayVetor {
	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setNome("Gionai");
		aluno.setNomeEscola("JdevTreinamento");

		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Curso de Java");

		double notasCursoJava[] = { 9.1, 9.2, 8.3, 8.5 };
		double notasLogica[] = { 9.5, 7.4, 8.2, 6.8 };

		disciplina.setNota(notasCursoJava);

		aluno.getDisciplinas().add(disciplina);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Logica");
		disciplina2.setNota(notasLogica);

		aluno.getDisciplinas().add(disciplina2);

		System.out.println("Nome do aluno :" + aluno.getNome() + " inscrito no curso : " + aluno.getNomeEscola());
		System.out.println("------------Disciplinas do Aluno-------------");
		for (Disciplina d : aluno.getDisciplinas()) {
			System.out.println(d.getDisciplina());

			double notaMax = 0.0;

			for (int pos = 0; pos < d.getNota().length; pos++) {
				System.out.println(" A nota " + (pos + 1) + " é = " + d.getNota()[pos]);
				if (pos == 0) {
					notaMax = d.getNota()[pos];
				} else {
					if (notaMax < d.getNota()[pos]) {
						notaMax = d.getNota()[pos];
					}
				}

			}

			System.out.println("A maior nota da disciplina é " + notaMax);
		}

	}
}