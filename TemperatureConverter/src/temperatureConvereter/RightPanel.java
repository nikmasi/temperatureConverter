package temperatureConvereter;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RightPanel extends JPanel{
	
	private JLabel result;
	
	public RightPanel() {
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(0x123456));
		
		result=MyFrame.new_label("Result",Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

		this.add(result,gbc);
	}
	
	public JLabel get_result() { return result;}
}
