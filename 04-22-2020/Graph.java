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
  public Path shortestPath(Node target, Paths candidates) {
    if (candidates == null) return null; 
    else if (candidates.size() == 0) return new Path(); 
    else {
      for (Path candidate : candidates) {
        //ask if last node in candididate path is target node
        if (candidate.get(candidate.size() - 1).equals(target)) {
          //if it is, return that path and you are done!
          return candidate;}
      }
      //if it is not, we need to make a new set of candidates
      Paths newSet = new Paths();
      //loop thru each candidate
      for (Path candidate: candidates){
        //check to see if path is a dead end
        if (neighborsOf(candidate.get(candidate.size()-1)) == null){
          System.out.println(candidate.get(candidate.size()-1) +" is a dead end.");
        } else {
          // loop thru the neighbors of the last node of the candidate
          for (Node n: neighborsOf( candidate.get(candidate.size() -1) )) {
            //clone the path so we can alter it without altering original object
            Path clone = candidate.clone();
            //if the candidate path already contains the node we are looking at that 
            //means it is not the shortest path and it contains a cycle, so we do not
            //add it to the new candidate set
            if (clone.contains(n)) {
              //do nothing
            } else {
              //otherwise add the node we are looking at to the end of the clone path and
              //add that path as a candidate for the next round
              clone.add(n);
              newSet.add(clone);
          }
        }
    } 
  }
      //recursively look through each set of candidates until we have a path that reaches the target node
      return shortestPath(target, newSet);
  }  
  }
  
  public static void main(String[] args) {
    //creating new graph
    Graph a = new Graph();
    Node  sf = new Node("san francisco");
    Node   p = new Node("portland");
    Node  la = new Node("los angeles");
    Node slc = new Node("salt lake city");
    Node  v = new Node("vancouver");
    Node   s = new Node("seattle");
    Node   h = new Node("helena");
    Node   d = new Node("denver");
    Node  lv = new Node("las vegas");
    Node sfe = new Node("santa fe");
    Node  ph = new Node("phoenix");
    Node   e = new Node("el paso");
    a.put( sf, new Neighbors(new Node[] {  p, slc,  la           } ));
    a.put(  p, new Neighbors(new Node[] {  s, slc,  sf           } ));
    a.put(slc, new Neighbors(new Node[] {  h,   d,  lv,  sf,   p } ));
    a.put( la, new Neighbors(new Node[] { sf,  lv,  ph,   e      } ));
    
    Path path = a.shortestPath(new Node(args[1]),
                            new Paths(new Path(new Node(args[0]))));
    System.out.println( path ); /* 

Welcome to DrJava.  Working directory is C:\Users\dgerman\Desktop\mels example
> java Graph "san francisco" "los angeles"
[san francisco, los angeles]
> java Graph "san francisco" "portland"
[san francisco, portland]
> java Graph "san francisco" "seattle"
[san francisco, portland, seattle]
> java Graph "los angeles" "seattle"
las vegas is a dead end.
phoenix is a dead end.
el paso is a dead end.
[los angeles, san francisco, portland, seattle]
> 

                                 */
  }
}