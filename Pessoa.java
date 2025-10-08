package extra;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected String telefone;

    public Pessoa(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = null;
    }

    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        if (telefone != null) {
            System.out.println("Telefone: " + telefone);
        }
    }
