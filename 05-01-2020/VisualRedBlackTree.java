import java.awt.*;

public class VisualRedBlackTree extends RedBlackTree {
  public void draw(Graphics g) {
    Font myFont = new Font("Courier", Font.BOLD, 40); // numbers inside nodes have a certain size  
    ((Graphics2D)g).setFont(myFont);
    ((Graphics2D)g).drawString(this.toString(), 100, 100); 

    
    /*
    
Welcome to DrJava.  Working directory is C:\Users\dgerman\Desktop\fri-may-01
> RedBlackTree t = new RedBlackTree()
> t

> t.add("Tyler")
> t
Tyler 
> t.add("Michael")
> t
Michael Tyler 
> t.add("Corey")
> t
Corey Michael Tyler 
> t.add("Derek K")
> t
Corey Derek K Michael Tyler 
> t.add("Wenjie")
> t
Corey Derek K Michael Tyler Wenjie 
> t.root
RedBlackTree$Node@4d085d26
> t.root.data
"Michael"
> t.root.left
RedBlackTree$Node@1cfada7
> t.root.left.data
"Corey"
> t.root.right.data
"Tyler"
> t.root.right.left
null
> t.root.right.right
RedBlackTree$Node@17150380
> t.root.right.right.data
"Wenjie"
> 
    
     */
  }
}