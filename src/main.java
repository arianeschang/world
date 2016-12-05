import java.util.*;

public class main {

	public static void main(String[] args){
			
		World myWorld = new World(1, 15);
		
		int[] worldSize = myWorld.getWorldSize();
		
		 Random randomGenerator = new Random();
		 
		 for (int i = 0; i < worldSize[0]; i++)
		 {
			 for (int j = 0; j < worldSize[1]; j++)
			 {
				 int objType = randomGenerator.nextInt(5);
				 WorldObject newObj;
				 if (objType == 0) newObj = new Autonomous("", 'a');
				 else if (objType == 1) newObj = new Moveable("", 'm');
				 else if (objType == 2) newObj = new Immoveable("", 'x');
				 else continue;
				 myWorld.add(newObj, i, j);
			 }
		 }
		 
		 int i = 0;
		 int max = 100;
		 
		 while (i < max)
		 {
			 myWorld.display();
			 myWorld.step();
			 System.out.println(" ");
			 i++;
		 }

		
				
	}
}
