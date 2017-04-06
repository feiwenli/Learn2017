package trying;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 * 游戏窗口类
 * @author Administrator
 *
 */

@SuppressWarnings("serial")
public class GameFrame extends MyFrame{  //GUI编程：swing ,AWT等 java不擅长做桌面软件
	
	Image img = GameUtil.getImage("images/8.jpg");

	private double x=100,y=100;
	@Override
	public void paint(Graphics g) {
		
		g.drawLine(100, 100, 300, 300);
		g.drawRect(100, 100, 200, 200);
		Color c = g.getColor();
		
		g.setColor(Color.red);
		g.fillOval(100, 100, 200, 200);
		g.drawLine(300, 100, 100, 300);
		g.setColor(c);
		
		Font f = new Font("宋体",Font.BOLD,50);
		g.setFont(f);
		//g.drawString("我的第一个界面",100,100);
		
		g.drawImage(img,(int) x,(int) y, null);
		
		x+=3;
	
	}


	public static void main (String [] args){
		GameFrame gf = new GameFrame ();
		gf.launchFrame();
	}
		
}
