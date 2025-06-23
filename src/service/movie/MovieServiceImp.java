package service.movie;

import dao.MovieDAO;
import domain.Member;
import domain.Movie;
import observer.VipObserver;
import observer.ReservationSubject;
import util.InputUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieServiceImp implements MovieService {
    private final MovieDAO movieDAO;
    private final Scanner sc;

    public MovieServiceImp(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
        this.sc = new Scanner(System.in);
    }

    @Override
    public boolean deleteMovie(Member member){
    List<Movie> movies = movieDAO.getAllMovies();
    if (movies.isEmpty()) {
        System.out.println("등록된 영화가 없습니다.");
        return false;
    }

    System.out.println("==== 영화 목록 ====");
    for (int i = 0; i < movies.size(); i++) {
        Movie m = movies.get(i);
        System.out.printf("%d. %s (%s) [제작자: %s]\n", i + 1, m.getTitle(), m.getTime(), m.getMemberId());
    }
    System.out.print("삭제할 영화 선택(번호): ");
    int idx = InputUtil.getIntInput(sc) - 1;
    if (idx < 0 || idx >= movies.size()) {
        System.out.println("잘못된 입력입니다.");
        return false;
    }

    Movie movieToDelete = movies.get(idx);

    // 제작자인지 확인
    if (movieToDelete.getMemberId() != member.getMemberId()) {
        System.out.println("본인이 등록한 영화만 삭제할 수 있습니다.");
        return false;
    }

    // 실제 삭제
    if (movieDAO.deleteMovie(movieToDelete.getId())) {
        System.out.println("영화가 삭제되었습니다.");
        return true;
    } else {
        System.out.println("삭제에 실패했습니다.");
        return false;
    }
}

    @Override
    public boolean registerMovie(Member member) {
        System.out.print("영화 제목: ");
        String title = sc.nextLine();
        System.out.print("상영 시간(예: 18:30): ");
        String time = sc.nextLine();
        String[] seatTypes = {"노약좌석", "임산부석", "일반석", "프리미엄석"};
        Map<String, Integer> seatCounts = new HashMap<>();

        for (String seatType : seatTypes) {
            System.out.print(seatType + " 개수: ");
            int count = sc.nextInt();
            sc.nextLine();
            seatCounts.put(seatType, count);
        }

        return movieDAO.createMovie(new Movie(title, time, seatCounts, member.getMemberId()));
    }

}
