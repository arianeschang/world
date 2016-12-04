
public abstract class Move {
	
	abstract void initialize(Direction direction, World thisWorld, WorldObject thisObject);
	abstract void startPlay();
	abstract void endPlay();
	
	public final void play(){

	      //initialize the game
	      initialize(Direction direction, World thisWorld, WorldObject thisObject);

	      //start game
	      startPlay();

	      //end game
	      endPlay();
	}
	
	
	
	

}
