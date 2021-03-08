package com.yang.enumer;

/**
 * 位置枚举类，写死最多只有四个人
 */
public enum SeatEnum {
    upper(3, "上"),
    Left(4, "左"),
    right(2, "右"),
    lower(1, "我");

    SeatEnum(Integer code, String seat) {
        this.code = code;
        this.seat = seat;
    }

    private Integer code;
    private String seat;

    public Integer getCode() {
        return code;
    }

    public String getSeat() {
        return seat;
    }
    public static SeatEnum getByCode(Integer code) {
        if (code == null ) {
            return null;
        }
        for (SeatEnum seat : SeatEnum.values()) {
            if (seat.getCode().equals(code)) {
                return seat;
            }
        }
        return null;
    }
}
