package temperatureConvereter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftPanel extends JPanel {
	private JLabel degree;
	private JLabel enter;
	private JComboBox comboBox;
	private JComboBox comboBox2;
	private JButton button;
	private String[] combo = {"Celsius (*C)","Fahrenheit (*F)", "Kelvin (K)", "Rankine (*R)"};
	private JTextField textField;
	
	public JTextField new_textField(int x, int y,Color foreground, Color background,int columns) {
		JTextField textF = new JTextField();
		textF.setPreferredSize(new Dimension(x,y));
		textF.setForeground(foreground);
		textF.setBackground(background);
		textF.addActionListener(Main.mf);
		textF.setFont(new Font("Calibri", 20,20));
		textF.setColumns(columns);
		return textF;
	}
	
	public JComboBox new_comboBox(String[] combo) {
		JComboBox cb= new JComboBox(combo);
		cb.addActionListener(Main.mf);
		cb.setFont(new Font("Calibri", 20,20));
		cb.setPreferredSize(new Dimension(170, cb.getPreferredSize().height));
		return cb;
	}
	
	public JButton new_button(String text,int bx,int by, int bw, int bh) {
		JButton b=new JButton();
		b.setText(text);
		b.setBounds(bx,by,bw,bh);
		//b.addActionListener(Main.mf);
		b.setFont(new Font("Calibri", 20,20));
		return b;
	}
	
	public LeftPanel() {
		
		enter=MyFrame.new_label("Enter Temperature",Color.GRAY);

		JPanel pantext=new JPanel(new GridLayout(2,1,12,12));
		JPanel panflow=new JPanel(new FlowLayout());
		pantext.add(enter);
		pantext.add(degree=MyFrame.new_label("Degree",Color.GRAY));
		pantext.setBorder(BorderFactory.createEmptyBorder(20, 5, 1, 10));
		panflow.add(textField=new_textField(35, 35,Color.WHITE, new Color(0x123456),6));
		panflow.setBorder(BorderFactory.createEmptyBorder(1, 10, 20, 10));
        JPanel pan=new JPanel();
        pan.setLayout(new GridLayout(4,1,12,12));
        pan.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		
		comboBox=new_comboBox(combo);
		
		comboBox2=new_comboBox(combo);
		button=new_button("Convert ->",100,100,200,100);
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Dugme je pritisnuto!");
		        Main.mf.convert();
		    }
		});
		
		panflow.add(comboBox);
		pan.add(MyFrame.new_label("  Convert in",Color.GRAY));
		pan.add(comboBox2);
		pan.add(button);
		this.add(pantext);
		this.add(panflow);
		this.add(pan);
	}
	
	public JButton getButton() {return button;}
	public JTextField getTextField() {return textField;}
	public JComboBox getcomboBox() {return comboBox;}
	public JComboBox getcomboBox2() {return comboBox2;}
}
