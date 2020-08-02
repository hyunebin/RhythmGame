package RythmGame;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread {
    private Player player;
    private boolean isloop; // 곡의 반복
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean isloop){ //name == 재생할 노래목록
        try{
            this.isloop = isloop;
            file = new File(main.class.getResource("Music/" + name).toURI()); // 해당 파일의 위치를 가져옴
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getTime(){
        if(player == null)
            return 0;
        return player.getPosition();
    }

    public void close(){ // 언제 실행하여도 종요를 할수있게 하는 기능
        isloop = false;
        player.close();
        this.interrupt();
    }

    public void run(){
        try{
            player.play();
            do {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            }while(isloop);

        }catch (Exception e){

        }
    }

}
