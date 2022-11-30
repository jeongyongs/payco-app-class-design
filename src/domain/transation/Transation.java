package domain.transation;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transation implements Printable {     // 거래 내역
    protected String id;                // 거래 번호
    protected Date date;                // 거래 날짜
    protected long amount;              // 금 액

    public Transation(long amount) {    // 생성자
        this.date = new Date();
        this.id = makeOrderNum();
        this.amount = amount;
    }

    protected String makeOrderNum() {   // 주문 번호 생성
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");   // 날짜 포맷팅
        return simpleDateFormat.format(date) + (long) (Math.random() * 100000000);      // 주문 번호 반환
    }

    protected String makeDate() {       // 거래 일시 생성
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd E요일 HH:mm:ss z");
        return simpleDateFormat.format(date);
    }

    public abstract void printInfo();   // 거래 내역 출력
}
