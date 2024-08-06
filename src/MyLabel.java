import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyLabel extends JLabel {
    private String text;
    MyLabel(String text){
        this.text = text;
        this.setText(text);
        this.setHorizontalTextPosition(JLabel.CENTER);
//        Border border = BorderFactory.createLineBorder(Color.RED,3);
//        this.setBorder(border);
        this.setBounds(100,100,250,250);
    }
}
