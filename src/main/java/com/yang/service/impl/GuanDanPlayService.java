package com.yang.service.impl;

import com.yang.enumer.CardEnum;
import com.yang.enumer.SeatEnum;
import com.yang.model.Play;
import com.yang.model.Player;
import com.yang.service.PlayService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GuanDanPlayService implements PlayService {
    //打牌的人list
    private List<Player> playerList;
    private Map<SeatEnum, Player> seat2PlayerMap;
    //剩余未出的牌集合
    private List<CardEnum> cardList;

    @Override
    public Boolean reset() {
        playerList = new ArrayList<>(4);
        seat2PlayerMap = null;
        cardList = new ArrayList<>(108);
        for (CardEnum card : CardEnum.values()) {
            int i = card == CardEnum.CDW || card == CardEnum.CXW ? 2 : 8;
            for (; i > 0; i--) {
                cardList.add(card);
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean setFirstPlay(Integer seatCode) {
        List<CardEnum> unPlayCardList = Arrays.stream(CardEnum.values()).collect(Collectors.toList());
        SeatEnum seat = SeatEnum.getByCode(seatCode);
        Player player1 = new Player();
        player1.setPlayList(new ArrayList<>());
        player1.setPlayOrder(1);
        player1.setRemainder(108 / 4);
        player1.setSeat(seat);
        player1.setUnPlayCardList(new ArrayList<>(unPlayCardList));
        seatCode++;
        SeatEnum seat2 = SeatEnum.getByCode(seatCode > 4 ? seatCode - 4 : seatCode);
        Player player2 = new Player();
        player2.setPlayList(new ArrayList<>());
        player2.setPlayOrder(2);
        player2.setRemainder(108 / 4);
        player2.setSeat(seat2);
        player2.setUnPlayCardList(new ArrayList<>(unPlayCardList));
        seatCode++;
        SeatEnum seat3 = SeatEnum.getByCode(seatCode > 4 ? seatCode - 4 : seatCode);
        Player player3 = new Player();
        player3.setPlayList(new ArrayList<>());
        player3.setPlayOrder(3);
        player3.setRemainder(108 / 4);
        player3.setSeat(seat3);
        player3.setUnPlayCardList(new ArrayList<>(unPlayCardList));
        seatCode++;
        SeatEnum seat4 = SeatEnum.getByCode(seatCode > 4 ? seatCode - 4 : seatCode);
        Player player4 = new Player();
        player3.setPlayList(new ArrayList<>());
        player4.setPlayOrder(4);
        player4.setRemainder(108 / 4);
        player4.setSeat(seat4);
        player4.setUnPlayCardList(new ArrayList<>(unPlayCardList));
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        seat2PlayerMap = playerList.stream().collect(Collectors.toMap(Player::getSeat, x -> x));
        return Boolean.TRUE;
    }

    @Override
    public Boolean play(Integer seatCode, String playCards) {
        Player player = seat2PlayerMap.get(SeatEnum.getByCode(seatCode));
        Play play = null;
        if (playCards == null || playCards.length() == 0) {
            play = new Play(player, Collections.emptyList());
            player.getPlayList().add(play);
            return Boolean.TRUE;
        }
        char[] playCardArr = playCards.toCharArray();
        List<CardEnum> playCardList = new ArrayList<>(playCardArr.length);
        for (char c : playCardArr) {
            playCardList.add(CardEnum.getByCode(c + ""));
        }
        player.setRemainder(player.getRemainder() - playCardList.size());
        play = new Play(player, playCardList);
        player.getPlayList().add(play);
        player.getUnPlayCardList().removeAll(playCardList);
        cardListRemove(new ArrayList<>(playCardList));
        return Boolean.TRUE;
    }

    private void cardListRemove(List<CardEnum> playCardList) {
        loop:
        for (Iterator<CardEnum> playCardListIterator = playCardList.iterator(); playCardListIterator.hasNext(); ) {
            CardEnum next = playCardListIterator.next();
            for (Iterator<CardEnum> iterator = cardList.iterator(); iterator.hasNext(); ) {
                if (next == iterator.next()) {
                    iterator.remove();
                    playCardListIterator.remove();
                    continue loop;
                }
            }
        }
    }
}
