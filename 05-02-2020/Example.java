import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Example implements ActionListener {
  public static int lastOne(int[] m) {
    int index = m.length-1; 
    while (m[index] != 1 && index > 0) 
      index--; 
    return index;
  }
  int[][] m; 
  int count;
  Timer t; 
  public Example(Timer t, int[][] m) {
    this.t = t; 
    this.m = m; 
  }
  public void actionPerformed(ActionEvent e) {
    this.count += 1; 
    if (count == 20) { 
      System.out.println("That's it, we end at iteration no. " + this.count);
      t.stop(); 
    } else { 
      System.out.println("What's up?  ... #" + this.count); 
      SeparateTesting.advance(m); 
      show(m); 
    }
  }
  public static void main(String[] args) {
    String argument = args.length == 0 ? "3" : args[0]; 
    int size = Integer.parseInt( argument ); 
    int[][] m = new int[size][size];
    Timer t = new Timer(1000, null); 
    Example e = new Example(t, m);
    t.addActionListener( e ); 
    t.start();       
  }
  public static void show(int[][] matrix) {
    for (int[] row : matrix) 
      System.out.println( java.util.Arrays.toString( row ) ); 
    System.out.println("-----------------"); 
  }
}