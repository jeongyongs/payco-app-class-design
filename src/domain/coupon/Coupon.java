package domain.coupon;

public abstract class Coupon implements Discountable {      // 쿠폰 추상 클래스
    protected String id;    // 쿠폰 아이디
    protected String name;  // 쿠폰 이름
    protected long amount;  // 할인 값

    public Coupon(String id, String name, long amount) {    // 생성자
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public abstract long discount(long amount);             // 할인 계산
}
