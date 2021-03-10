package com.yang.model.dto;

import com.alibaba.fastjson.JSON;

public class PlayDTO {
    //打牌人的位置code,对应SeatEnum的code
    private Integer seatCode;
    //打了哪些牌，字符串拼接，如JJQQKK
    private String playCards;
    //渠道ID 目前有guanDan
    private String channelId;

    public PlayDTO() {
    }

    public Integer getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(Integer seatCode) {
        this.seatCode = seatCode;
    }

    public String getPlayCards() {
        return playCards;
    }

    public void setPlayCards(String playCards) {
        this.playCards = playCards;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
