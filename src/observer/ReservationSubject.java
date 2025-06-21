package observer;

import java.util.ArrayList;
import java.util.List;

public class ReservationSubject implements Subject {
    // 싱글턴 패턴 구현
    private static final ReservationSubject instance = new ReservationSubject();
    public static ReservationSubject getInstance() {
        return instance;
    }

    private final List<Observer> observers = new ArrayList<>();

    private ReservationSubject() {}

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    // VIP에게만 알림
    public void notifyVipObservers(String memberId, String message) {
        for (Observer o : observers) {
            if (o instanceof VipObserver) {
                VipObserver vip = (VipObserver) o;
                if (vip.getMemberId().equals(memberId)) {
                    vip.update(message);
                }
            }
        }
    }

    // 이미 VIP로 등록돼 있는지 확인하는 헬퍼 메서드
    public boolean isVipRegistered(String memberId) {
        for (Observer o : observers) {
            if (o instanceof VipObserver && ((VipObserver) o).getMemberId().equals(memberId)) {
                return true;
            }
        }
        return false;
    }

}
