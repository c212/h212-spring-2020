import java.util.*;
public class Path extends ArrayList<Node> {
  public Path() {
  }
  public Path(Node n) {
    this.add(n);
  }
  public Path clone() {
    Path a = new Path();
    for (Node n : this)
      a.add(n);
    return a;
  }
}