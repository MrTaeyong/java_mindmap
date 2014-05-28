import java.util.Vector;

public class NodeDTO {
	private final static int DEFAULT_NODE_SIZE_X = 100;
	private final static int DEFAULT_NODE_SIZE_Y = 30;
	
	private int x, y;
	private int width, height;
	private String text;
	private int level;
	private NodeDTO parent;
	private Vector<NodeDTO> reference;
	
	public NodeDTO(int x, int y, int width, int height, NodeDTO parent){
		this.x = x; this.y = y;
		this.width = width; this.height = height;
		this.parent = parent;
		this.reference = new Vector<NodeDTO>();
	}
	
	public NodeDTO(NodeDTO parent){
		this(0, 0, DEFAULT_NODE_SIZE_X, DEFAULT_NODE_SIZE_Y, parent);
	}

	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void setReference(NodeDTO node){
		reference.add(node);
	}
	public Vector<NodeDTO> getReference(){
		return reference;
	}
	
}
