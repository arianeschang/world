////public class DirectionIterations implements Container {
//
//		@Override
//		public Iterator getIterator(){
//			return new StepIterator();
//		}
//		
//		private class StepIterator implements Iterator{
//			
//			int xIndex;
//			int yIndex;
//			Direction thisDirection;
//			World thisWorld;
//	
//			@Override
//			public void setWorld(World world){
//				thisWorld = world;
//			}
//			@Override
//			public void setDirection(Direction direction){
//				thisDirection = direction;
//			}
//			
//			@Override
//			public void setThisObject(WorldObject thisObj){
//
//				xIndex = thisObj.xPosition;
//				yIndex = thisObj.yPosition;
//				
//			}
//			
//			@Override
//			public boolean canMove()
//			{
//				return (thisWorld.getWorld()[xIndex][yIndex] instanceof Moveable);	
//			}
//
//			@Override
//			public int[] next(){
//				WorldObject[][] worldArray = thisWorld.getWorld();
//				int[] worldSize = thisWorld.getWorldSize();
//				int maxY = worldSize[1] - 1;
//				int maxX = worldSize[0] - 1;
//				int[] nextPosition = new int[2];
//				System.out.println(thisDirection);
//				
//				switch(thisDirection){
//				case up:
////					if (yIndex == 0){
////						nextPosition[0] = xIndex;
////						nextPosition[1] = yIndex;
////					}
//					if (yIndex!=0){
//						nextPosition[0] = xIndex;
//						nextPosition[1] = yIndex - 1;
//					}
//					return nextPosition;
//
//				case down:
////					if (yIndex == maxY){
////						nextPosition[0] = xIndex;
////						nextPosition[1] = 0;
////					}
//					if (yIndex!=maxY){
//						nextPosition[0] = xIndex;
//						nextPosition[1] = yIndex + 1;
//
//					}
//					return nextPosition;
//
//				case left:
////					if (xIndex == 0){
////						nextPosition[0] = maxX;
////						nextPosition[1] = yIndex;
////					}
//					if (xIndex != 0){
//						nextPosition[0] = xIndex - 1;
//						nextPosition[1] = yIndex;
//					}
//					return nextPosition;
//
//				case right:
////					if (xIndex == maxX){
////						nextPosition[0] = 0;
////						nextPosition[1] = yIndex;
////					}
//					if (xIndex != maxX){
//						nextPosition[0] = xIndex + 1;
//						nextPosition[1] = yIndex;
//					}
//					return nextPosition;
//
//				}
//				return null;
//			}
//			
//		}
//}
