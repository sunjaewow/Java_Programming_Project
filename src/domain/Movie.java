package domain;

public class Movie {
    private int id;
    private String title;
    private int seatCount;

    public Movie(String title, int seatCount) {
        this.title = title;
        this.seatCount = seatCount;
    }

    public Movie(int id, String title, int seatCount) {
        this.id = id;
        this.title = title;
        this.seatCount = seatCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
