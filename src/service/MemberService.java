package service;

import dao.MemberDAO;
import domain.Member;
import observer.AdminObserver;
import observer.ReservationSubject;

import java.util.Scanner;

public class MemberService {
    private final MemberDAO dao;
    private final Scanner sc;

    public MemberService() {
        this.dao = new MemberDAO();
        this.sc = new Scanner(System.in);
    }

    public void signup() {
        System.out.println("[회원가입]");
        System.out.println("1. 사용자로 회원가입");
        System.out.println("2. 관리자로 회원가입");
        System.out.print("선택: ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("아이디: ");
        String id = sc.nextLine();
        System.out.print("비밀번호: ");
        String password = sc.nextLine();
        System.out.print("나이: ");
        int age = sc.nextInt();
        sc.nextLine();
        String role = (type == 2) ? "ADMIN" : "USER";
        boolean ok = dao.createMember(new Member(id, password, age, role));
        if (ok) {
            System.out.println("회원가입 완료! 권한: " + role);
        }
    }

    public Member login() {
        System.out.println("[로그인]");
        while (true) {
            System.out.print("아이디: ");
            String id = sc.nextLine();
            System.out.print("비밀번호: ");
            String password = sc.nextLine();
            Member member = dao.loginMember(id, password);
            if (member != null) {
                System.out.println("로그인 성공!");
                if (member.getRole().equals("ADMIN")) {
                    System.out.println("관리자님 어서오세요.");

                } else {
                    System.out.println("환영합니다. ");
                }
                return member;
            } else {
                System.out.println("로그인 실패! 다시 입력해주세요.");
            }
        }
    }
}
