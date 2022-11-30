package test;

import domain.coupon.AmountCoupon;
import domain.coupon.PercentCoupon;
import domain.payment.Orderable;
import domain.franchise.Franchise;
import domain.franchise.Order;
import domain.member.Member;
import domain.wallet.Managable;
import domain.wallet.Wallet;
import domain.wallet.bank.NHBank;
import domain.wallet.card.KBCard;
import domain.point.Point;

import java.util.ArrayList;

public class PaycoAppTest {                                                                                        // 메인 테스트 코드
    public static void main(String[] args) {
        Managable user1 = new Member("user2221067", "a1234@", "이정용",                            // 회원 생성
                new Wallet(new ArrayList<>(), new ArrayList<>(), new Point(50000), new ArrayList<>()));
        Franchise franchise = new Franchise("00000001", "GS25");                                        // 가맹점 등록
        Orderable orderable = new Order(franchise, 39800);                                                   // 가맹점 주문서 생성
        user1.add(new KBCard("1234-1234-1234-1234", "1234", "12/34", "123"));        // 카드 등록
        user1.add(new NHBank("123-1234-1234-12", "1234"));                                           // 은행 계좌 등록
        user1.add(new PercentCoupon("12345678", "할인 쿠폰", 10));                             // 퍼센트 쿠폰 추가
        user1.add(new AmountCoupon("12345679", "할인 쿠폰", 1000));                            // 가격 쿠폰 추가
        orderable.order("카드", 0, user1, 0).printInfo();                        // 카드 결제 요청
        orderable.order("포인트", 0, user1, 0).printInfo();                      // 포인트 결제 요청
        user1.trans(0, "하나", "123-123456-12345", 10000).printInfo();         // 계좌 송금 요청
    }
}
