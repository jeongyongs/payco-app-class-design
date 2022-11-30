package domain.wallet;

import domain.franchise.Franchise;
import domain.payment.Payment;
import domain.transfer.Transfer;

public interface Managable {    // 지갑 관리 인터페이스
    void add(Object object);    // 지갑 객체 추가

    void remove(String type, int index);    // 지갑 객체 삭제

    void earn(long amount);     // 포인트 적립

    Payment pay(String type, int index, Franchise franchise, long amount, int couponIndex);     // 결제 요청

    Transfer trans(int index, String toBank, String toNumber, long amount);                     // 송금 요청
}
