package commend;

import domain.Member;
import facade.ReservationFacade;

public class ReserveCommand implements Command {
    private final ReservationFacade reservationFacade;
    private final Member member;

    public ReserveCommand(ReservationFacade reservationFacade, Member loginMember) {
        this.reservationFacade = reservationFacade;
        this.member = loginMember;
    }

    @Override
    public void execute() {
        reservationFacade.reserveTicket(member);
    }
}

