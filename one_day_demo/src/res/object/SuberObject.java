package res.object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuberObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX , worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int SolidAreaDefultX = 0;
    public int SolidAreaDefultY = 0;

    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX =worldX - gp.play.worldx + gp.play.ScreenX;
        int screenY =worldY - gp.play.worldy + gp.play.ScreenY;

        if (worldX + gp.tilsize > gp.play.worldx - gp.play.ScreenX &&
                worldX - gp.tilsize < gp.play.worldx + gp.play.ScreenX &&
                worldY + gp.tilsize > gp.play.worldy - gp.play.ScreenY &&
                worldY - gp.tilsize < gp.play.worldy + gp.play.ScreenY ){

            g2.drawImage(image , screenX , screenY , gp.tilsize , gp.tilsize , null);
        }

    }

}
