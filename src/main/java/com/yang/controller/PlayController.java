package com.yang.controller;

import com.alibaba.fastjson.JSON;
import com.yang.factory.PlayServiceFactory;
import com.yang.model.dto.PlayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Boolean reset(@RequestParam String channelId) {
        return factory.getService(channelId).reset();
    }

    //设置第一个出牌的人接口
    @GetMapping("/setFirstPlay")
    public Boolean setFirstPlay(@RequestBody PlayDTO play) {
        return factory.getService(play.getChannelId()).setFirstPlay(play.getSeatCode());
    }

    //打牌接口
    @GetMapping("/play")
    public Boolean play(@RequestBody PlayDTO play) {
        return factory.getService(play.getChannelId()).play(play.getSeatCode(), play.getPlayCards());
    }

    //获取每个人信息接口
    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestBody PlayDTO play) {
        return JSON.toJSONString(factory.getService(play.getChannelId()).getUserInfo());
    }

    //获取剩余的牌接口
    @GetMapping("/surplus")
    public String surplus(@RequestBody PlayDTO play) {
        return JSON.toJSONString(factory.getService(play.getChannelId()).surplus());
    }
}
