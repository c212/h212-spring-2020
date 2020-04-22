import java.util.*;
public class Neighbors extends ArrayList<Node> {
  public Neighbors( Node[] neighbors ) {
    for (Node n: neighbors)
      this.add(n);
  }
}