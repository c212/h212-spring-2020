import java.util.*;
public class Node {
  String name;
  public Node(String name) {
    this.name = name;
  }
  public String toString() {
    return this.name;
  }
  public int hashCode() {
    return this.name.hashCode();
  }
  public boolean equals(Object other) {
    if (other instanceof Node)
      return this.name.equals(((Node)other).name);
    else
      return false;
  }
  public static void main(String[] args) {
    Map<Node, String> a = new HashMap<Node, String>(); //making a new hashmap from nodes
    //to strings
    a.put(new Node("A"), "something"); //making a node A mapped to "something"
    a.put(new Node("A"), "something else"); //this should remap A to "something else" since
    //hashcode is based on name, not object
    System.out.println( a ); //should print "{A = something else}", there is only one mapping
    Node b = new Node("A"); //creating two more nodes with the same name
    Node c = new Node("A"); 
    System.out.println(b.hashCode()); //should print the same two hashcodes
    System.out.println(c.hashCode()); 
    System.out.println(b.equals(c)); //should be true
    System.out.println(a.get(b)); //should get "something else" both times
    System.out.println(a.get(c)); 
  }
}