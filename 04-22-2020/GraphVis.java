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
    g.drawOval(x, y, 20, 20);
    g.drawString(node.name, x, y);
    
  }
  
  public void paintComponent(Graphics g) {
    for (Node node: this.graph.keySet()){
      this.drawNode(g, node, 
                    (10 + (int)(Math.random()*((this.width-20)+1))), 
                    (10 + (int)(Math.random()*((this.height-20)+1))));}
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