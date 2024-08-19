package main;

import entity.Entity;

public class collisaionchek {
    GamePanel gp;
    public collisaionchek(GamePanel gp){
        this.gp = gp;
    }

    public void checktile(Entity entity){
        int entityleftworldx = entity.worldx + entity.bounds.x;
        int entityrightworldx = entity.worldx + entity.bounds.x +entity.bounds.width;
        int entitytopworldy = entity.worldy + entity.bounds.y;
        int entitybottomworldy = entity.worldy + entity.bounds.y +entity.bounds.height;

        int entityleftcol = entityleftworldx/ gp.tilsize;
        int entityrightcol = entityrightworldx/ gp.tilsize;
        int entitytoprow = entitytopworldy/ gp.tilsize;
        int entitybottomtoprow = entitybottomworldy/ gp.tilsize;

        int tilNum1 , tilNum2;

        switch (entity.direction){
            case "up":
                entitytoprow = (entitytopworldy - entity.speed)/gp.tilsize;
                tilNum1 = gp.tile.maptilenum[entityleftcol][entitytoprow];
                tilNum2 = gp.tile.maptilenum[entityrightcol][entitytoprow];

                if(gp.tile.tile[tilNum1].collision == true || gp.tile.tile[tilNum2].collision == true){

                    entity.colisianon = true;


                }

            break;
            case "down":
                entitybottomtoprow = (entitybottomworldy - entity.speed)/gp.tilsize;
                tilNum1 = gp.tile.maptilenum[entityleftcol][entitybottomtoprow];
                tilNum2 = gp.tile.maptilenum[entityrightcol][entitybottomtoprow];

                if(gp.tile.tile[tilNum1].collision == true || gp.tile.tile[tilNum2].collision == true){

                    entity.colisianon = true;
                }
                break;
            case "left":
                entityleftcol = (entityleftworldx - entity.speed)/gp.tilsize;
                tilNum1 = gp.tile.maptilenum[entityleftcol][entitytoprow];
                tilNum2 = gp.tile.maptilenum[entityleftcol][entitybottomtoprow];

                if(gp.tile.tile[tilNum1].collision == true || gp.tile.tile[tilNum2].collision == true){

                    entity.colisianon = true;
                }
                break;
            case "right":
                entityrightcol = (entityrightworldx + entity.speed)/gp.tilsize;
                tilNum1 = gp.tile.maptilenum[entityrightcol][entitytoprow];
                tilNum2 = gp.tile.maptilenum[entityrightcol][entitybottomtoprow];

                if(gp.tile.tile[tilNum1].collision == true || gp.tile.tile[tilNum2].collision == true){

                    entity.colisianon = true;
                }
                break;

        }

    }


    public int checkobj (Entity entity , boolean Player) {

        int index = 999;
        for (int i = 0; i < gp.obj.length; i++) {

            if (gp.obj[i] != null ){
                entity.bounds.x= entity.worldx + entity.bounds.x;
                entity.bounds.y = entity.worldy + entity.bounds.y;

                    gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                    gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                    switch (entity.direction){

                        case "up":
                            entity.bounds.y -= entity.speed;
                            if(entity.bounds.intersects(gp.obj[i].solidArea)){
                                System.out.println("Up collision");
                                if (gp.obj[i].collision == true){
                                    entity.colisianon = true;
                                }
                                if(Player == true){

                                    index = i ;
                                }
                            }
                            break;
                            case "down":
                                entity.bounds.y += entity.speed;
                                if(entity.bounds.intersects(gp.obj[i].solidArea)){
                                    System.out.println("down collision");
                                    if (gp.obj[i].collision == true){
                                        entity.colisianon = true;
                                    }
                                    if(Player == true){

                                        index = i ;
                                    }
                                }
                                break;
                                case "left":
                                    entity.bounds.x -= entity.speed;
                                    if(entity.bounds.intersects(gp.obj[i].solidArea)){

                                        System.out.println("left collision");
                                        if (gp.obj[i].collision == true){
                                            entity.colisianon = true;
                                        }
                                        if(Player == true){

                                            index = i ;
                                        }
                                    }
                                    break;
                                    case "right":
                                        entity.bounds.x += entity.speed;
                                        if(entity.bounds.intersects(gp.obj[i].solidArea)){
                                            System.out.println("right collision");
                                            if (gp.obj[i].collision == true){
                                                entity.colisianon = true;
                                            }
                                            if(Player == true){

                                                index = i ;
                                            }
                                        }
                                        break;



                    }

                    entity.bounds.x  = entity.SolidAreaDefultX;
                    entity.bounds.y  = entity.SolidAreaDefultY;
                    gp.obj[i].solidArea.x = gp.obj[i].SolidAreaDefultX;
                    gp.obj[i].solidArea.y = gp.obj[i].SolidAreaDefultY;
            }
        }

        return index;

    }

}
