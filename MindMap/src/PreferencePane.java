import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PreferencePane extends JPanel{
	Controller controller;
	JTextField txtPoints;
	JTextField txtSize;
	JTextField txtText;
	
	public PreferencePane(Controller controller){
		this.controller = controller;
		setLayout(null);
		//this.setSize(175, 500);
		JLabel label = new JLabel("좌표");
		label.setBounds(this.getX() + 20, this.getY() + 20, 35, 20);
		add(label);
		
		txtPoints = new JTextField();
		txtPoints.setBounds(label.getX() + label.getWidth(), label.getY(), 100, 20);
		add(txtPoints);
		txtPoints.setColumns(10);
		
		JLabel label_1 = new JLabel("길이");
		label_1.setBounds(label.getX(), label.getY() + label.getHeight() + 5, 35, 20);
		add(label_1);
		
		txtSize = new JTextField();
		txtSize.setBounds(txtPoints.getX(), label_1.getY(), 100, 20);
		add(txtSize);
		txtSize.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("텍스트");
		lblNewLabel.setBounds(label.getX(), label_1.getY() + label_1.getHeight() + 5, 35, 20);
				add(lblNewLabel);
		
		txtText = new JTextField();
		txtText.setBounds(txtPoints.getX(), lblNewLabel.getY(), 100, 20);
		add(txtText);
		txtText.setColumns(10);
		
		JButton button = new JButton("적용");
		button.setBounds(label.getX(), lblNewLabel.getY() + lblNewLabel.getHeight() + 10, 75, 29);
		button.addActionListener(controller);
		add(button);
		
		this.setPreferredSize(new Dimension(175, 200));
	}
}
