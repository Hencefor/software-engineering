package quyang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import operation3.Dock;
import operation3.FileOpe;
import operation3.FileOpeDock;
import operation3.User;

public class Dock2_1  implements ActionListener {
	Dock da;
	User us;
	public Dock2_1(Dock x, User y) {
		da = x;
		us = y;
	}
	JFrame frame = new JFrame();

	 JButton button1 = new JButton("Check");
	 JButton button2 = new JButton("Exit");
	 JLabel label1 = new JLabel("           DOCK    A");
	 JLabel label2 = new JLabel("<html>Waiting for Check<br>......</html>",JLabel.CENTER);
	 JLabel label3 = new JLabel("Light",JLabel.CENTER);
	 JLabel label4 = new JLabel("59",JLabel.CENTER);
	 JLabel label5 = new JLabel("Use Time: 1 : 30",JLabel.CENTER);
	 
	 public void go() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		frame.getContentPane().add(label1);
		label1.setBounds(0,0,430,120);
		label1.setBackground(Color.BLACK);
		label1.setOpaque(true);
		label1.setFont(new java.awt.Font("serif", 1, 45));
		label1.setForeground(Color.WHITE);
		
		
		frame.getContentPane().add(label2);
		label2.setBounds(0,150,430,200);
		label2.setBackground(Color.BLACK);
		label2.setOpaque(true);
		label2.setFont(new java.awt.Font("serif", 1, 40));
		label2.setForeground(Color.WHITE);
		
		
		frame.getContentPane().add(button1);
		button1.setBounds(60,520,320,70);
		button1.setBackground(Color.BLACK);
		Font bigFont = new Font("serif",Font.BOLD,30);
		button1.setFont(bigFont);
		button1.setForeground(Color.WHITE);
		button1.addActionListener(this);
		
		frame.getContentPane().add(button2);
		button2.setBounds(60,630,320,70);
		button2.setBackground(Color.BLACK);
		button2.setFont(bigFont);
		button2.setForeground(Color.WHITE);
		button2.addActionListener(this);
		
		
			frame.getContentPane().add(label3);
			label3.setBounds(0,780,70,70);
			label3.setBackground(Color.BLACK);
			label3.setOpaque(true);
			label3.setFont(new java.awt.Font("serif", 1, 25));
			label3.setForeground(Color.WHITE);
			frame.getContentPane().add(label4);
			
			label4.setBounds(360,780,70,70);
			label4.setBackground(Color.BLACK);
			label4.setOpaque(true);
			label4.setFont(new java.awt.Font("serif", 1, 25));
			label4.setForeground(Color.WHITE);
			
			
			
			MyThread  mt = new MyThread(label4,label3,da,us);
			mt.act();
			//button1.addActionListener(t);
			
			frame.setSize(450,900);
			frame.setVisible(true);
			
		 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button2) {
			frame.dispose();
			Dock1 gui = new Dock1(da,us);
			String a = label1.getText();
			if (a == "           DOCK    A") {
				gui.go();
			}
			if (a == "           DOCK    B") {
				gui.go();
				gui.label1.setText("           DOCK    B");
			}
			if (a == "           DOCK    C") {
				gui.go();
				gui.label1.setText("           DOCK    C");
			}
		}
		else if (e.getSource() == button1) {
			frame.dispose();
			Dock3 gui = new Dock3();
			String a = label1.getText();
			if (a == "           DOCK    A") {
				gui.go();
				us.pick();
				da.releaseScooter();
				FileOpe.updateUser(us);
				FileOpeDock.updateDock(da);
			}
			if (a == "           DOCK    B") {
				gui.go();
				gui.label1.setText("           DOCK    B");
				us.pick();
				da.releaseScooter();
				FileOpe.updateUser(us);
				FileOpeDock.updateDock(da);
			}
			if (a == "           DOCK    C") {
				gui.go();
				gui.label1.setText("           DOCK    C");
				us.pick();
				da.releaseScooter();
				FileOpe.updateUser(us);
				FileOpeDock.updateDock(da);
			}
		}
	}

}
