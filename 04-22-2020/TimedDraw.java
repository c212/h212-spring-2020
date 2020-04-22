import java.util.Timer;
import java.util.TimerTask;
public class TimedDraw{
  GraphVis drawing;
  Timer timer;
  int repeats;
  
  public TimedDraw(GraphVis drawing){
    this.drawing = drawing;
    this.timer = new Timer();
    this.repeats = this.drawing.allpaths.size();
    timer.scheduleAtFixedRate(new Action(), 3000, 1000);
    }
  
  
  class Action extends TimerTask{
    public void run() {
      if (repeats <=0){
        System.out.println("cancelling timer");
        timer.cancel();
        timer.purge();
      } else {
      System.out.println("repainting jframe");
      drawing.currentpath = drawing.allpaths.get(0);
      drawing.allpaths.remove(0);
      drawing.repaint();
      repeats = repeats -1;
      }
    }
  }
    
}