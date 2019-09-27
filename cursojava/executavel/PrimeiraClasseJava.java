package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Autenticar;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<Aluno>();
		/*
		 * Hashmap é uma lista que dentro dela temos uma chave que identifica uma
		 * sequencia de valores tbm
		 */
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
		Diretor diretor = new Diretor();
		
		diretor.setLogin(JOptionPane.showInputDialog("LOGIN:"));
		diretor.setSenha(JOptionPane.showInputDialog("SENHA:"));
		
		if(new Autenticar(diretor).autenticar()) {
			
		for (int qtd = 1; qtd <= 2; qtd++) {

			String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
			String idade = JOptionPane.showInputDialog("Qual a idade?");
			/*
			 * String dataNascimento =
			 * JOptionPane.showInputDialog("Qual a data de Nascimento?"); String
			 * RegistroGeral = JOptionPane.showInputDialog("Qual o RG?"); String numeroCpf =
			 * JOptionPane.showInputDialog("Qual o Cpf?"); String NomeEscola =
			 * JOptionPane.showInputDialog("Qual o Nome da Escola?");
			 */

			Aluno aluno1 = new Aluno();

			/* aluno1.setNumeroCpf(numeroCpf); */
			aluno1.setNome(nome);
			aluno1.setIdade(Integer.valueOf(idade));
			/*
			 * aluno1.setRegistroGeral(RegistroGeral);
			 * aluno1.setDataNascimento(dataNascimento); aluno1.setNomeMae("Rosemaria");
			 * aluno1.setNomePai("José"); aluno1.setDataMatricula("20/05/2019");
			 * aluno1.setNomeEscola(NomeEscola);
			 */

			for (int pos = 1; pos <= 2; pos++) {

				Disciplina disc = new Disciplina();

				double nota[] = new double[disc.getNota().length];

				String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
				String nota1 = JOptionPane.showInputDialog("Qual a nota do primeiro Bimestre?");
				String nota2 = JOptionPane.showInputDialog("Qual a nota do segundo Bimestre?");
				String nota3 = JOptionPane.showInputDialog("Qual a nota do terceiro Bimestre?");
				String nota4 = JOptionPane.showInputDialog("Qual a nota do quarto Bimestre?");

				nota[0] = Integer.parseInt(nota1);
				nota[1] = Integer.parseInt(nota2);
				nota[2] = Integer.parseInt(nota3);
				nota[3] = Integer.parseInt(nota4);

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(nota);

				aluno1.getDisciplinas().add(disciplina);

			}

			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina");

			if (escolha == 0)/* Opção sim é == 0 */ {

				int continuaRemover = 0;
				int posicao = 1;
				while (continuaRemover == 0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3, 4 ?");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuaRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
				}

			}
			alunos.add(aluno1);
		}

		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

		for (Aluno aluno : alunos) { /* Separei em Listas */
			if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
				maps.get(StatusAluno.APROVADO).add(aluno);

			} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				maps.get(StatusAluno.RECUPERACAO).add(aluno);
			} else
				maps.get(StatusAluno.REPROVADO).add(aluno);

		}

		System.out.println("-------- Lista dos Alunos Aprovados -----------");

		for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
			System.out.println("Aluno " + aluno.getNome() + " " + aluno.getAlunoAprovado() + " " + "Com média de = "
					+ aluno.getMediaNota());
		}

		System.out.println("-------- Lista dos Alunos de Reprovados -----------");
		for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
			System.out.println("Aluno " + aluno.getNome() + " " + aluno.getAlunoAprovado() + " " + "Com média de = "
					+ aluno.getMediaNota());
		}
		System.out.println("-------- Lista dos Alunos de Recuperação -----------");
		for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
			System.out.println("Aluno " + aluno.getNome() + " " + aluno.getAlunoAprovado() + " " + "Com média de = "
					+ aluno.getMediaNota());
		}

	 }else {
		 JOptionPane.showMessageDialog(null, "LOGIN OU SENHA INCORRETO");
	 }
}

}