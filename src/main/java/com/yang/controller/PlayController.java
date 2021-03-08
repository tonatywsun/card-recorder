package com.yang.controller;

import com.yang.factory.PlayServiceFactory;
import com.yang.model.dto.PlayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打牌Controller类
 */
@RestController
@RequestMapping("/play")
public class PlayController {
    @Autowired
    private PlayServiceFactory factory;

    //开始/重置接口
    @GetMapping("/reset")
    public void reset(@RequestBody PlayDTO play) {
        factory.getService(play.getChannelId()).reset();
    }

    //设置第一个出牌的人接口
    @GetMapping("/setFirstPlay")
    public void setFirstPlay(@RequestBody PlayDTO play) {
        factory.getService(play.getChannelId()).setFirstPlay(play.getSeatCode());
    }

    //打牌接口
    @GetMapping("/play")
    public void play(@RequestBody PlayDTO play) {
        factory.getService(play.getChannelId()).play(play.getSeatCode(),play.getPlayCards());
    }

    //获取每个人信息接口

    //获取剩余的牌接口

}
