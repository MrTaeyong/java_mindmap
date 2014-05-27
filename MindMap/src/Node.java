import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.event.AncestorListener;

class Node extends JLabel implements MouseMotionListener, MouseListener{
	public Node(){
		this.setSize(100, 30);
		this.setOpaque(true);
		this.setBackground(Color.CYAN);
		this.setText("MindMapNode");
//		this.addMouseListener(this);
//		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		setText(e.getX() + ", " + e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getButton() == arg0.BUTTON1){
			System.out.println("left button clicked");
		}
		else if(arg0.getButton() == arg0.BUTTON3){
			System.out.println("right button clicked");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}