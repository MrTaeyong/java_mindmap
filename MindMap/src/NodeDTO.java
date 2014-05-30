import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public class NodeDTO extends Rectangle{
	private final static int DEFAULT_NODE_SIZE_X = 100;
	private final static int DEFAULT_NODE_SIZE_Y = 30;
	
//	private int x, y;
//	private int width, height;
	private Point[] midPoint;
	private String text;
	private int level;
	private NodeDTO parent;
	private Vector<NodeDTO> child;
	
	public NodeDTO(int x, int y, int width, int height, String text, NodeDTO parent){
		this.setBounds(x, y, width, height);
//		this.x = x; this.y = y;
//		this.width = width; this.height = height;
		this.midPoint = new Point[4];
		for(int i = 0; i < midPoint.length; i++)
			midPoint[i] = new Point();
		setMidPoint();
		this.text = text;
		this.parent = parent;
		this.child = new Vector<NodeDTO>();
	}
	
	public NodeDTO(NodeDTO parent){
		this(0, 0, DEFAULT_NODE_SIZE_X, DEFAULT_NODE_SIZE_Y, "MindMapNode", parent);
	}
	
	public void setMidPoint() {
		// 0:Top, 1:Right, 2:Bottom, 3:Left
		midPoint[0].x = width / 2 + x;
		midPoint[0].y = y;
		midPoint[1].x = x + width;
		midPoint[1].y = height / 2 + y;
		midPoint[2].x = midPoint[0].x;
		midPoint[2].y = y + height;
		midPoint[3].x = x;
		midPoint[3].y = midPoint[1].y;
		
	}
	
//	public void setLocation(int x, int y){
//		this.x = x;
//		this.y = y;
//	
//	}
//	
//	public void setSize(int width, int height){
//		this.setSize(width, height);
//		this.width = width;
//		this.height = height;
//	}
//	
//	public int getX() {
//		return x;
//	}
//	
//	public void setX(int x) {
//		this.startPoint.x = x;
//		this.x = x;
//	}
//
//	public int getY() {
//		return startPoint.y;
//		return y;
//	}
//	
//	public void setY(int y) {
//		this.startPoint.y = y;
//		this.y = y;
//	}
//
//	public int getWidth() {
//		return size.width;
//		return width;
//	}
//
//	public void setWidth(int width) {
//		this.size.width = width;
//		this.width = width;
//	}
//
//	public int getHeight() {
//		return size.height;
//		return height;
//	}
//
//	public void setHeight(int height) {
//		this.size.height = height;
//		this.height = height;
//	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void setChild(NodeDTO node){
		child.add(node);
	}
	public Vector<NodeDTO> getChild(){
		return child;
	}
	
	public Point[] getMidPoint(){
		return midPoint;
	}
	
}
