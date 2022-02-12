package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import domein.ExamenPeriode;

public class Gui implements ActionListener
{
	private static ExamenPeriode eP = new ExamenPeriode();
	private static JTextField tf1, tf2;
	private static JButton add, reset;
	private static JPanel panel1, panel2;
	private static JFrame frame;
	private static JLabel label, label2;

	public static void main(String[] args)
	{

		frame = new JFrame("ExamenPeriodeCalculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 100);

		panel1 = new JPanel();
		label = new JLabel("Enter studiepunten and punten");
		tf1 = new JTextField(5);
		tf2 = new JTextField(5);
		add = new JButton("Add");
		add.addActionListener((ActionListener) new Gui());
		add.setBackground(Color.YELLOW);
		reset = new JButton("Reset");
		reset.addActionListener((ActionListener) new Gui());
		reset.setBackground(Color.GREEN);
		panel1.add(label);
		panel1.add(tf1);
		panel1.add(tf2);
		panel1.add(add);
		panel1.add(reset);
		panel1.setBackground(Color.CYAN);

		panel2 = new JPanel();
		panel2.setBackground(Color.CYAN);
		label2 = new JLabel(
				String.format("Je behaalde %d/%d of %.2f%n", eP.getBehaald(), eP.getTotal(), eP.getProcent()));
		panel2.add(label2);

		frame.getContentPane().add(BorderLayout.CENTER, panel1);
		frame.getContentPane().add(BorderLayout.SOUTH, panel2);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == add)
		{

			int studiepunten = 0, punten = 0;
			studiepunten = Integer.parseInt(tf1.getText());
			punten = Integer.parseInt(tf2.getText());
			eP.addPunten(studiepunten, punten);
			if (eP.getProcent() > 50)
				panel2.setBackground(Color.GREEN);
			else
				panel2.setBackground(Color.RED);

		} else
		{
			eP.reset();
			panel2.setBackground(Color.CYAN);
		}

		label2.setText(String.format("Je behaalde %d/%d of %.2f%n", eP.getBehaald(), eP.getTotal(), eP.getProcent()));
	}

}
