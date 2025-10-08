public class Aluno extends Pessoa {
    protected String matricula;
    protected double nota1;
    protected double nota2;

    public Aluno(String nome, String cpf, String telefone, String matricula, double nota1, double nota2) {
        super(nome, cpf, telefone);
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Aluno(String nome, String cpf, String matricula, double nota1, double nota2) {
        super(nome, cpf);
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public void exibir() {
        super.exibir();
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Média: " + calcularMedia());
    }
}
