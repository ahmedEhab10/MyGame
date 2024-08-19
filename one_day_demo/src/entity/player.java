package entity;
import main.GamePanel;
import main.keyhandler;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class player extends Entity {
    GamePanel gp;
    keyhandler key;
    public final int ScreenX;
    public final int ScreenY;
    public int HasKey = 0;
    int trynum = 0;
    public player(GamePanel gp, keyhandler key) {

        this.gp = gp;
        this.key = key;


        ScreenX = gp.ScreenWidth / 2 - (gp.tilsize/2);
        ScreenY = gp.ScreenHeight / 2 - (gp.tilsize/2);

        bounds = new Rectangle();
        bounds.x = 8 ;
        bounds.y = 16 ;
        SolidAreaDefultX = bounds.x;
        SolidAreaDefultY =  bounds.y;
        bounds.width = 32;
        bounds.height = 32;

        setdefaultvalu();
        getPlayerImage();
    }

    public void setdefaultvalu() {

        worldx = gp.tilsize * 23;
        worldy =gp.tilsize *  21;
        speed = 4;
        direction = "down";
    }


    public void getPlayerImage(){

        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));

        }catch (IOException e){

        e.printStackTrace();
            System.out.println("aaa");
        }



    }

//100%
    public void Update() {
        if (key.UPpreesd == true || key.DOWNpreesd ==true || key.LEFTpreesd == true || key.RIGHTpreesd == true){

            if (key.UPpreesd == true) {
                direction = "up";
            } else if (key.DOWNpreesd == true) {
                direction = "down";
            } else if (key.LEFTpreesd == true) {
                direction = "left";
            } else if (key.RIGHTpreesd == true) {
                direction = "right";
            }



            colisianon = false;
            gp.colli.checktile(this);

            //check obj collision
           int objindex = gp.colli.checkobj(this ,true);
           pickupobject(objindex);

            if (colisianon == false){
                switch (direction){
                    case "up":
                        worldy -= speed;
                        break;
                    case "down":
                        worldy += speed;
                        break;
                    case "left":
                        worldx -= speed;
                        break;
                    case "right":
                        worldx += speed;
                        break;

                }


            }

            spritecounter++;
            if (spritecounter > 10) {
                if (spritenumber==1){
                    spritenumber=2;
                } else if (spritenumber==2) {
                    spritenumber=1;
                }
                spritecounter = 0;
        }

        }

    }

    public void pickupobject(int i){
        if(i !=999 ){
            String ObjectName = gp.obj[i].name;

            switch (ObjectName){
                case "key":
                    gp.playse(1);
                    HasKey++;
                    gp.obj[i] = null;
                    gp.ui.showmassage("Key picked up!");
                    break;
                case "Door":
                   if(colisianon == true){
                       if(trynum<15) {
                           gp.ui.showmassage("You need to pick up door!");
                           trynum++;
                       }else {
                           gp.ui.showmassage("Man be smarter!");
                       }
                   }
                    if (HasKey != 0) {
                        gp.playse(3);
                        gp.obj[i] = null;
                        HasKey--;
                        gp.ui.showmassage("are you sure you want to do this?!");

                    }
                    break;
                case "Boots":
                    gp.playse(2);
                    speed+=2;
                    gp.obj[i] = null;
                    gp.ui.showmassage("Nice boot!");
                    break;
                case "Chest":
                    gp.playse(6);
                    gp.ui.gamefinish = true;
                    gp.stopmusic();
                    gp.playse(4);
                    break;
            }

        }

    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spritenumber ==1){
                    image = up1;
                }
                if(spritenumber ==2){
                    image = up2;
                }
                break;
                case "down":
                    if(spritenumber ==1){
                        image = down1;
                    }
                    if(spritenumber ==2){
                        image = down2;
                    }
                    break;
            case "left":
                if(spritenumber ==1){
                    image = left1;
                }
                if(spritenumber ==2){
                    image = left2;
                }
                break;
                case "right":
                    if(spritenumber ==1){
                        image = right1;
                    }
                    if(spritenumber ==2){
                        image = right2;
                    }
                    break;

        }
        g2.drawImage(image , ScreenX , ScreenY ,gp.tilsize , gp.tilsize ,null);


      //  g2.setColor(Color.WHITE);
       // g2.fillRect(x,y,gp.tilsize,gp.tilsize);




        // BufferedImage image = null;

       /* switch (direction) {
            case "up":
                image= up1;
                break;
            case "down":
                image= down1;
                break;
            case "laft":
                image= left1;
                break;
            case "right":
                image= right1;
                break;
        }
        g2.drawImage(image,x,y,gp.tilsize,gp.tilsize,null);

    }*/


    }


}



