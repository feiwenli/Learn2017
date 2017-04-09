package GUI;

import java.awt.*;
import java.awt.event.*;

public class TrstActionEvent {

	public static void main(String[] args) {
		Frame f = new Frame("Test");
		Button b = new Button("press me");
		Monitor m = new Monitor();
		b.addActionListener(m);
		f.add(b,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
}

class Monitor implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("a buttonn has been pressed");
	}
}