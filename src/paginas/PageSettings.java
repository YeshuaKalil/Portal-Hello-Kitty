package paginas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class PageSettings {
	
	public static JButton createButton(String nome, int largura) {
		JButton button = new JButton(nome);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setFocusPainted(false);
		button.setBackground(new Color(255, 90, 100));
		button.setForeground(new Color(250, 250, 250));
		button.setMaximumSize(new Dimension(largura, 30));
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(205, 50, 50)));
		return button;
		
	}
	
	public static JPanel createHeader(String title) {
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(255, 100, 100));
		headerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(205, 50, 50)));

		JLabel headerLabel = new JLabel(title);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		headerPanel.add(headerLabel);
		return headerPanel;
	}
	
	public static JPanel createDataModel(String labelName, JTextField inp) {
		JLabel label = new JLabel(labelName);
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setForeground(new Color(255, 100, 100));
		label.setMaximumSize(new Dimension(150, 20));
		inp.setMaximumSize(new Dimension(200, 20));
		JPanel dataModel = new JPanel();
		dataModel.setLayout(new BoxLayout(dataModel, BoxLayout.X_AXIS));
		dataModel.setMaximumSize(new Dimension(350, 20));
		dataModel.setBackground(new Color(255, 190, 200));
		dataModel.add(label);
		dataModel.add(inp);
		return dataModel;
	}
	
	public static JPanel createDataModel(String labelName, JCheckBox[] checkBoxDisc) {
		JLabel label = new JLabel(labelName);
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setForeground(new Color(255, 100, 100));
		label.setMaximumSize(new Dimension(150, 20));
		JPanel labelPane = new JPanel();
		labelPane.setLayout(new BoxLayout(labelPane, BoxLayout.X_AXIS));
		labelPane.setMaximumSize(new Dimension(350, 20));
		labelPane.setBackground(new Color(255, 190, 200));
		JPanel emptyPane = new JPanel();
		emptyPane.setMaximumSize(new Dimension(200, 20));
		emptyPane.setBackground(new Color(255, 190, 200));
		labelPane.add(label);
		labelPane.add(emptyPane);
		
		JPanel checkBoxes = new JPanel();
		checkBoxes.setLayout(new BoxLayout(checkBoxes, BoxLayout.Y_AXIS));
		checkBoxes.setBackground(new Color(255, 190, 200));
		
		boolean checkBox = false;
		for(int i = 0; i < checkBoxDisc.length; i++) {
			if(checkBoxDisc[i] != null) {
				checkBoxes.add(Box.createVerticalStrut(10));
				checkBoxes.add(checkBoxDisc[i]);
				checkBoxDisc[i].setHorizontalTextPosition(SwingConstants.RIGHT);
				checkBoxDisc[i].setAlignmentX(Component.LEFT_ALIGNMENT);
				checkBox = true;
			}
		}
		
		JPanel checkBoxPane = new JPanel();
		checkBoxPane.setLayout(new BoxLayout(checkBoxPane, BoxLayout.X_AXIS));
		checkBoxPane.setBackground(new Color(255, 190, 200));
		JPanel emptyPane2 = new JPanel();
		emptyPane2.setMaximumSize(new Dimension(150, 20));
		emptyPane2.setBackground(new Color(255, 190, 200));
		checkBoxPane.add(emptyPane2);
		if(checkBox == true) {
			checkBoxPane.add(checkBoxes);
		} else {
			checkBoxPane.add(new JLabel("Nenhuma disciplina disponível."));
		}
		
		checkBoxes.setMaximumSize(new Dimension(200, Integer.MAX_VALUE));
		JPanel dataModel = new JPanel();
		dataModel.setLayout(new BoxLayout(dataModel, BoxLayout.Y_AXIS));
		dataModel.setBackground(new Color(255, 190, 200));
		dataModel.add(labelPane);
		dataModel.add(checkBoxPane);
		return dataModel;
	}
	
	public static JScrollPane createScroll(JPanel panel) {
		JScrollPane scrollPane = new JScrollPane(panel);

		JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
		verticalBar.setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(255, 90, 100);
		        this.thumbHighlightColor = new Color(205, 50, 50);
		        this.thumbLightShadowColor = new Color(255, 150, 150);
		        this.trackColor = new Color(255, 190, 200);
		    }
		
		    @Override
		    protected JButton createDecreaseButton(int orientation) {
		        return createZeroButton();
		    }
		
		    @Override
		    protected JButton createIncreaseButton(int orientation) {
		        return createZeroButton();
		    }
		
		    private JButton createZeroButton() {
		        JButton button = new JButton();
		        button.setPreferredSize(new Dimension(0, 0));
		        button.setMinimumSize(new Dimension(0, 0));
		        button.setMaximumSize(new Dimension(0, 0));
		        return button;
		    }
		});

		verticalBar.setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
		verticalBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		return scrollPane;
	}
}
