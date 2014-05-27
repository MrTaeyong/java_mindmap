import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MindMapMainFrame extends JFrame implements ActionListener{
	JPanel MindMapPanel;
	public MindMapMainFrame() {
		setTitle("MindMap");
		setSize(1200, 800);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		menuInit();
		toolBarInit();
		
		JPanel prefPanel = new PreferencePane();
		getContentPane().add(prefPanel, BorderLayout.WEST);
		
		MindMapPanel = new MindMapPane();
		getContentPane().add(MindMapPanel, BorderLayout.CENTER);
		initialize();
		setMinimumSize(new Dimension(prefPanel.getPreferredSize()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initialize(){
		
	}
	
	private void toolBarInit(){
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton newButton = new JButton("새로 만들기");
		toolBar.add(newButton);
		newButton.addActionListener(this);
		
		JButton openButton = new JButton("열기");
		toolBar.add(openButton);
		openButton.addActionListener(this);
		
		JButton saveButton = new JButton("저장");
		toolBar.add(saveButton);
		saveButton.addActionListener(this);
		
		JButton saveAsButton = new JButton("다른이름저장");
		toolBar.add(saveAsButton);
		saveAsButton.addActionListener(this);
		
		JButton exitButton = new JButton("닫긔");
		toolBar.add(exitButton);
		exitButton.addActionListener(this);
	}
	
	private void menuInit(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuNewfile = new JMenuItem("새로 만들기");
		mnFile.add(menuNewfile);
		menuNewfile.addActionListener(this);
		
		JMenuItem menuOpenfile = new JMenuItem("열기");
		mnFile.add(menuOpenfile);
		menuOpenfile.addActionListener(this);
		
		JMenuItem menuSavefile = new JMenuItem("저장");
		mnFile.add(menuSavefile);
		menuSavefile.addActionListener(this);
		
		JMenuItem menuSaveAs = new JMenuItem("다른이름으로 저장");
		mnFile.add(menuSaveAs);
		menuSaveAs.addActionListener(this);
		
		JMenuItem menuExit = new JMenuItem("닫긔");
		mnFile.add(menuExit);
		menuExit.addActionListener(this);
	}
	
	public static void main(String[] args){
		JFrame b = new MindMapMainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("새로 만들기")){
			initialize();
		}
		else if(arg0.getActionCommand().equals("열기")){
			new MindMapFileChooser();
		}
		else if(arg0.getActionCommand().equals("닫긔")){
			System.exit(0);
		}
	}
}
