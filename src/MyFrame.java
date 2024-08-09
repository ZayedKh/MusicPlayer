import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {
    private JButton [] buttons; //Array of buttons
    public boolean showMusicControls; //Boolean to control which frame is visible
    private int numberOfButtons; //Int that decides the number of buttons to display
    private String [] buttonTitles; //Array of strings that hold the text displayed on the buttons


    MyFrame(int numberOfButtons, String [] buttonTitles) {
        this.numberOfButtons = numberOfButtons;

        buttonTitles = new String[numberOfButtons];
        buttons = new JButton[numberOfButtons];

        for (int i = 0; i < numberOfButtons;i++){ //Loop that configures the buttons and sets their paramenters
            this.buttonTitles[i] = buttonTitles[i];

            buttons[i] = new JButton();
            buttons[i].setBounds(125, 150 + (i*75),200,50);
            buttons[i].setText(buttonTitles[i]);
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("Comic Sans", Font.BOLD, 10));
            buttons[i].setForeground(Color.white);
            buttons[i].setBackground(Color.black);
            buttons[i].addActionListener(this);
        }

        // Configure the frame and set it's parameters
        this.setTitle("Music player GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(150, 110, 200));
        this.setResizable(false);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);

        for (int i = 0; i < 3; i++){ // Loop that adds buttons to the frame
            this.add(buttons[i]);
        }

        this.add(new MyLabel("Choose your song!"));

        ImageIcon headphoneImage = new ImageIcon("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\headphones.png"); // Changes the GUI icon
        this.setIconImage(headphoneImage.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validSongChoice = false;
        showMusicControls = false;
        String songNumber;
        if (e.getSource() == buttons[0]) {
            songNumber = "1";
            try {
                Main.chooseSong(validSongChoice, songNumber);
                showMusicControls = true;
                this.setVisible(false);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == buttons[1]) {
            songNumber = "2";
            try {
                Main.chooseSong(validSongChoice, songNumber);
                showMusicControls = true;
                this.setVisible(false);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == buttons[2]) {
            songNumber = "3";
            try {
                Main.chooseSong(validSongChoice, songNumber);
                showMusicControls = true;
                this.setVisible(false);
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
