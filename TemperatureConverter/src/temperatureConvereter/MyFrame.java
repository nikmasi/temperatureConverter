package temperatureConvereter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MyFrame extends JFrame implements ActionListener{
	
	private RightPanel rightPanel;
	private LeftPanel leftPanel;
	
	public void frame_config() {
		this.setTitle("temperature-converter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650,400);
		this.setLayout(new GridLayout(1,2));
	}
	
	public static JLabel new_label(String text,Color color) {
		JLabel label=new JLabel();
		label.setText(text);
		label.setFont(new Font("Calibri", 20,30));
		label.setForeground(color);
		return label;
	}
	
	MyFrame(){
		frame_config();
		this.add(leftPanel=new LeftPanel());
		this.add(rightPanel=new RightPanel());
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(0x123456));
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
	
	public void convert() {
		String text=leftPanel.getTextField().getText();
		Double num=0.0;
		int greska=0;
		try {
			num=Double.parseDouble(text);
		}
		catch(NumberFormatException e){
			System.out.println("GRESKA");
			greska=1;
		}
		System.out.println(leftPanel.getcomboBox().getSelectedItem());
		
		if(greska==0) {
			Double s=switchConvert(num);
			rightPanel.get_result().setText(s.toString());
		}else {
			rightPanel.get_result().setText("enter a number");
		}
		
	}
	
	public Double switchConvert(Double num) {
		Double res=num;
		switch (leftPanel.getcomboBox().getSelectedIndex()) {
		case 0: {
			switch(leftPanel.getcomboBox2().getSelectedIndex()) {
			case 1: res=CelsiusToFahrenheit(num);break;
			case 2: res=CelsiusToKelvin(num);break;
			case 3: res=CelsiusToRankine(num);break;
			}
			break;
		}
		case 1:{
			switch(leftPanel.getcomboBox2().getSelectedIndex()) {
			case 0: res=FahrenheitToCelsius(num);break;
			case 2: res=FahrenheitToKelvin(num);break;
			case 3: res=FahrenheitToRankine(num);break;
			}
			break;
		}
		case 2:{
			switch(leftPanel.getcomboBox2().getSelectedIndex()) {
			case 0: res=KelvinToCelsius(num);break;
			case 1: res=KelvinToFahrenheit(num);break;
			case 3: res=KelvinToRankine(num);break;
			}
			break;
		}
		case 3:{
			switch(leftPanel.getcomboBox2().getSelectedIndex()) {
			case 0: res=RankineToCelsius(num);break;
			case 1: res=RankineToFahrenheit(num);break;
			case 2: res=RankineToKelvin(num);break;
			}
			break;
		}
	}
		return res;
	}
	
	public double FahrenheitToCelsius(double tem) {
		return (tem-32)/1.8;
	}
	
	public double FahrenheitToKelvin(double tem) {
		return (tem-32)/1.8+273.15;
	}
	
	public double FahrenheitToRankine(double tem) {
		return tem+ 459.67;
	}
	
	public double CelsiusToFahrenheit(double tem) {
		return (tem*1.8)+32;
	}
	
	public double CelsiusToKelvin(double tem) {
		return tem+273.15;
	}
	
	public double CelsiusToRankine(double tem) {
		return (tem+273.15)*1.8;
	}
	
	public double KelvinToFahrenheit(double tem) {
		return ((tem-273.15)*1.8)+32;
	}
	
	public double KelvinToCelsius(double tem) {
		return tem-273.15;
	}
	
	public double KelvinToRankine(double tem) {
		return tem*1.8;
	}
	
	public double RankineToFahrenheit(double tem) {
		return tem-459.67;
	}
	
	public double RankineToCelsius(double tem) {
		return tem*0.555555556-273.15;
	}
	
	public double RankineToKelvin(double tem) {
		return tem*0.555555556;
	}
}
