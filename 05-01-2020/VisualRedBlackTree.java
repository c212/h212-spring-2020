import java.awt.*;

public class VisualRedBlackTree extends RedBlackTree {
  public void draw(Graphics g) {
    Font myFont = new Font("Courier", Font.BOLD, 40); // numbers inside nodes have a certain size  
    ((Graphics2D)g).setFont(myFont);
    // ((Graphics2D)g).drawString(this.value + "", this.x + radius*2/3, this.y + radius*4/3); 
    ((Graphics2D)g).drawString("Look, I am your tree!", 100, 100); 

  }
}