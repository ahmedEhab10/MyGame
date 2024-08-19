package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int maptilenum [][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        maptilenum = new int[gp.maxworldcol][gp.maxworldrow];
        gettileimage();
        loadmap("/res/maps/world01.txt");
    }

    public void gettileimage(){

        try{

            tile [0] = new Tile();
            tile [0].image = ImageIO.read(getClass().getResourceAsStream("/res/tites/grass.png"));

            tile [1] = new Tile();
            tile [1].image = ImageIO.read(getClass().getResourceAsStream("/res/tites/wall.png"));
            tile [1].collision = true;

            tile [2] = new Tile();
            tile [2].image = ImageIO.read(getClass().getResourceAsStream("/res/tites/water.png"));
            tile [2].collision = true;

            tile [3] = new Tile();
            tile [3].image = ImageIO.read(getClass().getResourceAsStream("/res/tites/earth.png"));

            tile [4] = new Tile();
            tile [4].image = ImageIO.read(getClass().getResourceAsStream("/res/tites/tree.png"));
            tile[4].collision = true;

            tile [5] = new Tile();
            tile [5].image = ImageIO.read(getClass().getResourceAsStream("/res/tites/sand.png"));


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void loadmap(String filepath ){

        try{
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col<gp.maxworldcol && row<gp.maxworldrow){

                String line = br.readLine();
                while(col<gp.maxworldcol){

                    String numbers [] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    maptilenum[col][row] = num;
                    col++;
                }
                if(col==gp.maxworldcol){

                    col=0;
                    row++;
                }

            }
            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2 ){

        int worldcol = 0;
        int worldrow =0 ;

        while (worldcol< gp.maxworldcol && worldrow < gp.maxworldrow ){

            int tilenumber = maptilenum[worldcol][worldrow];

            int worldX = worldcol * gp.tilsize;
            int worldY = worldrow * gp.tilsize;
            int screenX =worldX - gp.play.worldx + gp.play.ScreenX;
            int screenY =worldY - gp.play.worldy + gp.play.ScreenY;

                if (worldX + gp.tilsize > gp.play.worldx - gp.play.ScreenX &&
                    worldX - gp.tilsize < gp.play.worldx + gp.play.ScreenX &&
                    worldY + gp.tilsize > gp.play.worldy - gp.play.ScreenY &&
                    worldY - gp.tilsize < gp.play.worldy + gp.play.ScreenY ){

                g2.drawImage(tile[tilenumber].image , screenX , screenY , gp.tilsize , gp.tilsize , null);
            }

            worldcol++;


            if(worldcol == gp.maxworldcol){
                worldcol=0;

                worldrow++;

            }
        }






       // g2.drawImage(tile[0].image,0,0,gp.tilsize, gp.tilsize, null);

    }
}
