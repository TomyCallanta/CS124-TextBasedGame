package room;

import anno.*;

public class Room2 {

	@Direction(command="go east")
	private Room3 east;
	
	@Direction(command="go south")
	private Room1 south;
	
	private boolean tookSword = false;
	private boolean wordFound2 = false;
	
	private int count = 0;
	private boolean inPool = false;
	private boolean graveFound = false;
	
	public String getDescription()
	{
		count++;
		String output ="You are in room 2 - "+count+" times\n";
		output +="You the door leads down some steps into an underground cave system. There is a deep pool in the middle of the cave.\n";
        output +="You see something shiny at the bottom of the pool.\n";
        output +="You can command to 'swim' in the pool.\n";
        output +="You can command to 'look' around.\n";
		return output;
	}
	
	@Command(command="list")
	public String listMethods() {
		String output = "";
		if(!inPool) output += "swim\n";
		else output += "takeSword\n";
		if(graveFound) output += "dig\n";
		output += "look\n";
		
		return output;
	}
	
	@Command(command="swim")
	public String swim() {
		inPool = true;
		return "You find a shiny sword at the bottom.\nYou can command to takeSword.\n";
	}
	
	@Command(command="takeSword")
	public String takeSword() {
		if(inPool) {
			tookSword = true;
			return "You take the bright and shiny sword.\n";	
		}else {
			return "What sword?\n";
		}
	}
	
	@Command(command="look")
	public String look() {
		if (!graveFound){
            graveFound = true;
            return "You find a pile rubble.  It looks like a shallow grave.\nYou can command to 'dig' to see what is under it.\n";
        }else{
            return "You see nothing else of interest.\n";
        }
	}
	
	@Command(command="dig")
	public String dig() {
		String output = "";
		if (!graveFound)
        {
            output = "You dig into the ground and disturb the home of a poisonous snake.  It bites and you die... The End\n";
        }
        else
        {
            wordFound2 = true;
            output = "You dig up the grave and find a skeleton holding a scroll.  It contains 3 words but 2 are unreadable.  The remaining word says 'Zam'\n";
        }
        
        return output;
	}
}
