package com.caveofprogramming.designpatterns.demo1.view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import com.caveofprogramming.designpatterns.demo1.model.Model;

public class View extends JFrame implements ActionListener {
	private Model model;
	private JButton helloButton;
	private JButton goodbyeButton;

	public View(Model model) throws HeadlessException {
		super("MVC Demo");
		this.model = model;
		
		helloButton = new JButton("Hello!");
		goodbyeButton = new JButton("Goodbye!");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx=1;
		gc.gridy=1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		add(helloButton, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx=1;
		gc.gridy=2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;		
		
		add(goodbyeButton, gc);
		
		// The subject of the Observer pattern
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		
		goodbyeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sorry to see you go.");
			}
		});
		
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		
        if (source == helloButton) {
            System.out.println("Hello there!");
        }
        else {
            System.out.println("Some other button.");                    
        }
	}
}
