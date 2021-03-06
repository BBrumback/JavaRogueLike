
/**
 * this class hold all the maps for the game
 * @author Ben Brumback
 * @version 11/30/13
 */
public class Map {
	
	// Level 1 map
	private int[][] map1 = { {1,1,1,1,1,1,1,1,1},   
							 {1,0,1,1,1,1,1,1,1},
							 {1,0,0,0,0,1,1,1,1},
							 {1,0,1,1,0,1,1,1,1},
							 {1,0,0,0,0,0,0,0,1},
							 {1,0,1,1,0,1,1,0,1},
							 {1,0,1,0,0,0,1,0,1},
							 {1,0,0,0,1,0,0,2,1},
							 {1,1,1,1,1,1,1,1,1}};
	
	//Level 2 map
	private int[][] map2 = {{1,1,1,1,1,1,1,1,1,1,1,1},   
							{1,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,0,1,1,1,0,1,1,0,1},
							{1,1,1,0,1,1,1,0,1,1,0,1},
							{1,0,0,0,0,0,0,0,1,1,0,1},
							{1,0,1,1,1,1,1,0,1,1,0,1},
							{1,0,1,0,0,0,1,0,0,0,0,1},
							{1,0,0,0,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,0,1,1,1,1,1},
							{1,2,0,0,1,1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1,1,1,1,1,1}};
	
	//Level 3 map
	private int[][] map3 = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},   
							{1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1,1},
							{1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1},
							{1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1},
							{1,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1},
							{1,1,0,1,1,1,0,1,0,1,1,0,1,1,1,0,1,1},
							{1,1,0,1,0,0,0,1,0,0,0,0,1,0,1,0,1,1},
							{1,1,0,0,0,1,0,0,0,1,0,1,1,0,0,0,1,1},
							{1,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1},
							{1,2,0,0,0,1,1,0,0,0,0,1,0,0,0,0,1,1},
							{1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,1},
							{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
							{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
	
	/**
	 * a method to get the level 1 map
	 * @return int[][]
	 */
	public int[][] getMap1()
	{
		return map1;
	}
	
	/**
	 * a method to get the level 2 map
	 * @return int[][]
	 */
	public int[][] getMap2()
	{
		return map2;
	}
	
	/**
	 * a method to get the level 3 map
	 * @return int[][]
	 */
	public int[][] getMap3()
	{
		return map3;
	}
}
