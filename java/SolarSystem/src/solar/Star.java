package solar;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Star {
	Image img;
	
	double x,y;
	double width,height;
	
	Star(){
	}
	
	Star (Image img){
		this.img = img ;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	Star(Image img,double x,double y){
		this(img);
		this.x = x;
		this.y = y;	
		
	}
	
	Star(String imgPath,double x,double y){
		this(GameUtil.getImage(imgPath),x,y);	//用this调用构造方法
	}
	
	void draw(Graphics g){
		g.drawImage(img, (int)x,(int) y, null);
	}
}
