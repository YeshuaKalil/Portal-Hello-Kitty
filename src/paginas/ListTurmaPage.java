// Gustavo Beirão Vinagre da Nobrega Santos
// João Vitor Antunes dos Santos
// Ricardo Yeshua Cavalcante Kalil
package paginas;

import java.awt.*;
import javax.swing.*;

import pessoas.Aluno;
import pessoas.Professor;
import escola.Disciplina;
import principal.Principal;
import escola.Turma;

public class ListTurmaPage extends JPanel {

    private JFrame frame;

    public ListTurmaPage(JFrame frame) {
        this.frame = frame;
        setup();
    }

    public void setup() {
        this.removeAll();

        JPanel header = PageSettings.createHeader("Lista de Turmas");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 190, 200));

        Turma[] turmas = Principal.getTurmas();

        if (turmas != null) {
            boolean temTurma = false;
            for (Turma t : turmas) {
                if (t != null) {
                    temTurma = true;

                    Professor prof = t.getProfessor();
                    Disciplina disc = t.getDisciplina();
                    Aluno[] alunos = t.getAlunos();

                    String nomeProf = (prof != null) ? prof.getNome() : "Sem professor";
                    String nomeDisc = (disc != null) ? disc.getNome() : "Sem disciplina";

                    // Monta string com nomes dos alunos separados por ";"
                    StringBuilder nomesAlunos = new StringBuilder();
                    if (alunos != null) {
                        for (Aluno a : alunos) {
                            if (a != null) {
                                if (nomesAlunos.length() > 0) {
                                    nomesAlunos.append("; ");
                                }
                                nomesAlunos.append(a.getNome());
                            }
                        }
                    }
                    if (nomesAlunos.length() == 0) {
                        nomesAlunos.append("Nenhum aluno");
                    }

                    // Cria painel para exibir turma
                    JPanel turmaPanel = new JPanel();
                    turmaPanel.setLayout(new BoxLayout(turmaPanel, BoxLayout.Y_AXIS));
                    turmaPanel.setBackground(new Color(255, 220, 220));
                    turmaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    turmaPanel.add(new JLabel("Professor: " + nomeProf));
                    turmaPanel.add(new JLabel("Disciplina: " + nomeDisc));
                    turmaPanel.add(new JLabel("Alunos: " + nomesAlunos.toString()));

                    turmaPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    panel.add(Box.createVerticalStrut(10));
                    panel.add(turmaPanel);
                }
            }

            if (!temTurma) {
                panel.add(new JLabel("Nenhuma turma cadastrada."));
            }
        } else {
            panel.add(new JLabel("Nenhuma turma cadastrada."));
        }

        JButton voltar = PageSettings.createButton("Voltar", 100);
        voltar.addActionListener(e -> Principal.voltarMenu());
        panel.add(Box.createVerticalStrut(20));
        panel.add(voltar);

        JScrollPane scrollPane = PageSettings.createScroll(panel);

        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.revalidate();
        this.repaint();
    }
}
