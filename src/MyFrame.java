import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MyFrame extends JFrame {

    MyFrame(){
        this.setTitle("Music player GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(150, 110, 200));
        this.setResizable(false);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(new MyLabel("Choose your song!"));
        ImageIcon headphoneImage = new ImageIcon("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\headphones.png");
        this.setIconImage(headphoneImage.getImage());

    }

}
