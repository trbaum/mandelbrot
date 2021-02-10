import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MBAListener implements ActionListener{

   private int counter;
   
   public MBAListener(){
      super();
      this.counter = 0;
   
   }
     
   
   public void actionPerformed(ActionEvent arg0) {
      this.counter += 1;               
   } 
   
   public int getInfo(){
      return this.counter;
   }         
         
}