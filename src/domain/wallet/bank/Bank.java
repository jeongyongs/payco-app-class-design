package domain.wallet.bank;

import domain.wallet.Account;
import domain.transfer.Transfer;
import domain.transfer.Transferable;

public abstract class Bank extends Account implements Transferable {                    // 은행 계좌 추상 클래스
    public Bank(String number, String pw) {     // 생성자
        super(number, pw);
    }

    @Override
    public abstract Transfer transfer(String toBank, String toNumber, long amount);     // 송 금

    @Override
    protected abstract boolean callAPI();      // 은행 API 호출
}
