import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static File[] songs = new File[3];
    public static String[] songTitles = new String[]{"Instant Crush - Daft Punk", "Murder on my mind - YNW Melly", "Flashing lights - Kanye West"};
    public static String[] controlSong = new String[]{"Play", "Stop", "Reset", "Choose other song", "Quit"};
    public static boolean validSongChoice = false;
    private static Clip chosenClip = null;

    public static void main(String[] args) {
        MyFrame songSelectorFrame = new MyFrame(3, songTitles);
    }

    public static void manipulateSong(String response) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        if (Main.validSongChoice) {
            MyFrame frame = new MyFrame(5, controlSong);

            response = response.toUpperCase();
            switch (response) {
                case ("P"):
                    chosenClip.start();

                    break;
                case ("S"):
                    chosenClip.stop();

                    break;
                case ("R"):
                    chosenClip.setMicrosecondPosition(0);
                    break;
                case ("C"):
                    frame.setVisible(false);
                    Main.validSongChoice = false;
                    chosenClip.stop();
                    MyFrame songSelectorFrame = new MyFrame(3, songTitles);
                    break;
                case ("Q"):
                    frame.setVisible(false);
                    chosenClip.stop();
                    System.out.println("Thanks for listening!");
                    Main.validSongChoice = false;
                    System.exit(0);
                    break;
            }

        }
    }


    /*
        This method takes in a boolean - validSongChoice, and a String - songNumber. This method holds the files used to play the songs.
        A switch statement is used to control which song to play, based on the songNumber variable, each song corresponds to a number which is based on which option
        the user chooses.

        The while loop ensures that the user selects a valid song, once a song is selected the boolean is set to true and the while loop is broken.
        After the while loop the manipulateSong method is called to control the song, using the chosenClip Clip as the parameter.
         */
    public static void chooseSong(boolean validSongChoice, String songNumber) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        // Files to hold songs are created

        songs[0] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\instant_crush.wav");
        songs[1] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\murder_on_my_mind.wav");
        songs[2] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\flashing_lights.wav");

        AudioInputStream[] audioInputStreams = new AudioInputStream[3];
        Clip[] clips = new Clip[3];


        for (int i = 0; i < 3; i++) {
            audioInputStreams[i] = AudioSystem.getAudioInputStream(songs[i]);
            clips[i] = AudioSystem.getClip();
            clips[i].open(audioInputStreams[i]);
        }
        chosenClip = null; // Parameter to send to the manipulateSong method.

        // While loop to ensure the user selects a valid song
        while (!Main.validSongChoice) {
            switch (songNumber) {
                case ("1"):
                    chosenClip = clips[0]; // ChosenClip is set to the song chosen by the user
                    Main.validSongChoice = true; // Boolean set to true if valid song is selected
                    break;
                case ("2"):
                    chosenClip = clips[1];
                    Main.validSongChoice = true;
                    break;
                case ("3"):
                    chosenClip = clips[2];
                    Main.validSongChoice = true;
                    break;
                default:
                    System.out.println("Please choose a valid song!"); // Default option in case user doesn't select a valid option.
            }
        }
        manipulateSong(songNumber); // Method call
    }


    public static void chooseSong(boolean validSongChoice) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Scanner scanner = new Scanner(System.in);
        String response = "";

        songs[0] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\instant_crush.wav");
        songs[1] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\murder_on_my_mind.wav");
        songs[2] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\flashing_lights.wav");

        AudioInputStream[] audioInputStreams = new AudioInputStream[3];
        Clip[] clips = new Clip[3];


        for (int i = 0; i < 3; i++) {
            audioInputStreams[i] = AudioSystem.getAudioInputStream(songs[i]);
            clips[i] = AudioSystem.getClip();
            clips[i].open(audioInputStreams[i]);
        }

        while (!validSongChoice) {
            System.out.println("""
                    Which song would you like to play? (Select the number of the song you want to play)
                    1) Instant Crush - Daft Punk
                    2) Murder on my mind - YNW Melly
                    3) Flashing lights - Kanye West""");
            response = scanner.next();

            response = response.toLowerCase();
            switch (response) {
                case ("1"):
                    chosenClip = clips[0];
                    validSongChoice = true;
                    break;
                case ("2"):
                    chosenClip = clips[1];
                    validSongChoice = true;
                    break;
                case ("3"):
                    chosenClip = clips[2];
                    validSongChoice = true;
                    break;
                default:
                    System.out.println("Please choose a valid song");
            }
        }
        manipulateSong(response);
    }

    public static void closeFrame(MyFrame frame) {
        frame.setVisible(false);
    }

}
