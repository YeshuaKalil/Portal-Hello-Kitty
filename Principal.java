import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CADASTRO PESSOA:\n");
        System.out.print("Nome: ");
        String nomePessoa = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfPessoa = scanner.nextLine();
        System.out.print("Telefone (deixe vazio se não tiver): ");
        String telefonePessoa = scanner.nextLine();
        Pessoa pessoa;
        if (telefonePessoa.isEmpty()) {
            pessoa = new Pessoa(nomePessoa, cpfPessoa);
        } else {
            pessoa = new Pessoa(nomePessoa, cpfPessoa, telefonePessoa);
        }

        System.out.println("\n CADASTRO ALUNO:\n");
        System.out.print("Nome: ");
        String nomeAluno = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfAluno = scanner.nextLine();
        System.out.print("Telefone (opcional): ");
        String telefoneAluno = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Nota 1: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Nota 2: ");
        double nota2 = scanner.nextDouble();
        scanner.nextLine();
        Aluno aluno;
        if (telefoneAluno.isEmpty()) {
            aluno = new Aluno(nomeAluno, cpfAluno, matricula, nota1, nota2);
        } else {
            aluno = new Aluno(nomeAluno, cpfAluno, telefoneAluno, matricula, nota1, nota2);
        }

        System.out.println("CADASTRO PROFESSOR:\n");
        System.out.print("Nome: ");
        String nomeProf = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfProf = scanner.nextLine();
        System.out.print("Telefone (opcional): ");
        String telefoneProf = scanner.nextLine();
        System.out.print("Quantidade de Horas: ");
        int qtdHoras = scanner.nextInt();
        System.out.print("Valor por Hora: ");
        double valorHora = scanner.nextDouble();

        Professor professor;
        if (telefoneProf.isEmpty()) {
            professor = new Professor(nomeProf, cpfProf, null, qtdHoras, valorHora);
        } else {
            professor = new Professor(nomeProf, cpfProf, telefoneProf, qtdHoras, valorHora);
        }

        System.out.println("Dados Pessoa:");
        pessoa.exibir();

        System.out.println("Dados Aluno:");
        aluno.exibir();

        System.out.println("Dados Professor:");
        professor.exibir();

        scanner.close();
    }
}
