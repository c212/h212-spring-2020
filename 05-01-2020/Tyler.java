import javax.swing.*; 
import java.awt.*; 

public class Tyler extends JComponent {
  public static void main(String[] args) {
    JFrame a = new JFrame("Tyler's example");
    VisualRedBlackTree b = new VisualRedBlackTree();     
    Tyler c = new Tyler(b); 
    a.add(c);     
    a.setSize(900, 600); 
    a.setVisible(true); 
  }
  public Tyler(VisualRedBlackTree r) {
    this.r = r;  
  }
  public void paintComponent(Graphics g) {
    this.r.draw(g);     
  }
  VisualRedBlackTree r; 
}