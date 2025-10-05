// Gustavo Beirão Vinagre da Nobrega Santos
// João Vitor Antunes dos Santos
// Ricardo Yeshua Cavalcante Kalil
package pessoas;

public abstract class Pessoa {
	protected String nome;
	protected String CPF;
	protected String telefone;
	protected String email;
	protected int idade;
	
	public Pessoa(String nome, String CPF, String telefone, String email, int idade) {
		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
		this.email = email;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public abstract void exibir();
}
