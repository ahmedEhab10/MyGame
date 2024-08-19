package main;

import res.object.OBJ_KEY;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Font arial , arial_80;
    BufferedImage Keyimg;
    boolean massageon = false;
    String massage = "";
    int massagecounter = 0;
    public boolean gamefinish = false;
    double playing_time = 0;
    DecimalFormat df = new DecimalFormat("#0.00");


    public UI(GamePanel gp) {
        this.gp=gp;
        arial = new Font("Arial", Font.PLAIN, 30);
        arial_80 = new Font("Arial", Font.BOLD, 80);
        OBJ_KEY KEY = new OBJ_KEY();
        Keyimg = KEY.image;
    }

    public void showmassage(String massage){
        this.massage=massage;
        massageon=true;
    }

    public void draw(Graphics2D g2) {

        if(gamefinish == true) {
            String text;
            int textleaanthe;
            int x;
            int y;

            g2.setFont(arial);
            g2.setColor(Color.WHITE);

            text = "You found the treasure!";
            textleaanthe = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x= gp.ScreenWidth/2 - textleaanthe/2;
            y= gp.ScreenHeight/2 - gp.tilsize*4;

            g2.drawString(text , x , y );

            g2.setFont(arial_80);
            g2.setColor(Color.yellow);
            text = "Congreatulation!";
            textleaanthe = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x= gp.ScreenWidth/2 - textleaanthe/2;
            y= gp.ScreenHeight/2 + gp.tilsize*2;

            g2.drawString(text , x , y );


            g2.setFont(arial);
            g2.setColor(Color.WHITE);

            text = "Your Time:"+df.format(playing_time)+"!";
            textleaanthe = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x= gp.ScreenWidth/2 - textleaanthe/2;
            y= gp.ScreenHeight/2 + gp.tilsize*4;

            g2.drawString(text , x , y );


            g2.setFont(arial_80);
            g2.setColor(Color.WHITE);

            text = "Wait The Full Game!";
            textleaanthe = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x= gp.ScreenWidth/2 - textleaanthe/2;
            y= gp.ScreenHeight/2 + gp.tilsize*6;

            g2.drawString(text , x , y );

            gp.GameThread = null;

        }else {g2.setFont(arial);
            g2.setColor(Color.WHITE);
            g2.drawImage(Keyimg, gp.tilsize/2,gp.tilsize/2 , gp.tilsize , gp.tilsize , null);
            g2.drawString("x " +gp.play.HasKey, 74 ,50);

           //time
            playing_time +=(double) 1/60;
            g2.drawString("Time:" +df.format(playing_time) ,gp.tilsize*15 ,65);

            if(massageon == true){
                g2.setFont(new Font("Arial", Font.PLAIN, 30));
                g2.drawString(massage, gp.tilsize/2, gp.tilsize*5 );
                massagecounter++;

                if(massagecounter>120){
                    massagecounter=0;
                    massageon=false;
                }
            }
        }


    }
}
