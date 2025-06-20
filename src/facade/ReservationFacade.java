package facade;

import domain.Member;
import domain.Movie;
import domain.seat.Seat;
import service.reservation.ReservationService;
import service.reservation.ReservationServiceImp;

import java.util.Scanner;

public class ReservationFacade {
    private final ReservationService reservationService;

    public ReservationFacade() {
        this.reservationService = new ReservationServiceImp();
    }

    // 퍼사드 패턴! - 예매의 모든 흐름을 한 메서드로 제공
    public void reserveTicket(Member member) {
        Movie movie = reservationService.selectMovie();
        if (movie == null) return;

        String seatType = reservationService.selectSeatType(movie);
        if (seatType == null) return;

        boolean popcorn = reservationService.askPopcorn();

        Seat seat = reservationService.createSeat(seatType, popcorn);

        reservationService.processReservation(member, movie, seatType, seat);
    }
}
