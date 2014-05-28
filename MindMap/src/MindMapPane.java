import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;


public class MindMapPane extends JPanel{
	public MindMapPane(){
		setLayout(null);
		setPreferredSize(new Dimension(500, 500));
		setBounds(0, 0, 500, 500);
		setBackground(Color.darkGray);
		
	}
	
	public void addNode(Node node, Controller eventListener){
		node.addMouseMotionListener((MouseMotionListener)eventListener);
		node.addMouseListener((MouseListener)eventListener);
		add(node);
	}
	
	public void drawLines(NodeDTO root){
		Queue<NodeDTO> q = new LinkedList<NodeDTO>();
		Graphics g = getGraphics();
		g.setColor(Color.WHITE);
		q.add(root);
		while(q.size() > 0){
			NodeDTO node = q.peek();
			q.remove();
			for(NodeDTO n : node.getReference()){
				g.drawLine(node.getX(), node.getY(), n.getX(), n.getY());
				q.add(n);
			}
		}
	}
}
