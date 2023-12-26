package UIComponent;

public interface Button {
    void renderButton();
    void onClick();
}

class WindowsButton implements Button {
    public void renderButton(){
        System.out.println("windows button renderd");
    }

    public void onClick(){
        System.out.println("windows button clicked");
    }
}
class MacOSButton implements Button {
    public void renderButton(){
        System.out.println("MacOS button created");
    }

    public void onClick(){
        System.out.println("MacOS button clicked");
    }
}
