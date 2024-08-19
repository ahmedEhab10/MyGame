package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyhandler implements KeyListener {
    public boolean  UPpreesd , DOWNpreesd , LEFTpreesd , RIGHTpreesd ;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       int code = e.getKeyCode();

       if (code == KeyEvent.VK_W) {
           UPpreesd = true;
       }
        if (code == KeyEvent.VK_S) {
            DOWNpreesd = true;
        }
        if (code == KeyEvent.VK_A) {
            LEFTpreesd = true;
        }
        if (code == KeyEvent.VK_D) {
            RIGHTpreesd = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            UPpreesd = false;
        }
        if (code == KeyEvent.VK_S) {
            DOWNpreesd = false;
        }
        if (code == KeyEvent.VK_A) {
            LEFTpreesd = false;
        }
        if (code == KeyEvent.VK_D) {
            RIGHTpreesd = false;
        }


    }


}
