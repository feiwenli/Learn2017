package GUI;

import java.awt.*;
import java.awt.event.*;

public class TestActionEvent2 {

	public static void main(String[] args) {
		Frame f = new Frame("test");
		Button b1 = new Button("start");
		Button b2 = new Button("stop");
		Monitor2 m = new Monitor2();
		b1.addActionListener(m);
		b2.addActionListener(m);
		b2.setActionCommand("game over");
		f.add(b1,"North");
		f.add(b2, "Center");
		f.pack();
		f.setVisible(true);
	}

}

class Monitor2 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("a button has been pressef,"+
				"the relative info is:\n"+arg0.getActionCommand());
		
	}
	
}