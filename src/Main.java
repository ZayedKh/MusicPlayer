import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);
        String response;
        boolean validSongChoice = false;

        File [] songs = new File[3];

        songs[0] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\instant_crush.wav");
        songs[1] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\murder_on_my_mind.wav");
        songs[2] = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\flashing_lights.wav");

        AudioInputStream [] audioInputStreams = new AudioInputStream[3];
        Clip [] clips = new Clip[3];

        for (int i = 0; i < 3; i++){
            audioInputStreams[i]= AudioSystem.getAudioInputStream(songs[i]);
            clips[i] = AudioSystem.getClip();
            clips[i].open(audioInputStreams[i]);
        }

        while (!validSongChoice) {
            System.out.println("Which song would you like to play? (Select the number of the song you want to play)\n" +
                    "1) Instant Crush - Daft Punk\n2) Murder on my mind - YNW Melly\n3) Flashing lights - Kanye West");
            response = scanner.next();

            response = response.toLowerCase();

            switch (response) {
                case ("1"):
                    clips[0].start();
                    validSongChoice = true;
                    break;
                case("2"):
                    clips[1].start();
                    validSongChoice = true;
                    break;
                case("3"):
                    clips[2].start();
                    validSongChoice = true;
                    break;
                default:
                    System.out.println("Please choose a valid song");
            }
        }

        System.out.println("Enjoy the song!");
        response = scanner.next();
    }
}
