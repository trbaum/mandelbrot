import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

public class Mandelbrot{
   private double xCenter;
   private double yCenter;
   private double radius;
   private int pixelRadius;
   private int depth;
   private JFrame f;
   private ButtonPanel b;
   private MBListener l;
   private ColorMap c;
      
   
   public static void main(String[] args){
      Mandelbrot m = new Mandelbrot(300,10);
      double scale = m.radius / (m.pixelRadius*1.0);
      int counter = 0;
      int[] bCounter = new int[4];
      boolean delta = false;
      m.render();
      while(true){
         int[] info = m.l.getInfo();
         int[] bInfo = m.b.getInfo();
         //delta = false;
         if(info[2] != counter){
            counter += 1;
            m.xCenter = m.xCenter + scale*(info[0]-m.pixelRadius);
            m.yCenter = m.yCenter - scale*(info[1]-m.pixelRadius);
            delta = true;
         }
         if(bInfo[0] != bCounter[0]){
            m.radius /= 2.0;
            scale = m.radius / (m.pixelRadius*1.0);
            bCounter[0] += 1;
            delta = true;
         }
         if(bInfo[1] != bCounter[1]){
            m.radius *= 2.0;
            scale = m.radius / (m.pixelRadius*1.0);
            bCounter[1] += 1;
            delta = true;
         }
         if(bInfo[2] != bCounter[2]){
            m.depth *= 2;
            bCounter[2] += 1;
            delta = true;
         }
         if(bInfo[3] != bCounter[3]){
            m.depth /= 2;
            bCounter[3] += 1;
            delta = true;
         }
         if(delta == true){
            m.render();
            delta = false;
         }
         try{TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){};
      }
   }
   
   
   public Mandelbrot(int pixelRadius, int depth){
      int bSize = 20;
      this.pixelRadius = pixelRadius;
      this.depth = depth;
      this.xCenter = 0.0;
      this.yCenter = 0.0;
      this.radius = 2.0;
      this.f = new JFrame("Mandelbrot Set");
      this.b = new ButtonPanel(pixelRadius,bSize);
      this.l = new MBListener();
      this.c = new ColorMap();
      
      c.add(Color.BLUE);
      c.add(Color.RED);
      c.add(Color.YELLOW);
      c.add(Color.WHITE);
      c.add(Color.BLACK);
     
      this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.f.setSize(pixelRadius*2,(pixelRadius*2)+bSize); 
      this.f.setLayout(new BorderLayout());
      this.f.addMouseListener(l);
      Container c = this.f.getContentPane();
      c.setSize(pixelRadius*2,pixelRadius*2+bSize);
      c.add(this.b,BorderLayout.PAGE_END);
      
      this.f.setVisible(true);
   }
   
   private void render(){
      MBPanel mb = new MBPanel(this.pixelRadius,this.depth,this.xCenter,this.yCenter,this.radius,this.c);
      mb.setSize(pixelRadius*2,pixelRadius*2);
      
      Container c = this.f.getContentPane();
      c.removeAll();
      c.setSize(pixelRadius*2,pixelRadius*2+20);
      c.add(mb,BorderLayout.CENTER);
      c.add(this.b,BorderLayout.PAGE_END);
      
      this.f.setVisible(true);
   }
   
   public void move(double radius, double x, double yCenter){
      this.radius = radius;
      this.xCenter = xCenter;
      this.yCenter = yCenter;
      this.render();
   }
   
   
}