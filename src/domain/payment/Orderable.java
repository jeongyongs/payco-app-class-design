package domain.payment;

import domain.wallet.Managable;

public interface Orderable {    // 주문 인터페이스
    Payment order(String type, int methodIndex, Managable managable, int couponIndex);  // 주문 요청
}
