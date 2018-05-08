import java.util.ArrayList;

public class CareTaker {
	public ArrayList<Memento> mementos;
	
	public CareTaker() {
		mementos = new ArrayList<Memento>();
	}
	
	public void addMemento(Memento mem) {
		mementos.add(mem);
	}
	
	public Memento getMemento(int index) {
		return mementos.get(index);
	}
	
	public int getSize() {
		return mementos.size();
	}
}
