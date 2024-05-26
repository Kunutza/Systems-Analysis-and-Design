import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
	         public void run() {
	            new Gui();
	         }
	      });
	   }
		
	}


