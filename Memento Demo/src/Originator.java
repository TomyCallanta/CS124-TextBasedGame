
public class Originator {
	private int width;
	private int height;
	private int opacity;
	
	public Originator(int w, int h, int o) {
		width = w;
		height = h;
		opacity = o;
	}
	
	public Memento save() {
		System.out.println("Originator: Saving into Memento");
		return new Memento(width, height, opacity);
	}
	
	public void restore(Memento mem) {
		width = mem.getWidth();
		height = mem.getHeight();
		opacity = mem.getOpacity();
	}
	
	public void setWidth(int w) {
		width = w;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public void setOpacity(int o) {
		opacity = o;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getOpacity() {
		return opacity;
	}
}
