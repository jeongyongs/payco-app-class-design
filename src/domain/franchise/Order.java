package domain.franchise;

import domain.payment.Orderable;
import domain.payment.Payment;
import domain.wallet.Managable;

public class Order implements Orderable {           // 주문서
    private Franchise franchise;    // 가맹점 정보
    private long cost;              // 금 액

    public Order(Franchise franchise, long cost) {  // 생성자
        this.franchise = franchise;
        this.cost = cost;
    }

    @Override
    public Payment order(String type, int methodIndex, Managable managable, int couponIndex) {  // 주문 요청
        return managable.pay(type, methodIndex, franchise, cost, couponIndex);
    }
}
