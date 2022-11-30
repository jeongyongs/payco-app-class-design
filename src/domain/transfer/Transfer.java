package domain.transfer;

import domain.transation.Transation;
import domain.wallet.bank.Bank;

public class Transfer extends Transation {      // 송금 내역
    private Bank fromBank;      // 보내는 계좌 객체
    private String toBank;      // 받는 계좌 은행
    private String toNumber;    // 받는 계좌 번호

    public Transfer(Bank fromBank, String toBank, String toNumber, long amount) {   // 생성자
        super(amount);
        this.fromBank = fromBank;
        this.toBank = toBank;
        this.toNumber = toNumber;
    }

    @Override
    public void printInfo() {   // 거래 내역 출력
        System.out.println("*-------------------------------------------------*");
        System.out.println("*                    거래 내역                    *");
        System.out.println("*-------------------------------------------------*");
        System.out.println("* 거래 번호   : " + id);
        System.out.println("* 거래 일시   : " + makeDate());
        System.out.println("* 보내는 계좌 : " + fromBank);
        System.out.println("* 받는 계좌   : " + toBank + ", " + toNumber);
        System.out.println("* 금 액       : " + amount + " 원");
        System.out.println("*-------------------------------------------------*");
        System.out.println();
    }
}
