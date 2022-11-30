package domain.payment;

import domain.transation.Transation;
import domain.franchise.Franchise;

public class Payment extends Transation {   // 결제 내역
    private PayMethod payMethod;            // 결제 수단
    private Franchise franchise;            // 가맹점

    public Payment(PayMethod payMethod, Franchise franchise, long amount) { // 생성자
        super(amount);
        this.payMethod = payMethod;
        this.franchise = franchise;
    }

    @Override
    public void printInfo() {               // 거래 내역 출력
        System.out.println("*-------------------------------------------------*");
        System.out.println("*                    결제 내역                    *");
        System.out.println("*-------------------------------------------------*");
        System.out.println("* 결제 번호 : " + id);
        System.out.println("* 결제 일시 : " + makeDate());
        System.out.println("* 결제 수단 : " + payMethod);
        System.out.println("* 가맹점    : " + franchise);
        System.out.println("* 금 액     : " + amount + " 원");
        System.out.println("*-------------------------------------------------*");
        System.out.println();
    }
}
