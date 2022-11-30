package domain.coupon;

public interface Discountable { // 할인 계산 인터페이스
    long discount(long amount); // 할인 계산
}
