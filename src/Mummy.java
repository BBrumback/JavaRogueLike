import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * The mummy class
 * @author Ben Brumback
 * @version 11/30/13
 */
public class Mummy {

	private int currentX;
	private int currentY;
	private String direction = "left";
	private int[][] location;
	private boolean hitWall = false;
	private Animation currentAnimation;
	
	static final int ANIMATION_SPEED = 140;
	static final int TILE_SIZE = 32;
	
	private Animation mummyRight = new Animation(animationGen("MUMMY_RIGHT.BMP"), ANIMATION_SPEED);
	private Animation mummyLeft = new Animation(animationGen("MUMMY_LEFT.BMP"), ANIMATION_SPEED);
	private Animation mummyUp = new Animation(animationGen("MUMMY_UP.BMP"), ANIMATION_SPEED);
	private Animation mummyDown = new Animation(animationGen("MUMMY_DOWN.bmp"), ANIMATION_SPEED);
	
	/**
	 * Constructor
	 * @param StartingX
	 * @param StartingY
	 * @param inputDirection
	 * @param map
	 * @throws SlickException
	 */
	public Mummy(int StartingX, int StartingY, String inputDirection, int[][] map) throws SlickException
	{
		location = map;
		direction = inputDirection;
		animation();
		currentX = StartingX;
		currentY = StartingY;
		mummyRight.setLooping(false);
		mummyLeft.setLooping(false);
		mummyUp.setLooping(false);
		mummyDown.setLooping(false);
	}
	
	/**
	 * a method to move the mummy
	 */
	public void moveMummy()
	{
		animation();
		move();
		if(hitWall)
		{
			turn();
		}
	}
	
	/**
	 * a method to get the location
	 * @return int
	 */
	public int getLocationX()
	{
		return currentX;
	}
	
	/**
	 * a method to get the location
	 * @return int
	 */
	public int getLocationY()
	{
		return currentY;
	}
	
	
	/**
	 * a helper method to make animations
	 * @param file
	 * @return SpriteSheet
	 * @throws SlickException
	 */
	private SpriteSheet animationGen(String file) throws SlickException
	{
		Image image = new Image("res/" + file);
		SpriteSheet spriteSheet = new SpriteSheet(image, TILE_SIZE, TILE_SIZE);
		return spriteSheet;
	}
	
	/**
	 * a helper method to move based on the direction the mummy is facing
	 */
	private void move()
	{
		if(direction == "left" && location[currentY][currentX -1] == 0)
		{
			mummyLeft.restart();
			currentX--;
		}
		else if(direction == "right" && location[currentY][currentX +1] == 0)
		{
			mummyRight.restart();
			currentX++;
		}
		else if(direction == "up" && location[currentY -1][currentX] == 0)
		{
			mummyUp.restart();
			currentY--;
		}
		else if(direction == "down" && location[currentY +1][currentX] == 0)
		{

			mummyDown.restart();
			currentY++;
		}
		else
		{
			hitWall = true;
		}
	}
	
	/**
	 * a helper method. if the mummy has hit a wall it will turn around
	 */
	private void turn()
	{
		if(direction == "left")
		{
			direction = "right";
		}
		else if(direction == "right")
		{
			direction = "left";
		}
		else if(direction == "up")
		{
			direction = "down";
		}
		else if(direction == "down")
		{
			direction = "up";
		}
		hitWall = false;
	}
	
	/**
	 * a helper method to set the animation based on the direction
	 */
	private void animation()
	{
		if(direction == "left")
		{
			currentAnimation = mummyLeft;
		}
		else if(direction == "right")
		{
			currentAnimation = mummyRight;
		}
		else if(direction == "up")
		{
			currentAnimation = mummyUp;
		}
		else if(direction == "down")
		{
			currentAnimation = mummyDown;
		}
	}
	
	/**
	 * a method to reurn the mummies current animation
	 * @return Animation
	 */
	public Animation getAnimation()
	{
		return currentAnimation;
	}
}
