package tacticsBattle.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import tacticsBattle.objects.FightObjectComp;
import tacticsBattle.objects.FightObjectType;

public class Fight implements HasObjs
{
	List<FightObjectComp> objs;
	boolean needsCommand;
	FightObjectComp currObjToCommand;
	
	public Fight()
	{
		objs = new ArrayList<FightObjectComp>();
		needsCommand = false;
	}
	
	public List<FightObjectComp> getObjs()
	{
		return objs;
	}
	
	public float step(float delta)
	{
		// check to see if any obj will call a stop during this
		// increment
		float shortestTimeToCommand = delta;
		currObjToCommand = null;
		for (FightObjectComp obj : objs) 
		{
			if (obj.checkType(FightObjectType.TYPE_COMMANDABLE))
			{
				float thisObjTimeToCommand = obj.checkStopThisTurn(delta);
				if (thisObjTimeToCommand < shortestTimeToCommand)
				{
					currObjToCommand = obj;
					shortestTimeToCommand = thisObjTimeToCommand;
				}
			}else
			{
				// this is for AI
				// also we need a spot for
				// characters that are on auto-think or whatevs.
				
			}
		}
		// now run through with the adjusted time:
		for (FightObjectComp obj : objs)
		{
			obj.update(shortestTimeToCommand);
		}
		if (currObjToCommand != null)
		{
			this.needsCommand = true;
		}else
			this.needsCommand = false;
		return delta;
	}
	
	public FightObjectComp getObjToCommand()
	{
		return this.currObjToCommand;
	}
	
	public boolean checkNeedsCommand()
	{
		return this.needsCommand;
	}
	
	public void addFighter(FightObjectComp f)
	{
		objs.add(f);
		f.setObjHolder(this);
	}
	
	public void removeFighter(FightObjectComp f)
	{
		objs.remove(f);
		f.setObjHolder(null);
	}
}