package temperatureConvereter;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main{
	static MyFrame mf;
	
	public static void main(String[] args) {
		try { 
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception ex) {
            System.out.println("GRESKA");
        }
		mf=new MyFrame();
	}
}
