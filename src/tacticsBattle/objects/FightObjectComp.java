package tacticsBattle.objects;

import tacticsBattle.commands.FightCommandComp;
import tacticsBattle.objects.FightObjectType;
import tacticsBattle.util.Pos3Comp;
import tacticsBattle.core.HasObjs;
import tacticsBattle.core.HasCmds;

public interface FightObjectComp
{
	
	public boolean checkType(FightObjectType type);
	
	public boolean addType(FightObjectType type);
	
	public float checkStopThisTurn(float delta);
	
	public void update(float delta);
	
	public void executeCommand(FightCommandComp f);
	
	public String getName();
	
	public String getRelativeName();
	
	public float getX();
	
	public float getY();
	
	public float getZ();
	
	public Pos3Comp getPos();
	
	public void setPos(float x, float y, float z);
	
	public void setPos(Pos3Comp p);
	
	public float getSize();
	
	public void setObjHolder(HasObjs ho);
	
	public void setCmdHolder(HasCmds ho);
}