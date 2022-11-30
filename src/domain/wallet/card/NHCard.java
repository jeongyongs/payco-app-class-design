package domain.wallet.card;

import domain.franchise.Franchise;
import domain.payment.Payment;

public class NHCard extends Card {      // 농협 카드
    public NHCard(String number, String pw, String vaildDate, String cvc) {     // 생성자
        super(number, pw, vaildDate, cvc);
    }

    @Override
    public Payment pay(Franchise franchise, long amount) {                      // 결 제
        if (callAPI()) {
            System.out.println("카드 결제가 완료되었습니다.");
            return new Payment(this, franchise, amount);           // 결제 내역 생성
        }
        return null;
    }

    @Override
    protected boolean callAPI() {       // 카드사 API 호출
        System.out.println("농협카드에 유효성 검사를 요청합니다.");
        System.out.println("농협카드에 거래를 요청합니다.");
        return true;
    }

    @Override
    public String toString() {          // 결제수단 이름 반환
        return "신용카드(농협)";
    }
}
