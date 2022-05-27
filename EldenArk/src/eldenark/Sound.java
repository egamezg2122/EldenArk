package eldenark;

/**
 *
 * @author elias
 * 
 */


import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {
    
    Clip clip;
    
    URL soundURL[] = new URL[30];
    
    public Sound() {

        soundURL[0] = getClass().getResource("/media/MENU.wav");
        soundURL[1] = getClass().getResource("/media/MENU2.wav");
        soundURL[2] = getClass().getResource("/media/COMBAT.wav");
        soundURL[3] = getClass().getResource("/media/FINALBOSS.wav");
        soundURL[4] = getClass().getResource("/media/EXPERIENCE.wav");
        soundURL[5] = getClass().getResource("/media/OPTIONMENU.wav"); 
        soundURL[6] = getClass().getResource("/media/LOOT.wav");
        soundURL[7] = getClass().getResource("/media/NOPASS.wav");
        soundURL[8] = getClass().getResource("/media/SPECIALHAB.wav");
        soundURL[9] = getClass().getResource("/media/POTION.wav");
        soundURL[10] = getClass().getResource("/media/ATTACK.wav");
        soundURL[11] = getClass().getResource("/media/DEFENSE.wav");
    }
    
    public void setFile(int i) {
        
        try{
        
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);  
            
            clip = AudioSystem.getClip();
            
            clip.open(ais);
            
        }catch(Exception e){
        
        }
    
    }
    
    public void play() {
    
        clip.start();
        
    }
    
    public void loop() {
    
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        
    }
    
    public void stop() {
        
        clip.stop();
    
    }
    
    // Sound Methods
    
    public void playMusic (int i){
        
        this.setFile(i);
        
        this.play();
        
        this.loop();

    }
    
    public void stopMusic (){
    
        this.stop();
        
    }
    
    public void playSE (int i){
    
        this.setFile(i);
        
        this.play();
        
    }

    public Sound(Clip clip) {
        this.clip = clip;
    }
        
}

