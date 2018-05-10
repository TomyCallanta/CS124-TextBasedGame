package room;
import anno.Command;
import anno.Direction;

public class TirePlace implements City{
	
	@Direction(command="go to Willy Butte")
	private Ditch d;
	@Direction(command="go to the road")
	private Road r;
	@Direction(command="go to Cozy Cone Motel")
	private CozyConeMotel ccm;
	
	private int count = 0;
	private Player mater; 
	
	public void setPlayer(Player p) {
		mater = p;
	}
	
	public String getDescription()
	{
		count++;
		String output = "You arrive at Luigi's Casa Della Tires  - "+count+" times\n"; 
		output += "You arrive at the Luigi's Casa Della Tires, the premier tire store in Radiator Springs \n"
				+ "You see Luigi smiling behind the counter.\n"
				+ "Luigi: Hello Mater! Do you want anything in particular? \n";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'requestForTires'.\n";
        output += "You can command to 'go to Willy Butte'.\n";
        output += "You can command to 'go to the road'.\n";
        output += "You can command to 'go to Cozy Cone Motel'.\n";
        return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	
	@Command(command = "requestForTires")
	public String requestForTires(){
		String output ="";
		output += "Mater: I need some tires for to help someone at the theatre, can i have 4 wheels for a mini truck? \n"
				+ "Luigi: Sure, That will be 55 dollars in total. \n";
				
		if(mater.checkBag("cash")!= -1) {
			output += "Mater: Here you go! \n"
					+ "Luigi: Here are the tires. \n ";
			mater.addBag("tires");
		}
		else {
			output += "Mater: I don't have 55 dollars at the moment. I will be back. \n"
					+ "Luigi: Okay! I will be here.";
		}
		return output;
	}
}
