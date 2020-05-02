import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Example implements ActionListener {
  int[][] m; 
  int count;
  Timer t; 
  public Example(Timer t, int[][] m) {
    this.t = t; 
    this.m = m; 
  }
  public void actionPerformed(ActionEvent e) {
    this.count += 1; 
    if (count == 10) { 
      System.out.println("That's it, we end at iteration no. " + this.count);
      t.stop(); 
    } else { 
      System.out.println("What's up?  ... #" + this.count); 
      advance(m); 
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
  public static boolean advance(int[][] matrix) {
    int size = matrix.length; 
    int i = (int)(Math.random() * size);
    int j = (int)(Math.random() * size);
    matrix[i][j] += 1; 
    return true;
  }
  public static void show(int[][] matrix) {
    for (int[] row : matrix) 
      System.out.println( java.util.Arrays.toString( row ) ); 
    System.out.println("-----------------"); 
  }
}