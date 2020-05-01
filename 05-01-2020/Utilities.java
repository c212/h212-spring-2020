import java.awt.*; 

public class Utilities {
  /**
   * Draw an arrow line between two points.
   * @param g the graphics component.
   * @param x1 x-position of first point.
   * @param y1 y-position of first point.
   * @param x2 x-position of second point.
   * @param y2 y-position of second point.
   * @param d  the width of the arrow.
   * @param h  the height of the arrow.
   */
  public static void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
    int dx = x2 - x1, dy = y2 - y1;
    int a = (x1 + x2) / 2; 
    int b = (y1 + y2) / 2; 
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - d, xn = xm, ym = h, yn = -h, x;
    double sin = dy / D, cos = dx / D;
    
    x = xm*cos - ym*sin + x1;
    ym = xm*sin + ym*cos + y1;
    xm = x;
    
    x = xn*cos - yn*sin + x1;
    yn = xn*sin + yn*cos + y1;
    xn = x;
    
    int[] xpoints = {x2, (int) xm, (int) xn};
    int[] ypoints = {y2, (int) ym, (int) yn};
    
    g.drawLine(x1, y1, x2, y2);
    g.fillPolygon(xpoints, ypoints, 3);
  } 
  public static void arrow(Graphics g, int x1, int y1, int x2, int y2, int d, int h) { 
    g.drawLine(x1, y1, x2, y2); 
    drawArrowLine(g, x1, y1, x1 + (x2 - x1) * 2 / 3, y1 + (y2 - y1) * 2 / 3, d, h); 
  }
}