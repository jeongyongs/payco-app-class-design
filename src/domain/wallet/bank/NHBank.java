package domain.wallet.bank;

import domain.transfer.Transfer;

public class NHBank extends Bank {              // 농협 은행
    public NHBank(String number, String pw) {   // 생성자
        super(number, pw);
    }

    @Override
    public Transfer transfer(String toBank, String toNumber, long amount) {     // 송 금
        if (callAPI()) {
            System.out.println("송금이 완료되었습니다.");

            return new Transfer(this, toBank, toNumber, amount);     // 거래 내역 생성
        }
        return null;
    }

    @Override
    protected boolean callAPI() {   // 은행 API 호출
        System.out.println("농협은행에 유효성 검사를 요청합니다.");
        System.out.println("농협은행에 거래를 요청합니다.");
        return true;
    }

    @Override
    public String toString() {      // 계좌 정보 반환
        return "농협, " + number;
    }
}
