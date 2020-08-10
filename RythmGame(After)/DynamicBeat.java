package RythmGame;

import javafx.scene.layout.Background;
import jdk.nashorn.internal.ir.EmptyNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {

    private Graphics screenGraphics; // 더블 버퍼링에 이용할 그릇
    private Image screenImage; //더블 버퍼링에 이용할 그릇
    private Image introBackground = new ImageIcon(main.class.getResource("images/BackGround.jpg")).getImage(); // 시작시 배경화면
    private JLabel Menuba = new JLabel(new ImageIcon(main.class.getResource("images/Menu.png")));// 메뉴바 이미지
    private int mouseX,mouseY; // 마우스의 x,y 좌표값

    // 버튼들의 이미지
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
    private  ImageIcon EasyButton = new ImageIcon(main.class.getResource("images/EasyButton.png"));
    private  ImageIcon HardButton = new ImageIcon(main.class.getResource("images/HardButton.png"));
    private  ImageIcon EasyButtonClick = new ImageIcon(main.class.getResource("images/EasySelectButton.png"));
    private  ImageIcon HardButtonClick = new ImageIcon(main.class.getResource("images/HardSelectButton.png"));
    private  ImageIcon BackButton = new ImageIcon(main.class.getResource("images/BackButton.png"));
    private  ImageIcon BackButtonClick = new ImageIcon(main.class.getResource("images/BackButtonClick.png"));

    //버튼
    private JButton exitButton = new JButton(exitButtonNonClick);
    private JButton StartButton = new JButton(StartButtonNonClick);
    private JButton EndButton = new JButton(EndButtonNonClick);
    private JButton RightButton = new JButton(NextButtonR);
    private JButton LeftButton = new JButton(NextButtonL);
    private JButton Easy_Button = new JButton(EasyButton);
    private JButton Hard_Button = new JButton(HardButton);
    private JButton Back_Button = new JButton(BackButton);


    private  boolean isMainScreen = false; //메인 화면 이미지
    private  boolean isGameScreen = false; // 게임 실행시 화면 이미지

    public static Game game; // 한번에 한게임만 진행할 수 있음

    ArrayList<track> trackList= new ArrayList<track>(); // 트랙의 생성자를 저장하는 ArrayList


    private Music selectMusic;// 선택된 음악
    private Image SelcetedImage;// 음악 커버이미지
    private Image titleImage;// 음악 제목에 대한 이미지
    private int nowSelected = 0;

    Music introMusic = new Music("ForYou.mp3", true);

    public DynamicBeat(){

        trackList.add(new track("Name.png", "Dalmabal.png", "Game.jpg", "Sakuranbo select.mp3", "Sakuranbo.mp3", "Sakuranbo - Dalmabal")); // 트랙배열에 1번곡
        trackList.add(new track("Name1.png","Travis.png","Game1.jpg", "Stand a Chance_ex.mp3", "Stand a Chance.mp3", "Stand a Chance")); // 트랙배열에 2번곡
        trackList.add(new track("Name2.png", "Yebin.jpg","Game3.jpg","LadySelect.mp3","LadyFor.mp3", "Lady - Yebin")); // 트랙배열에 3번곡


        setUndecorated(true);// 기본 자바 메뉴자가 안보이게됨
        setTitle("Dynamic Beat"); // 게임 타이틀
        setSize(main.SCREEN_WIDTH, main.SCREEN_HEIGHT);// 게임의 크기
        setResizable(false); // 한번 설정된 화면은 사용자가 임의로 수정할 수 없음
        setLocationRelativeTo(null); // 실행시 화면의 정중앙에 실행
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 프로세스까지 완전 종료
        setVisible(true); // 화면에 출력
        setBackground(new Color(0,0,0,0));  //배경화면 색 > 안해주면 적용시킨 이미지 노출 x
        setLayout(null); // 레이아웃 관리자 사용 x 그럼으로 직접 기능들의 위치를 정해주어야함
        addKeyListener(new KeyListener()); // 키보드 리스너

        introMusic.start();// 배경음악

        // 닫기 버튼에 대한 구성
        exitButton.setBounds(1160,0,32,32);
        exitButton.setBorderPainted(false);// 버튼의 겉선 제거
        exitButton.setContentAreaFilled(false); // 버튼의 모양 제거
        exitButton.setFocusPainted(false);// 버튼를 클릭시 글자 테투리 제거
        exitButton.addMouseListener(new MouseAdapter() {// 버튼에 대한 마우스 기능
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);// 상속
                exitButton.setIcon(exitButtonNonClick); // 버튼의 이미지를 해당 이미지로 변경함
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 버튼의 이미지위에 있을때 마우스 커서의 이미지를 바꿈
                Music NonClickButton = new Music("NonClickButton.mp3", false); // 버튼위로 갈때 효과음 ㅏ빠빠빠빠빰
                NonClickButton.start();// 버튼 효과음 재생
            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                exitButton.setIcon(exitButtonClick);// 버튼의 이미지를 해당 이미지로 변경
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 버튼의 이미지를 나왔을때 마우스 커서의 이미지를 원래로 돌려둠
            }

            @Override
            public void mousePressed(MouseEvent e){ //버튼 클릭시 기능
                Music ClickButton = new Music("ClickButton.mp3", false);// 버튼 클릭시 재생되는 효과음
                ClickButton.start();// 버튼 효과음을 재생
                try{
                    Thread.sleep(1000); // 해당 시간 만큼 기다렸다가 종료
                }catch (InterruptedException ex){
                    ex.getMessage();// 오류가 있으시 해당 오류 메세지 출력
                }
                System.exit(0);// 시스템 종료
            }
        });



        StartButton.setBounds(880,500,400,100);
        StartButton.setBorderPainted(false);// 버튼의 겉선 제거
        StartButton.setContentAreaFilled(false);// 버튼의 모양 제거
        StartButton.setFocusPainted(false);// 버튼를 클릭시 글자 테투리 제거
        StartButton.addMouseListener(new MouseAdapter() {// 버튼에 대한 마우스 기능
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);//상속
                StartButton.setIcon(StartButtonClick);// 버튼의 이미지를 해당 이미지로 바꿈
                StartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 버튼위에 마우스 커서가 있을때 커서의 이미지를 바꿔줌
                Music NonClickButton = new Music("NonClickButton.mp3", false);// 버튼의 효과음 객체
                NonClickButton.start();// 효과음 재생

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                StartButton.setIcon(StartButtonNonClick);// 버튼의 이미지를 해당 이미지로 바꿈
                StartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 버튼위에 마우스 커서가 있을때 커서의 이미지를 바꿔줌
            }

            @Override
            public void mousePressed(MouseEvent e){// 버튼을 클릭시
                Music ClickButton = new Music("ClickButton.mp3", false);// 버튼 클릭시 효과음
                ClickButton.start();// 효과음 재생
                introMusic.close();// 해당 버튼은 start 버튼임으로 게임선택화면창으로 이동 그럼으로 배경 음악은 종료
                inMain();// 메인함수 실행

            }
        });

        add(StartButton);// start버튼을 Jframe에 추가


        EndButton.setBounds(880,600,400,100);
        EndButton.setBorderPainted(false);// 버튼의 겉선 제거
        EndButton.setContentAreaFilled(false);//버튼의 모양제거
        EndButton.setFocusPainted(false);//버튼 클릭시 컽선 제거
        EndButton.addMouseListener(new MouseAdapter() {// 마우스에 대한 기능리스너
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);//상속
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

        Menuba.setBounds(0,0,1200, 32);
        Menuba.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent event) {// 메뉴바를 클릭하고 움직일시

                mouseX = event.getX();// 마우스의 x좌표값을 얻어옴
                mouseY = event.getY();// 마우스의 y좌표값을 얻어옴

            }
        });

        Menuba.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {// 마우스를 드래그 할시
                super.mouseDragged(e);
                int x = e.getXOnScreen(); //윈도우상 스크린상의 x좌표를 얻어와 x에 대입
                int y = e.getYOnScreen(); //윈도우상 스크린상의 y좌표를 얻어와 y에 대입
                setLocation(x - mouseX, y - mouseY);// 메뉴바를 잡고 드래그를 했을때 해당 위치로 이동 < 해당 식은 이해 아직 x
            }
        });

         // 상속된 JFrame에 들어감
        add(exitButton); // exit버튼이 메뉴바 위에 있어야 하기때문에 먼저 선언
        add(Menuba);


        LeftButton.setVisible(false);// 처음 메인화면에는 해당 버튼이 보여질 필요가 없기 때문에 false
        LeftButton.setBounds(140,310,64,64);
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
                selectL();
            }
        });

        add(LeftButton);

        RightButton.setVisible(false); // 처음 메인화면에는 해당 버튼이 보여질 필요가 없기 때문에 false
        RightButton.setBounds(1080,310,64,64);
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
                selectR();
            }
        });

        add(RightButton);

        Easy_Button.setVisible(false);
        Easy_Button.setBounds(655,580,400,100);
        Easy_Button.setBorderPainted(false);
        Easy_Button.setContentAreaFilled(false);
        Easy_Button.setFocusPainted(false);
        Easy_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);
                Easy_Button.setIcon(EasyButtonClick);
                Easy_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music NonClickButton = new Music("NonClickButton.mp3", false);
                NonClickButton.start();

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                Easy_Button.setIcon(EasyButton);
                Easy_Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music ClickButton = new Music("ClickButton.mp3", false);
                ClickButton.start();
                GameStart(nowSelected, "Easy");

            }
        });

        add(Easy_Button);

        Hard_Button.setVisible(false);
        Hard_Button.setBounds(200,580,400,100);
        Hard_Button.setBorderPainted(false);
        Hard_Button.setContentAreaFilled(false);
        Hard_Button.setFocusPainted(false);
        Hard_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);
                Hard_Button.setIcon(HardButtonClick);
                Hard_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music NonClickButton = new Music("NonClickButton.mp3", false);
                NonClickButton.start();

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                Hard_Button.setIcon(HardButton);
                Hard_Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music ClickButton = new Music("ClickButton.mp3", false);
                ClickButton.start();
                GameStart(nowSelected, "Hard");
                //오른쪽버튼 클릭시 이벤트

            }
        });

        add(Hard_Button);



        Back_Button.setVisible(false);
        Back_Button.setBounds(20,60,64,64);
        Back_Button.setBorderPainted(false);
        Back_Button.setContentAreaFilled(false);
        Back_Button.setFocusPainted(false);
        Back_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 버튼위에 있을때
                super.mouseEntered(e);
                Back_Button.setIcon(BackButtonClick);
                Back_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music NonClickButton = new Music("NonClickButton.mp3", false);
                NonClickButton.start();

            }

            public void mouseExited(MouseEvent e){ // 마우스가 버튼위에서 사라졌을대
                Back_Button.setIcon(BackButton);
                Back_Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music ClickButton = new Music("ClickButton.mp3", false);
                ClickButton.start();
                BackMain();// 메인으로 돌아가면 보여야 하는 기능들을 다시 보여줌


            }
        });

        add(Back_Button);

    }


    public void paint(Graphics g){ // 가장 첫번째로 화면을 그려주는 함수
        screenImage = createImage(main.SCREEN_WIDTH, main.SCREEN_HEIGHT); // screenImage를 설정
        screenGraphics = screenImage.getGraphics();
        screenDraw((Graphics2D)screenGraphics);
        g.drawImage(screenImage,0,0,null); // 화면에 이미지를 그림

    }

    public void screenDraw(Graphics2D g){
        g.drawImage(introBackground, 0, 0,null);
        if(isMainScreen == true){// 게임선택창으로 이동한다면
            g.drawImage(SelcetedImage, 340,100, null);
            g.drawImage(titleImage,340,70,null);
        }

        if(isGameScreen == true){ // 게임화면으로 넘어간다면
            game.screenDraw(g); //game 클래스에 있는 내용을 그려준다.
        }
        paintComponents(g);
        this.repaint();
        //repaint() 호출시 컴포넌트의 paintComponent() 호출
        //컴포넌트가 다시 그려져야 그 때 변경된 위치에 변경된 모양으로 출력됨 screenDraw가 호출될때마다 이미지 새로 갱신

    }
    /*
            paint()와 screenDraw의 더블 버퍼링
            기존의 paint(g)를 사용하면 g를 사용해 그래픽을 그린다. paint()만 사용하면 그림판위에 하나의 그림을 순차적으로 그리게 된다. 프로그램상으로는 해당기능이 빨라 체감은 적지만 다양한 그래픽
            을 사용하게 된다면 깜빡임이 발생할 수 있다. 이러한 현상을 줄이기위해 그림을 전부 그려놓은 다른 공간을 마련해 미리 그려둔 그림을 가져오는 형식으로 일처리의 효율을 높이게 된다.

     */


    public void selectTrack(int nowSelect){

        if(selectMusic != null){// 현재 재생되는 음악이 있다면
            selectMusic.close(); //음악 종료
        }
        titleImage =  new ImageIcon(main.class.getResource("images/" + trackList.get(nowSelect).getTitleImage())).getImage(); //trackList에 nowSelect번 쨰에 있는 타이틀 이미지를 얻어와 대입
        SelcetedImage = new ImageIcon(main.class.getResource("images/" + trackList.get(nowSelect).getStartImage())).getImage();//trackList에 nowSelect번 쨰에 있는 게임 스타트 이미지를 얻어와 대입
        selectMusic =  new Music(trackList.get(nowSelect).getStartMusic(), true); // trackList에 nowSelect번 쨰에 있는 음악를 얻어와 대입
        selectMusic.start();//음악시작
    }

    public void selectL(){
        if(nowSelected == 0){ // 0번째 위치에서 왼쪽 버튼을 누른다면 오른쪽 끝으로 이동해야 하기때문에 trackList의 크기에서 1를 뺀값으로 이동한다.
            nowSelected = trackList.size() - 1;
            selectTrack(nowSelected);
        }

        else{// 아닌경우는 nowSelected에서 1을 감소하면 된다.
            nowSelected--;
            selectTrack(nowSelected);
        }
    }

    public void selectR(){// 동일한 로직
        if(nowSelected == trackList.size()-1){
            nowSelected =  0;
            selectTrack(nowSelected);
        }

        else{
            nowSelected++;
            selectTrack(nowSelected);
        }
    }

    public void GameStart(int nowSelected, String difficulty){ // 게임화면으로 이동시 실행 즉 hard , easy버튼 클릭시
        if(selectMusic != null){
            selectMusic.close(); // 실행되고 있는 음악이 있다면 종료시켜줌
        }

        isMainScreen = false;// 메인화면은 x
        LeftButton.setVisible(false);
        RightButton.setVisible(false);
        Easy_Button.setVisible(false);
        Hard_Button.setVisible(false);
        introBackground = new ImageIcon(main.class.getResource("images/" + trackList.get(nowSelected).getGameImage())).getImage(); // 해당 게임이미지로 변경
        Back_Button.setVisible(true);// 뒤로가기 버튼은 활성화
        isGameScreen = true;
        game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,trackList.get(nowSelected).getGameMusic());
        game.start();
        setFocusable(true);
    }

    public void BackMain(){
        isMainScreen = true;
        LeftButton.setVisible(true);
        RightButton.setVisible(true);
        introBackground = new ImageIcon(main.class.getResource("images/Sakura.jpg")).getImage();
        Back_Button.setVisible(false);
        Easy_Button.setVisible(true);
        Hard_Button.setVisible(true);
        selectTrack(nowSelected);
        isGameScreen = false;
        game.close();
    }

    public void inMain(){ // start버튼 클릭시 실행함수 게임선택화면으로 이동
        introBackground = new ImageIcon(main.class.getResource("images/Sakura.jpg")).getImage(); // 해당 이미지로 배경화면 이미지를 변경함
        isMainScreen = true;
        StartButton.setVisible(false);// 게임선택화면에 보여지지 않아도 되는 버튼 제거
        EndButton.setVisible(false);// 게임선택화면에 보여지지 않아도 되는 버튼 제거ㅍ
        LeftButton.setVisible(true);// 왼쪽버튼
        RightButton.setVisible(true);//오른쪽버튼
        Easy_Button.setVisible(true);//난이도 버튼
        Hard_Button.setVisible(true);//난이도 버튼
        selectTrack(0);// 게임선택화면의 0번째 곡에 대한 타이틀 노래등 실행
        introMusic.close();// 배경화면에서 게임 선택화면으로 넘어왔음으로 배경 노래는 종료
    }



}
