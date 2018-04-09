package room;

import anno.*;

public class Room5 {

	@Direction(command="go south")
	private Room3 south;
	
	private boolean babyDead = false;
	private boolean tookSword = false;
	
	private int count = 0;

	public String getDescription()
	{
		count++;
		return "You are in room 5 - "+count+" times";
	}
	
	@Command(command="attack")
	public String attack() {
		String output;
		if (tookSword){
            output = "You charge to attack the dragon brandishing your sword.  The dragon breathes fire into the chamber turning you to ash... The End.\n";
        }
        else{
            output = "In a flash of wisdom, you resist.  Only a fool would attack such a creature with his bare hands.\n";
        }
		
		return output;
	}
	
	@Command(command="passphrase")
	public String passphrase(String ans) {
		String output;
		if ((ans.equalsIgnoreCase("AlaKaZam"))){
            if (babyDead){
                output = "That is correct.  The dragon breathes fire into the chamber turning you to ash for killing her baby... The End.\n";
            }
            else{
                output ="That is correct.  The dragon allows you to pass and you escape... Congratulations on your 10pts.\n";
            }
        }
        else{
            output = "That is incorrect.  The dragon breathes fire into the chamber turning you to ash... The End.\n";
        }
        
        return output;
	}
	
	@Command(command="look")
	public String look() {
		return "There is no way around the dragon.\n";
	}
}
