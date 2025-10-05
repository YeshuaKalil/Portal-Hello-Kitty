// Gustavo Beirão Vinagre da Nobrega Santos
// João Vitor Antunes dos Santos
// Ricardo Yeshua Cavalcante Kalil
package pessoas;

import escola.*;

public class Professor extends Pessoa{
	private String regisProf;
	private Disciplina[] disc;

	public Professor(String nome, String CPF, String telefone, String email, int idade, String regisProf, Disciplina[] disc) {
		super(nome, CPF, telefone, email, idade);
		this.regisProf = regisProf;
		this.disc = disc;
	}
	
	public void exibir() {
		System.out.println(getNome());
		System.out.println(getCPF());
		System.out.println(getTelefone());
		System.out.println(getEmail());
		System.out.println(getIdade());
		System.out.println(getRegisProf());
		
		for(int i = 0; i < this.disc.length; i++) {
			if(this.disc[i] != null) {
				System.out.println(this.disc[i].getNome());
			}
		}
	}

	public String getRegisProf() {
		return regisProf;
	}

	public void setRegisProf(String regisProf) {
		this.regisProf = regisProf;
	}
}
