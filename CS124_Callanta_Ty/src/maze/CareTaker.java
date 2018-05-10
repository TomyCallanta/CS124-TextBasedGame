package maze;
import java.util.ArrayList;

public class CareTaker {
	ArrayList<Memento> savedBag = new ArrayList<Memento>();
	
	public void addMemento(Memento m) {
		savedBag.add(m);
	}
	public Memento getMemento(int index) {
		return savedBag.get(index);
	}
}
