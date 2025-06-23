package service.movie;

import domain.Member;
import domain.Movie;

public interface MovieService {
    boolean registerMovie(Member member);

    boolean deleteMovie(Member member);
}
