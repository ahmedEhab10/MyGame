package main;

import entity.player;
import res.object.SuberObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel  implements Runnable{

    final int origtilsize = 16;
    final int scale =3;

    public final int tilsize = origtilsize * scale; //3 *16 = 48
    public final int maxScreenCol = 18;
    public final int maxScreenRow = 14;
    public final int ScreenWidth = tilsize * maxScreenCol;  // 48 * 16 = 768
    public  final int ScreenHeight = tilsize * maxScreenRow; // 48 * 12 = 576

    //world sitting

    public final int maxworldcol =50;
    public final int maxworldrow =50;
    public final int worldwidth = tilsize * maxworldcol;
    public final int worldheight = tilsize * maxworldrow;

    keyhandler key = new keyhandler();
    public collisaionchek colli = new collisaionchek(this);

    public AssetesSeter assetesSeter = new AssetesSeter(this);
    public UI ui = new UI(this);
    Thread GameThread;

    //the Sound
    Sound sound = new Sound();



   public player play = new player(this , key);

   public SuberObject obj [] = new SuberObject[10];

    public TileManager tile = new TileManager(this);

    int FPS = 60;


    public GamePanel(){
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }

    public void setupgame(){

        assetesSeter.setobject();

        playmusic(0);
    }

    public void StartGameTrid(){

        GameThread = new Thread(this);
        GameThread.start();
    }


    @Override
    public void run() {
        double drawinterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;



        while(GameThread!=null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawinterval;

            lastTime = currentTime;
            if(delta >= 1){
                // it will update information such as chracter possition
                Update();
                // draw the screen with the update information
                repaint();
                delta--;
            }


        }

    }

    public void Update(){

    play.Update();

    }

    public void paintComponent(Graphics g){
    super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tile.draw(g2);

        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2 , this);
            }
        }

        play.draw(g2);
        ui.draw(g2);
        g2.dispose();

    }

    public void playmusic(int i){

        sound.setfile(i);
        sound.playSound();
        sound.loop();
    }

    public void stopmusic(){

        sound.stopSound();
    }

    public void playse(int i){
        sound.setfile(i);
        sound.playSound();
    }
}
