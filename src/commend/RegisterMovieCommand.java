package commend;

import domain.Member;
import service.movie.MovieService;

public class RegisterMovieCommand implements Command {
    private final MovieService movieService;
    private final Member member;

    public RegisterMovieCommand(MovieService movieService, Member member) {
        this.movieService = movieService;
        this.member = member;
    }

    @Override
    public void execute() {
        movieService.registerMovie(member);
    }
}
