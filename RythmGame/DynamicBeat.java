package RythmGame;

import javafx.scene.layout.Background;
import jdk.nashorn.internal.ir.EmptyNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class DynamicBeat extends JFrame {

    private Image screenImage; //더블 버퍼링에 이용할 그릇
    private Graphics screenGraphics; // 더블 버퍼링에 이용할 그릇
    private Image introBackground = new ImageIcon(main.class.getResource("images/BackGround.jpg")).getImage();;
    private Image SelcetedImage = new ImageIcon(main.class.getResource("images/Dalmabal.png")).getImage();
    private Image titleImage = new ImageIcon(main.class.getResource("images/Name.png")).getImage();
    private JLabel Menuba = new JLabel(new ImageIcon(main.class.getResource("images/Menu.png")));
    private int mouseX,mouseY;
    private  ImageIcon exitButtonClick = new ImageIcon((main.class.getResource("images/ExitOnClick.png")));
    private  ImageIcon exitButtonNonClick = new ImageIcon((main.class.getResource("images/ExitNonClick.png")));
    private  ImageIcon StartButtonNonClick = new ImageIcon((main.class.getResource("images/NonClickStart.png")));
    private  ImageIcon StartButtonClick = new ImageIcon((main.class.getResource("images/ClickStart.png")));
    private  ImageIcon EndButtonNonClick = new ImageIcon((main.class.getResource("images/NonClickEnd.png")));
    private  ImageIcon EndButtonClick = new ImageIcon((main.class.getResource("images/ClickEnd.png")));
    private  ImageIcon NextButtonR = new ImageIcon(main.class.getResource("images/rightArrow.png"));
    private  ImageIcon NextButtonL = new ImageIcon(main.class.getResource("images/leftArrow.png"));
    private  ImageIcon NextButtonRClick = new ImageIcon(main.class.getResource("images/rightArrowClick.png"));
    private  ImageIcon NextButtonLClick = new ImageIcon(main.class.getResource("images/leftArrowClick.png"));
    private JButton exitButton = new JButton(exitButtonNonClick);
    private JButton StartButton = new JButton(StartButtonNonClick);
    private JButton EndButton = new JButton(EndButtonNonClick);
    private JButton RightButton = new JButton(NextButtonR);
    private JButton LeftButton = new JButton(NextButtonL);

    private  boolean isMainScreen = false;

    public DynamicBeat(){ // 가장 먼저 실행
        setUndecorated(true);// 기본 자바 메뉴자가 안보이게됨
        setTitle("Dynamic Beat"); // 게임 타이틀
        setSize(main.SCREEN_WIDTH, main.SCREEN_HEIGHT);
        setResizable(false); // 한번 설정된 화면은 사용자가 임의로 수정할 수 없음
        setLocationRelativeTo(null); // 실행시 화면의 정중앙에 실행
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 프로세스까지 완전 종료
        setVisible(true); // 화면에 출력
        setBackground(new Color(0,0,0,0));
        setLayout(null);

        exitButton.setBounds(1100,50,30,30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);
                exitButton.setIcon(exitButtonClick);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music NonClickButton = new Music("NonClickButton.mp3", false);
                NonClickButton.start();

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                exitButton.setIcon(exitButtonNonClick);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music ClickButton = new Music("ClickButton.mp3", false);
                ClickButton.start();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.getMessage();
                }
                System.exit(0);
            }
        });



        StartButton.setBounds(40,200,400,100);
        StartButton.setBorderPainted(false);
        StartButton.setContentAreaFilled(false);
        StartButton.setFocusPainted(false);
        StartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);
                StartButton.setIcon(StartButtonClick);
                StartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music NonClickButton = new Music("NonClickButton.mp3", false);
                NonClickButton.start();

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                StartButton.setIcon(StartButtonNonClick);
                StartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music ClickButton = new Music("ClickButton.mp3", false);
                ClickButton.start();
                isMainScreen = true;
                StartButton.setVisible(false);
                EndButton.setVisible(false);
                LeftButton.setVisible(true);
                RightButton.setVisible(true);
                introBackground = new ImageIcon(main.class.getResource("images/Sakura.jpg")).getImage();
            }
        });

        add(StartButton);


        EndButton.setBounds(40,330,400,100);
        EndButton.setBorderPainted(false);
        EndButton.setContentAreaFilled(false);
        EndButton.setFocusPainted(false);
        EndButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);
                EndButton.setIcon(EndButtonClick);
                EndButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music NonClickButton = new Music("NonClickButton.mp3", false);
                NonClickButton.start();

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                EndButton.setIcon(EndButtonNonClick);
                EndButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music ClickButton = new Music("ClickButton.mp3", false);
                ClickButton.start();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.getMessage();
                }
                System.exit(0);
            }
        });

        add(EndButton);


        Menuba.setBounds(0,0,1200, 20);
        Menuba.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent event) {

                    mouseX = event.getX();
                    mouseY = event.getY();

            }
        });

        Menuba.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });

        add(Menuba); // 상속된 JFrame에 들어감
        add(exitButton);


        Music introMusic = new Music("ForYou.mp3", true);
        introMusic.start();

        LeftButton.setVisible(false);
        LeftButton.setBounds(140,310,60,60);
        LeftButton.setBorderPainted(false);
        LeftButton.setContentAreaFilled(false);
        LeftButton.setFocusPainted(false);
        LeftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);
                LeftButton.setIcon(NextButtonLClick);
                LeftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music NonClickButton = new Music("NonClickButton.mp3", false);
                NonClickButton.start();

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                LeftButton.setIcon(NextButtonL);
                LeftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music ClickButton = new Music("ClickButton.mp3", false);
                ClickButton.start();
                //왼쪽버튼 클릭시 이벤트
                System.exit(0);
            }
        });

        add(LeftButton);
        RightButton.setVisible(false);
        RightButton.setBounds(1080,310,60,60);
        RightButton.setBorderPainted(false);
        RightButton.setContentAreaFilled(false);
        RightButton.setFocusPainted(false);
        RightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);
                RightButton.setIcon(NextButtonRClick);
                RightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music NonClickButton = new Music("NonClickButton.mp3", false);
                NonClickButton.start();

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                RightButton.setIcon(NextButtonR);
                RightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music ClickButton = new Music("ClickButton.mp3", false);
                ClickButton.start();
                //오른쪽버튼 클릭시 이벤트
                System.exit(0);
            }
        });

        add(RightButton);

    }


    public void paint(Graphics g){ // 가장 첫번째로 화면을 그려주는 함수
        screenImage = createImage(main.SCREEN_WIDTH, main.SCREEN_HEIGHT); // screenImage를 설정
        screenGraphics = screenImage.getGraphics();
        screenDraw(screenGraphics);
        g.drawImage(screenImage,0,0,null); // 화면에 이미지를 그림

    }

    public void screenDraw(Graphics g){
        g.drawImage(introBackground, 0, 0,null);
        if(isMainScreen == true){
            g.drawImage(SelcetedImage, 340,100, null);
            g.drawImage(titleImage,340,70,null);
        }
        paintComponents(g);
        this.repaint();
    }

}
