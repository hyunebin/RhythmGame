package RythmGame;

public class Beat {

    public Beat(int time, String noteName) {
        this.time = time;
        this.noteName = noteName;
    }

    private int time;
    private String noteName;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

}
