package RythmGame;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;

public class NoteFall extends Thread {
    private Image Note = new ImageIcon(main.class.getResource("images/Note.png")).getImage();
    private int x,y = 580 - (1000 / main.SLEEP_TIME * main.NOTE_SPEED) * main.REACH_TIME;
    private String noteType;

    private boolean proceeded = true;

    public boolean isProceeded(){
        return proceeded;
    }

    public void close(){
        proceeded = false;
    }

    public String NoteType(){
        return noteType;
    }

    public NoteFall(String noteType){
            if (noteType.equals("a")){
                x = 200;
            }
            else  if (noteType.equals("s")){
                x = 304;
            }
            else  if (noteType.equals("d")){
                x = 408;
            }
            else  if (noteType.equals("f")){
                x = 512;
            }
            else  if (noteType.equals("h")){
                x = 616;
            }
            else  if (noteType.equals("j")){
                x = 720;
            }
            else  if (noteType.equals("k")){
                x = 824;
            }
            else  if (noteType.equals("l")){
                x = 928;
            }

            this.noteType = noteType ;

    }

    public void ScreenDraw(Graphics2D g){
            if(!noteType.equals("long")){
                    g.drawImage(Note,x,y,null);
            }

            else{
                    g.drawImage(Note,x+100,y,null);
            }

    }

    public void run(){
        try {
            while(true){
                drop();
                Thread.sleep(main.SLEEP_TIME);
                if(proceeded){
                    Thread.sleep(main.SLEEP_TIME);
                }

                else{
                    interrupt();
                    break;
                }
            }

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    public void drop(){
         y += main.NOTE_SPEED;
         if(y > 620){
             System.out.println("Miss");
             close();
         }
    }

    public void judge(){
        if(y >= 613){
            System.out.println("Late");
            close();;
        }

        else if( y > 600){
            System.out.println("good");
            close();
        }

        else if( y > 587){
            System.out.println("PerFect");
            close();
        }

        else if( y > 570){
            System.out.println("great");
            close();
        }


    }

}

