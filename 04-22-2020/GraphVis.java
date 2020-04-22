import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Color;
public class GraphVis extends JComponent{
  
  int width, height;
  Graph graph;
  Paths allpaths;
  Path currentpath;
  
  
  public GraphVis(int width, int height, Graph graph, Paths allpaths, Path bestpath) {
    this.width = width;
    this.height = height;
    this.graph = graph;
    this.currentpath = new Path();
    allpaths.add(bestpath);
    this.allpaths = allpaths; 
    
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
  
  public void lightNode(Graphics g, Node node){
    g.setColor(new Color(114, 247, 236));
    g.fillOval(node.x, node.y, 20, 20);
  }
  
  
  public void paintComponent(Graphics g) {
    //drawing each node, placing evenly around in a circle
    double t = 6;
    for (Node node: this.graph.keySet()){
      this.drawNode(g, node, (int)(200*Math.cos(t)+250), (int)(200*Math.sin(t)+250));
      System.out.println(node+""+node.x+node.y);
      t = t + 6.28/this.graph.keySet().size();
    }
    
    //drawing paths between nodes
    for (Node node: this.graph.keySet()){
      for (Node neighbor: graph.neighborsOf(node)) {
        this.drawPath(g, node, neighbor);
      }
    }
    
    //drawing current path
    t = 0;
    for (Node node: currentpath){
      System.out.println(node+""+node.x+node.y);
      this.lightNode(g, node);
      }
    int i = 0;
    g.setColor(new Color(114, 247, 236));
    while (i<currentpath.size()-1) {
      this.drawPath(g, currentpath.get(i), currentpath.get(i+1));
      i = i+1;
    }
    }
    
  
    public static void main(String[] args) {
    //constructing graph
    Graph a = new Graph();
    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    Node E = new Node("E");
    Node F = new Node("F");
    Node G = new Node("G");
    Node H = new Node("H");
    
    a.put( A, new Neighbors(new Node[] { B })) ;
    a.put( B, new Neighbors(new Node[] { C })) ;
    a.put( C, new Neighbors(new Node[] { D, A })) ;
    a.put( D, new Neighbors(new Node[] { A, E })) ;
    a.put( E, new Neighbors(new Node[] { B, G })) ;
    a.put( F, new Neighbors(new Node[] { C, H, E })) ;
    a.put( G, new Neighbors(new Node[] { D, F})) ;
    a.put( H, new Neighbors(new Node[] { A, C })) ;
    
    //running search
    Pair pair = a.shortestPath(F, new Paths(new Path(C)), new Paths());
    Paths paths = pair.allpaths;
    Path bestpath = pair.path;
    
    //constructing Jframe to hold visualization
    JFrame frame = new JFrame();
    frame.setVisible(true);
    int width = 500, height = 500;
    frame.setSize(width+20, height+40);
    GraphVis drawing = new GraphVis(width, height, a, paths, bestpath);
    frame.add(drawing);
    TimedDraw timeddraw = new TimedDraw(drawing);
    }
    
        
}