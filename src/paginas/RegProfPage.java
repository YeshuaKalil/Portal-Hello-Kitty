package paginas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import escola.Disciplina;
import principal.Principal;

public class RegProfPage extends JPanel{
	
	private JFrame frame;

	public RegProfPage(JFrame frame) {
		this.frame = frame;
		setup();
	}
	
	public void setup() {
		
		this.removeAll();
		
		JPanel header = PageSettings.createHeader("Registrar Professor");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(255, 190, 200));
		
		// Preencher dados do Aluno (nome)
		JTextField nomeProfInp = new JTextField(0);
		JPanel nomeProf = PageSettings.createDataModel("Nome do Professor: ", nomeProfInp);
				
		// Preencher dados do Aluno (CPF)
		JTextField CPFProfInp = new JTextField(0);
		JPanel CPFProf = PageSettings.createDataModel("CPF do Professor: ", CPFProfInp);
					
		// Preencher dados do Aluno (telefone)
		JTextField telefoneProfInp = new JTextField(0);
		JPanel telefoneProf = PageSettings.createDataModel("Telefone do Professor: ", telefoneProfInp);
						
		// Preencher dados do Aluno (email)
		JTextField emailProfInp = new JTextField(0);
		JPanel emailProf = PageSettings.createDataModel("Email do Professor: ", emailProfInp);
				
		// Preencher dados do Aluno (idade)
		JTextField idadeProfInp = new JTextField(0);
		JPanel idadeProf = PageSettings.createDataModel("Idade do Professor: ", idadeProfInp);
				
		// Preencher dados do Aluno (matricula)
		JTextField regisProfInp = new JTextField(0);
		JPanel regisProf = PageSettings.createDataModel("Registro do Professor: ", regisProfInp);
				
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
		Disciplina disciplinas[] = Principal.getDisciplinas();
		for(int i = 0; i < disciplinas.length; i++) {
			if(disciplinas[i] != null) {
				checkBoxDisc[i] = new JCheckBox(disciplinas[i].getNome());
				checkBoxDisc[i].setBackground(new Color(255, 190, 200));
				checkBoxDisc[i].setForeground(new Color(255, 100, 100));
				checkBoxDisc[i].setFocusPainted(false);
			}
		}
		
		JPanel checkDisc = PageSettings.createDataModel("Disciplinas: ", checkBoxDisc);
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(nomeProf);
		panel.add(Box.createVerticalStrut(10));
		panel.add(CPFProf);
		panel.add(Box.createVerticalStrut(10));
		panel.add(telefoneProf);
		panel.add(Box.createVerticalStrut(10));
		panel.add(emailProf);
		panel.add(Box.createVerticalStrut(10));
		panel.add(idadeProf);
		panel.add(Box.createVerticalStrut(10));
		panel.add(regisProf);
		panel.add(Box.createVerticalStrut(10));
		panel.add(checkDisc);
		panel.add(Box.createVerticalStrut(20));
		panel.add(opcoesProf);
		panel.add(Box.createVerticalStrut(20));
		panel.add(Box.createVerticalGlue());
		
		voltar.addActionListener(e -> Principal.voltarMenu());
		registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if( !(nomeProfInp.getText().trim().isEmpty()) && !(CPFProfInp.getText().trim().isEmpty()) &&
						!(telefoneProfInp.getText().trim().isEmpty()) && !(emailProfInp.getText().trim().isEmpty()) &&
						!(regisProfInp.getText().trim().isEmpty())) {
						int idade;
						try {
							idade = Integer.parseInt(idadeProfInp.getText());
						}catch(Exception err) {
							JOptionPane.showMessageDialog(RegProfPage.this, "Preencha o campo 'Idade do Aluno: ' com um número inteiro!");
							return;
						}
						
						Disciplina disc[] = new Disciplina[10];
						boolean discSelected = false;
						for(int i = 0; i < disc.length; i++) {
							if(checkBoxDisc[i] != null && checkBoxDisc[i].isSelected()) {
								disc[i] = disciplinas[i];
								discSelected = true;
							}
						}
						if(discSelected == true) {
							Principal.registrarProf(RegProfPage.this, nomeProfInp.getText(), CPFProfInp.getText(), telefoneProfInp.getText(), emailProfInp.getText(), idade, regisProfInp.getText(), disc);
						} else {
							JOptionPane.showMessageDialog(RegProfPage.this, "Preencha o campo 'Disciplina: '");
						}
						
				} else {
						JOptionPane.showMessageDialog(RegProfPage.this, "Preencha os dados corretamente!");
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
