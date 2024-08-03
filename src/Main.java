import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);

        File file = new File("C:\\Users\\T L S\\JavaProjects\\MusicPlayer\\Resources\\instant_crush.wav");

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        

    }
}