import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The tutorial screen for project 5
 * @author Ben Brumback
 * @version 11/30/13
 */
public class Help extends BasicGameState
{
	private Image menu;
	private Image tutorial;
	private MouseOverArea buttonMenu;

	private int menuButtonX = 240;
	private int menuButtonY = 340;
	
	/**
	 * Constructor
	 * @param state
	 */
	public Help(int state)
	{
		
	}

	/**
	 * slick initialize
	 */
	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException 
	{
		tutorial = new Image("res/tutorial.bmp");
		menu = new Image("res/menu.bmp");
		buttonMenu = new MouseOverArea(gc, menu, menuButtonX, menuButtonY);
	}

	/**
	 * slick render
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics arg2) throws SlickException 
	{
		tutorial.draw();
		menu.draw(menuButtonX, menuButtonY);
	}

	/**
	 * slick update
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException
	{
		if(buttonMenu.isMouseOver() && Mouse.isButtonDown(0))
		{
			sbg.enterState(0);
		}
	}

	/**
	 * get state ID
	 */
	@Override
	public int getID() {
		return 5;
	}

}
