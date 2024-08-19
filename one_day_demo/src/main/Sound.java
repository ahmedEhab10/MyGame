package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL SoundUrl [] = new URL[30];

    public Sound() {

        SoundUrl[0] = getClass().getResource("/res/sound/BlueBoyAdventure.wav");
        SoundUrl[1] = getClass().getResource("/res/sound/coin.wav");
        SoundUrl[2] = getClass().getResource("/res/sound/powerup.wav");
        SoundUrl[3] = getClass().getResource("/res/sound/unlock.wav");
        SoundUrl[4] = getClass().getResource("/res/sound/fanfare.wav");

    }


    public void setfile(int i){
    try {
        AudioInputStream ais = AudioSystem.getAudioInputStream(SoundUrl[i]);
        clip = AudioSystem.getClip();
        clip.open(ais);
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public void playSound() {
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopSound() {
        clip.stop();
    }





}
