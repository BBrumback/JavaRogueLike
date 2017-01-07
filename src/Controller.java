import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * the controller class for this project
 * @author Ben Brumback
 * @version 11/30/13
 */
public class Controller  extends StateBasedGame
{
	public static final String gameName = "something to be named later";
	public static final int menu = 0;
	public static final int playLevel1 = 1;
	public static final int playLevel2 = 2;
	public static final int playLevel3 = 3;
	public static final int win = 4;
	public static final int help = 5;
	private Map mapGen = new Map();
	
	/**
	 * the constructor for the Controller class that generates the game states
	 * @param gameName
	 * @throws SlickException
	 */
	public Controller(String gameName) throws SlickException {
		super(gameName);
		this.addState(new Game(playLevel1, mapGen.getMap1(), 1, 4, "right"));
		this.addState(new Game(playLevel2, mapGen.getMap2(), 7, 1, "down"));
		this.addState(new Game(playLevel3, mapGen.getMap3(), 1, 4, "left"));
		this.addState(new Win(win));
		this.addState(new Menu(menu));
		this.addState(new Help(help));
		
	}

	/**
	 * a method that initialized the game states and starts the game
	 */
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(playLevel1).init(gc, this);
		this.getState(playLevel2).init(gc, this);
		this.getState(playLevel3).init(gc, this);
		this.getState(win).init(gc, this);
		this.enterState(menu);
	}
	
}
