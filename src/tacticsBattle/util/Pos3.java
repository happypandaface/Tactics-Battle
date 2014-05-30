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
	
	public float len()
	{
		return this.x*this.x+this.y*this.y+this.z*this.z;
	}
	public float len2()
	{
		return (float)Math.sqrt(this.len());
	}
	
	public Pos3Comp add(Pos3Comp p)
	{
		this.x += p.getX();
		this.y += p.getY();
		this.z += p.getZ();
		return this;
	}
	public Pos3Comp sub(Pos3Comp p)
	{
		this.x -= p.getX();
		this.y -= p.getY();
		this.z -= p.getZ();
		return this;
	}
	public Pos3Comp nor()
	{
		float length = this.len2();
		this.x /= length;
		this.y /= length;
		this.z /= length;
		return this;
	}
	public Pos3Comp mul(Pos3Comp p)
	{
		this.x *= p.getX();
		this.y *= p.getY();
		this.z *= p.getZ();
		return this;
	}
	public Pos3Comp div(Pos3Comp p)
	{
		this.x /= p.getX();
		this.y /= p.getY();
		this.z /= p.getZ();
		return this;
	}
	public Pos3Comp mul(float f)
	{
		this.x *= f;
		this.y *= f;
		this.z *= f;
		return this;
	}
	public Pos3Comp div(float f)
	{
		this.x /= f;
		this.y /= f;
		this.z /= f;
		return this;
	}
	
	public Pos3Comp set(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	
	public Pos3Comp set(Pos3Comp p)
	{
		this.x = p.getX();
		this.y = p.getY();
		this.z = p.getZ();
		return this;
	}
}