import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MindMapFileChooser extends JFileChooser{
	public MindMapFileChooser(){
		JFileChooser chooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("XML", "xml");
		chooser.addChoosableFileFilter(filter);
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("OBJ", "obj"));
		
		int value = chooser.showOpenDialog(null);
		if(value == JFileChooser.APPROVE_OPTION){
			System.out.println("방금 선택한 파일 : " + chooser.getSelectedFile().getName());
			File file = chooser.getSelectedFile();
			System.out.println("파일이 있는 디렉토리 : " + file);
		}
	}
}
