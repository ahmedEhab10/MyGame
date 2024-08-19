package res.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_KEY extends SuberObject {

    public OBJ_KEY() {

        name ="key";

    try {
        image = ImageIO.read(getClass().getResourceAsStream("/res/object/key.png"));
    }catch (IOException e){
        System.out.println("Image not found");
        e.printStackTrace();
    }
    }
}
