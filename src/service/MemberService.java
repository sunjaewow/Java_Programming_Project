package service;

import dao.MemberDAO;
import domain.Member;

import java.util.Scanner;

public class MemberService {
    private final MemberDAO dao;
    private final Scanner sc;

    public MemberService(MemberDAO dao, Scanner sc) {
        this.dao = dao;
        this.sc = sc;
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
        String pw = sc.nextLine();
        System.out.print("나이: ");
        int age = sc.nextInt();
        sc.nextLine();
        String role = (type == 2) ? "ADMIN" : "USER";
        boolean ok = dao.createMember(new Member(id, pw, age, role));
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
            String pw = sc.nextLine();
            Member mem = dao.loginMember(id, pw);
            if (mem != null) {
                System.out.println("로그인 성공!");
                return mem;
            } else {
                System.out.println("로그인 실패! 다시 입력해주세요.");
            }
        }
    }
}
