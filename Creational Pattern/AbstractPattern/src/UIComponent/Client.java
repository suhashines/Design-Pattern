package UIComponent;
public class Client {
    public static void main(String[] args) {
        UIFactory uiFactory = new OSFactory().createUIFactory("Win");
        Button button = uiFactory.createButton();
        button.renderButton();
        button.onClick();

        Textbox textBox = uiFactory.createTextBox();
        textBox.renderTextbox();
        textBox.input();
    }
}
