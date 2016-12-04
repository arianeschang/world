
public class Moveable extends WorldObject {
	public Moveable(String assignedName, char assignedToken){
		super(assignedName, assignedToken);
	}
		
//	protected void bump(Direction bumpDirection) {
//		
//		int newIndex = getNewIndex(bumpDirection);
//		if (newIndex >= 0)
//		{
//			int newX = -1;
//			int newY = -1;
//			if (bumpDirection.equals(Direction.up) || bumpDirection.equals(Direction.down))
//			{
//				newX = xPosition;
//				newY = newIndex;
//			}
//			else if (bumpDirection.equals(Direction.right) || bumpDirection.equals(Direction.left))
//			{
//				newX = newIndex;
//				newY = yPosition;
//			}
//						
//			WorldObject nextObj = myWorld.getObjAt(newX, newY);
//			this.setPosition(newX, newY);
//			
//			if (nextObj instanceof Moveable && !(nextObj.equals(this)))
//			{
////				System.out.println(nextObj.xPosition);
//				((Moveable)(nextObj)).bump(bumpDirection);
//			}
//		
//		}
//	}
////	
//	private int getNewIndex(Direction dir)
//	{		
//		switch(dir){
//		case up:
//			if (yPosition != 0){
//				return yPosition - 1;
//			}
//		case down:
//			if (yPosition != this.myWorld.getWorldSize()[1] -1){
//				return yPosition + 1;
//			}
//
//		case left:
//			if (xPosition != 0){
//				return xPosition - 1;
//			}
//
//		case right:
//			if (xPosition != this.myWorld.getWorldSize()[0] -1){
//				return xPosition +1;
//			}
//		}
//		return -1;
//	}
	
}
