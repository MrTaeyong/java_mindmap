import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

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
		repaint();
	}
	
	public void paintComponent(Graphics g){
		// 오버라이딩 안된 paintCompnent를 먼저 수행 후 패널에 추가되어있는 노드들을 하나씩 조사하여 선을 이음.
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		Component[] components = getComponents();
		for(Component c : components){
			if(c instanceof Node){
				NodeDTO parent = ((Node) c).getMatchNodeDTO();
				Vector<NodeDTO> child = parent.getChild();
				for(NodeDTO node : child){
					Point[] linePoints = getLinePoints(parent.getMidPoint(), node.getMidPoint());
					g.drawLine(linePoints[0].x, linePoints[0].y, linePoints[1].x, linePoints[1].y);
					g.drawLine(linePoints[1].x, linePoints[1].y, linePoints[2].x, linePoints[2].y);
					g.drawLine(linePoints[2].x, linePoints[2].y, linePoints[3].x, linePoints[3].y);
				}
			}
		}
	}
	
	private Point[] getLinePoints(Point[] midPointOfParent, Point[] midPointOfChild){
		int diffX = midPointOfParent[0].x - midPointOfChild[0].x;
		int diffY = midPointOfParent[1].y - midPointOfChild[1].y;
		if(diffX < 0 && diffY < 0){
			diffX = midPointOfChild[3].x - midPointOfParent[1].x;
			diffY = midPointOfChild[0].y - midPointOfParent[2].y;
			if(diffX > diffY)
				return buildLinePoints(midPointOfParent[1], midPointOfChild[3], diffX, diffY);
			else
				return buildLinePoints(midPointOfParent[2], midPointOfChild[0], diffX, diffY);
		}
		else if(diffX < 0 && diffY >= 0){
			diffX = midPointOfChild[3].x - midPointOfParent[1].x;
			diffY = midPointOfParent[0].y - midPointOfChild[2].y;
			if(diffX > diffY)
				return buildLinePoints(midPointOfParent[1], midPointOfChild[3], diffX, diffY);
			else
				return buildLinePoints(midPointOfChild[2], midPointOfParent[0], diffX, diffY);
		}
		else if(diffX >= 0 && diffY < 0){
			diffX = midPointOfParent[3].x - midPointOfChild[1].x;
			diffY = midPointOfChild[0].y - midPointOfParent[2].y;
			if(diffX > diffY)
				return buildLinePoints(midPointOfChild[1], midPointOfParent[3], diffX, diffY);
			else
				return buildLinePoints(midPointOfParent[2], midPointOfChild[0], diffX, diffY);
		}
		else if(diffX >= 0 && diffY >= 0){
			diffX = midPointOfParent[3].x - midPointOfChild[1].x;
			diffY = midPointOfParent[0].y - midPointOfChild[2].y;
			if(diffX > diffY)
				return buildLinePoints(midPointOfChild[1], midPointOfParent[3], diffX, diffY);
			else
				return buildLinePoints(midPointOfChild[2], midPointOfParent[0], diffX, diffY);
		}
		return null;
	}
	
	private Point[] buildLinePoints(Point start, Point end, int diffX, int diffY){
		Point[] linePoint = new Point[4];
		for(int i = 0; i < linePoint.length; i++)
			linePoint[i] = new Point();
		
		if(diffX > diffY){
			linePoint[0] = start;
			linePoint[1].x = diffX / 2 + start.x;
			linePoint[1].y = start.y;
			linePoint[2].x = linePoint[1].x;
			linePoint[2].y = end.y;
			linePoint[3] = end;
		}
		else{
			linePoint[0] = start;
			linePoint[1].x = start.x;
			linePoint[1].y = diffY / 2 + start.y;
			linePoint[2].x = end.x;
			linePoint[2].y = linePoint[1].y;
			linePoint[3] = end;
		}
		return linePoint;
	}
	
//	public void drawLines(NodeDTO root){
//		Queue<NodeDTO> q = new LinkedList<NodeDTO>();
//		Graphics g = getGraphics();
//		g.setColor(Color.WHITE);
//		q.add(root);
//		while(q.size() > 0){
//			NodeDTO node = q.peek();
//			q.remove();
//			if(node.getChild().size() > 0){
//				for(NodeDTO n : node.getChild()){
//					g.drawLine(node.getX(), node.getY(), n.getX(), n.getY());
//					q.add(n);
//				}
//			}
//		}
//	}
}
