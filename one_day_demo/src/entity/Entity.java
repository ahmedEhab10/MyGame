package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldx ,worldy;
    public int speed;

    public BufferedImage up1 , up2 , down1 , down2 , left1 , left2 , right1 , right2;
    public String direction;

    public int spritecounter = 0;
    public int spritenumber= 1;

    public Rectangle bounds;
    public int SolidAreaDefultX, SolidAreaDefultY;
    public boolean colisianon = false;
}
