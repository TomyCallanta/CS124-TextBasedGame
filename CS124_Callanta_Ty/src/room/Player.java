package room;

public class Player {
	private String[] bag = new String[15];
	private String[] event = new String[15];
	private int bagCount = 0;
	private int eventCount = 0;
	
	
	public String seeInventory() {
		String temp = "";
		for(int i = 0; i<bag.length; i++) {
			if(bag[i] == null)
				continue;
			temp += bag[i] + ", ";
		}
		if(temp.equals(""))
			temp = "No Items in Inventory";
		temp += "\n";
		return temp;
	}
	
	public void addBag(String item) {
		bag[bagCount] = item;
		bagCount++;
		System.out.println("Added item to inventory.");
	}
	
	public void addEvent(String item) {
		event[eventCount] = item;
		eventCount++;
		System.out.println("Event Unlocked.");
	}
	
	public void eventDone(String item) {
		int position = checkEvents(item);
		if(position!= -1) {
			event[position] = null;
			eventCount--;
		}
	}
	
	public boolean itemPresent(String item) {
		if(checkBag(item) == -1)
			return false;
		else 
			return true;
	}
	
	public void dropItem(String item) {
		int position = checkBag(item);
		if(position!= -1) {
			bag[position] = null;
			bagCount--;
		}
	}
	
	public int checkEvents(String item) {
		int itemCheck = -1;
		for(int i = 0; i<event.length; i++) {
			if(event[i]!= null && event[i].equalsIgnoreCase(item)) {
				itemCheck = i;
				break;
			}
		}
		return itemCheck;
	}
	
	public int checkBag(String item) {
		int itemCheck = -1;
		for(int i = 0; i<bag.length; i++) {
			if(bag[i]!= null && bag[i].equalsIgnoreCase(item)) {
				itemCheck = i;
				break;
			}
		}
		return itemCheck;
	}

}