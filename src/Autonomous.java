
public class Autonomous extends Moveable {
	
	public Autonomous(String assignedName, char assignedToken){
		super(assignedName, assignedToken);
	}
	
	public void step(){
		Direction[] directionValues = Direction.values();
		Direction randomDirection = directionValues[(int)(Math.random() * directionValues.length)];
		System.out.println(randomDirection);
		
		this.bump(randomDirection);
	}
}
