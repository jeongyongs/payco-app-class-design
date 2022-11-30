package domain.point;

import domain.franchise.Franchise;
import domain.payment.PayMethod;
import domain.payment.Payment;

public class Point implements PayMethod, Earnable {     // 포인트
    private long amount;                // 포인트 잔액

    public Point(long amount) {         //생성자
        this.amount = amount;
    }

    @Override
    public Payment pay(Franchise franchise, long amount) {              // 결 제
        if (this.amount >= amount) {
            this.amount -= amount;
            System.out.println("포인트 결제가 완료되었습니다.");
            System.out.println("포인트 : " + this.amount);
            return new Payment(this, franchise, amount);    // 결제 내역 생성
        }
        return null;
    }

    @Override
    public void earn(long amount) {     // 포인트 적립
        this.amount += amount;
    }

    @Override
    public String toString() {          // 결제 수단명 반환
        return "포인트";
    }
}
