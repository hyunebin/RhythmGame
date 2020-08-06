package RythmGame;

import javax.swing.*;
import java.awt.*;

public class Game extends Thread {

    private Image GameInfoImage = new ImageIcon(main.class.getResource("images/gameinfo.png")).getImage();
    private Image LineImage = new ImageIcon(main.class.getResource("images/Line.png")).getImage();
    private Image LineRoute = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image NoteLine = new ImageIcon(main.class.getResource("images/NoteLine.png")).getImage();
    private Image Note = new ImageIcon(main.class.getResource("images/Note.png")).getImage();
    private Image SpresA = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresS = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresD = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresF = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresH = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresJ = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresK = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresL = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();

    private String titleName;
    private String diffculty;
    private String MusicTitle;

    public Game(String titleName, String diffculty, String MusicTitle){
        this.titleName = titleName;
        this.diffculty = diffculty;
        this.MusicTitle = MusicTitle;
    }



    public void screenDraw(Graphics2D g) {

            g.drawImage(SpresA, 200,27, null);
            g.drawImage(SpresS,304,27,null);
            g.drawImage(SpresD,408,27,null);
            g.drawImage(SpresF,512,27,null);
            g.drawImage(SpresH,616,27,null);
            g.drawImage(SpresJ,720,27,null);
            g.drawImage(SpresK,824,27,null);
            g.drawImage(SpresL,928,27,null);



            g.drawImage(NoteLine, 196,27,null);
            g.drawImage(NoteLine, 300,27,null);
            g.drawImage(NoteLine, 404,27,null);
            g.drawImage(NoteLine, 508,27,null);
            g.drawImage(NoteLine, 612,27,null);
            g.drawImage(NoteLine, 716,27,null);
            g.drawImage(NoteLine, 820,27,null);
            g.drawImage(NoteLine, 924,27,null);
            g.drawImage(NoteLine, 1028,27,null);

            g.drawImage(LineImage, 0,580, null);
            g.drawImage(GameInfoImage, 0,660, null);

            g.drawImage(Note, 200,300,null);
            g.drawImage(Note, 304,300,null);
            g.drawImage(Note, 408,300,null);
            g.drawImage(Note, 512,300,null);
            g.drawImage(Note, 616,300,null);
            g.drawImage(Note, 720,300,null);
            g.drawImage(Note, 824,300,null);
            g.drawImage(Note, 928,300,null);

            g.setColor(Color.white);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g.setFont(new Font("Arial", Font.BOLD,30));
            g.drawString(titleName,20, 695);
            g.drawString(diffculty, 1100,695);
            g.drawString("000000",600,695);
            g.drawString("a",240,610);
            g.drawString("s",344,610);
            g.drawString("d",448,610);
            g.drawString("f",552,610);
            g.drawString("h",656,610);
            g.drawString("j",760,610);
            g.drawString("k",864,610);
            g.drawString("l",968,610);



    }

    public void PreesA(){
            SpresA = new ImageIcon(main.class.getResource("images/NoteRoutePress.png")).getImage();
    }

        public void PreesS(){
                SpresS = new ImageIcon(main.class.getResource("images/NoteRoutePress.png")).getImage();
        }

        public void PreesD(){
                SpresD = new ImageIcon(main.class.getResource("images/NoteRoutePress.png")).getImage();
        }

        public void PreesF(){
                SpresF = new ImageIcon(main.class.getResource("images/NoteRoutePress.png")).getImage();
        }

        public void PreesH(){
                SpresH = new ImageIcon(main.class.getResource("images/NoteRoutePress.png")).getImage();
        }

        public void PreesJ(){
                SpresJ = new ImageIcon(main.class.getResource("images/NoteRoutePress.png")).getImage();
        }

        public void PreesK(){
                SpresK = new ImageIcon(main.class.getResource("images/NoteRoutePress.png")).getImage();
        }

        public void PreesL(){
                SpresL = new ImageIcon(main.class.getResource("images/NoteRoutePress.png")).getImage();
        }


    public void ReleaseA(){
            SpresA = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    }

    public void ReleaseS(){
            SpresS = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    }

        public void ReleaseD(){
                SpresD = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
        }

        public void ReleaseF(){
                SpresF = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
        }

        public void ReleaseH(){
                SpresH = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
        }

        public void ReleaseJ(){
                SpresJ = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
        }

        public void ReleaseK(){
                SpresK = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
        }

        public void ReleaseL(){
                SpresL = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
        }



    public void run(){

    }
}
