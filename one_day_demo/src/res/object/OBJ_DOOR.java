package res.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_DOOR extends SuberObject {
    public OBJ_DOOR() {
        name ="Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/object/door.png"));
        }catch (IOException e){
            System.out.println("Image not found");
            e.printStackTrace();
        }
        collision =true;
    }
}
