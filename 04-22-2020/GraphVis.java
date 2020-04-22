import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
public class GraphVis extends JComponent{
  public static void main(String[] args) {
    //constructing graph
    Graph a = new Graph();
    //constructing Jframe to hold visualization
    JFrame frame = new JFrame();
    frame.setVisible(true);
    int width = 500, height = 500;
    frame.setSize(width+20, height+40);
    //GraphVis drawing = new GraphVis(width, height, a);
    //frame.add(drawing);
  }
}