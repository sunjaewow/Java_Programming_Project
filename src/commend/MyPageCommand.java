package commend;

import domain.Member;
import service.reservation.ReservationService;

public class MyPageCommand implements Command {
    private final ReservationService reservationService;
    private final Member member;

    public MyPageCommand(ReservationService reservationService, Member member) {
        this.reservationService = reservationService;
        this.member = member;
    }

    @Override
    public void execute() {
        reservationService.showMyPage(member);
    }
}
