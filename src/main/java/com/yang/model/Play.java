package com.yang.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.yang.enumer.CardEnum;

import java.util.List;

/**
 * 一次出牌动作,谁出了哪些牌
 */
public class Play {
    //打牌的人
    @JSONField(serialize = false)
    private Player player;
    //打出了哪些牌
    private List<CardEnum> playCardList;

    public Play(Player player, List<CardEnum> playCardList) {
        this.player = player;
        this.playCardList = playCardList;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<CardEnum> getPlayCardList() {
        return playCardList;
    }

    public void setPlayCardList(List<CardEnum> playCardList) {
        this.playCardList = playCardList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
