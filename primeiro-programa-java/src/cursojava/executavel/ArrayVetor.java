package cursojava.executavel;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ArrayVetor {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno(null);
		aluno.setNome("Carlos Daniel");
		aluno.setNomeEscola("Análise de Sistemas");
		
		double[] notas = {4, 8, 7.5, 9};		
		double[] notas2 = {7, 7.8, 10, 8};		
		double[] notas3 = {9, 8.6, 5, 9.3};			
		
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Java");		
		disciplina.setNota(notas);
		
		aluno.getDisciplina().add(disciplina);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Javascript");
		disciplina2.setNota(notas2);
		
		aluno.getDisciplina().add(disciplina2);

		Disciplina disciplina3 = new Disciplina();
		disciplina3.setDisciplina("HTML e CSS");	
		disciplina3.setNota(notas3);
		
		aluno.getDisciplina().add(disciplina3);
		
		//---------------------------------------
		Aluno[] arrayAlunos = new Aluno[1];
		
		arrayAlunos[0] = aluno;
		
		for (int pos = 0; pos < arrayAlunos.length; pos++) {
			
			System.out.println(arrayAlunos[pos].getNome());
			
		}
		
		/*
		System.out.println("Nome do aluno: " + aluno.getNome());
		System.out.println("Curso do aluno: " + aluno.getNomeEscola());
		System.out.println("------ Desempenho ------");
		
		
		for (Disciplina d : aluno.getDisciplina()) {
			double maiorNota = 0;
			int posMaiorNota = 0;
			double menorNota = Double.POSITIVE_INFINITY;
			int posMenorNota = 0;
			
			System.out.println("\nDisciplina: " + d.getDisciplinas());
			System.out.println("As notas da disciplina são:");
			
			for (int i = 0; i < d.getNota().length; i++) {
				System.out.println("Nota " + i + ": " + d.getNota()[i]);
				if (d.getNota()[i] > maiorNota) {
					maiorNota = d.getNota()[i];
					posMaiorNota = i;
				} else
					if (d.getNota()[i] < menorNota) {
						menorNota = d.getNota()[i];
						posMenorNota = i;
					}
			}
			System.out.println("A maior nota foi " + maiorNota);
			System.out.println("A menor nota foi " + menorNota);
		}
		*/
	}
}
