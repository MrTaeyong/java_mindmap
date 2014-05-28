import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

class Node extends JLabel{	
	private final static int DEFAULT_NODE_SIZE_X = 100;
	private final static int DEFAULT_NODE_SIZE_Y = 30;
	private NodeDTO matchedNodeDTO;
	
	public Node(Point p, Dimension d, NodeDTO matchedNodeDTO){
		setBounds(p.x, p.y, d.width, d.height);
		setOpaque(true);
		setBackground(Color.CYAN);
		setText("MindMapNode");
		this.matchedNodeDTO = matchedNodeDTO;
	}
	
	public Node(NodeDTO matchedNodeDTO){
		this(new Point(0, 0), new Dimension(DEFAULT_NODE_SIZE_X, DEFAULT_NODE_SIZE_Y), matchedNodeDTO);
	}
	
	public NodeDTO getMatchNodeDTO(){
		return matchedNodeDTO;
	}
}