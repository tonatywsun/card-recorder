package com.yang.enumer;

/**
 * 牌的枚举
 */
public enum CardEnum {
    A("A"),
    C2("2"),
    C3("3"),
    C4("4"),
    C5("5"),
    C6("6"),
    C7("7"),
    C8("8"),
    C9("9"),
    C0("0"),
    CJ("J"),
    CQ("Q"),
    CK("K"),
    CXW("X"),
    CDW("D");

    CardEnum(String number) {
        this.number = number;
    }

    //牌的点数
    private String number;
    //牌的花色属性暂时不实现
    //private DesignEnum Design;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static CardEnum getByCode(String number) {
        if (number == null || number.length() == 0) {
            return null;
        }
        for (CardEnum card : CardEnum.values()) {
            if (card.getNumber().equals(number)) {
                return card;
            }
        }
        return null;
    }
}
