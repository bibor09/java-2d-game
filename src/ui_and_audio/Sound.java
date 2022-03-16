package ui_and_audio;

import javax.imageio.stream.ImageOutputStream;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Sound {
    Clip clip;
    File soundFile[] = new File[5];

    public Sound(){
        soundFile[0] = new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Sounds\\player_music.wav");
        soundFile[1] = new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Sounds\\gameover_se.wav");
        soundFile[2] = new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Sounds\\hit_se.wav");
        soundFile[3] = new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Sounds\\enemy_death_se.wav");
        soundFile[4] = new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Sounds\\hurt_se.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }

}
