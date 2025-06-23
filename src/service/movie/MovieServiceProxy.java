package service.movie;

import domain.Member;
import domain.Movie;

public class MovieServiceProxy implements MovieService{
    private final MovieService movieService;

    public MovieServiceProxy(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public boolean registerMovie(Member member) {
        if (!"ADMIN".equals(member.getRole())) {
            System.out.println("권한이 없습니다. 관리자만 영화 등록이 가능합니다.");
            return false;
        }
        return movieService.registerMovie(member);
    }

    @Override
    public boolean deleteMovie( Member member) {
        if (!"ADMIN".equals(member.getRole())) {
            System.out.println("권한이 없습니다. 관리자만 영화 삭제 가능합니다.");
            return false;
        }
        return movieService.deleteMovie(member);
    }
}
