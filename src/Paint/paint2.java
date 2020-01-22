package Paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class paint2{
	  public static void main(String[] args) {
	      JTextArea ta = new JTextArea(5, 5);
	      JTextField tf = new JTextField();
	      ta.setText("The coding noses celebrated hours");
	      ta.setForeground(Color.blue);
	      tf.setText("random text");

	      dessinateur support = new dessinateur();
	      support.setPopup(ta, tf);

	      JMenuBar menuBar = new JMenuBar();
	      menuBar.add(support.getMenu());
	      JFrame frame = createFrame("Cut Copy Paste Menu Example");
	      frame.setJMenuBar(menuBar);

	      frame.add(tf, BorderLayout.NORTH);
	      frame.add(new JScrollPane(ta));
	      frame.setVisible(true);
	  }

	  public static JFrame createFrame(String title) {
	      JFrame frame = new JFrame(title);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setSize(new Dimension(800, 700));
	      return frame;
	  }
	}