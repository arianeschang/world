import java.util.Iterator;

abstract class WorldObject {
	//public or private?
	private String name;
	private char token;
	protected int xPosition;
	protected int yPosition;
	protected World myWorld;

	
	public WorldObject(String assignedName, char assignedToken){
		this.name = assignedName;
		this.token = assignedToken;
	}

	protected void setPosition(int xPos, int yPos)
	{
		this.xPosition = xPos;
		this.yPosition = yPos;
	}
	
	protected void setWorld(World world){
		myWorld = world;
	}

	
	public char getToken()
	{
		return this.token;
	}
	
	public String getName()
	{
		return this.name;
	}

	
	
}
