package room;

import anno.*;

public class Room3 {

	@Direction(command="go west")
	private Room2 west;
	@Direction(command="go north")
	private Room5 north;
	@Direction(command="go south")
	private Room4 south;
	

	private boolean tookSword = false;
	private boolean wordFound3 = false;
	private boolean babyDead = false;
	
	private boolean chestFound = false;
	
	
	private int count = 0;

	public String getDescription()
	{
		count++;
		return "You are in room 3 -" +count+" times";
	}
	
	@Command(command="attack")
	public String attack() {
		String output= "";
		if (tookSword)
        {
            babyDead = true;
            output += "You charge the baby dragon with your bright shiny sword.  You cleave its head clean off.\n";
            output += "You can 'look' around.\n";
        }
        else
        {
            output += "You charge the baby dragon and try to take in on with your bare hands.  Its wakes and bites your head clean off... The End\n";
        }
        
        return output;
	}
	
	@Command(command="look")
	public String look() {
		String output = "";
		if(!chestFound) {
			if(!babyDead) {
				output += "You quietly avoid the baby dragon and make your way to the other side of the chamber and find a chest.\n";
				output += "You can 'openChest'\n";
			}else {
				output += "You make your way to the other side of the chamber and find a chest.\n";
				output += "You can 'openChest'\n";
			}
		}else {
			
		}
		return output;
	}
	
	@Command(command="openChest")
	public String openChest() {
		String output = "";
		
		if (chestFound){
            wordFound3 = true;
            output = "Inside is a book.  A page is ear-marked and the word 'Ala' written in blood.\n";
        }
        else{
            output = "What chest?\n";
        }
        
        return output;
	}
}
