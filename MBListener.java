import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MBListener extends MouseAdapter{

   private int xCenter;
   private int yCenter;
   private int counter;
   
   public MBListener(){
      super();
      this.counter = 0;
   }
   
   public void mouseClicked(MouseEvent e){
      xCenter = e.getX();
      yCenter = e.getY();
      counter = counter+1;
   }
   
   public int[] getInfo(){
      int[] info = new int[3];
      info[0] = this.xCenter;
      info[1] = this.yCenter;
      info[2] = this.counter;
      return info;
   }

}