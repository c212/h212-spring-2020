import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class SeparateTesting {
  // purpose statement: advance tries to seize next line 
  public static boolean advance(int[][] matrix) {
    int size = matrix.length; 
    int line = -1, column = -1; 
    for (int i = 0; i < size; i++) {
      column = lastOne(matrix[i]); 
      if (column >= 0) {
        line = i; 
      } else {
        matrix[i][0] = 1; 
        return true; 
      }
    }
    return attempt(line, column, matrix); 
  }
  // purpose statement: attempt is backtracking to last extensible state 
  public static boolean attempt(int line, int column, int[][] m) {
    int size = m.length; 
    if (line < 0) return false; 
    else if (line <= size-1) {
      if (column == size-1) {
        m[line][column] = 0; 
        return attempt(line - 1, lastOne(m[line-1]), m); 
      } else {
        m[line][column] = 0;
        m[line][column+1] = 1; 
        return true;
      }
    } return false; 
  }
  public static int lastOne(int[] m) {
    int index = m.length-1; 
    while (index >= 0 && m[index] != 1) 
      index--; 
    return index;
  }
  public static void main(String[] args) {
    int[][] m = new int[3][3]; 
    show(m);
    boolean result = advance(m); 
    show(m); 
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    advance(m);
    show(m);
    
  }
  public static void show(int[][] matrix) {
    for (int[] row : matrix) 
      System.out.println( java.util.Arrays.toString( row ) ); 
    System.out.println("-----------------"); 
  }
}