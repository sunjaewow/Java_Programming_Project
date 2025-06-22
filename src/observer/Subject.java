package observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);

    // 1. 모든 VIP에게 공지 (공지사항)
    void notifyVipObservers(String message);

    // 2. 특정 VIP 한 명에게만 알림 (축하 등)
    void notifyVipObserver(String memberId, String message);
}
