import javax.swing.*; 
import java.awt.*; 

public class Tyler extends JComponent {
  public static void main(String[] args) {
    JFrame a = new JFrame("Tyler's example");
    VisualRedBlackTree b = new VisualRedBlackTree(); 
    b.add("Wenjie"); 
    b.add("Karishma"); 
    b.add("Tyler"); 
    b.add("Anna"); 
    b.add("Michael"); 
    b.add("Mel"); 
    b.add("Corey"); 
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
  /*********************************************************************
  
Welcome to DrJava.  Working directory is C:\Users\dgerman\Desktop\fri-may-01
> VisualRedBlackTree b = new VisualRedBlackTree()
> b

> b.add("Wenjie")
> b.show()
" ( Wenjie) "
> b.add("Karishma")
> b.show()
"Karishma  ( Wenjie) "
> b.add("Tyler")
> b.show()
"Karishma  ( Tyler) Wenjie "
> b.add("Anna")
> b.show()
"Anna Karishma  ( Tyler) Wenjie "
> b.add("Michael")
> b.show()
"Anna Karishma Michael  ( Tyler) Wenjie "
> b.add("Mel")
> b.show()
"Anna Karishma Mel Michael  ( Tyler) Wenjie "
> b.add("Corey")
> b.show()
"Anna Corey Karishma  ( Mel) Michael Tyler Wenjie "
> 
  
  *********************************************************************/
}