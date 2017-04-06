package solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Planet extends Star{
	
	Planet(Image img, double x, double y) {
		super(img, x, y);
	}
	
	Planet(String imgPath, double x, double y) {
		super(imgPath, x, y);
	}
	
	double longAxis;  	//长轴
	double shortAxis;	//短轴
	double speed;		//速度
	double degree; 		//角度
	Star center;		//绕着某个中心飞
	
	boolean satellite;
	
	Planet( String imgPath,double longAxis,double shortAxis, double speed, Star center) {
		super(GameUtil.getImage(imgPath));

		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
		this.x = center.x+ longAxis;
		this.y = center.y ;
	}
	
	Planet( String imgPath,double longAxis,double shortAxis, double speed, Star center,boolean satellite){
		this(imgPath,longAxis,shortAxis,speed,center);
		this.satellite = satellite;
	}
	
	void draw(Graphics g){
		super.draw(g);
		if(!satellite){
			drawTrace(g);
		}
		move();
	}
	
	void move(){	
		//沿着椭圆轨迹运动
		x = center.x + center.width/2 + longAxis*Math.cos(degree);
		y = center.y + center.height/2  +shortAxis*Math.sin(degree);
		
		degree += speed;
	}
	
	void drawTrace(Graphics g){
		double ovalX,ovalY,ovalWidth,ovalHeight;
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = center.x + center.width/2 - longAxis;
		ovalY = center.y +center.height/2 - shortAxis;
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX,(int)ovalY,(int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}	
}
