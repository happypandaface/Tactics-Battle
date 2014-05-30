package tacticsBattle.commands;

import tacticsBattle.objects.FightObjectComp;
import tacticsBattle.util.Pos3;
import tacticsBattle.util.Pos3Comp;

public class MoveCommand extends FightCommand
{
	public FightObjectComp obj;
	public FightObjectComp tar;
	float speed = 0.001f;
	
	public void setTarget(FightObjectComp obj)
	{
		this.tar = obj;
	}
	public void setObj(FightObjectComp obj)
	{
		this.obj = obj;
	}
	public float checkStopThisTurn(float delta)
	{
		if (delta == 0)
			return 0;
		Pos3Comp dist = new Pos3();
		dist.set(this.tar.getPos());
		dist.sub(this.obj.getPos());
		
		float len = dist.len();
		
		return len/speed;
	}
	public void update(float delta)
	{
		if (delta == 0)
			return;
		Pos3Comp dist = new Pos3();
		dist.set(this.tar.getPos());
		dist.sub(this.obj.getPos());
		dist.nor();
		dist.mul(speed);
		this.obj.setPos(this.obj.getPos().add(dist));
	}
}