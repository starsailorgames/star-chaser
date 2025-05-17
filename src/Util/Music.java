package Util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    private Clip music;
    private long musicTimePosition;
    private static Music instance;

    private Music(){ }

    public static Music getInstance() {
        if (instance == null) {
            instance = new Music();
        }
        return instance;
    }

    public boolean importMusic(String filePath) {
        try {
            File audio = new File(filePath);
            if (!audio.exists()) {
                System.err.println("Error finding audio file: " + filePath);
                return false;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
                music = AudioSystem.getClip();
                music.open(audioStream);
                music.loop(Clip.LOOP_CONTINUOUSLY);
            return true;
        } catch (Exception e) {
            System.err.println("Error loading audio: " + e.getMessage());
            return false;
        }
    }

    public void playMusic(){
        music.start();
    }

    public void pauseMusic(){;
        if(music.isRunning() == true){
            musicTimePosition = music.getMicrosecondPosition();
            music.stop();
        }
    }

    public void resumeMusic(){
        if(music.isRunning() == false){
            music.setMicrosecondPosition(musicTimePosition);
            music.start();
        }
    }

}