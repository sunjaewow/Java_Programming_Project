package domain;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private int memberId;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    private String id;

    private String password;

    private int age;

    private int balance = 0; // 잔액

    public Member(String id, String password, int age, String role) {
        this.id = id;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    private String role;

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getAge() {
        return age;
    }

    private List<Reservation> reservationList = new ArrayList<>();

    public void setBalance(int balance) {
        this.balance = balance;
    }


// ... 생성자/getter/setter 등 생략

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
        this.balance -= reservation.getPrice(); // 예매시 자동 차감
    }

    public void removeReservation(Reservation reservation) {
        reservationList.remove(reservation);
        this.balance += reservation.getPrice(); // 예매 취소시 환불
    }

    public int getBalance() {
        return balance;
    }
    public void chargeMoney(int amount) {
        this.balance += amount;
    }
    public List<Reservation> getReservationList() {
        return reservationList;
    }

}
