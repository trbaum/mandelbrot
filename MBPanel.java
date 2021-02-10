import javax.swing.*;    
import java.awt.*;    

public class MBPanel extends JPanel {
   private double xCenter;
   private double yCenter;
   private double radius;
   private int pixelRadius;
   private int depth;
   private ColorMap c;


   public MBPanel(int pixelRadius,int depth,double xCenter,double yCenter,double radius,ColorMap c){
      this.pixelRadius = pixelRadius;
      this.depth = depth;
      this.xCenter = xCenter;
      this.yCenter = yCenter;
      this.radius = radius;
      this.c = c;

   }


   
   public void paintComponent(Graphics g){    
      // clear the previous painting
      super.paintComponent(g);    
      Graphics2D g2 = (Graphics2D)g;        
      double scale = this.radius / (this.pixelRadius*1.0);
      for(int i = -pixelRadius; i <= pixelRadius; i++){
         for(int j = -pixelRadius; j <= pixelRadius; j++){
            double range = iterations(xCenter+(i*1.0*scale),yCenter-+(j*1.0*scale));
            g2.setColor(this.c.getColor(range));
            g2.fillRect(i+pixelRadius,j+pixelRadius,1,1);
         }
      }
   }
   
    
    
   public double iterations(double x,double y){
      ComplexNumber c = new ComplexNumber(x,y);
      ComplexNumber z = new ComplexNumber(0.0,0.0);
      for(int i = 0; i<=this.depth; i++){
         if(z.distance() >= 2.0){
            return ((i*1.0)/(this.depth*1.0));
         }
         z = z.square().add(c);
      }
      return 1.1; //max value
   }
   
   


}