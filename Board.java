/*Seif Mohamed 
This the class for the object board created in the main file.
 */



import java.awt.*;  
import javax.swing.*; 
import java.awt.geom.Line2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

// just to draw the board 
public class Board extends JComponent  {

	@Override
   	public void paintComponent(Graphics g) {
      g.drawLine(0, 100, 480, 100);
      g.drawLine(193, 160, 193, 460);
      g.drawLine(293, 160, 293, 460);
      g.drawLine(93, 260, 393, 260);
      g.drawLine(93, 360, 393, 360);
      Graphics2D graphicsObj = (Graphics2D) g;


  }
}
