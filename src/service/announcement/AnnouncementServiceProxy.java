package service.announcement;

import domain.Member;
public class AnnouncementServiceProxy implements AnnouncementService {
    private final AnnouncementService realService;

    public AnnouncementServiceProxy(AnnouncementService realService) {
        this.realService = realService;
    }

    @Override
    public void sendVipAnnouncement(Member member) {
        if (!"ADMIN".equals(member.getRole())) {
            System.out.println("권한이 없습니다. 관리자만 공지사항 전파가 가능합니다.");
            return;
        }
        realService.sendVipAnnouncement(member);
    }
}

