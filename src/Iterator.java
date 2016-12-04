
public interface Iterator {
	public void setDirection(Direction thisDirection);
	public void setWorld(World thisWorld);
	public void setThisObject(WorldObject thisObject);
	public boolean hasNext();
	public int[] next();
	public boolean canMove();
}
