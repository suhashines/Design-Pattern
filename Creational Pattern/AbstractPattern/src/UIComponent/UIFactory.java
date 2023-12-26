package UIComponent;

public interface UIFactory {
    Button createButton();
    Textbox createTextBox();
}


class WindowsUIFactory implements UIFactory {
    public Button createButton(){
        return new WindowsButton();
    }
    public Textbox createTextBox(){
        return new WindowsTextbox();
    }
}

class MacOSUIFactory implements UIFactory {
    public Button createButton(){
        return new MacOSButton();
    }
    public Textbox createTextBox(){
        return new MacOSTextbox();
    }
}
