package paginas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import principal.Principal;

public class RegDiscPage extends JPanel{
	
	private JFrame frame;

	public RegDiscPage(JFrame frame) {
		this.frame = frame;
		setup();
	}

	private void setup() {
		
		JPanel header = PageSettings.createHeader("Registrar Disciplina");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(255, 190, 200));
		
		// Preencher dados do Aluno (nome)
		JTextField nomeDiscInp = new JTextField(0);
		JPanel nomeAluno = PageSettings.createDataModel("Nome da Disciplina: ", nomeDiscInp);
				
				
		JButton registrar = PageSettings.createButton("Registrar", 100);
		JButton voltar = PageSettings.createButton("Voltar", 100);
		JPanel opcoesAluno = new JPanel();
		opcoesAluno.setLayout(new BoxLayout(opcoesAluno, BoxLayout.X_AXIS));
		opcoesAluno.setMaximumSize(new Dimension(230, 20));
		opcoesAluno.setBackground(new Color(255, 190, 200));
		opcoesAluno.add(registrar);
		opcoesAluno.add(Box.createHorizontalStrut(30));
		opcoesAluno.add(voltar);
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(nomeAluno);
		panel.add(Box.createVerticalStrut(20));
		panel.add(opcoesAluno);
		panel.add(Box.createVerticalGlue());
		
		voltar.addActionListener(e -> Principal.voltarMenu());
		registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if( !(nomeDiscInp.getText().trim().isEmpty())) {
						Principal.registrarDisc(RegDiscPage.this, nomeDiscInp.getText());
					} else {
						JOptionPane.showMessageDialog(RegDiscPage.this, "Preencha os dados corretamente!");
					}
				
			}
		});
		
		JScrollPane scrollPane = PageSettings.createScroll(panel);
        
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

		
	}
	
	
}
