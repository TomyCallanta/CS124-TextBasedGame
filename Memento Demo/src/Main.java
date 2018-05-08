import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input = "";
		
		Originator pic = new Originator(1,1,1);
		CareTaker ct = new CareTaker();
		ct.addMemento(pic.save());

		int currentState = 0;

		System.out.println("current state: " + currentState);
		System.out.println("width: " + pic.getWidth());
		System.out.println("height: " + pic.getHeight());
		System.out.println("opacity: " + pic.getOpacity());
		
		while(!input.equalsIgnoreCase("exit")) {
			input = in.nextLine();
			
			String parsed[] = input.split(" ");
			if(parsed.length > 1) {
				if(parsed[0].equals("changeWidth"))
					pic.setWidth(Integer.parseInt( parsed[1]));
				else if(parsed[0].equals("changeHeight"))
					pic.setHeight(Integer.parseInt( parsed[1]));
				else if(parsed[0].equals("changeOpacity"))
					pic.setOpacity(Integer.parseInt( parsed[1]));
			}else if(input.equals("save")) {
				ct.addMemento(pic.save());
				currentState++;
			}else if(input.equals("undo")) {
				currentState--;
				pic.restore(ct.getMemento(currentState));
			}else if(input.equals("redo")) {
				currentState++;
				pic.restore(ct.getMemento(currentState));
			}
			
			System.out.println("current state: " + currentState);
			System.out.println("width: " + pic.getWidth());
			System.out.println("height: " + pic.getHeight());
			System.out.println("opacity: " + pic.getOpacity());
		}
	}

}
