package tacticsBattle.util;

/*
This class was made because someone
might pair this engine with like,
a graphics engine, and then they will
have to use this to wrap the graphics
engine's own 3D vector in it.
 */

public interface Pos3Comp
{
	public float getX();
	
	public float getY();
	
	public float getZ();
}