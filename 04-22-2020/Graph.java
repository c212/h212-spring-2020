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
    if (candidates == null) return null; // if there is no starting node there is no path
    else if (candidates.size() == 0) return new Path(); // if starting node is target node then path is empty
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
          System.out.println(candidate.get(candidate.size()-1) +"is a dead end.");
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
}