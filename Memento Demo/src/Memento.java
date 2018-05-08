
public class Memento {
	private int width;
	private int height;
	private int opacity;
	
	public Memento(int w, int h, int o) {
		width = w;
		height = h;
		opacity = o;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getOpacity(){
		return opacity;
	}
}
