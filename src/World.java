import java.lang.reflect.Method;
import java.util.*;


public class World 
{
	private boolean containsAutonomous;
	private final WorldObject[][] worldObjs;
	public WorldIter iter;
	

	public World(int latitude, int longitude){
		worldObjs = new WorldObject[latitude][longitude];
		this.iter = new WorldIter();
	}
	
	public void step()
	{
		if (!containsAutonomous)
		{
			System.err.println("This World contains no autonomous objects");
		}
		int x = (int)(Math.random() * (worldObjs.length));
		int y = (int)(Math.random() * (worldObjs[0].length));
		
		if (worldObjs[x][y] instanceof Autonomous)
		{
			((Autonomous)(worldObjs[x][y])).step();
		}
		else step();
	}
	
	public synchronized void step(Autonomous a, Direction d)
	{
		this.iter.shift(a, d);
	}
	
	public void display(){
		for(int i=0; i<worldObjs.length; i++){
			for (int j=0; j<worldObjs[0].length; j++){
				if (worldObjs[i][j] == null) {
					System.out.print(' ');
				}
				else{
					System.out.print(worldObjs[i][j].getToken());
				}
			}
			System.out.println("");
		}
	}
	
	public void add(WorldObject object, int xPos, int yPos){
		
		object.setWorld(this);

		if (worldObjs[xPos][yPos] != null){
			System.out.println("Can not add this item, there is already an item there");
		}
		else
		{
			worldObjs[xPos][yPos] = object;
			object.setPosition(xPos, yPos);
			if (object instanceof Autonomous) containsAutonomous = true;
		}
	}
	
	protected WorldObject getObjAt(int x, int y)
	{
		return worldObjs[x][y];
	}
	
	public int[] getWorldSize()
	{
		int[] worldSize = new int[2];
		worldSize[0] = worldObjs.length;
		worldSize[1] = worldObjs[0].length;
		return worldSize;
	}

	private class WorldIter implements Iterator<WorldObject> 
	{
		private Direction dir;
		private WorldObject currentObj;
		
		private void shift(Autonomous m, Direction dir)
		{
			this.dir = dir;
			this.currentObj = m;

			while (this.hasNext())
			{
				if ((this.next()) instanceof Moveable)
				{
					this.currentObj = this.next();
				}
				else break;
			}
			
			if (this.next() instanceof Immoveable) return;
			
			else
			{
				int[] nextIndices = nextIndices();
				if (nextIndices[0] >= 0 && nextIndices[1] >= 0 && (worldObjs[nextIndices[0]][nextIndices[1]] == null))
				{
//					while  (!this.prev().equals(m))
//					{
						this.shift(nextIndices[0], nextIndices[1]);
					//}
				}
			}
		}
		
		private void shift(int i, int j)
		{
			worldObjs[currentObj.xPosition][currentObj.yPosition] = null;
			final WorldObject prevObject = this.prev();
			final int xX = currentObj.xPosition;
			final int xY = currentObj.yPosition;
			worldObjs[i][j] = currentObj;
			currentObj.xPosition = i;
			currentObj.yPosition = j;
			if (prevObject != null && (prevObject instanceof Moveable))
			{
				System.out.println(i + " " + j);
				this.currentObj = prevObject;
				shift(xX, xY);
			}
		}
		
		
		public boolean hasNext() 
		{
			switch(dir)
			{
				case down:
					if (currentObj.yPosition > 0 && worldObjs[currentObj.xPosition][currentObj.yPosition - 1] != null) 
					{
						return true;
					}
				case up:
					if (currentObj.yPosition < worldObjs[0].length - 1 && worldObjs[currentObj.xPosition][currentObj.yPosition + 1] != null)
					{
						return true;
					}
				case left:
					if (currentObj.xPosition > 0 && worldObjs[currentObj.xPosition - 1][currentObj.yPosition] != null)
					{
						return true;
					}
				case right:
					if (currentObj.xPosition < worldObjs.length - 1 && worldObjs[currentObj.xPosition + 1][currentObj.yPosition]!= null)
					{
						return true;
					}
			}
			return false;
		}


		@Override
		public WorldObject next() 
		{
			switch(dir)
			{
				case down:
					if (currentObj.yPosition > 0){
					return worldObjs[currentObj.xPosition][currentObj.yPosition - 1];
					}
				case up:
					if (currentObj.yPosition < worldObjs[0].length - 1){
						return worldObjs[currentObj.xPosition][currentObj.yPosition + 1];
					}
				case left:
					if (currentObj.xPosition > 0){
						return worldObjs[currentObj.xPosition - 1][currentObj.yPosition];
					}
				case right:
					if (currentObj.xPosition < worldObjs.length - 1){
						return worldObjs[currentObj.xPosition + 1][currentObj.yPosition];
					}
			}
			return null;
		}
		
		private WorldObject prev() 
		{
			switch(dir)
			{
				case up:
					if (currentObj.yPosition > 0){
					return worldObjs[currentObj.xPosition][currentObj.yPosition - 1];
					}
				case down:
					if (currentObj.yPosition < worldObjs[0].length - 1){
						return worldObjs[currentObj.xPosition][currentObj.yPosition + 1];
					}
				case right:
					if (currentObj.xPosition > 0){
						return worldObjs[currentObj.xPosition - 1][currentObj.yPosition];
					}
				case left:
					if (currentObj.xPosition < worldObjs.length - 1){
						return worldObjs[currentObj.xPosition + 1][currentObj.yPosition];
					}
			}
			return null;
		}
		
		private int[] nextIndices() 
		{
			int[] nextIndices = {-1,-1};
			switch(dir)
			{
				case down:
					if (currentObj.yPosition > 0)
					{
						nextIndices[0] = currentObj.xPosition;
						nextIndices[1] = currentObj.yPosition - 1;
					}
				case up:
					if (currentObj.yPosition < worldObjs[0].length - 1){
						nextIndices[0] = currentObj.xPosition;
						nextIndices[1] = currentObj.yPosition + 1;
					}
				case left:
					if (currentObj.xPosition > 0){
						nextIndices[0] = currentObj.xPosition - 1;
						nextIndices[1] = currentObj.yPosition;
					}
				case right:
					if (currentObj.xPosition < worldObjs.length - 1){
						nextIndices[0] = currentObj.xPosition + 1;
						nextIndices[1] = currentObj.yPosition;	
					}
			}
			return nextIndices;
		}

		@Override
		public void remove() 
		{
			// TODO Auto-generated method stub
		}
			
	}

}
