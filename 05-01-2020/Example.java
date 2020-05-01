import javax.swing.*;
import java.awt.*; 
import java.util.*; 
import java.awt.event.*; 

public class Example extends JComponent implements MouseListener, MouseMotionListener {
  
  public void mouseMoved(MouseEvent e) { }
  public void mouseDragged(MouseEvent e) { 
    if (this.selected != null) {
      this.selected.moveTo(e.getX(), e.getY()); 
      this.repaint(); 
    }
  }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }
  public void mousePressed(MouseEvent e) { 
    int x = e.getX(), y = e.getY(); 
    What what = this.what; 
    ArrayList<What> memory = new ArrayList<What>(); 
    while (what != null && ! memory.contains(what)) {
      if (what.contains(x, y)) {
        this.selected = what;
        break;
      } else {
        memory.add(what); 
        what = what.next; 
      }
    }
    
    System.out.println( this.selected ); 
    
  }
  public void mouseReleased(MouseEvent e) { 
    this.selected = null; 
  }
  public void mouseClicked(MouseEvent e) { }
  
  What selected; 
  
  What what;
  public Example(What what) {
    this.what = what;  
    this.addMouseMotionListener(this);
    this.addMouseListener(this); 
  }
  public void paintComponent(Graphics g) {
    ArrayList<What> memory = new ArrayList<What>(); 
    What what = this.what; 
    while (what != null && ! memory.contains(what)) {
      if (what.next != null) { 
        Utilities.arrow(g, what.x + what.radius, 
                           what.y + what.radius, 
                           what.next.x + what.radius, 
                           what.next.y + what.radius, 20, 10); 
        memory.add(what); 
        what = what.next;
      } else break;
    }
    memory = new ArrayList<What>(); 
    what = this.what; 
    while (what != null && ! memory.contains(what)) {
      what.draw(g); 
      memory.add(what); 
      what = what.next;
    }
  }
  public static void main(String[] args) {
    JFrame f = new JFrame("Some title"); 
    What what = new What(1, new What(2, new What(3, new What(4, new What(5, null)))));
    what.next.next.next.next.next = what;
    f.add(new Example(what)); 
    f.setSize(600, 600);
    f.setVisible(true); 
  }
}