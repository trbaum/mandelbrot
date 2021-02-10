import java.lang.Math;

public class ComplexNumber{
   private double a;
   private double b;
   
   public ComplexNumber(double a, double b){
      this.a = a;
      this.b = b;
   }
   
   public String toString(){
      return Double.toString(this.a) + " + " + Double.toString(this.b) + "i";
   }
   
   public ComplexNumber square(){
      double a = this.a * this.a - (this.b * this.b);
      double b = 2.0 * this.a * this.b;
      return new ComplexNumber(a,b);
   }
   
   public ComplexNumber add(ComplexNumber c){
      double a = this.a + c.a;
      double b = this.b + c.b;
      return new ComplexNumber(a,b);
   }
   
   public double distance(){
      return Math.sqrt((this.a * this.a) + (this.b * this.b));
   }

}