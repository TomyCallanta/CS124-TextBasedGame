package room;
import anno.*;

public class MaterHouse implements City{

	@Direction(command="go to Flo's cafe")
	private FloCafe fc;
	@Direction(command="go to the road")
	private Road r;
	@Direction(command="go to theater")
	private Theatre t;

	private int count = 0;
	private Player mater; 
	
	public void setPlayer(Player p) {}
	
	public String getDescription()
	{
		count++;
		String output = "You arrive at Mater's House - "+count+" times\n"; 
		output += "It is a pleasant morning in Radiator Springs.\n"
				+ "While deciding what to do for that morning you hear your phone ringing.\n";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'checkCommands'.\n";
		output += "You can command to 'findPhone'.\n";
        output += "You can command to 'look'.\n";
        output += "You can command to 'go to Flo's cafe'.\n";
        output += "You can command to 'go to the road'.\n";
        output += "You can command to 'go to theater'.\n";
        return output;
	}
	
	@Command(command = "checkCommands")
	public String checkCommands(){
		String output = "";
		output += "You can command to 'findPhone'.\n";
        output += "You can command to 'look'.\n";
        output += "You can command to 'go to Flo's Cafe'.\n";
        output += "You can command to 'go to the road'.\n";
        output += "You can command to 'go to Drive-In Theater'.\n";
		return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	
	@Command(command="findPhone")
	public String findPhone() {
		return "You find your phone and answered it.\n "
				+ "Sheriff: Hello? This is the Sheriff speaking! Mater, we have 2 cars "
				+ "that need your help. \n One is at Radiator Spring's Drive-In Theater. "
				+ "He seems to have a flat tire, while the other car is at Willy Butte. \n "
				+ "Sheriff: Can you help them? \n "
				+ "Mater: Of course! I am on my way. \n";	
	}
	
	@Command(command="look")
	public String look() {
		return "Nothing seems to be out of the ordinary in your room. \n";
	}
}