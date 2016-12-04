import java.util.Iterator;

abstract class WorldObject {
	
	//public or private?
	private String name;
	private char token;
	protected int[] position;
	protected World thisWorld;
	
	

	public WorldObject(String assignedName, char assignedToken){
		this.name = assignedName;
		this.token = assignedToken;
	}

	protected void setPosition(int xPos, int yPos)
	{
		int [] positions = new int[2];
		positions [0] = xPos;
		positions [1] = yPos;
		this.position = positions;
	}
	
	protected void setWorld(World world){
		thisWorld = world;
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
