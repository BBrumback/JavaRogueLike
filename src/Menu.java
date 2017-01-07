import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.gui.MouseOverArea;

/**
 * The menu for project 5
 * @author Ben Brumback
 * @version 11/30/13
 */
public class Menu  extends BasicGameState{
	private Image background;
	private Image start;
	private Image quit;
	private Image help;
	private MouseOverArea buttonStart;
	private MouseOverArea buttonQuit;
	private MouseOverArea buttonHelp;
	private int startButtonX = 130;
	private int startButtonY = 55;
	private int quitButtonX = 350;
	private int quitButtonY = 55;
	private int helpButtonX = 240;
	private int helpButtonY = 150;
	 
	/**
	 * Constructor
	 * @param state
	 */
	public Menu(int state)
	{
		
	}

	/**
	 * slick initialize
	 */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background = new Image("res/background1.bmp");
		start = new Image("res/start.bmp");
		quit = new Image("res/quit.bmp");
		help = new Image("res/help.bmp");
		
		buttonStart = new MouseOverArea(arg0, start, startButtonX, startButtonY);
		buttonQuit = new MouseOverArea(arg0, quit, quitButtonX, quitButtonY);
		buttonHelp = new MouseOverArea(arg0, help, helpButtonX, helpButtonY);
	}

	/**
	 * slick render
	 */
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException 
	{
		background.draw();
		start.draw(startButtonX,startButtonY);
		quit.draw(quitButtonX, quitButtonY);
		help.draw(helpButtonX, helpButtonY);
	}

	/**
	 * slick update
	 */
	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int arg2) throws SlickException 
	{
		if(buttonStart.isMouseOver() && Mouse.isButtonDown(0))
		{
			sbg.enterState(1);
		}
		if(buttonQuit.isMouseOver() && Mouse.isButtonDown(0))
		{
			System.exit(0);
		}
		if(buttonHelp.isMouseOver() && Mouse.isButtonDown(0))
		{
			sbg.enterState(5);
		}
	}
	
	/**
	 * get state ID
	 */
	public int getID()
	{
		return 0;
	}
}
