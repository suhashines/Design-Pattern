package UIComponent;
public interface Textbox {
    void renderTextbox();
    void input();
}

class WindowsTextbox implements Textbox {
    public void renderTextbox(){
        System.out.println("windows Textbox renderd");
    }

    public void input(){
        System.out.println("windows Textbox clicked");
    }
}
class MacOSTextbox implements Textbox {
    public void renderTextbox(){
        System.out.println("MacOS Textbox renderd");
    }

    public void input(){
        System.out.println("MacOS Textbox clicked");
    }
}
