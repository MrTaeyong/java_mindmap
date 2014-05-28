import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Controller implements ActionListener, MouseMotionListener, MouseListener{
	private Model mindMapModel;
	private View mindMapView;
	private Node selectedNode;
	private int startX, startY;
	private int endX, endY;
	
	public Controller(){
		// Model and View Initialize
		mindMapModel = new Model();
		mindMapView = new View();
		mindMapView.menuInit(this);
		mindMapView.toolBarInit(this);
		mindMapView.paneInit(this);
		mindMapView.setVisible(true);
		// create root node
		NodeDTO rootNode = new NodeDTO(null);
		mindMapModel.setRoot(rootNode);
		mindMapView.mindMapPanel.addNode(new Node(rootNode), this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Node eventNode;
		if(e.getSource() instanceof Node){
			eventNode = (Node) e.getSource();
			// 마우스 오른쪽 버튼 눌렀을 때 이벤트
			if(e.getButton() == MouseEvent.BUTTON3){
				// 새로운 노드를 생성
				NodeDTO newNode = new NodeDTO(eventNode.getMatchNodeDTO());
				mindMapView.mindMapPanel.addNode(new Node(newNode), this);
				eventNode.getMatchNodeDTO().setReference(newNode);
				mindMapView.mindMapPanel.drawLines(mindMapModel.getRoot());
//				int halfOfNodeX = (eventNode.getWidth() - eventNode.getX()) / 2;
//				int midPointOfNodeX = eventNode.getX() + halfOfNodeX;
//				System.out.println(eventNode.getX() + ", " + midPointOfNodeX);
//				Point startPoint = new Point(midPointOfNodeX, eventNode.getY());
//				halfOfNodeX = (newNode.getWidth() - newNode.getX()) / 2;
//				midPointOfNodeX = newNode.getX() + halfOfNodeX;
//				System.out.println(newNode.getX() + ", " + midPointOfNodeX);
//				Point endPoint = new Point(midPointOfNodeX, newNode.getY());
//				
//				Graphics g = mindMapView.mindMapPanel.getGraphics();
//				g.setColor(Color.WHITE);
//				g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
//				mindMapView.mindMapPanel.repaint();
			}
		}
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
		Node eventNode;
		if(e.getSource() instanceof Node){
			eventNode = (Node) e.getSource();
			startX = e.getXOnScreen();
			startY = e.getYOnScreen();
			if(selectedNode != null && selectedNode != eventNode){
				selectedNode.setBackground(Color.CYAN);
				selectedNode = eventNode;
				selectedNode.setBackground(Color.YELLOW);
			}
			else if(selectedNode == null){
				selectedNode = eventNode;
				selectedNode.setBackground(Color.YELLOW);
			}
		}
		else
		{
			selectedNode.setBackground(Color.CYAN);
			selectedNode = null;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Node eventNode;
		if(e.getSource() instanceof Node){
			eventNode = (Node) e.getSource(); 
			endX = e.getXOnScreen();
			endY = e.getYOnScreen();
			eventNode.setLocation(eventNode.getX() + endX - startX,
					eventNode.getY() + endY - startY);
			startX = endX;
			startY = endY;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("적용")){
			System.out.println("적용...");
		}
		else if(e.getActionCommand().equals("새로 만들기")){
//			initialize();
		}
		else if(e.getActionCommand().equals("열기")){
			new MindMapFileChooser();
		}
		else if(e.getActionCommand().equals("닫긔")){
			System.exit(0);
		}
	}
}
