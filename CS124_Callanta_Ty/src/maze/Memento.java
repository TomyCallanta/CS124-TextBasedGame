package maze;

public class Memento {
	private String[] bag;
	public Memento(String[] bagSave) {
		bag = bagSave;
	}
	
	public String[] getSavedBag() {
		return bag; 
	}
}
