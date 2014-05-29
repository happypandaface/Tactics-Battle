package tacticsBattle.util;

public class Pos3 implements Pos3Comp
{
	float x;
	float y;
	float z;
	public Pos3()
	{
		x = 0;
		y = 0;
		z = 0;
	}
	public Pos3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getZ()
	{
		return z;
	}
}