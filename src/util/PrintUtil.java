package util;

public class PrintUtil {
    public static void printFirstMenu() {
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 종료하기");
        System.out.print("선택: ");
    }

    public static void printMainMenu() {
        System.out.println("1. 영화예매하기");
        System.out.println("2. 영화관리");
        System.out.println("3. 마이페이지");
        System.out.println("4. 공지사항 전파");
        System.out.println("5. 종료하기");
        System.out.println("선택: ");
    }

    public static void printMyPage() {
        System.out.println("1. 예매 취소하기");
        System.out.println("2. 돈 충전하기");
        System.out.println("3. 뒤로가기");
        System.out.print("선택: ");
    }

    public static void printMovieManager() {
        System.out.println("\n==== 영화관리 ====");
        System.out.println("1. 영화등록");
        System.out.println("2. 영화삭제");
        System.out.println("3. 뒤로가기");
        System.out.print("선택: ");
    }
}
