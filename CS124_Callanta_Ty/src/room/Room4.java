package room;

import anno.*;

public class Room4 {
	@Direction(command="go north")
	private Room3 north;
	
	private boolean wordFound4 = false;
	
	private int count = 0;
	
	public String getDescription()
	{
		count++;
		return "You are in room 4 -" +count+" times";
	}
	
	@Command(command="look")
	public String look() {
		return "You see nothing of interest.\n";
	}
	
	@Command(command="answer")
	public String answer(Integer ans) {
		String output = "";
		if (ans==342*587){
            wordFound4 = true;
            
            output = "A low voice reverberates the word 'Ka' and fades away\\n";   
        }
        else{
            output = "The door closes behind you and you are trapped here forever to contemplate the value of 342*587... The End\n";
        }
		
		return output;
	}
}
