
package cursojava.executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classes.Secretario;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.excecoes.ExcecaoProcessarNota;
import cursojava.interfaces.PermitirAcesso;
/*
public class primeiraClasseJava {
	
	public static void main(String[] args) {
		
		try {

			// lerArquivo();
			
			String login = JOptionPane.showInputDialog("Informe o login:");
			String senha = JOptionPane.showInputDialog("Informe a senha:");
			
			if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar() || new FuncaoAutenticacao(new Secretario(login, senha)).autenticar()) {
				
				// List<Aluno> alunos = new ArrayList<Aluno>();
				List<Aluno> alunos = null;
				
				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
				
				int qtdAlunos = Integer.valueOf(JOptionPane.showInputDialog("Quantos alunos serão adicionados?"));
				
				for (int qtd = 1; qtd <= qtdAlunos; qtd++) {
				
					// new Aluno() é uma instância -> Criação de objetos
					
					String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + "?");
					String idade = JOptionPane.showInputDialog("Qual a idade?");
					/*String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno?");
					String rg = JOptionPane.showInputDialog("Qual o RG do aluno?");
					String cpf = JOptionPane.showInputDialog("Qual o CPF do aluno?");
					String nomeMae = JOptionPane.showInputDialog("Qual o nome da mãe do aluno?");
					String nomePai = JOptionPane.showInputDialog("Qual o nome do pai do aluno?");
					String matricula = JOptionPane.showInputDialog("Qual a matrícula do aluno?");
					String serie = JOptionPane.showInputDialog("Qual a serie do aluno?");
					String nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola do aluno?");
					
					// Aluno aluno1 = new Aluno(null);
					
					aluno1.setNome(nome);
					aluno1.setIdade(Integer.parseInt(idade));
					aluno1.setDataNascimento(dataNascimento);
					aluno1.setRegistroGeral(rg);
					aluno1.setNumeroCpf(cpf);
					aluno1.setNomeMae(nomeMae);
					aluno1.setNomePai(nomePai);
					aluno1.setDataMatricula(matricula);
					aluno1.setSerieMatriculado(serie);
					aluno1.setNomeEscola(nomeEscola);
					
					int qtdDisc = Integer.valueOf(JOptionPane.showInputDialog("Quantas disciplinas serão adicionados?"));
					
					for (int i = 1; i <= qtdDisc; i++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + i + ".");
						String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + i + ".");
						Disciplina disciplina = new Disciplina();
						
						disciplina.setDisciplina(nomeDisciplina);
						//disciplina.setNota(Double.valueOf(notaDisciplina));
						
						aluno1.getDisciplina().add(disciplina);
					}
					
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
					
					if (escolha == 0) {
						
						int continuarRemover = 0;
						int posicao = 1;
						
						while (continuarRemover == 0) {
							String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina (1, 2, 3, 4)");
							aluno1.getDisciplina().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
							posicao++;
							continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
						}
					}
					
					alunos.add(aluno1);
				}
				
				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
				
				for (Aluno aluno : alunos) {
					if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
					} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
						maps.get(StatusAluno.RECUPERACAO).add(aluno);
					} else {
						maps.get(StatusAluno.REPROVADO).add(aluno);
					}
				}
				
				System.out.println("--- Lista dos aprovados ---");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out.println("Nome: " + aluno.getNome());
					System.out.println("Resultado: " + aluno.getAlunoAprovado());
					System.out.println("Média: " + aluno.getMediaNota());
				}
				
				System.out.println("--- Lista dos em recuperação ---");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out.println("Nome: " + aluno.getNome());
					System.out.println("Resultado: " + aluno.getAlunoAprovado());
					System.out.println("Média: " + aluno.getMediaNota());
				}
				
				System.out.println("--- Lista dos reprovados ---");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out.println("Nome: " + aluno.getNome());
					System.out.println("Resultado: " + aluno.getAlunoAprovado());
					System.out.println("Média: " + aluno.getMediaNota());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Acesso não permitido.");
			}
		} catch (Exception e) {
			StringBuilder saida = new StringBuilder();
			
			e.printStackTrace();
			
			System.out.println("Mensagem: " + e.getMessage());
			
			for (int pos = 0; pos < e.getStackTrace().length; pos++) {
				saida.append("\n Classe de erro: " + e.getStackTrace()[pos].getClassName());
				saida.append("\n Método de erro: " + e.getStackTrace()[pos].getMethodName());
				saida.append("\n Linha de erro: " + e.getStackTrace()[pos].getLineNumber());
				saida.append("\n Class: " + e.getClass().getName());
			}
			
			JOptionPane.showMessageDialog(null, "Erro ao processar notas." + saida);
		} finally {
			JOptionPane.showMessageDialog(null, "Deu erro mas tudo certo.");

		}
	}
	}
	
	public static void lerArquivo() throws ExcecaoProcessarNota {
		try {
			File fil = new File("c://lines.txt");
			Scanner scanner = new Scanner(fil);
		} catch (FileNotFoundException e) {
			throw new ExcecaoProcessarNota(e.getMessage());
		}
	}*/

