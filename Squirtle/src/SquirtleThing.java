
public class SquirtleThing extends PokeThing {

	int squaresMoved = 1;
	
	/**
	 * SquirtleThing Constructor
	 * Creates a new <code>SquirtleThing</code> object.
	 * Associated graphics file will be squirtle.png
	 */
	public SquirtleThing()
	{
		super("Squirtle", "", 0);	
		setImageFileType(IMAGETYPE_PNG);
	}
	
	
	/**
	 * step method -- this method is called over and over
	 * <code>SquirtleThing</code> moves in a pattern and prints how far it has gone
	 */	
	public void step()
	{
		movementPattern();
		
		squaresMoved += 1;
		Gui g = getBoard().getGui();
		g.appendTextWindow("Squirtle has moved " + squaresMoved + " squares.");
	}
	
	
	/**
	 * movement in a repeating pattern
	 * <code>SquirtleThing</code> turns right if it is blocked or encounters a wall
	 */	
	public void movementPattern()
	{
		// Check the 'next' Location.  If there is a PokeThing or wall there, turn.
		boolean blocked;
		boolean stuck;
		boolean flowerBlock;
			
		Location nextLoc = getDirection().getNextLocation(getLocation()); 
		
		blocked = getBoard().thingAt(nextLoc) instanceof PokeThing;
		stuck = !(nextLoc.isValid(getBoard()));
		flowerBlock = getBoard().thingAt(nextLoc) instanceof FlowerThing;
		
		Gui g = getBoard().getGui();
		if (blocked)
		{
			move();
			g.appendTextWindow("Squirtle sees bulbasaur");
			setDirection(getDirection().left());
			
		} else if(stuck) {
			setDirection(getDirection().left());
			move();
			
		} else if (flowerBlock){
			
			g.appendTextWindow("Squirtle eats flower");
			
		} else
			move();
		
	}
}
