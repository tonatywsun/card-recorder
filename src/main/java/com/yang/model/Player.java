package com.yang.model;

import com.alibaba.fastjson.JSON;
import com.yang.enumer.CardEnum;
import com.yang.enumer.SeatEnum;

import java.util.List;
import java.util.Objects;

/**
 * 一个玩家
 */
public class Player {
    //这个玩家的位置
    private SeatEnum seat;
    //这个玩家第几个出牌
    private Integer playOrder;
    //这个玩家没有打过的牌
    private List<CardEnum> unPlayCardList;
    //这个玩家打过哪些牌
    private List<Play> playList;
    //这个玩家剩余牌数
    private Integer remainder;

    public SeatEnum getSeat() {
        return seat;
    }

    public void setSeat(SeatEnum seat) {
        this.seat = seat;
    }

    public Integer getPlayOrder() {
        return playOrder;
    }

    public void setPlayOrder(Integer playOrder) {
        this.playOrder = playOrder;
    }

    public List<CardEnum> getUnPlayCardList() {
        return unPlayCardList;
    }

    public void setUnPlayCardList(List<CardEnum> unPlayCardList) {
        this.unPlayCardList = unPlayCardList;
    }

    public List<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return seat == player.seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seat);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
