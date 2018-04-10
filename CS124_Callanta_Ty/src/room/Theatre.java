package room;

import anno.*;

public class Theatre {

	@Direction(command="go to the road")
	private Road r;
	@Direction(command="go to Mater's House")
	private MaterHouse mh;
	@Direction(command="go to Cozy Cone Motel")
	private CozyConeMotel ccm;
	
	private int count = 0;
	private boolean tireChanged = false;
	private boolean gasAdded = false;
	private Player mater; 
	
	public String getDescription()
	{
		count++;
		String output = "You arrive at Drive In Theatre - "+count+" times. \n"; 
		output += "You arrive at the Theater and see a mini truck in a need of a tire change.\n";
		output += "You can command to 'checkInventory'.\n";
		output += "You can command to 'fixTire'.\n";
		output += "You can command to 'talk'.\n";
        output += "You can command to 'go to Mater's House'.\n";
        output += "You can command to 'go to the road'.\n";
        output += "You can command to 'go to Cozy Cone Motel'.\n";
        return output;
	}
	
	@Command(command = "checkInventory")
	public String checkInventory(){
		String output = mater.seeInventory();
		return output;
	}
	
	@Command(command="talk")
	public String talk() {
		String output = "";
		if (mater.checkBag("fullGasContainer")!= -1 && mater.checkBag("tire") == -1){
            output += "Mini Truck: Thank you for changing my tire!! \n.";
            output += "Silence";
            output += "Mini Truck: I can't seem to move. Maybe I ran out of gas. Can you get some gas for me? \n";
            gasAdded = true;
        }
		else if(mater.checkBag("tire") == -1) {
			output += "Mini Truck: I somehow manage to have a hole on my tire because I ran over a sharp rock. Can you change my tire? \n. ";
		}
		else if (mater.checkBag("fullGasContainer")!= -1 && mater.checkBag("tire") != -1) {
			output+= "Mini Truck: Thanks for helping me Mater! Can I you bring me to the park by any chance? I don't really know how to get there. \n."
					+ "Mater: Yeah sure! Anything for a friend!";
			mater.dropItem("tire");
			mater.dropItem("fullGasContainer");
		
		}
		return output;
	}
	
	@Command(command ="addGas")
	public String addGas() {
		String output = "";
		if (mater.checkBag("fullGasContainer")!= -1){
			output += " You refill the gas tank of the Mini Truck.\n He seems like he wants to talk to you. \n";
			mater.dropItem("fullGasContainer");
		} else {
			output += "You don't have gas to refill the mini truck \n.";
		}
		return output;
	}	
}