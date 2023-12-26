package PrototypeRegistry;

public class Button implements Prototype{
    int x,y ;
    String color ;

    Button(int x,int y,String color){

        this.x = x;
        this.y = y;
        this.color = color;
        
    }

   @Override
   public Button getClone() {
      Button button = new Button(x,y,color);
      return button;
   }

   @Override
   public String getColor() {
       return color;
   }

}
