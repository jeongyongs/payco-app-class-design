package domain.franchise;

public class Franchise {                        // 가맹점
    private String id;
    private String name;

    public Franchise(String id, String name) {  // 생성자
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {                  // 가맹점 이름 반환
        return name;
    }
}
