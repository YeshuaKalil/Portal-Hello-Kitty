public class Professor extends Pessoa {
    protected int qtdHoras;
    protected double valorHora;
    protected double salario;

    public Professor(String nome, String cpf, String telefone, int qtdHoras, double valorHora) {
        super(nome, cpf, telefone);
        this.qtdHoras = qtdHoras;
        this.valorHora = valorHora;
        calcularSalario();
    }

    public void calcularSalario() {
        salario = qtdHoras * valorHora;
    }

    public void exibir() {
        super.exibir();
        System.out.println("Quantidade de Horas: " + qtdHoras);
        System.out.println("Valor por Hora: " + valorHora);
        System.out.println("Salário: " + salario);
    }
}
