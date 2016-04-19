package mobileapplication90;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Midlet extends MIDlet 
{
	public void startApp() 
	{
		DrawShape dShape = new DrawShape();
		Display.getDisplay(this).setCurrent(dShape); 
	}
	
	public void pauseApp() 
	{}
	
	public void destroyApp(boolean unconditional) 
	{}
}

class DrawShape extends Canvas 
{
	public void paint(Graphics g) 
	{
		g.setColor(0,0,255);
		g.drawArc(100, 150, 40,40,360,180);
		g.drawLine(140, 170, 140, 200);
		g.drawLine(140, 200, 90, 200);
		g.drawLine(90, 200, 90, 140);
		g.drawLine(90, 140,150, 140);
		g.drawLine(150, 140,150,210);
		g.drawLine(150, 210,80,210);
		g.drawLine(80, 210,80,130);
		g.drawLine(80, 130,160,130);
		g.drawLine(160, 130,160,220);
		g.drawLine(160,220,70,220);
		g.drawLine(70,220,70,120);
		g.drawLine(70,120,170,120);
		g.drawLine(170,120,170,230);
		g.drawLine(170,230,60,230);
		g.drawLine(60,230,60,110);
		g.drawLine(60,110,180,110);
		g.drawLine(180,110,180,230);
	}
}
