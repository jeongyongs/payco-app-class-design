package domain.payment;

import domain.franchise.Franchise;

public interface PayMethod {    // 결제 수단 인터페이스
    Payment pay(Franchise franchise, long amount);  // 결 제
}
