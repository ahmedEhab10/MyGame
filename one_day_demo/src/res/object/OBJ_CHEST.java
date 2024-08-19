package res.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_CHEST extends SuberObject{

    public OBJ_CHEST() {

        name ="Chest";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/object/chest.png"));
        }catch (IOException e){
            System.out.println("Image not found");
            e.printStackTrace();
        }
    }

}
