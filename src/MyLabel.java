import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyLabel extends JLabel {
    private String text;
    MyLabel(String text){
        this.text = text;
        this.setText(text);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setFont(new Font("MV Boli",Font.BOLD,25));
        this.setBounds(100,-50,250,250);
    }
}
