package room;

import anno.*;

public class CozyConeMotel {
	
	@Direction(command="go to Mater House")
	private MaterHouse mh;
	@Direction(command="go to the road")
	private Road r;
	@Direction(command="go to Drive-In Theater")
	private Theatre t;
	
	private int count = 0;
	private Player mater; 
	 
	public String getDescription()
	{
		count++;
		String output = "You arrive at Drive In Theatre - "+count+" times\n"; 
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
	
}
