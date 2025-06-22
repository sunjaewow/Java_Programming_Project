package service.announcement;

import domain.Member;
import observer.ReservationSubject;
import observer.VipObserver;

import java.util.Scanner;

public class AnnouncementServiceImp implements AnnouncementService {
    @Override
    public void sendVipAnnouncement(Member member) {
        ReservationSubject subject = ReservationSubject.getInstance();

        // 본인(관리자)이 VIP로 등록되어 있지 않으면 등록
        if (!subject.isVipRegistered(member.getId())) {
            subject.registerObserver(new VipObserver(member.getId()));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("[VIP 회원에게 보낼 공지사항을 입력하세요]");
        String message = sc.nextLine();
        observer.ReservationSubject.getInstance().notifyVipObservers(message);
    }
}

