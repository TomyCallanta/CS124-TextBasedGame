package room;
import anno.Command;
import anno.Direction;

public class FloGasStation implements City{
	
	@Direction(command="go to Flo's Cafe")
	private FloCafe fc;
	@Direction(command="go to the park")
	private Park p;
	
	private int count = 0;
	private Player mater; 

	public void setPlayer(Player p) {
		mater = p;
	}
	
	public String getDescription()
	{
		count++;
		String output = "You arrive at Flo's Gas Station - "+count+" times\n"; 
		output += "Gas Attendant: Hello! What do you want me to do for you today? \n";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'askForGas'.\n";
        output += "You can command to 'go to Flo's Cafe'.\n";
        output += "You can command to 'go to the park'.\n";
        return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	
	@Command(command = "askForGas")
	public String askForGas(){
		String output = "";
		
		if(mater.checkBag("container")!= -1 && mater.checkBag("cash") != -1 ) {
			output += "Mater: Can you fill this container with gas? \n Attendant: Sure! Do you have 30 Dollars? \n Mater: You bet I do! \n";
			output += "You hand over the container to the attendant and he fills the container with gas. /n"
					+ "You hand over the money to the attendant as he hands over the filled container \n ";
			output += "You add the filled container into your inventory \n";
			mater.dropItem("container");
			mater.dropItem("cash");
			mater.addBag("fullGasContainer");
		} else if(mater.checkBag("container")!= -1 && mater.checkBag("cash") == -1 ) {
			output +="Mater: Can you fill this container with gas? \n"
					+ "Attendant: Sure! Do you have 30 Dollars? \n"
					+ "Mater: Oh I don't. Do you accept hugs instead? \n"
					+ "Attendant: No cash no gas";
		} else if(mater.checkBag("fullGasContainer") != -1) {
			output += "I already gave you gas!! Come again next time";
			
		} else {
			output +="Mater: Can I have some gas for my friend? \n"
					+ "Attendant: Sure! Do you have a container where I can place gas in? \n"
					+ "Mater: Oh I don't. Do you accept hugs instead? \n"
					+ "Attendant: No container, no gas. \n";
		}
		
		return output;
	}
}