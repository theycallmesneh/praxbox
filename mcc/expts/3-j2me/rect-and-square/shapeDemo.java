 Code for Shapes:
//shapeDemo.java
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class shapeDemo extends MIDlet {
public void startApp() {
DrawShape dShape = new DrawShape();
Display.getDisplay(this).setCurrent(dShape); }
public void pauseApp() { }
public void destroyApp(boolean unconditional) {
}}
class DrawShape extends Canvas {
public void paint(Graphics g) {
int width = getWidth();
int height = getHeight();
g.setColor(255, 0, 0); // set the black color
int pointZ = 30;
g.fillRoundRect(pointZ, pointZ, 80, 40, 5, 5);
pointZ += 60;
g.setColor(255, 0, 255);
g.fillRect(pointZ, pointZ, 40, 40);
pointZ += 40;
g.setColor(100, 100, 255);
g.fillArc(pointZ, pointZ, 40, 40, 0, 180);
pointZ += 40;
g.setColor(0, 255, 255);
g.fillArc(pointZ, pointZ, 40, 40, 0, 360); }}