package com.yang.controller;

import com.yang.factory.PlayServiceFactory;
import com.yang.service.PlayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 打牌Controller类
 */
@Controller
@RequestMapping("/play")
public class PlayController {
    @Autowired
    private PlayServiceFactory factory;

    //首页跳转
    @RequestMapping("/indexPage")
    public String indexPage(ModelMap modelMap) {
        modelMap.put("url", "/play/reset?channelId=guanDan");
        return "index";
    }

    //设置第一个出牌的人接口
    @GetMapping("/setFirstPlay")
    public String setFirstPlay(@RequestParam Integer seatCode, @RequestParam String channelId) {
        factory.getService(channelId).setFirstPlay(seatCode);
        return "data";
    }

    //打牌接口
    @GetMapping("/play")
    public String play(@RequestParam String channelId, @RequestParam String playCards1,
                       @RequestParam String playCards2, @RequestParam String playCards3,
                       @RequestParam String playCards4, ModelMap modelMap) {
        Integer seatCode = 0;
        String playCards = "";
        if (StringUtils.isNotBlank(playCards1)) {
            seatCode = 1;
            playCards = playCards1;
        } else if (StringUtils.isNotBlank(playCards2)) {
            seatCode = 2;
            playCards = playCards2;
        } else if (StringUtils.isNotBlank(playCards3)) {
            seatCode = 3;
            playCards = playCards3;
        } else if (StringUtils.isNotBlank(playCards4)) {
            seatCode = 4;
            playCards = playCards4;
        }
        PlayService service = factory.getService(channelId);
        service.play(seatCode, playCards);
        modelMap.put("userInfo", service.getUserInfo());
        modelMap.put("surplus", service.surplus());
        return "data";
    }
}
