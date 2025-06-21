package observer;

public class VipObserver implements Observer {

    private final String memberId;

    public VipObserver(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public void update(String msg) {
        System.out.println("💎[VIP 알림] " + memberId + "님, " + msg);
    }

    public String getMemberId() {
        return memberId;
    }
}