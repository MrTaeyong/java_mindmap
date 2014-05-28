import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class View extends JFrame{
	public PreferencePane prefPanel;
	public MindMapPane mindMapPanel;
	public View() {
		setTitle("MindMap");
		setSize(1200, 800);
		setLayout(new BorderLayout(0, 0));
//		setMinimumSize(new Dimension(prefPanel.getPreferredSize()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
	}
	
	protected void paneInit(Controller c){
		prefPanel = new PreferencePane(c);
		mindMapPanel = new MindMapPane();
		add(prefPanel, BorderLayout.WEST);
		add(mindMapPanel, BorderLayout.CENTER);
	}
	
	protected void toolBarInit(Controller c){
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton newButton = new JButton("새로 만들기");
		toolBar.add(newButton);
		newButton.addActionListener(c);
		
		JButton openButton = new JButton("열기");
		toolBar.add(openButton);
		openButton.addActionListener(c);
		
		JButton saveButton = new JButton("저장");
		toolBar.add(saveButton);
		saveButton.addActionListener(c);
		
		JButton saveAsButton = new JButton("다른이름저장");
		toolBar.add(saveAsButton);
		saveAsButton.addActionListener(c);
		
		JButton exitButton = new JButton("닫긔");
		toolBar.add(exitButton);
		exitButton.addActionListener(c);
	}
	
	protected void menuInit(Controller c){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuNewfile = new JMenuItem("새로 만들기");
		mnFile.add(menuNewfile);
		menuNewfile.addActionListener(c);
		
		JMenuItem menuOpenfile = new JMenuItem("열기");
		mnFile.add(menuOpenfile);
		menuOpenfile.addActionListener(c);
		
		JMenuItem menuSavefile = new JMenuItem("저장");
		mnFile.add(menuSavefile);
		menuSavefile.addActionListener(c);
		
		JMenuItem menuSaveAs = new JMenuItem("다른이름으로 저장");
		mnFile.add(menuSaveAs);
		menuSaveAs.addActionListener(c);
		
		JMenuItem menuExit = new JMenuItem("닫긔");
		mnFile.add(menuExit);
		menuExit.addActionListener(c);
	}
}
