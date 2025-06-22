package commend;

import java.util.Scanner;
import domain.Member;
import service.announcement.AnnouncementService;

public class AnnouncementCommand implements Command {
    private final AnnouncementService announcementService;
    private final Member member;

    public AnnouncementCommand(AnnouncementService announcementService, Member member) {
        this.announcementService = announcementService;
        this.member = member;
    }

    @Override
    public void execute() {
        announcementService.sendVipAnnouncement(member);
    }
}
