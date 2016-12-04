
public class Moveable extends WorldObject {
	private Iterator iter;

	public Moveable(String assignedName, char assignedToken){
		super(assignedName, assignedToken);	
		
	}
		
	protected void bump(Direction bumpDirection) {
		
		DirectionIterations DirectionIteration = new DirectionIterations();
		iter = DirectionIteration.getIterator();
		iter.setWorld(thisWorld);
		iter.setThisObject(this);
		
		if (this.canMove(bumpDirection) == false){
			System.out.println("Sorry, this Object can not move in that direction");
			return;
		}
		
		int[] nextPosition = iter.next();
		this.position = nextPosition;
		
		WorldObject[][] worldArray = this.thisWorld.getWorld();
		WorldObject nextObj = worldArray[nextPosition[0]][nextPosition[1]];
		
		if (nextObj == null){
			return;
		}
		
		Moveable nextObjectMoveable = (Moveable) nextObj;
		nextObjectMoveable.bump(bumpDirection);
	
		return;
		
	}
	
	private boolean canMove(Direction bumpDirection){
		WorldObject[][] worldArray = this.thisWorld.getWorld();
		iter.setDirection(bumpDirection);
		
		while (iter.hasNext()){
			int[] nextPos = iter.next();
			if (worldArray[nextPos[0]][nextPos[1]] == null){
				return true;
			}
		}
		return false;
			
		}
	

	
}
