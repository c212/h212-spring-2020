public class Example {
  public static void main(String[] args) {
    String argument = args.length == 0 ? "3" : args[0]; 
    int size = Integer.parseInt( argument ); 
    int[][] m = new int[size][size];
    Example.show( m ); 
  }
  public static String advance(int[][] matrix) {
    return "Nah!";
  }
  public static void show(int[][] matrix) {
    for (int[] row : matrix) 
      System.out.println( java.util.Arrays.toString( row ) ); 
  }
}