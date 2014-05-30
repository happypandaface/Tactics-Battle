package tacticsBattle.commands;

import tacticsBattle.objects.FightObjectComp;

public interface FightCommandComp
{
	
	public float checkStopThisTurn(float delta);
	
	public void update(float delta);
}