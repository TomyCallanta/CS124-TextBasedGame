package room;
import anno.Command;
import anno.Direction;

public class Ditch implements City{
	
	@Direction(command="go to the park")
	private Park p;
	@Direction(command = "go to Luigi's Casa Della Tires")
	private TirePlace tp;
	@Direction(command="go to Drive-In Theatre")
	private Theatre t;
	
	private int count = 0;
	private Player mater; 
	
	public void setPlayer(Player p) {
		mater = p;
	}
	
	public String getDescription()
	{
		count++;
		String output = "You arrive at Willy Butte - "+count+" times\n"; 
		output += "Willy Butte is a racecar track. \n"
				+ "In the distance you see a ditch and can hear someone calling for help. \n";
		output += "You can command to 'checkCommands'.\n";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'exploreNoise'.\n";
        output += "You can command to 'go to the park'.\n";
        output += "You can command to 'go to Luigi's Casa Della Tires'.\n";
        output += "You can command to 'go to Drive-In Theatre'.\n";
        return output;
	}
	
	@Command(command = "checkCommands")
	public String checkCommands(){
		String output = "";

		output += "You can command to 'checkCommands'.\n";
		output += "You can command to 'exploreNoise'.\n";
        output += "You can command to 'go to the park'.\n";
        output += "You can command to 'go to Luigi's Casa Della Tires'.\n";
        output += "You can command to 'go to Drive-In Theatre'.\n";
		return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	
	@Command(command = "exploreNoise")
	public String exploreNoise(){
		String output = "";
		output += "You discover a car in the bottm of the ditch having a hard time getting out what should you do? \n";
		output += "Marga: Hello Mater! My name is Marga. I need help getting out of this ditch. I was practicing for a big race comming up and I fell into this ditch. \n"
				+ "Mater: Just like how Lightning McQueen started. Let me see what I can do. \n";
		output += "You can command to 'reachout' to reach for Marga and try to pull her out .\n";
        output += "You can command to 'searchArea'.\n";
        if(mater.checkBag("hook")!= -1) {
        	output += "You can command to 'useHook'.\n";	
        }
		return output;
	}
	
	@Command(command = "reachOut")
	public String reachOut(){
		String output = "";
		output += "You tried to each out to get Marga out of the ditch \n"
				+ "It does not seem to work. Maybe you need a hook to get her out. \n";
		return output;
	}
	
	@Command(command = "searchArea")
	public String searchArea(){
		String output = "";
		output += "You try to find a rope, to help get Marga out. \n"
				+ "Nothing seems to be of use \n";
		return output;
	}
	
	@Command(command = "useHook")
	public String useHook(){
		String output = "";
		output += "You attach the hook to Marga and pull her out.\n"
				+ "She looks exausted and she asks to bring her to a secret location \n"
				+ "Marga: I am late to a meeting can you bring me to this address? \n"
				+ "Suddenly Marga faints, leaving you clueless \n"
				+ "I guess I have to bring her to this location. It says it is by the park.\n";
		return output;
	}
}