import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class MindMapPane extends JPanel implements MouseMotionListener, MouseListener, ActionListener{
	private Vector<JLabel> nodeVector;
	private JLabel selectedNode;
	
	public MindMapPane(){
		super();
		setLayout(null);
		this.setPreferredSize(new Dimension(500, 500));
		this.setBounds(0, 0, 500, 500);
		
		addMouseMotionListener(this);
		addMouseListener(this);
		
		// 초기노드 생성
		nodeVector = new Vector<JLabel>();
		nodeVector.add(new Node());
		add(nodeVector.get(0));
		nodeVector.get(0).setLocation(getWidth() / 2, getHeight() / 2);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(selectedNode != null){
			selectedNode.setLocation(e.getX(), e.getY());
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// 이전에 선택된 노드와 마우스의 위치가 겹치지 않으면 이전에 선택됐던 노드의 색을 기본색으로 바꿈.
		if(selectedNode != null && !isIntersect(e.getPoint(), selectedNode)){
			selectedNode.setBackground(Color.CYAN);
		}
		// 마우스의 위치와 노드들의 위치를 비교하여 마우스가 눌린 위치에 있는 노드의 색을 선택된 색으로 바꿈.
		for(JLabel l : nodeVector){
			if(isIntersect(e.getPoint(), l)){
				selectedNode = l;
				l.setBackground(Color.GRAY);
				break;
			}
		}
		
		// 오른쪽 마우스를 누르면 새로운 노드 생성.
		if(e.getButton() == e.BUTTON3){
			JLabel newNode = new Node();
			nodeVector.add(newNode);
			add(newNode);
			int start = selectedNode.getX() + ((selectedNode.getWidth() - selectedNode.getX()) / 2);
			int end = newNode.getX() + ((newNode.getWidth() - selectedNode.getX()) / 2);
			getGraphics().setColor(Color.BLACK);
			getGraphics().drawLine(start, selectedNode.getY(), end, newNode.getY());
			repaint();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isIntersect(Point p, JLabel node){
		if((p.x >= node.getX() && p.x <= node.getX() + node.getWidth()) &&
				(p.y >= node.getY() && p.y <= node.getY() + node.getHeight()))
			return true;
		return false;
	}
}
