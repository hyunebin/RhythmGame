package RythmGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    public void keyPressed(KeyEvent e){

        if(DynamicBeat.game == null){ // 게임이 진행중이 아니라면
            return;
        }

        if (e.getKeyCode() == KeyEvent.VK_A){//현재 누른 키
            DynamicBeat.game.PreesA();
        }

        else if (e.getKeyCode() == KeyEvent.VK_S){//현재 누른 키
            DynamicBeat.game.PreesS();
        }

        else if (e.getKeyCode() == KeyEvent.VK_D){//현재 누른 키
            DynamicBeat.game.PreesD();
        }

        else if (e.getKeyCode() == KeyEvent.VK_F){//현재 누른 키
            DynamicBeat.game.PreesF();
        }

        else if (e.getKeyCode() == KeyEvent.VK_H){//현재 누른 키
            DynamicBeat.game.PreesH();
        }

        else if (e.getKeyCode() == KeyEvent.VK_J){//현재 누른 키
            DynamicBeat.game.PreesJ();

        }

        else if (e.getKeyCode() == KeyEvent.VK_K){//현재 누른 키
            DynamicBeat.game.PreesK();
        }

        else if (e.getKeyCode() == KeyEvent.VK_L){//현재 누른 키
            DynamicBeat.game.PreesL();
        }
    }

    public void keyReleased(KeyEvent e){

        if(DynamicBeat.game == null){ // 게임이 진행중이 아니라면
            return;
        }

        if (e.getKeyCode() == KeyEvent.VK_A){//현재 누른 키
            DynamicBeat.game.ReleaseA();
        }

        else if (e.getKeyCode() == KeyEvent.VK_S){//현재 누른 키
            DynamicBeat.game.ReleaseS();
        }

        else if (e.getKeyCode() == KeyEvent.VK_D){//현재 누른 키
            DynamicBeat.game.ReleaseD();
        }

        else if (e.getKeyCode() == KeyEvent.VK_F){//현재 누른 키
            DynamicBeat.game.ReleaseF();
        }

        else if (e.getKeyCode() == KeyEvent.VK_H){//현재 누른 키
            DynamicBeat.game.ReleaseH();
        }

        else if (e.getKeyCode() == KeyEvent.VK_J){//현재 누른 키
            DynamicBeat.game.ReleaseJ();

        }

        else if (e.getKeyCode() == KeyEvent.VK_K){//현재 누른 키
            DynamicBeat.game.ReleaseK();
        }

        else if (e.getKeyCode() == KeyEvent.VK_L){//현재 누른 키
            DynamicBeat.game.ReleaseL();
        }
    }
}
