package com.yang.model;

import com.yang.enumer.CardEnum;

import java.util.List;

/**
 * 一次出牌动作,谁出了哪些牌
 */
public class Play {
    //打牌的人
    private Player player;
    //打出了哪些牌
    private List<CardEnum> playCardList;

    public Play(Player player, List<CardEnum> playCardList) {
        this.player = player;
        this.playCardList = playCardList;
    }
}
