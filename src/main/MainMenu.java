package main;

import dao.MovieDAO;
import domain.Member;
import service.MemberService;
import service.MovieService;
import service.MovieServiceImp;
import service.MovieServiceProxy;

import java.util.Scanner;

public class MainMenu {
    private final Scanner sc;
    private final Member member;

    private final MovieService movieService;

    public MainMenu(Scanner sc, Member member) {
        this.sc = sc;
        this.member = member;
        MovieDAO movieDAO = new MovieDAO();
        MovieService movieServiceImp = new MovieServiceImp(movieDAO, sc);
        this.movieService = new MovieServiceProxy(movieServiceImp, member);;
    }

    public void showMenu() {
        while (true) {
            printMenu();
            int choice = getIntInput("선택: ");
            if (choice == 2) {
                if (movieService.registerMovie()) {
                    System.out.println("영화 등록 완료!");
                }
            }
            if (choice == 4) {
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }
            // 각 기능은 나중에 연결!
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. 영화예매하기");
        System.out.println("2. 영화등록하기");
        System.out.println("3. 마이페이지");
        System.out.println("4. 종료하기");
    }
}
