import java.awt.*; 

public class What {
  final int radius = 20; 
  int value; 
  What next;
  int x, y;
  boolean contains(int x, int y) {
    return radius >= Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));  
  }
  boolean drawn = false; 
  public What(int value, What next) {
    this.value = value; 
    this.next = next; 
    this.x = (int)(Math.random() * 400 + 50); 
    this.y = (int)(Math.random() * 400 + 50); 
  }
  public void draw(Graphics g) {
    g.setColor(Color.WHITE); 
    g.fillOval(this.x, this.y, 2 * radius, 2 * radius); 
    g.setColor(Color.BLACK); 
    g.drawOval(this.x, this.y, 2 * radius, 2 * radius); 
    Font myFont = new Font("Courier", Font.BOLD, 20); // numbers inside nodes have a certain size  
    ((Graphics2D)g).setFont(myFont);
    ((Graphics2D)g).drawString(this.value + "", this.x + radius*2/3, this.y + radius*4/3); 
  }
  void moveTo(int x, int y) {
    this.x = x;
    this.y = y; 
  }
}