package GUI;

import java.awt.*;

public class TestPaint {

	public static void main(String[] args) {
		new PaintFrame().launchFrame();

	}

}

@SuppressWarnings("serial")
class PaintFrame extends Frame{
	public void launchFrame(){
		setBounds(200,200,600,600);
		setVisible(true);
	}
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillRect(44, 52, 66, 77);
		g.setColor(Color.gray);
		g.drawLine(33, 55, 202, 90);
		g.setColor(c);
	}
}
