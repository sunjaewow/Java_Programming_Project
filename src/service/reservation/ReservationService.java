package service.reservation;

import domain.Member;
import domain.Movie;
import domain.seat.Seat;

public interface ReservationService {

    void showMyPage(Member member);

    Movie selectMovie();

    String selectSeatType(Movie movie);

    boolean askPopcorn();

    Seat createSeat(String seatType, boolean popcorn);

    void processReservation(Member member, Movie movie, String seatType, Seat seat);
}
