package paginas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import principal.Principal;

public class RegAlunoPage extends JPanel{
	
	private JFrame frame;

	public RegAlunoPage(JFrame frame) {
		this.frame = frame;
		setup();
	}
	
	private void setup() {
		
		JPanel header = PageSettings.createHeader("Registrar Aluno");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(255, 190, 200));
		
		// Preencher dados do Aluno (nome)
		JTextField nomeAlunoInp = new JTextField(0);
		JPanel nomeAluno = PageSettings.createDataModel("Nome do Aluno: ", nomeAlunoInp);
				
		// Preencher dados do Aluno (CPF)
		JTextField CPFAlunoInp = new JTextField(0);
		JPanel CPFAluno = PageSettings.createDataModel("CPF do Aluno: ", CPFAlunoInp);
					
		// Preencher dados do Aluno (telefone)
		JTextField telefoneAlunoInp = new JTextField(0);
		JPanel telefoneAluno = PageSettings.createDataModel("Telefone do Aluno: ", telefoneAlunoInp);
						
		// Preencher dados do Aluno (email)
		JTextField emailAlunoInp = new JTextField(0);
		JPanel emailAluno = PageSettings.createDataModel("Email do Aluno: ", emailAlunoInp);
				
		// Preencher dados do Aluno (idade)
		JTextField idadeAlunoInp = new JTextField(0);
		JPanel idadeAluno = PageSettings.createDataModel("Idade do Aluno: ", idadeAlunoInp);
				
		// Preencher dados do Aluno (matricula)
		JTextField matrAlunoInp = new JTextField(0);
		JPanel matrAluno = PageSettings.createDataModel("Matrícula do Aluno: ", matrAlunoInp);
				
				
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
		panel.add(Box.createVerticalStrut(10));
		panel.add(CPFAluno);
		panel.add(Box.createVerticalStrut(10));
		panel.add(telefoneAluno);
		panel.add(Box.createVerticalStrut(10));
		panel.add(emailAluno);
		panel.add(Box.createVerticalStrut(10));
		panel.add(idadeAluno);
		panel.add(Box.createVerticalStrut(10));
		panel.add(matrAluno);
		panel.add(Box.createVerticalStrut(20));
		panel.add(opcoesAluno);
		panel.add(Box.createVerticalGlue());
		
		voltar.addActionListener(e -> Principal.voltarMenu());
		registrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if( !(nomeAlunoInp.getText().trim().isEmpty()) && !(CPFAlunoInp.getText().trim().isEmpty()) &&
						!(telefoneAlunoInp.getText().trim().isEmpty()) && !(emailAlunoInp.getText().trim().isEmpty()) &&
						!(matrAlunoInp.getText().trim().isEmpty())) {
						try {
							int idade = Integer.parseInt(idadeAlunoInp.getText());
							Principal.registrarAluno(RegAlunoPage.this, nomeAlunoInp.getText(), CPFAlunoInp.getText(), telefoneAlunoInp.getText(), emailAlunoInp.getText(), idade, matrAlunoInp.getText());
						}catch(Exception err) {
							JOptionPane.showMessageDialog(RegAlunoPage.this, "Preencha o campo 'Idade do Aluno: ' com um número inteiro!");
						}
					} else {
						JOptionPane.showMessageDialog(RegAlunoPage.this, "Preencha os dados corretamente!");
					}
				
			}
		});
		
		JScrollPane scrollPane = PageSettings.createScroll(panel);
        
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

		
	}
	
	
}