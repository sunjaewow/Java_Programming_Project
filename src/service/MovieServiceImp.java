package service;

import dao.MovieDAO;
import domain.Movie;

import java.util.Scanner;

public class MovieServiceImp implements MovieService {
    private final MovieDAO movieDAO;
    private final Scanner sc;

    public MovieServiceImp(MovieDAO movieDAO, Scanner sc) {
        this.movieDAO = movieDAO;
        this.sc = sc;
    }

    @Override
    public boolean registerMovie() {
        System.out.print("영화 제목: ");
        String title = sc.nextLine();
        System.out.print("좌석 수: ");
        int seatCount = sc.nextInt();
        sc.nextLine();
        // 여기서 추가로 좌석별 개수, 가격 등도 받을 수 있음!
        // ... 필요한 만큼 입력받기

        return movieDAO.createMovie(new Movie(title, seatCount));
    }

}
