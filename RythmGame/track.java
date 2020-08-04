package RythmGame;

public class track {
    private String titleImage; //제목 부분 이미지\
    private String startImage;// 게임 선택창 표지 이미지
    private String gameImage;// 게임 실행시 이미지
    private String StartMusic;// 게임 선택창 음악
    private String gameMusic;// 해당 곡을 실행했을때 음악


    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getStartImage() {
        return startImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }

    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public String getStartMusic() {
        return StartMusic;
    }

    public void setStartMusic(String startMusic) {
        StartMusic = startMusic;
    }

    public String getGameMusic() {
        return gameMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }

    public track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic) {
        this.titleImage = titleImage;
        this.startImage = startImage;
        this.gameImage = gameImage;
        StartMusic = startMusic;
        this.gameMusic = gameMusic;
    }
}
