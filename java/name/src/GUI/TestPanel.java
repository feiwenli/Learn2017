package GUI;

import java.awt.*;

public class TestPanel {
	public static void main (String[] args){
		Frame f = new Frame("java Frame with Panel");
		Panel p = new Panel(null);
		f.setLayout(null);
		f.setBounds(300,300,500,500);
		f.setBackground(new Color(22,44,33));
		p.setBounds(50,50,400,400);
		p.setBackground(new Color(88,99,12));
		f.add(p);
		f.setVisible(true);
	}
}
