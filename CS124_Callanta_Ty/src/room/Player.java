package room;

public class Player {
	private boolean tireChanged;
	private boolean gasAdded; 
	private String[] bag = new String[15];
	private int bagCount = 0;
	
	
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
	
	public void dropItem(String item) {
		int position = checkBag(item);
		if(position!= -1) {
			bag[position] = null;
			bagCount--;
		}
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
