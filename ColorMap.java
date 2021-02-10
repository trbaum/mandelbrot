import java.awt.*;
import java.util.ArrayList;

public class ColorMap{
   private ArrayList<Color> colors;
   
   public ColorMap(){
      colors = new ArrayList<Color>(); 
   }
   
   public void add(Color c){
      this.colors.add(c);
   }
   
   public Color getColor(double range){
      // requires at least 2 colors in colors
      if(range >= 1.0) return Color.BLACK;
      
      Color left = Color.WHITE;
      Color right = Color.WHITE;
      double leftDist = 0.0;
      double rightDist = 0.0;
      // 0 <= range <= 1
      double len = 1.0 * this.colors.size();
      for(double i = 0; i < len; i++){
         if(range == i/(len-1)) return this.colors.get((int)(i));
         if(range > i/(len-1) & range < (i+1.0)/(len-1)){
            left = this.colors.get((int)(i));
            right = this.colors.get((int)(i+1));
            leftDist = range - i/(len-1);
            rightDist = (i+1)/(len-1) - range;
            break;
         }
      }
      int red = weightedMean(left.getRed(),1.0/leftDist,right.getRed(),1.0/rightDist);
      int green = weightedMean(left.getGreen(),1.0/leftDist,right.getGreen(),1.0/rightDist);
      int blue = weightedMean(left.getBlue(),1.0/leftDist,right.getBlue(),1.0/rightDist);
      return new Color(red,green,blue);
      
   }
   
   public static int weightedMean(int a, double aWeight, int b, double bWeight){
      return (int)((a*aWeight + b*bWeight)/(aWeight + bWeight));
   }

}