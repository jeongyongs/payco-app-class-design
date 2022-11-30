package domain.wallet;

import domain.coupon.Coupon;
import domain.franchise.Franchise;
import domain.payment.Payment;
import domain.point.Point;
import domain.transfer.Transfer;
import domain.wallet.card.Card;
import domain.wallet.bank.Bank;

import java.util.ArrayList;

public class Wallet implements Managable {  // 지 갑
    public static final int RATIO = 5;     // 적립률

    private ArrayList<Card> cards;          // 카 드
    private ArrayList<Bank> banks;          // 은행 계좌
    private Point point;                    // 포인트
    private ArrayList<Coupon> coupons;      // 쿠 폰

    public Wallet(ArrayList<Card> cards, ArrayList<Bank> banks, Point point, ArrayList<Coupon> coupons) {   // 생성자
        this.cards = cards;
        this.banks = banks;
        this.point = point;
        this.coupons = coupons;
    }

    @Override
    public void add(Object object) {        // 지갑 객체 추가
        if (object instanceof Card) {       // 카드 추가
            cards.add((Card) object);
            return;
        }
        if (object instanceof Bank) {       // 은행 계좌 추가
            banks.add((Bank) object);
            return;
        }
        if (object instanceof Coupon) {     // 쿠폰 추가
            coupons.add((Coupon) object);
        }
    }

    @Override
    public void remove(String type, int index) {    // 지갑 객체 삭제
        if (type.equals("카드")) {                  // 카드 삭제
            cards.remove(index);
            return;
        }
        if (type.equals("은행")) {                  // 은행 계좌 삭제
            banks.remove(index);
            return;
        }
        if (type.equals("쿠폰")) {                  // 쿠폰 삭제
            coupons.remove(index);
        }
    }

    @Override
    public void earn(long amount) {         // 포인트 적립
        point.earn(amount);
    }

    @Override
    public Payment pay(String type, int index, Franchise franchise, long amount, int couponIndex) {     // 결제 요청
        long cost;          // 할인된 금액
        long earnPoint;     // 적립 포인트
        Payment p;          // 결제 내역

        if (couponIndex == -1) {      // 쿠폰 미사용 결제
            if (type.equals("카드")) {
                earnPoint = (long) ((int) amount * RATIO * 0.01);   // 적립 포인트 계산
                point.earn(earnPoint);                               // 포인트 적립
                p = cards.get(index).pay(franchise, amount);         // 카드 결제
                System.out.println("" + earnPoint + " 포인트가 적립되었습니다.");
                return p;
            }
            if (type.equals("포인트")) {
                return point.pay(franchise, amount);                 // 포인트 결제
            }
        }
        if (type.equals("카드")) {    // 쿠폰 사용 결제
            cost = coupons.remove(couponIndex).discount(amount);     // 할인 금액 계산
            earnPoint = (long) ((int) cost * RATIO * 0.01);         // 적립 포인트 계산
            point.earn(earnPoint);                                   // 포인트 적립
            p = cards.get(index).pay(franchise, cost);               // 카드 결제
            System.out.println("" + earnPoint + " 포인트가 적립되었습니다.");
            return p;
        }
        if (type.equals("포인트")) {
            return point.pay(franchise, coupons.remove(couponIndex).discount(amount));  // 포인트 결제
        }
        return null;
    }

    @Override
    public Transfer trans(int index, String toBank, String toNumber, long amount) {     // 송금 요청
        return banks.get(index).transfer(toBank, toNumber, amount);
    }
}
