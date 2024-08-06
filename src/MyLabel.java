import javax.swing.*;

public class MyLabel extends JLabel {
    private String text;
    MyLabel(String text){
        this.text = text;
        this.setText(text);
        this.setHorizontalTextPosition(JLabel.CENTER);
    }
}
