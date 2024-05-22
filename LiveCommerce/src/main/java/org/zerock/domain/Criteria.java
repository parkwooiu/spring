package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {

    private int pageNum; // 몇 페이지
    private int amount; // 페이지 당 몇 개 보여줄 것인지
    private int startRow; // 시작 레코드

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.startRow = (pageNum - 1) * amount;
    }

    // startRow에 대한 getter 메서드 추가
    public int getStartRow() {
        return startRow;
    }
}
