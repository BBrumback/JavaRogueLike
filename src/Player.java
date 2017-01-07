import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.*;

/**
 * the player Class
 * @author Ben Brumback
 * @version 11/30/13
 */
public class Player {
	
	private int currentX, currentY;
	private int[][] location;
	private Input input;
	private String direction = "right";
	static final int TILE_SIZE = 32;
	static final int ANIMATION_SPEED = 140;
	private Animation explorerRight = new Animation(animationGen("EXPLORER_RIGHT.BMP"), ANIMATION_SPEED);
	private Animation explorerLeft = new Animation(animationGen("EXPLORER_LEFT.BMP"), ANIMATION_SPEED);
	private Animation explorerUp = new Animation(animationGen("EXPLORER_UP.BMP"), ANIMATION_SPEED);
	private Animation explorerDown = new Animation(animationGen("EXPLORER_DOWN.bmp"), ANIMATION_SPEED);
	
	/**
	 * Constructor
	 * @param startingX
	 * @param startingY
	 * @param gameMap
	 * @throws SlickException
	 */
	public Player(int startingX, int startingY, int[][] gameMap) throws SlickException
	{
		location = gameMap;
		currentX = startingX;
		currentY = startingY;
		explorerRight.setLooping(false);
		explorerLeft.setLooping(false);
		explorerUp.setLooping(false);
		explorerDown.setLooping(false);
	}
	
	/**
	 * a helper method to move the player right
	 */
	private void moveRight()
	{
		if(location[currentY][currentX +1] != 1)
		{
			currentX++;
		}
	}
	
	/**
	 * a helper method to move the player left
	 */
	private void moveLeft()
	{
		if(location[currentY][currentX -1] != 1)
		{
			currentX--;
		}
	}
	
	/**
	 * a helper method to move the player up
	 */
	private void moveUp()
	{
		if(location[currentY -1][currentX] != 1)
		{
			currentY--;
		}
	}
	
	/**
	 * a helper method to move the player down
	 */
	private void moveDown()
	{
		if(location[currentY +1][currentX] != 1)
		{
			currentY++;
		}
	}
	
	/**
	 * a method that controls the movement of the player
	 * @param gc
	 */
	public void playerMove(GameContainer gc)
	{
		input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_RIGHT))
		{
			moveRight();
			direction = "right";
			explorerRight.restart();
		}
		else if(input.isKeyDown(Input.KEY_DOWN))
		{
			moveDown();
			direction = "down";
			explorerDown.restart();
		}
		else if(input.isKeyDown(Input.KEY_LEFT))
		{
			moveLeft();
			direction = "left";
			explorerLeft.restart();
		}
		else if(input.isKeyDown(Input.KEY_UP))
		{
			moveUp();
			direction = "up";
			explorerUp.restart();
		}
	}
	
	/**
	 * a method to get the location of the player
	 * @return int
	 */
	public int getLocationX()
	{
		return currentX;
	}
	
	/**
	 * a method to get the location of the play
	 * @return int
	 */
	public int getLocationY()
	{
		return currentY;
	}

	/**
	 *  a method to get the animation of the player based on which direction they are facing
	 * @return Animation
	 */
	public Animation direction()
	{
		if(direction == "right")
		{
			return explorerRight;
		}
		else if (direction == "left")
		{
			return explorerLeft;
		}
		else if (direction == "up")
		{
			return explorerUp;
		}
		else if (direction == "down")
		{
			return explorerDown;
		}
		else
		{
			return explorerUp;
		}
	}
	
	/**
	 * a helper method to generate animations
	 * @param file
	 * @return
	 * @throws SlickException
	 */
	private SpriteSheet animationGen(String file) throws SlickException
	{
		Image image = new Image("res/" + file);
		SpriteSheet spriteSheet = new SpriteSheet(image, TILE_SIZE, TILE_SIZE);
		return spriteSheet;
	}
}