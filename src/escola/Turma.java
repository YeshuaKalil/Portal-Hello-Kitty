// Gustavo Beirão Vinagre da Nobrega Santos
// João Vitor Antunes dos Santos
// Ricardo Yeshua Cavalcante Kalil
package escola;

import pessoas.*;

public class Turma {
	private Aluno[] alunos;
	private Professor prof;
	private Disciplina disc;
	
	public Turma(Aluno[] alunos, Professor prof, Disciplina disc) {
		this.alunos = alunos;
		this.prof = prof;
		this.disc = disc;
	}
}
