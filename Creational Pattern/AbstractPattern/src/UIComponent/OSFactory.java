package UIComponent;
public class OSFactory {
    UIFactory createUIFactory(String OS){

        if(OS.equalsIgnoreCase("Win")){
            return new WindowsUIFactory();
        }else if(OS.equalsIgnoreCase("Mac")){
            return new MacOSUIFactory();
        }
        return null ;
    }
}
