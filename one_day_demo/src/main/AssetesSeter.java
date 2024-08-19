package main;

import res.object.OBJ_Boots;
import res.object.OBJ_CHEST;
import res.object.OBJ_DOOR;
import res.object.OBJ_KEY;

public class AssetesSeter {


    GamePanel gp;
    public AssetesSeter(GamePanel gp) {
        this.gp = gp;
    }

    public void setobject() {

    gp.obj[0] = new OBJ_KEY();
    gp.obj[0].worldX = 23 * gp.tilsize;
    gp.obj[0].worldY = 7 * gp.tilsize;

    gp.obj[1] = new OBJ_KEY();
    gp.obj[1].worldX = 23 * gp.tilsize;
    gp.obj[1].worldY =40 * gp.tilsize;

    gp.obj[2] = new OBJ_KEY();
    gp.obj[2].worldX = 38 * gp.tilsize;
    gp.obj[2].worldY =8 * gp.tilsize;


    gp.obj[3] = new OBJ_DOOR();
    gp.obj[3].worldX =  10* gp.tilsize;
    gp.obj[3].worldY =11 * gp.tilsize;

//try
//    gp.obj[3] = new OBJ_DOOR();
//    gp.obj[3].worldX =  23* gp.tilsize;
//    gp.obj[3].worldY =17 * gp.tilsize;


    gp.obj[4] = new OBJ_DOOR();
    gp.obj[4].worldX = 8 * gp.tilsize;
    gp.obj[4].worldY = 28* gp.tilsize;

    gp.obj[5] = new OBJ_DOOR();
    gp.obj[5].worldX =  12* gp.tilsize;
    gp.obj[5].worldY =22 * gp.tilsize;


    gp.obj[6] = new OBJ_CHEST();
    gp.obj[6].worldX = 10 * gp.tilsize;
    gp.obj[6].worldY =7 * gp.tilsize;


    gp.obj[7] = new OBJ_Boots();
    gp.obj[7].worldX = 37 * gp.tilsize;
    gp.obj[7].worldY =42 * gp.tilsize;

    }
}
