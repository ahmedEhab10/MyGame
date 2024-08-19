package res.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends SuberObject{

    public OBJ_Boots() {

        name ="Boots";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/object/boots.png"));
        }catch (IOException e){
            System.out.println("Image not found");
            e.printStackTrace();
        }
    }
}
