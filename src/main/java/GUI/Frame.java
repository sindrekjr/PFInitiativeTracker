package java.GUI;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

	public Frame() {
		super("Pathfinder Initiative Tracker");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setSize(600,600);
		this.setLayout(new BorderLayout());

		this.initialize();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initialize() {
		final JPanel panel = new JPanel();
		panel.add(new JLabel("Characters:"));

		this.add(panel, BorderLayout.LINE_START);

	}
}
