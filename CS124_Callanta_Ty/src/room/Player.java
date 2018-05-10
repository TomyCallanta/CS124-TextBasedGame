package room;
import maze.Memento;

public class Player {
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
	
	public void setState(String[] curBag) {
		System.out.println("From Player: Updated Bag");
		bag = curBag;
	}
	
	public Memento saveState() {
		System.out.println("From Player: Saving to Memento./n");
		return new Memento(bag);
	}
	
	public String[] restoreFromMemento( Memento memento) {
		bag = memento.getSavedBag();
		System.out.println("From Player: Previous Bag Saved in Memento\n. ");
		return bag; 
	}

}