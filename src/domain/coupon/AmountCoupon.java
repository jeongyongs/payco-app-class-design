package domain.coupon;

public class AmountCoupon extends Coupon {                      // 금액 할인 쿠폰
    public AmountCoupon(String id, String name, long amount) {  // 생성자
        super(id, name, amount);
    }

    @Override
    public long discount(long amount) {                         // 할인 계산
        return amount - this.amount;
    }
}
