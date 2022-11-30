package domain.transfer;

public interface Transferable {     // 송금 인터페이스
    Transfer transfer(String toBank, String toNumber, long amount); // 송 금
}
