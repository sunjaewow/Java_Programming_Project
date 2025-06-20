package domain;

import java.util.HashMap;
import java.util.Map;

public class Movie {
    private int id;
    private String title;
    private String time;

    private int memberId;

    private Map<String, Integer> seatCounts;

    public Movie(String title, String time, Map<String, Integer> seatCounts, int memberId) {
        this.title = title;
        this.time = time;
        this.seatCounts=seatCounts;
        this.memberId = memberId;

    }

    public Movie(int id, String title, String time, Map<String, Integer> seatCounts, int memberId) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.seatCounts = seatCounts;
        this.memberId = memberId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Map<String, Integer> getSeatCounts() {
        return seatCounts;
    }

    public void setSeatCounts(Map<String, Integer> seatCounts) {
        this.seatCounts = seatCounts;
    }
}
