import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * the Win screen
 * @author Ben Brumback
 * @version 11/30/13
 */
public class Win extends BasicGameState {
	
	private Image backgroundWin;
	private Image menu;
	private Image quit;
	private MouseOverArea buttonMenu;
	private MouseOverArea buttonQuit;
	private int menuButtonX = 130;
	private int menuButtonY = 240;
	private int quitButtonX = 350;
	private int quitButtonY = 240;
	
	/**
	 * Constructor that only takes the games state ID
	 * @param state
	 */
	public Win(int state)
	{
		
	}

	/**
	 * slick initializing
	 */
	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {
		backgroundWin = new Image("res/background_win.bmp");
		menu = new Image("res/menu.bmp");
		quit = new Image("res/quit.bmp");
		
		buttonMenu = new MouseOverArea(gc, menu, menuButtonX, menuButtonY);
		buttonQuit = new MouseOverArea(gc, quit, quitButtonX, quitButtonY);
	}

	/**
	 * slick render
	 */
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException 
	{
		backgroundWin.draw();
		menu.draw(menuButtonX, menuButtonY);
		quit.draw(quitButtonX, quitButtonY);
	}

	/**
	 * slick update
	 */
	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int arg2) throws SlickException 
	{
		if(buttonMenu.isMouseOver() && Mouse.isButtonDown(0))
		{
			sbg.enterState(0);
		}
		if(buttonQuit.isMouseOver() && Mouse.isButtonDown(0))
		{
			System.exit(0);
		}
	}
	
	/**
	 * slick get the state ID
	 */
	public int getID()
	{
		return 4;
	}
}
