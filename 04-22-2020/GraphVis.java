import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.lang.Math;
public class GraphVis extends JComponent{
  
  //how to get random int: Min + (int)(Math.random()*((max-min)+1))
  int width, height;
  Graph graph;
  
  public GraphVis(int width, int height, Graph graph) {
    this.width = width;
    this.height = height;
    this.graph = graph;
  }
  
  public void drawNode(Graphics g, Node node, int x, int y){
    node.x = x;
    node.y = y;
    g.fillOval(x, y, 20, 20);
    g.drawString(node.name, x, y);
    
  }
  
  public void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
    //modifying to put arrow in the middle
    int ay1 = y1;
    int ay2 = y2;
    int ax1 = x1;
    int ax2 = x2;
    
    //using midpoint formula to place arrow
    x2 = (int)((x1 + x2)/2);
    y2 = (int)((y1 + y2)/2);
   
    int dx = (x2 - x1), dy = y2 - y1;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - d, xn = xm, ym = h, yn = -h, x;
    double sin = dy / D, cos = dx / D;
    
    x = (xm*cos - ym*sin + x1);
    ym = xm*sin + ym*cos + y1;
    xm = x;
    
    x = (xn*cos - yn*sin + x1);
    yn = xn*sin + yn*cos + y1;
    xn = x;
    
    int[] xpoints = { x2, (int) xm, (int) xn};
    int[] ypoints = { y2, (int) ym, (int) yn};
    
    g.drawLine(ax1, ay1, ax2, ay2);
    g.fillPolygon(xpoints, ypoints, 3);
  }
  
  public void drawPath(Graphics g, Node node1, Node node2){
    this.drawArrowLine(g, node1.x+10, node1.y+10, node2.x+10, node2.y+10, 5, 5);
  }
  
  
  
  public void paintComponent(Graphics g) {
    //drawing each node
    for (Node node: this.graph.keySet()){
      this.drawNode(g, node, 
                    (10 + (int)(Math.random()*((this.width-20)+1))), 
                    (10 + (int)(Math.random()*((this.height-20)+1))));}
    
    //drawing paths between nodes
    for (Node node: this.graph.keySet()){
      for (Node neighbor: graph.neighborsOf(node)) {
        this.drawPath(g, node, neighbor);
      }
    }
  }
  
    public static void main(String[] args) {
    //constructing graph
    Graph a = new Graph();
    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    a.put( A, new Neighbors(new Node[] { B, C })) ;
    a.put( B, new Neighbors(new Node[] { C })) ;
    a.put( C, new Neighbors(new Node[] { D, A, B })) ;
    a.put( D, new Neighbors(new Node[] { A, B })) ;
    
    //constructing Jframe to hold visualization
    JFrame frame = new JFrame();
    frame.setVisible(true);
    int width = 500, height = 500;
    frame.setSize(width+20, height+40);
    GraphVis drawing = new GraphVis(width, height, a);
    frame.add(drawing);
  }
}