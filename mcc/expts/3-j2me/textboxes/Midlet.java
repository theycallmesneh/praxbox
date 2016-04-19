package HelloMidlet;
//Text boxes are screens and don't need a form in which to ex­ist.

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;

public class Midlet extends MIDlet implements CommandListener
{
	private Command quit = new Command("Exit", Command.EXIT, 1);
	private static Midlet instance;
	private TextBox textBox;
	private int MAX_SIZE = 100;
	private String initialText = "You can edit the contents of this TextBox";
	
	public Midlet()
	{
		super();
		instance = this;
	}
	
	public void pauseApp()
	{
	}
	
	public void destroyApp(boolean destroy)
	{
		textBox = null;
		initialText = null;
		instance = null;
	}
	
	void quit()
	{
		destroyApp(true);
		notifyDestroyed();
	}
	
	public void startApp()
	{
		textBox = new TextBox("A TextBox",initialText,MAX_SIZE,TextField.ANY);
		textBox.addCommand(quit);
		textBox.setCommandListener(this);
		display();
	}
	
	public static Midlet getInstance()
	{
		return instance;
	}
	
	public void display()
	{
		Display.getDisplay(this).setCurrent(textBox);
	}
	
	public void commandAction(Command c, Displayable d)
	{
		if (c == quit)
		{
			quit();
		}
	}
}
