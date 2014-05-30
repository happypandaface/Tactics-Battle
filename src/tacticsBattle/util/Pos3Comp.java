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
	
	public float len();
	public float len2();
	
	public Pos3Comp add(Pos3Comp p);
	public Pos3Comp sub(Pos3Comp p);
	public Pos3Comp nor();
	public Pos3Comp mul(Pos3Comp p);
	public Pos3Comp div(Pos3Comp p);
	public Pos3Comp mul(float f);
	public Pos3Comp div(float f);
	
	public Pos3Comp set(float x, float y, float z);
	public Pos3Comp set(Pos3Comp p);
}