package tacticsBattle.example;

import tacticsBattle.core.Fight;
import tacticsBattle.objects.Character;
import tacticsBattle.objects.Enemy;
import tacticsBattle.objects.FightObjectComp;
import tacticsBattle.commands.MoveCommand;
import tacticsBattle.objects.FightObjectType;
import java.util.Scanner;
import java.util.List;

public class Example
{
	public static long lastTime;
	
    public static void main(String[] args)
	{
		Fight fight = new Fight();
		Character guy = new Character();
		guy.setName("jason");
		guy.addType(FightObjectType.TYPE_COMMANDABLE);
		fight.addFighter(guy);
		{
			Enemy orc = new Enemy();
			orc.setName("orc");
			fight.addFighter(orc);
		}
		{
			Enemy orc = new Enemy();
			orc.setName("orc");
			fight.addFighter(orc);
		}
		int i = 0;
		Scanner scan = new Scanner(System.in);
        System.out.println("Ready!");
		boolean done = false;
		lastTime = System.currentTimeMillis();
		while(!done)
		{
			long now = System.currentTimeMillis();
			float delta = now - lastTime;
			lastTime = now;
			fight.step(delta);
			if (fight.checkNeedsCommand())
			{
				FightObjectComp commandObj = fight.getObjToCommand();
				System.out.println(commandObj.getName()+" needs a command!");
				String cmd = scan.nextLine();
				String[] cmdParts = cmd.split(" ");
				
				switch(cmdParts[0])
				{
					case "start":
						System.out.println("Here we go!");
						break;
					case "state":
						for (FightObjectComp obj : fight.getObjs())
						{
							System.out.println(obj.getRelativeName());
						}
						break;
					case "go":
						MoveCommand mc = new MoveCommand();
						commandObj.executeCommand(mc);
						break;
					case "move":
						// check for indicators as to where to move
						for (FightObjectComp obj : fight.getObjs())
						{
						}
						break;
					case "quit":
					case "end":
					case "exit":
						done = true;
						break;
				}
				lastTime = System.currentTimeMillis();
			}
			//System.out.println(""+System.currentTimeMillis());
		}
		System.out.println("Cya!");
    }
}