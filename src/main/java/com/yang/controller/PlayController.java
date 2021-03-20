package com.yang.controller;

import com.yang.factory.PlayServiceFactory;
import com.yang.model.Player;
import com.yang.service.PlayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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
        PlayService service = factory.getService(channelId);
        service.play(1, playCards1);
        service.play(2, playCards2);
        service.play(3, playCards3);
        service.play(4, playCards4);
        Map<Integer, Player> userInfo = service.getUserInfo();
        modelMap.put("user1Info", userInfo.get(1));
        modelMap.put("user2Info", userInfo.get(2));
        modelMap.put("user3Info", userInfo.get(3));
        modelMap.put("user4Info", userInfo.get(4));
        modelMap.put("surplus", service.surplus());
        return "data";
    }
}
