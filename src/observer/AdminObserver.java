package observer;

public class AdminObserver implements Observer {
    private String adminId; // 혹은 email 등

    public AdminObserver(String adminId) {
        this.adminId = adminId;
    }
    @Override
    public void update(String message) {
        System.out.println("[관리자 알림] " + adminId + "님: " + message);
    }
}