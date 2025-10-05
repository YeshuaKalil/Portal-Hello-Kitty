// Gustavo Beirão Vinagre da Nobrega Santos
// João Vitor Antunes dos Santos
// Ricardo Yeshua Cavalcante Kalil
package principal;

import java.awt.*;

import javax.swing.*;

import escola.*;
import pessoas.*;
import paginas.*;

public class Principal {
	private static JFrame frame;
	private static JPanel cards;
	private static CardLayout cardLayout;
	
	private static MenuPage menu;
	private static RegAlunoPage regAlunoPag;
	private static RegDiscPage regDiscPag;
	private static RegProfPage regProfPag;
	
	private static Aluno[] alunos;
	private static Professor[] professores;
	private static Disciplina[] disciplinas;
	private static Turma[] turmas;
	
	
	public static void regAlunoMenu() {
		cardLayout.show(cards, "Registrar Aluno");
	}
	
	public static void regProfMenu() {
		cardLayout.show(cards, "Registrar Professor");
		regProfPag.setup();
	}
	
	public static void regDiscMenu() {
		cardLayout.show(cards, "Registrar Disciplina");
	}
	
	public static void listTurmaMenu() {
		int i = 0;
		while(i<alunos.length) {
			if(alunos[i] != null) {
				alunos[i].exibir();
			} 
			i++;
		}
		i = 0;
		while(i<professores.length) {
			if(professores[i] != null) {
				professores[i].exibir();
			} 
			i++;
		}
	}
	
	public static void sairMenu() {
		frame.dispose();
		System.exit(0);
	}
	
	public static void voltarMenu() {
		cardLayout.show(cards, "Menu");
	}
	
	public static void registrarAluno(RegAlunoPage regAlunoPag, String nome, String CPF, String telefone, String email, int idade, String matr) {
		encaixarLista(regAlunoPag, alunos, nome, CPF, telefone, email, idade, matr);
		cardLayout.show(cards, "Menu");
	}
	
	public static void registrarDisc(RegDiscPage regDiscPag, String nome) {
		encaixarLista(regDiscPag, disciplinas, nome);
		cardLayout.show(cards, "Menu");
	}
	
	public static void registrarProf(RegProfPage regProfPag, String nome, String CPF, String telefone, String email, int idade, String regisProf, Disciplina[] disc) {
		encaixarLista(regProfPag, professores, nome, CPF, telefone, email, idade, regisProf, disc);
		cardLayout.show(cards, "Menu");
	}
	
	public static void main(String[] args) {
		
		alunos = new Aluno[20];
		professores = new Professor[10];
		disciplinas = new Disciplina[10];
		turmas = new Turma[10];
		
		frame = new JFrame("Gerenciamento Escolar");
		frame.setSize(500, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
		
		
        menu = new MenuPage(frame);
		cards.add(menu, "Menu");
		
		regAlunoPag = new RegAlunoPage(frame);
		cards.add(regAlunoPag, "Registrar Aluno");
		
		regProfPag = new RegProfPage(frame);
		cards.add(regProfPag, "Registrar Professor");
		
		regDiscPag = new RegDiscPage(frame);
		cards.add(regDiscPag, "Registrar Disciplina");
		
		frame.add(cards);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

	

	public static Aluno[] getAlunos() {
		return alunos;
	}

	public static void setAlunos(Aluno[] alunos) {
		Principal.alunos = alunos;
	}

	public static Professor[] getProfessores() {
		return professores;
	}

	public static void setProfessores(Professor[] professores) {
		Principal.professores = professores;
	}

	public static Disciplina[] getDisciplinas() {
		return disciplinas;
	}

	public static void setDisciplinas(Disciplina[] disciplinas) {
		Principal.disciplinas = disciplinas;
	}

	public static Turma[] getTurmas() {
		return turmas;
	}

	public static void setTurmas(Turma[] turmas) {
		Principal.turmas = turmas;
	}

	private static void encaixarLista(JPanel regAlunoPag, Aluno[] alunos, String nome, String CPF, String telefone, String email, int idade, String matr) {
		boolean loop = true;
		int i = 0;
		while(loop) {
			if(alunos[i] == null) {
				Aluno aluno = new Aluno(nome, CPF, telefone, email, idade, matr);
				alunos[i] = aluno;
				loop = false;
			} else {
				if((i+1) == alunos.length) {
					JOptionPane.showMessageDialog(regAlunoPag, "Não é possível registrar um aluno (lista cheia)");
					loop = false;
				}
			}
			i++;
		}
	}
	
	private static void encaixarLista(JPanel regProfPag, Professor[] Professores, String nome, String CPF, String telefone, String email, int idade, String regisProf, Disciplina[] disc) {
		boolean loop = true;
		int i = 0;
		while(loop) {
			if(professores[i] == null) {
				Professor professor = new Professor(nome, CPF, telefone, email, idade, regisProf, disc);
				professores[i] = professor;
				loop = false;
			} else {
				if((i+1) == professores.length) {
					JOptionPane.showMessageDialog(regProfPag, "Não é possível registrar um professor (lista cheia)");
					loop = false;
				}
			}
			i++;
		}
	}
	
	private static void encaixarLista(RegDiscPage regDiscPag, Disciplina[] disciplinas, String nome) {
		boolean loop = true;
		int i = 0;
		while(loop) {
			if(disciplinas[i] == null) {
				Disciplina disciplina = new Disciplina(nome);
				disciplinas[i] = disciplina;
				loop = false;
			} else {
				if((i+1) == disciplinas.length) {
					JOptionPane.showMessageDialog(regDiscPag, "Não é possível registrar uma disciplina (lista cheia)");
					loop = false;
				}
			}
			i++;
		}
	}
}
