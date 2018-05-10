package room;
import anno.Command;
import anno.Direction;
import anno.EnterCondition;

@EnterCondition(intercept = "say")
public class SecretHideout implements City{
	
	@Direction(command="go to the park")
	private Park p;
	
	private int count = 0;
	private Player mater; 
	private boolean inquired = false;
	public void setPlayer(Player p) {
		mater = p;
	}
	
	public String getDescription()
	{
		count++;
		String output = "You arrive at the Secret Hideout - "+count+" times\n"; 
		output += "You arrive an empty street with a door at the end of the alley way. \n "
				+ " You try to wake up Marga but she does not respond. As you approach the door you see a slot \n"
				+ "You  knock the door then the slit opens revealing two eyes staring at you. \n "
				+ "Mater: Excuse me, would it be possible for me to leave Marga here? She does not want to wake up. \n"
				+ "Guy: Password. \n"
				+ "Mater: Password? \n"
				+ "Guy: This is the Lightning McQueen fan club. What is the password. Only the biggest fans can enter. \n"
				+ "You can command to 'checkCommands'. \n";
		output += "You can command to 'checkInventory'.\n"
				+ "You can command to 'say <Password>'. \n"
				+ "You can command to 'go to the park'. \n";
        return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	
	@Command(command = "checkCommands")
	public String checkCommands() {
		String output = "";
		output += "You can command to 'checkInventory'.\n"
				+ "You can command to 'say <Password>'. \n"
				+ "You can command to 'go to the park'. \n";
		return output; 
	}
	
	@Command(command = "say")
	public String say(String password){
		String output = "";
		if(password.equals("Kachow")) {
			output += "You remember the phrase 'kachow' being said by McQueen once you gave him his photo \n"
					+ "Mater: Kachow \n"
					+ "Guy: You can enter. \n"
					+ "You enter the fan club and place Marga in a nearby sofa. She shortly wakes up after and thanks you for bringing her inside \n"
					+ "You finish your objectives for the day. You can go to the Chief and tell him of your progress \n"
					+ "You begin to relax. The End ";
		}else {
			output = "Wrong Password\n";
		}
		
		return output;
	}
	
	public void inquire() {
		inquired = true;
	}
	public boolean hasInquired() {
		return inquired;
	}
}
