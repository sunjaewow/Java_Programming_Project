package service.movie;

import domain.Member;

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
}
