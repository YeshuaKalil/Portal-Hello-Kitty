package paginas;

import principal.*;
import java.awt.*;
import javax.swing.*;

public class MenuPage extends JPanel{
	private JFrame frame;

	public MenuPage(JFrame frame) {
		this.frame = frame;
		setup();
	}	

	private void setup() {
		
		JPanel header = PageSettings.createHeader("Menu");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(255, 190, 200));
		
		JButton regAluno = PageSettings.createButton("Registrar Aluno", 200);
		JButton regProf = PageSettings.createButton("Registrar Professor", 200);
		JButton regDisc = PageSettings.createButton("Registrar Disciplina", 200);
		JButton regTurma = PageSettings.createButton("Registrar Turma", 200);
		JButton listTurma = PageSettings.createButton("Listar Turmas", 200);
		JButton sair = PageSettings.createButton("Sair", 200);
		
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(regAluno);
		panel.add(Box.createVerticalStrut(10));
		panel.add(regProf);
		panel.add(Box.createVerticalStrut(10));
		panel.add(regDisc);
		panel.add(Box.createVerticalStrut(10));
		panel.add(regTurma);
		panel.add(Box.createVerticalStrut(10));
		panel.add(listTurma);
		panel.add(Box.createVerticalStrut(10));
		panel.add(sair);
		panel.add(Box.createVerticalStrut(20));
		panel.add(Box.createVerticalGlue());
		
		regAluno.addActionListener(e -> Principal.regAlunoMenu());
		regProf.addActionListener(e -> Principal.regProfMenu());
		regDisc.addActionListener(e -> Principal.regDiscMenu());
		listTurma.addActionListener(e -> Principal.listTurmaMenu());
		sair.addActionListener(e -> Principal.sairMenu());

		JScrollPane scrollPane = PageSettings.createScroll(panel);
        
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
		
	}
	
}
