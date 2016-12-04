import java.util.*;


public class World{

	private WorldObject[][] thisWorld;

	public World(int latitude, int longitude){
		thisWorld = new WorldObject[latitude][longitude];
	}
	
	public void step(){

	}
	
	public void display(){
		for(int i=0; i<thisWorld.length; i++){
			for (int j=0; j<thisWorld[0].length; j++){
				if (thisWorld[j][i] == null) {
					System.out.print(' ');
				}
				else{
					System.out.print(thisWorld[j][i].getToken());
				}
			}
			System.out.println();
		}
	}
	
	public void add(WorldObject object, int xPos, int yPos){
		
		char objectChar = object.getToken();
		object.setWorld(this);

		
		if (thisWorld[xPos][yPos] != null){
			System.out.println("Can not add this item, there is already an item there");
		}
		else{
			thisWorld[xPos][yPos] = object;
			object.setPosition(xPos, yPos);
		}
	}
	
	public WorldObject[][] getWorld(){
		return thisWorld;
	}
	
	public int[] getWorldSize(){
		
		int[] worldSize = new int[2];
		WorldObject[][] thisWorld = getWorld();
		worldSize[0] = thisWorld[0].length;
		worldSize[1] = thisWorld.length;
		
		return worldSize;
	}		
	
	
}
