package domain.wallet;

public abstract class Account {     // 금융 상품 추상 클래스
    protected String number;        // 금융 상품 번호
    protected String pw;            // 금융 상품 비밀번호

    public Account(String number, String pw) {  // 생성자
        this.number = number;
        this.pw = pw;
    }

    protected abstract boolean callAPI();       // API 호출
}
