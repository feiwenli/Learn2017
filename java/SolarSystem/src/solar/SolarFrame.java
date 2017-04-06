package solar;

import java.awt.Graphics;
import java.awt.Image;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

/**
 * 太阳系的主窗口
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class SolarFrame extends MyFrame{

		Image background = GameUtil.getImage("images/bg.jpg");
		Star sun = new Star("images/0.jpg",Constant.GAME_WIDTH/2,Constant.GAME_HIGHT/2);
		Planet mercury = new Planet("images/1.jpg",100,50,0.3,sun);
		Planet venus = new Planet("images/2.jpg",130,80,0.2,sun);
		Planet earth = new Planet("images/3.jpg",150,100,0.1,sun);
		Planet mars = new Planet("images/4.jpg",180,150,0.08,sun);
		Planet jupiter = new Planet("images/5.jpg",220,190,0.05,sun);
		Planet saturn = new Planet("images/6.jpg",280,230,0.03,sun);
		Planet uranus = new Planet("images/7.jpg",330,270,0.015,sun);
		Planet nepture = new Planet("images/8.jpg",410,320,0.007,sun);
		
		Planet moon = new Planet ("images/moon.jpg",34,26,0.1,earth,true);
	
		public void paint(Graphics g){
			g.drawImage(background,0,0,null);
			sun.draw(g);
			mercury.draw(g);
			venus.draw(g);
			earth.draw(g);
			mars.draw(g);
			jupiter.draw(g);
			saturn.draw(g);
			uranus.draw(g);
			nepture.draw(g);
			
			moon.draw(g);
		}
		
		
		
		public static void main (String [] args){
			new SolarFrame().launchFrame();
		}
		
	

}
