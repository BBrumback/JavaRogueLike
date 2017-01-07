import java.util.Stack;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The game state for project 5
 * 
 * @author Ben Brumback
 * @version 11/30/13
 */
public class Game extends BasicGameState
{
	private int[][] map;
	private Player player1;
	static final int TILE_SIZE = 32;
	static final int quitX = 0;
	static final int quitY = 440;
	
	private int ID;
	private int mummyStartX, mummyStartY;
	private String mummyDirection;
	private Image wall;
	private Image background;
	private Image quit;
	private Image door;
	private MouseOverArea buttonQuit;
	private Animation currentAnimation;
	private Animation mummyAnimation;
	private Mummy mummy;
	
	private Stack<Integer> xSight;
	private Stack<Integer> ySight;
	
	private Input input;
	
	/**
	 * the Constructor for the game
	 * 
	 * @param state
	 * @param levelMap
	 * @param mummyX
	 * @param mummyY
	 * @param direction
	 * @throws SlickException
	 */
	public Game(int state, int[][] levelMap, int mummyX, int mummyY, String direction) throws SlickException
	{
		ID = state;
		mummyStartX = mummyX;
		mummyStartY = mummyY;
		mummyDirection = direction;
		map = levelMap;
	}

	/**
	 * Slick initializing 
	 */
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		load(gc, sbg);
	}

	/**
	 * Slick rendering
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics arg2) throws SlickException 
	{
		quit.draw(quitX, quitY);
		setSight();
		while(!xSight.isEmpty())
		{
			renderArea(xSight.pop(), player1.getLocationY());
		}
		
		while(!ySight.isEmpty())
		{
			renderArea(player1.getLocationX(), ySight.pop());
		}
		currentAnimation.draw(player1.getLocationX()*TILE_SIZE, player1.getLocationY()*TILE_SIZE);
	}

	/**
	 * Slick update
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException
	{
		input = gc.getInput();
		
		if(map[player1.getLocationY()][player1.getLocationX()] == 2)
		{
			changeRooms(ID+1, gc, sbg);
		}
		
		if(mummy.getLocationX() == player1.getLocationX() && mummy.getLocationY() == player1.getLocationY())
		{
			changeRooms(0, gc, sbg);
		}
		
		if(currentAnimation.getFrame() == 3)
		{
			player1.playerMove(gc);
			currentAnimation = player1.direction();
		}
		if(buttonQuit.isMouseOver() && Mouse.isButtonDown(0))
		{
			changeRooms(0, gc, sbg);
		}
		mummyAnimation = mummy.getAnimation();
		if(mummyAnimation.getFrame() == 3)
		{
			mummy.moveMummy();
		}
	}
	
	/**
	 * Slick get the state ID
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 *  a helper method that will generate a stack where the player can see
	 * @param xPos
	 * @param yPos
	 * @param direction
	 */
	private void sightX(int xPos,int yPos, int direction)
	{
		if(map[yPos][xPos] != 1)
		{
			sightX(xPos + direction, yPos, direction);
			xSight.push(xPos);
		}
	}

	/**
	 * A helper method that will generates a stack based on where the player can see
	 * @param xPos
	 * @param yPos
	 * @param direction
	 */
	private void sightY(int xPos,int yPos, int direction)
	{
		if(map[yPos][xPos] != 1)
		{
			sightY(xPos, yPos + direction, direction);
			ySight.push(yPos);
		}
	}
	
	/**
	 * a helper method that renders whatever is at a position 
	 * @param x
	 * @param y
	 */
	@SuppressWarnings("deprecation")
	private void renderAtPos(int x, int y)
	{
		if(map[y][x] == 1)
		{
			wall.draw(x*TILE_SIZE, y*TILE_SIZE);
		}
		else if(map[y][x] == 0)
		{
			background.draw(x*TILE_SIZE, y*TILE_SIZE);
		}
		else if(map[y][x] == 2)
		{
			door.draw(x*TILE_SIZE, y*TILE_SIZE);
		}
		if(x == mummy.getLocationX() && y == mummy.getLocationY())
		{
			mummyAnimation.draw(x*TILE_SIZE,y*TILE_SIZE);
		}
		else
		{
			//i dont know why this is deprecated, but it works very well here
			mummyAnimation.updateNoDraw();
		}
	}
	
	/**
	 * a helper method that renders everything around an area
	 * @param x
	 * @param y
	 */
	private void renderArea(int x, int y)
	{
		renderAtPos(x, y);
		renderAtPos(x + 1, y);
		renderAtPos(x - 1, y);
		renderAtPos(x, y + 1);
		renderAtPos(x, y - 1);
	}
	
	/**
	 * a helper method that calls all the methods to generate the players sight
	 */
	private void setSight()
	{
		sightX(player1.getLocationX(), player1.getLocationY(), 1);
		sightX(player1.getLocationX(), player1.getLocationY(), -1);
		sightY(player1.getLocationX(), player1.getLocationY(), 1);
		sightY(player1.getLocationX(), player1.getLocationY(), -1);
	}
	
	/**
	 * A helper method to initialize everything
	 * @param gc
	 * @param sbg
	 * @throws SlickException
	 */
	private void load(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		wall = new Image("res/Wall1.gif");
		background = new Image("res/Background2.bmp");
		quit = new Image("res/menu.bmp");
		door = new Image("res/Door.gif");
		player1 = new Player(1,1, map);
		currentAnimation = player1.direction();
		buttonQuit = new MouseOverArea(gc, quit, quitX, quitY);
		xSight = new Stack<Integer>();
		ySight = new Stack<Integer>();
		mummy = new Mummy(mummyStartX, mummyStartY, mummyDirection, map);
		mummyAnimation = mummy.getAnimation();
	}
	
	/**
	 * a helper method that resets everything when the rooms change
	 * @param roomNum
	 * @param gc
	 * @param sbg
	 * @throws SlickException
	 */
	private void changeRooms(int roomNum, 	GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		load(gc, sbg);
		sbg.enterState(roomNum);
	}	
}
