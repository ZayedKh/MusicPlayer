import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {
    JButton [] songButtons = new JButton[3];

    MyFrame() {
        String [] songTitles = new String[]{"Instant Crush - Daft Punk", "Murder on my mind - YMW Melly", "Flashing lights - Kanye West"};


        for (int i = 0; i < 3;i++){
            songButtons[i] = new JButton();
            songButtons[i].setBounds(125, 150 + (i*75),200,50);
            songButtons[i].setText(songTitles[i]);
            songButtons[i].setFocusable(false);
            songButtons[i].setFont(new Font("Comic Sans", Font.BOLD, 10));
            songButtons[i].setForeground(Color.white);
            songButtons[i].setBackground(Color.black);
            songButtons[i].addActionListener(this);
        }

        this.setTitle("Music player GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(150, 110, 200));
        this.setResizable(false);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        for (int i = 0; i < 3; i++){
            this.add(songButtons[i]);
        }
        this.add(new MyLabel("Choose your song!"));
        ImageIcon headphoneImage = new ImageIcon("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\headphones.png");
        this.setIconImage(headphoneImage.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validSongChoice = false;
        String songNumber;
        if (e.getSource() == songButtons[0]) {
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
        } else if (e.getSource() == songButtons[1]) {
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
        } else if (e.getSource() == songButtons[2]) {
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
