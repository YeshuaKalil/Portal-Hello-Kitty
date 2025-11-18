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

    // Método para exibir os dados da turma
    public void exibir() {
        System.out.println("=== Dados da Turma ===");
        
        // Professor
        if (prof != null) {
            System.out.println("Professor: " + prof.getNome() + " (Registro: " + prof.getRegisProf() + ")");
        } else {
            System.out.println("Professor: não definido");
        }

        // Disciplina
        if (disc != null) {
            System.out.println("Disciplina: " + disc.getNome());
        } else {
            System.out.println("Disciplina: não definida");
        }

        // Alunos
        System.out.println("Alunos:");
        if (alunos != null) {
            boolean temAluno = false;
            for (Aluno a : alunos) {
                if (a != null) {
                    System.out.println(" - " + a.getNome() + " (Matrícula: " + a.getMatricula() + ")");
                    temAluno = true;
                }
            }
            if (!temAluno) {
                System.out.println("Nenhum aluno registrado.");
            }
        } else {
            System.out.println("Lista de alunos não inicializada.");
        }
    }

    // Métodos de coleta (getters)
    public Aluno[] getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        return prof;
    }

    public Disciplina getDisciplina() {
        return disc;
    }

    
}
