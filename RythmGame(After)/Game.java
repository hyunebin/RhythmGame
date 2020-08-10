package RythmGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread {

    private Image GameInfoImage = new ImageIcon(main.class.getResource("images/gameinfo.png")).getImage();
    private Image LineImage = new ImageIcon(main.class.getResource("images/Line.png")).getImage();
    private Image LineRoute = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image NoteLine = new ImageIcon(main.class.getResource("images/NoteLine.png")).getImage();
    private Image SpresA = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresS = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresD = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresF = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresH = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresJ = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresK = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();
    private Image SpresL = new ImageIcon(main.class.getResource("images/NoteRoute.png")).getImage();

    private String titleName; // 현재 실행할 곡의 이름
    private String diffculty;// 현재 실행한 곡의 난이도
    private String MusicTitle;
    private Music GameMusic;

    ArrayList<NoteFall> NoteList = new ArrayList<NoteFall>();

    public Game(String titleName, String diffculty, String MusicTitle){ // 생성자 형성
        this.titleName = titleName;
        this.diffculty = diffculty;
        this.MusicTitle = MusicTitle;
        GameMusic = new Music(this.MusicTitle, false);

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

        for(int i = 0; i < NoteList.size() ;i++){
            NoteFall note = NoteList.get(i);
            if(!note.isProceeded()){
                NoteList.remove(i);
                i--;
            }

            else{
                note.ScreenDraw(g);
            }

        }

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
        judge("a");
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
        dropNote();
    }

    public void close(){
        GameMusic.close();
        interrupt();
    }

    public void dropNote(){
        Beat[] beats = null;
        if (titleName.equals("Sakuranbo - Dalmabal") && diffculty.equals("Easy")){
            int startTime = 1000 - main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                    new Beat(startTime + gap * 2, "a"),
                    new Beat(startTime + gap * 4, "a"),
                    new Beat(startTime + gap * 6, "a"),
                    new Beat(startTime + gap * 8, "a"),
                    new Beat(startTime + gap * 10, "a"),
            };
        }

        else if(titleName.equals("Stand a Chance")){
            int startTime = 1000 - main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                    new Beat(startTime + gap * 2, "a"),
                    new Beat(startTime + gap * 4, "a"),
                    new Beat(startTime + gap * 6, "a"),
                    new Beat(startTime + gap * 8, "a"),
                    new Beat(startTime + gap * 10, "a"),
            };
        }

        else if(titleName.equals("Lady - Yebin")){
            int startTime = 1000 - main.REACH_TIME * 1000;
            beats = new Beat[]{
                    new Beat(startTime, "d")
            };
        }

        int i = 0;
        GameMusic.start();
        while(i < beats.length && !isInterrupted()){
            if(beats[i].getTime() <= GameMusic.getTime()){
                NoteFall note = new NoteFall(beats[i].getNoteName());
                note.start();
                NoteList.add(note);
                i++;
            }
        }




        /*NoteList.add(new NoteFall(200,300,"short"));
        NoteList.add(new NoteFall (304,300,"short"));
        NoteList.add(new NoteFall ( 408,300,"short"));
        NoteList.add(new NoteFall (512,300,"short"));
        NoteList.add(new NoteFall (616,300,"short"));
        NoteList.add(new NoteFall (720,300,"short"));
        NoteList.add(new NoteFall (824,300,"short"));
        NoteList.add(new NoteFall(928,300,"short"));
        */
    }

    public void judge(String in){
        for(int i = 0; i < NoteList.size(); i++){
            NoteFall note = NoteList.get(i);
            if(in.equals(note.NoteType())){
                note.judge();
                break;
            }

        }
    }
}
