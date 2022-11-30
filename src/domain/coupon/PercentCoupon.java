package domain.coupon;

public class PercentCoupon extends Coupon {                     // 퍼센트 할인 쿠폰
    public PercentCoupon(String id, String name, long amount) { // 생성자
        super(id, name, amount);
    }

    @Override
    public long discount(long amount) {                         // 할인 계산
        return (int) (amount * (100 - this.amount) * 0.01);
    }
}
