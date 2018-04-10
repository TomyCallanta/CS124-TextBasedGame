package room;

import anno.*;

public class FloCafe implements City {

	@Direction(command="go to the road")
	private Road r;
	@Direction(command="go to Mater's House")
	private MaterHouse mh;
	@Direction(command="go to Flo's Gas Station")
	private FloGasStation fgs;
	
	private int count = 0;
	private Player mater; 
	
	public void setPlayer(Player p) {
		mater = p;
	}
	
	public String getDescription()
	{
		count++;
		String output ="You are Flo's Cafe- "+count+" times\n";
		output +="You see Flo behind the counter, there are customers in the cafe.\n";
		 output +="You can command to 'checkInventory'.\n";
        output +="You can command to 'talkToFlo'.\n";
        output +="You can command to 'go to Mater's House'.\n";
        output +="You can command to 'go to the road'.\n";
        output +="You can command to 'go to Flo's Gas Station.' \n";
		return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	
	@Command(command = "talkToFlo")
	public String talkToFlow(){
		String output = "";
		output += "Mater: Hello Flo! How are you today? Your cafe seems to be very busy. \n"
				+ "Flo: It is! I am having a hard time actually since a lot of the customers are asking for my famous apple pie, that I am running out of apples. "
				+ "If you manage to find some apples for me, can you deliver some here. I can give you some money in exchange. \n "
				+ "Mater: I make sure to look out for some apples. \n";
		if(mater.checkBag("apples")!= -1) {
			output += "Mater: Here are some apples Flo. \n"
					+ "Flo: Thank you so much here is 100 dollars in exchange. \n"
					+ "You place the cash in your inventory. \n";
			mater.addBag("cash");
			mater.addBag("cash");
			mater.dropItem("apples");
		}
		return output;
	}
	
	
}
