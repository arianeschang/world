import java.util.Iterator;

//public class WorldIter implements Iterator<WorldObject> 
//{
//	private Direction dir;
//	private WorldObject[][] worldObjs;
//	private WorldObject currentObj;
//	
//	public void shift(Moveable m, Direction dir)
//	{
//		this.dir = dir;
//		currentObj = m;
//		if (!(this.hasNext()) || this.next() instanceof Immoveable) return;
//
//		while (this.hasNext() && (this.next()) instanceof Moveable)
//		{
//			currentObj = this.next();
//		}
//		
//		if (this.next() == null)
//		{
//			this.shift();
//		}
//		
//		shift(m, dir);
//	}
//	
//	private void shift()
//	{
//		if (freeSpot(this.next().xPosition, this.next().yPosition))
//		{
//			worldObjs[this.next().xPosition][this.next().yPosition] = currentObj;
//			worldObjs[currentObj.xPosition][currentObj.yPosition] = null;
//			currentObj.xPosition = this.next().xPosition;
//			currentObj.yPosition = this.next().yPosition;
//		}
//	}
//	
//	private boolean freeSpot(int x, int y)
//	{
//		return (worldObjs[x][y].equals(null));
//	}
//	
//	public boolean hasNext() 
//	{
//		switch(dir)
//		{
//			case down:
//				if (currentObj.yPosition > 0 && worldObjs[currentObj.xPosition][currentObj.yPosition - 1] != null) 
//					return true;
//			case up:
//				if (currentObj.yPosition < worldObjs.length - 1 && worldObjs[currentObj.xPosition][currentObj.yPosition + 1] != null)
//					return true;
//			case left:
//				if (currentObj.xPosition > 0 && worldObjs[currentObj.xPosition - 1][currentObj.yPosition] != null)
//					return true;
//			case right:
//				if (currentObj.xPosition < worldObjs[0].length - 1 && worldObjs[currentObj.xPosition + 1][currentObj.yPosition]!= null)
//					return true;
//		}
//		return false;
//	}
//
//
//	@Override
//	public WorldObject next() 
//	{
//		switch(dir)
//		{
//			case down:
//				if (currentObj.yPosition > 0)
//				return worldObjs[currentObj.xPosition][currentObj.yPosition - 1];
//			case up:
//				if (currentObj.yPosition < worldObjs.length - 1)
//					return worldObjs[currentObj.xPosition][currentObj.yPosition + 1];
//			case left:
//				if (currentObj.xPosition > 0)
//					return worldObjs[currentObj.xPosition - 1][currentObj.yPosition];
//			case right:
//				if (currentObj.xPosition < worldObjs[0].length - 1)
//					return worldObjs[currentObj.xPosition + 1][currentObj.yPosition];
//		}
//		return null;
//	}
//	
//	public int[] getPosition()
//	{
//		int [] pos = {currentObj.xPosition, currentObj.yPosition};
//		return pos;
//	}
//
//	@Override
//	public void remove() 
//	{
//		// TODO Auto-generated method stub
//	}
//		
//	
//}
