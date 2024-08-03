import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        boolean validSongChoice = false;

        chooseSong(validSongChoice);

    }

    private static void manipulateSong(String response, Clip clip) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Scanner scanner = new Scanner(System.in);
        boolean validSongChoice = false;
        while (!response.equals("Q")) {
            System.out.println("What would you like to do?\nS - stop\nP - play\nR - reset\nQ - quit\nC - choose other song");
            response = scanner.next();
            response = response.toUpperCase();
            switch (response) {
                case ("P"):
                    clip.start();
                    break;
                case ("S"):
                    clip.stop();
                    break;
                case("R"):
                    clip.setMicrosecondPosition(0);
                    break;
                case ("C"):
                    clip.stop();
                    chooseSong(validSongChoice);
                    break;
                case ("Q"):
                    System.out.println("Thanks for listening!");
                    break;
                default:
                    System.out.println("Please choose a valid option");
            }
        }
    }

    private static void chooseSong(boolean validSongChoice) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Scanner scanner = new Scanner(System.in);
        String response = "";


        File[] songs = new File[3];

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
        Clip chosenClip = null;
        while (!validSongChoice) {
            System.out.println("Which song would you like to play? (Select the number of the song you want to play)\n" +
                    "1) Instant Crush - Daft Punk\n2) Murder on my mind - YNW Melly\n3) Flashing lights - Kanye West");
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
        manipulateSong(response, chosenClip);
    }
}
