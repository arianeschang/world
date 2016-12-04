import java.util.*;

public class main {

	public static void main(String[] args){
			
		World myWorld = new World(5, 5);
		
		WorldObject[][] myWorldArray = myWorld.getWorld();
		int[] worldSize = myWorld.getWorldSize();
				
		int numAdditions = 0;
		
		Autonomous Ariane = new Autonomous("Ariane", '/');
		Immovable Building = new Immovable("Building", '+');
		Immovable Road = new Immovable("Road", '=');
		Moveable Chair = new Moveable("Chair", '1');
		Moveable Table = new Moveable("Ariane", '(');
		Autonomous Lindsey = new Autonomous("Caitrin", ')');
		
		
		
		myWorld.add(Ariane, 0, 0);
		//myWorld.add(Building, 2, 0);
		myWorld.add(Chair, 1, 0);
		myWorld.add(Table, 1, 1);
		myWorld.display();
		
		System.out.println("before ariane");
		System.out.println(Ariane.position[0]);
		System.out.println(Ariane.position[1]);

		Ariane.step();
		
		System.out.println("after ariane");
		System.out.println(Ariane.position[0]);
		System.out.println(Ariane.position[1]);
		
		System.out.println("after chair");
		System.out.println(Chair.position[0]);
		System.out.println(Chair.position[1]);

		
				
	}
}
