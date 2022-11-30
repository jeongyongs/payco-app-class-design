package domain.member;

import domain.franchise.Franchise;
import domain.payment.Payment;
import domain.transfer.Transfer;
import domain.wallet.Managable;
import domain.wallet.Wallet;

public class Member implements Managable {          // 회 원
    private String id;      // 회원 아이디
    private String pw;      // 회원 비밀번호
    private String name;    // 회원 이름
    private Wallet wallet;  // 지 갑

    public Member(String id, String pw, String name, Wallet wallet) {   // 생성자
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.wallet = wallet;
    }

    @Override
    public void add(Object object) {                // 지갑에 객체 추가
        wallet.add(object);
    }

    @Override
    public void remove(String type, int index) {    // 지갑에 객체 삭제
        wallet.remove(type, index);
    }

    @Override
    public void earn(long amount) {                 // 포인트 적립
        wallet.earn(amount);
    }

    @Override
    public Payment pay(String type, int index, Franchise franchise, long amount, int couponIndex) { // 결제 요청
        return wallet.pay(type, index, franchise, amount, couponIndex);
    }

    @Override
    public Transfer trans(int index, String toBank, String toNumber, long amount) {                 // 송금 요청
        return wallet.trans(index, toBank, toNumber, amount);
    }
}
