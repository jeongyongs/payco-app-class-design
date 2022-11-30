package domain.wallet.card;

import domain.wallet.Account;
import domain.franchise.Franchise;
import domain.payment.PayMethod;
import domain.payment.Payment;

public abstract class Card extends Account implements PayMethod {           // 카드 추상 클래스
    private String vaildDate;       // 유효 기간
    private String cvc;             // CVC

    public Card(String number, String pw, String vaildDate, String cvc) {   // 생성자
        super(number, pw);
        this.vaildDate = vaildDate;
        this.cvc = cvc;
    }

    @Override
    public abstract Payment pay(Franchise franchise, long amount);         // 결 제

    @Override
    protected abstract boolean callAPI();                                  // 카드사 API 호출
}
