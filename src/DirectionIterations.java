
public class DirectionIterations implements Container {

	
	
		@Override
		public Iterator getIterator(){
			return new StepIterator();
		}
		
		private class StepIterator implements Iterator{
			
			int xIndex;
			int yIndex;
			Direction thisDirection;
			World thisWorld;
	
			@Override
			public void setWorld(World world){
				thisWorld = world;
			}
			@Override
			public void setDirection(Direction direction){
				thisDirection = direction;
			}
			
			@Override
			public void setThisObject(WorldObject thisObj){

				int[] positions = thisObj.position;
				System.out.println(positions[0]);
				System.out.println(positions[1]);

				xIndex = positions[0];
				yIndex = positions[1];
				
			}
			
			@Override
			public boolean canMove(){
				
				return true;	
			}
			
			public boolean hasNext(){
				int xPos = this.next()[0];
				int yPos = this.next()[1];
				
				WorldObject nextObject = thisWorld.getWorld()[xPos][yPos];
				if (nextObject == null){
					return true;
				}
				if (nextObject.getClass().getName() == "Immoveable"){
					return false;
				}
				else{
					return true;
				}
			}
			
			@Override
			public int[] next(){
				WorldObject[][] worldArray = thisWorld.getWorld();
				int[] worldSize = thisWorld.getWorldSize();
				int maxY = worldSize[1] - 1;
				int maxX = worldSize[0] - 1;
				int[] nextPosition = new int[2];
				
				switch(thisDirection){
				case up:
					if (yIndex == 0){
						nextPosition[0] = xIndex;
						nextPosition[1] = maxY;
					}
					else{
						nextPosition[0] = xIndex;
						nextPosition[1] = yIndex - 1;
					}
					return nextPosition;

				case down:
					System.out.println(xIndex);
					System.out.println(yIndex);

					if (yIndex == maxY){
						nextPosition[0] = xIndex;
						nextPosition[1] = 0;
					}
					else{
						nextPosition[0] = xIndex;
						nextPosition[1] = yIndex + 1;

					}
					return nextPosition;

				case left:
					if (xIndex == 0){
						nextPosition[0] = maxX;
						nextPosition[1] = yIndex;
					}
					else{
						nextPosition[0] = xIndex - 1;
						nextPosition[1] = yIndex;
					}
					return nextPosition;

				case right:
					if (xIndex == maxX){
						nextPosition[0] = 0;
						nextPosition[1] = yIndex;
					}
					else{
						nextPosition[0] = xIndex + 1;
						nextPosition[1] = yIndex;
					}
					return nextPosition;

				}
				return null;
			}
			
		}
}
