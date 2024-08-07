import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {

    JButton instantCrushButton;
    JButton murderOnMyMindButton;
    JButton flashingLightsButton;

    MyFrame() {
        instantCrushButton = new JButton();
        instantCrushButton.setBounds(125, 150, 200, 50);
        instantCrushButton.setText("Instant Crush - Daft Punk");
        instantCrushButton.setFocusable(false);
        instantCrushButton.setFont(new Font("Comic Sans", Font.BOLD, 10));
        instantCrushButton.setForeground(Color.white);
        instantCrushButton.setBackground(Color.black);
        instantCrushButton.addActionListener(this);


        murderOnMyMindButton = new JButton();
        murderOnMyMindButton.setBounds(125, 225, 200, 50);
        murderOnMyMindButton.setText("Murder on my mind - YMW Melly");
        murderOnMyMindButton.setFocusable(false);
        murderOnMyMindButton.setFont(new Font("Comic Sans", Font.BOLD, 10));
        murderOnMyMindButton.setForeground(Color.white);
        murderOnMyMindButton.setBackground(Color.black);
        murderOnMyMindButton.addActionListener(this);

        flashingLightsButton = new JButton();
        flashingLightsButton.setBounds(125, 300, 200, 50);
        flashingLightsButton.setText("Flashing lights - Kanye West");
        flashingLightsButton.setFocusable(false);
        flashingLightsButton.setFont(new Font("Comic Sans", Font.BOLD, 10));
        flashingLightsButton.setForeground(Color.white);
        flashingLightsButton.setBackground(Color.black);
        flashingLightsButton.addActionListener(this);

        this.setTitle("Music player GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(150, 110, 200));
        this.setResizable(false);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.add(instantCrushButton);
        this.add(murderOnMyMindButton);
        this.add(flashingLightsButton);
        this.add(new MyLabel("Choose your song!"));
        ImageIcon headphoneImage = new ImageIcon("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\headphones.png");
        this.setIconImage(headphoneImage.getImage());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validSongChoice = false;
        String songNumber;
        if (e.getSource() == instantCrushButton) {
            songNumber = "1";
            try {
                Main.chooseSong(validSongChoice, songNumber);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == murderOnMyMindButton) {
            songNumber = "2";
            try {
                Main.chooseSong(validSongChoice, songNumber);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == flashingLightsButton) {
            songNumber = "3";
            try {
                Main.chooseSong(validSongChoice, songNumber);
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
