package main;

import domain.Member;

import java.util.Scanner;

public class MainMenu {
    private Scanner sc;
    private Member member;

    public MainMenu(Scanner sc, Member member) {
        this.sc = sc;
        this.member = member;
    }

    public void showMenu() {
        while (true) {
            System.out.println("1. 영화예매하기");
            System.out.println("2. 영화등록하기");
            System.out.println("3. 마이페이지");
            System.out.println("4. 종료하기");
            System.out.print("선택: ");
            int sel = sc.nextInt();
            sc.nextLine();
            if (sel == 4) {
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }
            // 각 기능은 나중에 연결!
        }
    }
}
