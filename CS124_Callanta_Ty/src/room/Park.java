package room;

import anno.Command;
import anno.Direction;

public class Park {
	@Direction(command="go Flo's Gas Station")
	private FloGasStation fgs;
	@Direction(command="go to Secret Hideout")
	private SecretHideout sh;
	@Direction(command="go to Willy Butte (Race Car Track) ")
	private Ditch d;
	
	private int count = 0;
	private Player mater; 
	private boolean ablePick = false;
	
	public String getDescription()
	{
		count++;
		String output = "You arrive at Drive In Theatre - "+count+" times\n"; 
		output += "You arrive at the park. You see your friend Doc sitting on a bench under several trees. You see a playground in the distance filled with kids playing around. \n";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'talkToDoc'.\n";
		output += "You can command to 'lookAround'.\n";
        output += "You can command to 'go to Car2'.\n";
        output += "You can command to 'go Flo's Gas Station.\n";
        // if you have the car with you 
        // output += "You can command to 'talkToTruck'. \n";
        return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	@Command(command = "talkToTruck")
	public String talkToTruck(){
		String output = "";
		output += "Mater: Here we are! We are at the park! \n"
				+ "Mini Truck: Thank you Mater! I am sorry I can't repay for your kindness with actual money, but you can have my trusty hook."
				+ " You can attach it to the back of the truck if you want to use it. \n"
				+ "Mater: Thank you!. \n "
				+ "The hook has been added to your inventory. \n";
		mater.addBag("hook");
		return output;
	}
	@Command(command = "talkToDoc")
	public String talkToDoc(){
		String output = "";
		if(ablePick == false) {
			 output = "Mater: Hey Doc, What are you doing here? /n"
					+ "Doc: Admiring the trees, they are filled with fruit. They must be worth a lot of money since Apples are a hot commody especially for people like Flo \n"
					+ "You can command to 'pickFruit' ";
			ablePick = true;
		}else if(ablePick == true && mater.checkBag("money") == -1) {
			 output = "There are no more fruits in the tree. You Lose";
		}
		return output;
	}
	
	@Command(command = "lookAround")
	public String lookAround(){
		String output = "There are a lot of families in the park playing and having fun. You sit down at a nearby bench and admire your surroundings. Time Passes and you are reminded to get back to work \n";
		return output;
	}
	
	// make sure that you are able to visit doc first 
	@Command(command = "pickFruit")
	public String pickFruit(){
		String output = "";
		if(ablePick == true) {
			output += "You pick fruit out of the tree and give some to Doc and keep some for yourself. Maybe you can give some to your friend or and eat one yourself./n"
					+ "You give some to Doc and keep some to yourself \n"
					+ "Doc: Thank you Mater! \n"
					+ "Apples have been added to your inventory \n"
					+ "You can command to 'eatFruit' \n ";
			mater.addBag("apples");
					
		}else {
			output += "There are no fruit to pick \n";
		}
		return output;
	}
	
	@Command(command ="eatFruit")
	public String eatFruit() {
		String output = "";
		if(mater.checkBag("apples")!= -1) {
			output += "You eat the fruit. It taste delicious. I sure hope I dont regret this later. \n";
			mater.dropItem("apples");
		}
		return output;
	}
}