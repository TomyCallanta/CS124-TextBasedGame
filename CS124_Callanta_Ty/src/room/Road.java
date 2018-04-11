package room;

import anno.*;

public class Road implements City {

	@Direction(command = "go to Flo's Cafe")
	private FloCafe fc;
	@Direction(command = "go to Mater's House")
	private MaterHouse mh;
	@Direction(command= "go to Drive-In Theatre")
	private Theatre t;
	@Direction(command = "go to Luigi's Casa Della Tires")
	private TirePlace tp;
		
	private int count = 0;
	private boolean canAdd1, canAdd2, canAdd3, canDig = false;
	private boolean pickUp = true;
	private Player mater;

	public void setPlayer(Player p) {
		mater = p;
	}
	
	public String getDescription()
	{
		count++;
		String output = "You drive by this road - "+count+" times\n"; 
		output += "You arrive at road and you see multiple signs pointing you to the next destination.\n";
		output += "You can command to 'checkCommands'. \n ";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'look'.\n";
		output += "You can command to 'go to Flo's Cafe.\n";
        output += "You can command to 'go to Mater's House'.\n";
        output += "You can command to 'go to Drive-In Theatre'.\n";
        output += "You can command to 'go to Luigi's Casa Della Tires'.\n";
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
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'look'.\n";
		output += "You can command to 'go to Flo's Cafe.\n";
        output += "You can command to 'go to Mater's House'.\n";
        output += "You can command to 'go to Drive-In Theatre'.\n";
        output += "You can command to 'go to Luigi's Casa Della Tires'.\n"; 
		return output;
	}
	
	@Command(command="look")
	public String lookAround() {
		String output ="";
		output += "You look around and something caught your eye underneath the dirt. \n"
				+ "You can command to 'dig' \n";
		canDig = true;
		return output; 
	}
	
	@Command(command = "dig")
	public String dig() {
		String output = "";
		if(canDig == true && pickUp == true) {
			output += "You find a picture of Lightning McQueen, a empty container, and a rubber duck. \n"
					+ "You can command to 'get picture'. \n "
					+ "You can command to 'get container'. \n"
					+ "You can command to 'get rubber duck'. \n";
			canAdd1 = true;
			canAdd2 = true;
			canAdd3 = true;
			pickUp = false;
		}else {
			output += "Why are you digging? Get back to work!\n";
		}
		return output;
	}
	
	@Command(command = "get picture")
	public String pickUpPicture() {
		String output = "";
		if(canAdd1 == true) {
			output += "You add the picture of Lightning McQueen to your inventory. \n";
			mater.addBag("picture");
			canAdd1 = false;
		} else {
			output += "What you talking about. \n";
		}
		return output;
	}
	@Command(command = "get container")
	public String pickUpContainer(){
		String output = "";
		if(canAdd2 == true) {
			output += "You add the empty container to your inventory. \n";
			mater.addBag("container");
			canAdd2 = false;
		} else {
			output += "What you talking about.\n";
		}
		return output;
	}
	@Command(command = "get rubber duck")
	public String pickUpDuck() {
		String output = "";
		if(canAdd3 == true) {
			output += "You add the rubber duck your inventory. \n";
			mater.addBag("duck");
			canAdd3 = false;
		} else {
			output += "What you talking about.\n";
		}
		return output;
	}
}
