package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转页面
 *
 * @author tona.sun
 * @version V1.0
 * @className: PageController
 * @date 2021/3/10 17:43
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/indexPage")
    public String indexPage(ModelMap modelMap) {
        modelMap.put("url", "http://127.0.0.1:9091/play/reset?channelId=guanDan");
        return "index";
    }
}
