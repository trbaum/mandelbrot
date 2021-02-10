import javax.swing.*;    
import java.awt.*;    

public class ButtonPanel extends JPanel {
   private int bSize;
   private int pixelRadius;
   private MBAListener zoomIn;
   private MBAListener zoomOut;
   private MBAListener moreDepth;
   private MBAListener lessDepth;


   public ButtonPanel(int pixelRadius, int bSize){
      this.bSize = bSize;
      this.pixelRadius = pixelRadius;
      this.zoomIn = new MBAListener();
      this.zoomOut = new MBAListener();
      this.moreDepth = new MBAListener();
      this.lessDepth = new MBAListener();
      
      JButton b0 = new JButton("+");
      JButton b1 = new JButton("-");
      JButton b2 = new JButton("Depth * 2");
      JButton b3 = new JButton("Depth / 2");
      
      b0.setBounds(0,pixelRadius/4,0,bSize);
      b1.setBounds(pixelRadius/2,pixelRadius,0,bSize);
      b2.setBounds(pixelRadius,3*pixelRadius/2,0,bSize);
      b3.setBounds(3*pixelRadius/2,2*pixelRadius,0,bSize);
     
      b0.addActionListener(this.zoomIn);
      b1.addActionListener(this.zoomOut);
      b2.addActionListener(this.moreDepth);
      b3.addActionListener(this.lessDepth);
      
      this.add(b0);
      this.add(b1);
      this.add(b2);
      this.add(b3);
   }
   
   public int[] getInfo(){
      int[] info = new int[4];
      info[0] = zoomIn.getInfo();
      info[1] = zoomOut.getInfo();
      info[2] = moreDepth.getInfo();
      info[3] = lessDepth.getInfo();
      return info;
   }
   
   
}
