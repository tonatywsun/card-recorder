package com.yang.service;

import com.yang.model.Player;

import java.util.Map;

public interface PlayService {
    /**
     * 重置各容器
     *
     * @return
     */
    Boolean reset();

    /**
     * 设置第一个出牌的人
     *
     * @return
     */
    Boolean setFirstPlay(Integer seatCode);

    /**
     * 出牌动作接口
     *
     * @return
     */
    Boolean play(Integer seatCode, String playCards);

    Map<Integer, Player> getUserInfo();

    Map<String, Long> surplus();
}
