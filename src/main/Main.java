package main;

import dao.MemberDAO;
import domain.Member;
import service.MemberService;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            MemberDAO memberDAO = new MemberDAO();
            MemberService memberService = new MemberService(memberDAO, sc);

            while (true) {
                System.out.println("1. 회원가입");
                System.out.println("2. 로그인");
                System.out.println("3. 종료하기");
                System.out.print("선택: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    memberService.signup();
                } else if (choice == 2) {
                    Member loginMember = memberService.login();
                    if (loginMember != null) {
                        MainMenu mainMenu = new MainMenu(sc, loginMember);
                        mainMenu.showMenu();
                    }
                } else if (choice == 3) {
                    System.out.println("이용해 주셔서 갑사합니다.");
                    break;
                }
            }
        }

}