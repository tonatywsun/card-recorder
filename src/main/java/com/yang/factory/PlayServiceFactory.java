package com.yang.factory;

import com.yang.enumer.ChannelEnum;
import com.yang.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PlayServiceFactory {
    @Autowired
    private Map<String, PlayService> playServiceMap;

    public PlayService getService(String channelId) {
        ChannelEnum channel = ChannelEnum.getByCode(channelId);
        if (channel == null) {
            return null;
        }
        return playServiceMap.get(channel.getCode() + "PlayService");
    }

}
