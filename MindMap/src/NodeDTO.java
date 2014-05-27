import java.util.Vector;

public class NodeDTO {
	private int x, y;
	private double width, height;
	private String text;
	private int level;
	private Vector<NodeDTO> reference;
	
	public NodeDTO(int x, int y, double width, double height){
		this.x = x; this.y = y;
		this.width = width; this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
