package room;

import anno.*;
@EnterCondition(intercept = "talk")
public class CozyConeMotel implements City{
	
	@Direction(command="go to Mater House")
	private MaterHouse mh;
	@Direction(command="go to the road")
	private Road r;
	@Direction(command="go to Drive-In Theater")
	private Theatre t;
	
	private int count = 0;
	private boolean doneTalking = false;
	private boolean gotPassword = false;
	private Player mater; 

	public void setPlayer(Player p) {
		mater = p;
	}
	
	public String getDescription()
	{
		count++;

		String output = "You arrive at CozyCone Motel - "+count+" times\n"; 
		output += "You arrive at the motel and you see Lightning McQueen in the distance talking to Sally.\n";
		output += "You can command to 'checkCommands'.\n";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'talk' to Lightning McQueen.\n";
        output += "You can command to 'go to Mater's House'.\n";
        output += "You can command to 'go to the road'.\n";
        output += "You can command to 'go to Drive-In Theater'.\n";
        return output;
	}
	
	@Command(command = "checkCommands")
	public String checkCommands(){
		String output ="";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'talk' to Lightning McQueen.\n";
        output += "You can command to 'go to Mater's House'.\n";
        output += "You can command to 'go to the road'.\n";
        output += "You can command to 'go to Drive-In Theater'.\n";
		return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	
	@Command(command = "use picture")
	public String usePicture() {
		String output = "";
		if(doneTalking) {
			output += "Lightning: Hello! Mater how are you? \n"
					+ "Mater: I am doing well. Say I found this picture of you behind my house. \n"
					+ "You hand over the picture. \n"
					+ "Lightning: KACHOW this brings back so much memories about the first races I did with Doc.\n"
					+ "I was speed and still am. KACHOW \n"
					+ "The phrase 'kachow' sticks in your mind. \n ";
			gotPassword = true;
		}else {
			output = "You can't use that now\n";
		}
		
		return output;
	}
	
	@Command(command = "talk")
	public String talk(){
		String output = "Mater: I am trying to find a password for this Lightning McQueen secret club. Do you have any clue what it might be? \n"
				+ "Lightning: Wow I am flattered but sorry Mater I don't have a clue. \n";
		doneTalking = true;
		return output;
		
//		String output = "";
//		if(mater.checkBag("picture") == -1 ) {
//			output += "Mater: I am trying to find a password for this Lightning McQueen secret club. Do you have any clue what it might be? \n"
//					+ "Lightning: Wow I am flattered but sorry Mater I don't have a clue. \n";
//			doneTalking = true;
//		}else{
//			output += "Lightning: Hello! Mater how are you? \n"
//					+ "Mater: I am doing well, I just wanted to drop by to say hi to you and Sally. \n"
//					+ "Lightning: That is very nice of you. Do you want to join us for dinner later? \n"
//					+ "Mater: Sure! I will be back after I finish my duties. \n"
//					+ "Lightning: I will see you! \n ";
//		}
//		return output;
	}
	
	public boolean gotPassword() {
		return gotPassword;
	}
}