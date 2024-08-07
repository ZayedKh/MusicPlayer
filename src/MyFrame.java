import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {

    JButton instantCrushButton;

    MyFrame() {
        instantCrushButton = new JButton();
        instantCrushButton.setBounds(125, 150, 200, 50);
        instantCrushButton.setText("Instant Crush - Daft Punk");
        instantCrushButton.setFocusable(false);
        instantCrushButton.setFont(new Font("Comic Sans", Font.BOLD, 10));
        instantCrushButton.setForeground(Color.white);
        instantCrushButton.setBackground(Color.black);
        instantCrushButton.addActionListener(this);

        this.setTitle("Music player GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(150, 110, 200));
        this.setResizable(false);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.add(instantCrushButton);
        this.add(new MyLabel("Choose your song!"));
        ImageIcon headphoneImage = new ImageIcon("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\headphones.png");
        this.setIconImage(headphoneImage.getImage());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validSongChoice = false;
        if (e.getSource() == instantCrushButton) {
            String songNumber = "1";
            try {
                Main.chooseSong(validSongChoice,songNumber);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
