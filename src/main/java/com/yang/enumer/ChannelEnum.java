package com.yang.enumer;

public enum ChannelEnum {
    GUANDAN("guanDan", "掼蛋");

    ChannelEnum(String code, String game) {
        this.code = code;
        this.game = game;
    }

    private String code;
    private String game;

    public String getCode() {
        return code;
    }

    public String getGame() {
        return game;
    }

    public static ChannelEnum getByCode(String code) {
        if (code == null || code.length() == 0) {
            return null;
        }
        for (ChannelEnum channel : ChannelEnum.values()) {
            if (channel.getCode().equals(code)) {
                return channel;
            }
        }
        return null;
    }

}
