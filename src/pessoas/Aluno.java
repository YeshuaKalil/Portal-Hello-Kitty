// Gustavo Beirão Vinagre da Nobrega Santos
// João Vitor Antunes dos Santos
// Ricardo Yeshua Cavalcante Kalil
package pessoas;

public class Aluno extends Pessoa {
	private String matricula;

	public Aluno(String nome, String CPF, String telefone, String email, int idade, String matricula) {
		super(nome, CPF, telefone, email, idade);
		this.matricula = matricula;
	}
	
	public void exibir() {
		System.out.println("Nome do Aluno: " + getNome());
		System.out.println("CPF do Aluno: " + getCPF());
		System.out.println("Telefone do Aluno: " + getTelefone());
		System.out.println("Email do Aluno: " + getEmail());
		System.out.println("Idade do Aluno: " + getIdade());
		System.out.println("Matrícula do Aluno: " + getMatricula());
		System.out.println();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
