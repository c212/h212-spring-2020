import java.util.*;
public class Graph extends HashMap<Node, Neighbors> {
  public void show() {
    for (Node n: this.keySet())
      System.out.println( n + ":" + this.get(n) );
    System.out.println("---");
  }
  public Neighbors neighborsOf(Node n) {
    return this.get(n);
  }
}