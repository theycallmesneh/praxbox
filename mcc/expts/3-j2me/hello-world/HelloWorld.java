package mobileapplication27;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class HelloWorld extends MIDlet implements CommandListener
{
	private Display display ;
	private TextBox textBox ;
	private Command quitCommand;
	
	public void startApp()
	{
		display = Display.getDisplay(this);
		quitCommand = new Command("Quit", Command.SCREEN, 1);
		textBox = new TextBox("Hello World", "My first MIDlet", 40, 0);
		textBox .addCommand(quitCommand);
		textBox .setCommandListener(this);
		display .setCurrent(textBox );
	}
	
	public void pauseApp()
	{}
	
	public void destroyApp(boolean unconditional)
	{}
	
	public void commandAction(Command choice, Displayable displayable)
	{
		if (choice == quitCommand)
		{	destroyApp(false);
			notifyDestroyed();
		}
	}
}
