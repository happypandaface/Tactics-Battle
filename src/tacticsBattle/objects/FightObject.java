package tacticsBattle.objects;

import tacticsBattle.commands.FightCommandComp;
import tacticsBattle.util.Pos3;
import tacticsBattle.util.Pos3Comp;
import tacticsBattle.core.HasObjs;
import java.util.EnumMap;

public class FightObject implements FightObjectComp
{
	float timeTilCommand = 500;
	String name;
	Pos3 pos;
	EnumMap<FightObjectType, Boolean> types;
	HasObjs objHolder;
	
	public FightObject()
	{
		types = new EnumMap<FightObjectType, Boolean>(FightObjectType.class);
	}
	
	public void setObjHolder(HasObjs ho)
	{
		this.objHolder = ho;
	}
	
	public boolean checkType(FightObjectType type)
	{
		if (types.get(type) == null)
			return false;
		return true;
	}
	
	public boolean addType(FightObjectType type)
	{
		boolean rtn = checkType(type);
		types.put(type, true);
		return rtn;
	}
	
	public float getX()
	{
		return pos.getX();
	}
	
	public float getY()
	{
		return pos.getY();
	}
	
	public float getZ()
	{
		return pos.getZ();
	}
	
	public Pos3Comp getPos()
	{
		return pos;
	}
	
	public float checkStopThisTurn(float delta)
	{
		this.timeTilCommand -= delta;
		return this.timeTilCommand;
	}
	
	public void update(float delta)
	{
		
	}
	
	public void executeCommand(FightCommandComp f)
	{
		this.timeTilCommand = 1000;
	}
	public String getName()
	{
		return this.name;
	}
	public String getRelativeName()
	{
		// this method makes sure no two objects in the fight have
		// the same name
		int objsBefore = 0;
		int objsAfter = 0;
		boolean checkingBefore = true;
		for (FightObjectComp obj : this.objHolder.getObjs())
		{
			if (obj == this)
				checkingBefore = false;
			else
			if (obj.getName().equals(this.getName()))
			{
				if (checkingBefore)
					++objsBefore;
				else
					++objsAfter;
			}
				
		}
		if (objsBefore == 0 && objsAfter == 0)
			return this.getName();
		else
			return this.getName()+(objsBefore+1);
	}
	public void setName(String s)
	{
		this.name = s;
	}
}