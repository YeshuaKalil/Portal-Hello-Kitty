// Gustavo Beirão Vinagre da Nobrega Santos
// João Vitor Antunes dos Santos
// Ricardo Yeshua Cavalcante Kalil
package paginas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import pessoas.Aluno;
import pessoas.Professor;
import escola.Disciplina;
import principal.Principal;

public class RegTurmaPage extends JPanel {
    
    private JFrame frame;
    private JPanel containerDisc; // painel para disciplinas dinâmicas
    private Professor professorSelecionado; // guarda o professor atual

    public RegTurmaPage(JFrame frame) {
        this.frame = frame;
        setup();
    }
    
    public void setup() {
        
        this.removeAll();
        
        JPanel header = PageSettings.createHeader("Registrar Turma");
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 190, 200));
        
        JButton registrar = PageSettings.createButton("Registrar", 100);
        JButton voltar = PageSettings.createButton("Voltar", 100);
        JPanel opcoesProf = new JPanel();
        opcoesProf.setLayout(new BoxLayout(opcoesProf, BoxLayout.X_AXIS));
        opcoesProf.setMaximumSize(new Dimension(230, 20));
        opcoesProf.setBackground(new Color(255, 190, 200));
        opcoesProf.add(registrar);
        opcoesProf.add(Box.createHorizontalStrut(30));
        opcoesProf.add(voltar);
        
        JCheckBox checkBoxDisc[] = new JCheckBox[10];
        Aluno alunos[] = Principal.getAlunos();
        for(int i = 0; i < alunos.length; i++) {
            if(alunos[i] != null) {
                checkBoxDisc[i] = new JCheckBox(alunos[i].getNome());
                checkBoxDisc[i].setBackground(new Color(255, 190, 200));
                checkBoxDisc[i].setForeground(new Color(255, 100, 100));
                checkBoxDisc[i].setFocusPainted(false);
            }
        }
        
        JPanel checkDisc = PageSettings.createDataModel("Alunos: ", checkBoxDisc);
        Professor profs[] = Principal.getProfessores();
        String profNomes[] = new String[10];
        for(int i = 0; i < profs.length; i++) {
            if(profs[i] != null) {
                profNomes[i] = profs[i].getRegisProf() + ": " + profs[i].getNome();
            }
        }
        
        boolean comboItem = false;
        for(int i = 0; i < profNomes.length; i++) {
            if(profNomes[i] != null) {
                comboItem = true;
            }
        }

        JComboBox listaProfs = new JComboBox(profNomes);
        JPanel containerComboProfs = PageSettings.createDataModel("Professor: ", listaProfs, comboItem);

     // Painel para disciplinas do professor
        containerDisc.removeAll();

        String profStr = (String) listaProfs.getSelectedItem();
        if (profStr != null && !profStr.isEmpty()) {
            String regisProf = profStr.split(":")[0].trim();
            professorSelecionado = Principal.buscarProfessorPorRegistro(regisProf);

            if (professorSelecionado != null) {
                Disciplina[] disciplinas = professorSelecionado.getDisc();

                // Grupo de botões para garantir seleção única
                ButtonGroup grupoDisciplinas = new ButtonGroup();

                for (Disciplina d : disciplinas) {
                    if (d != null) {
                        JRadioButton rb = new JRadioButton(d.getNome());
                        rb.setBackground(new Color(255, 190, 200));
                        rb.setForeground(new Color(255, 100, 100));
                        rb.setFocusPainted(false);

                        grupoDisciplinas.add(rb);
                        containerDisc.add(rb);
                    }
                }
            }
        }

        containerDisc.revalidate();
        containerDisc.repaint();
        
        panel.add(Box.createVerticalStrut(10));
        panel.add(checkDisc);
        panel.add(Box.createVerticalStrut(10));
        panel.add(containerComboProfs);
        panel.add(Box.createVerticalStrut(10));
        panel.add(containerDisc);
        panel.add(Box.createVerticalStrut(20));
        panel.add(opcoesProf);
        panel.add(Box.createVerticalStrut(20));
        panel.add(Box.createVerticalGlue());
        
        voltar.addActionListener(e -> Principal.voltarMenu());
        registrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno alu[] = new Aluno[10];
                boolean aluSelected = false;
                String profStr = (String) listaProfs.getSelectedItem();

                for(int i = 0; i < alu.length; i++) {
                    if(checkBoxDisc[i] != null && checkBoxDisc[i].isSelected()) {
                        alu[i] = alunos[i];
                        aluSelected = true;
                    }
                }

                if (!aluSelected) {
                    JOptionPane.showMessageDialog(RegTurmaPage.this, "Preencha o campo 'Aluno: '");
                } else if (profStr == null || profStr.isEmpty()) {
                    JOptionPane.showMessageDialog(RegTurmaPage.this, "Preencha o campo 'Professor: '");
                } else {
                    // Extrair registro do professor
                    String regisProf = profStr.split(":")[0].trim();
                    Professor professorSelecionado = Principal.buscarProfessorPorRegistro(regisProf);

                    if (professorSelecionado == null) {
                        JOptionPane.showMessageDialog(RegTurmaPage.this, "Professor não encontrado!");
                        return;
                    }

                    // Coletar disciplinas selecionadas
                    List<Disciplina> disciplinasSelecionadas = new ArrayList<>();
                    for (Component comp : containerDisc.getComponents()) {
                        if (comp instanceof JCheckBox cb && cb.isSelected()) {
                            for (Disciplina d : professorSelecionado.getDisc()) {
                                if (d != null && d.getNome().equals(cb.getText())) {
                                    disciplinasSelecionadas.add(d);
                                }
                            }
                        }
                    }

                    if (disciplinasSelecionadas.isEmpty()) {
                        JOptionPane.showMessageDialog(RegTurmaPage.this, "Selecione ao menos uma disciplina!");
                        return;
                    }

                    // Aqui você pode criar a turma com alunos, professor e disciplinas
                    // Turma turma = new Turma(alu, professorSelecionado, disciplinasSelecionadas);
                    Principal.registrarTurma();
                }
            }
        });
        
        JScrollPane scrollPane = PageSettings.createScroll(panel);
        
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        
        this.revalidate();
        this.repaint();
    }
}
