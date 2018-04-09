package room;

import anno.*;

public class Room1 {

	@Direction(command="go north")
	private Room2 north;


	private Object boo;
	
	private int count = 0;
	
	public String getDescription()
	{
		count++;
		String output = "You are in room 1 - "+count+" times\n"; 
		
		output += "You find yourself inside a dark room. You see a door to your north\n";
		
		return output;
	}
}
