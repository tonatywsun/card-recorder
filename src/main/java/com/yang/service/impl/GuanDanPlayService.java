package com.yang.service.impl;

import com.yang.enumer.CardEnum;
import com.yang.enumer.SeatEnum;
import com.yang.model.Player;
import com.yang.service.PlayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GuanDanPlayService implements PlayService {
    //打牌的人list
    private List<Player> playerList;
    private Map<SeatEnum, Player> seat2PlayerMap;
    //剩余未出的牌集合
    private List<String> cardList;

    @Override
    public Boolean reset() {
        playerList = new ArrayList<>(4);
        seat2PlayerMap = null;
        cardList = new ArrayList<>(108);
        for (CardEnum card : CardEnum.values()) {
            int i = card == CardEnum.CDW || card == CardEnum.CXW ? 2 : 8;
            for (; i > 0; i--) {
                cardList.add(card.getNumber());
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean setFirstPlay(Integer seatCode) {
        if (seatCode > 4 || seatCode < 0) {
            return Boolean.FALSE;
        }
        this.reset();
        int remainder = 108 / 4;
        List<String> unPlayCardList =
                Arrays.stream(CardEnum.values()).map(CardEnum::getNumber).collect(Collectors.toList());
        SeatEnum seat = SeatEnum.getByCode(seatCode);
        Player player1 = new Player();
        player1.setPlayList(new ArrayList<>());
        player1.setPlayOrder(1);
        player1.setRemainder(remainder);
        player1.setSeat(seat);
        player1.setUnPlayCardList(new ArrayList<>(unPlayCardList));
        seatCode++;
        SeatEnum seat2 = SeatEnum.getByCode(seatCode > 4 ? seatCode - 4 : seatCode);
        Player player2 = new Player();
        player2.setPlayList(new ArrayList<>());
        player2.setPlayOrder(2);
        player2.setRemainder(remainder);
        player2.setSeat(seat2);
        player2.setUnPlayCardList(new ArrayList<>(unPlayCardList));
        seatCode++;
        SeatEnum seat3 = SeatEnum.getByCode(seatCode > 4 ? seatCode - 4 : seatCode);
        Player player3 = new Player();
        player3.setPlayList(new ArrayList<>());
        player3.setPlayOrder(3);
        player3.setRemainder(remainder);
        player3.setSeat(seat3);
        player3.setUnPlayCardList(new ArrayList<>(unPlayCardList));
        seatCode++;
        SeatEnum seat4 = SeatEnum.getByCode(seatCode > 4 ? seatCode - 4 : seatCode);
        Player player4 = new Player();
        player4.setPlayList(new ArrayList<>());
        player4.setPlayOrder(4);
        player4.setRemainder(remainder);
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
        if (StringUtils.isBlank(playCards)) {
            player.getPlayList().add("");
            return Boolean.TRUE;
        }
        char[] playCardArr = playCards.toCharArray();
        List<String> playCardList = new ArrayList<>(playCardArr.length);
        for (char c : playCardArr) {
            playCardList.add(c + "");
        }
        player.setRemainder(player.getRemainder() - playCardList.size());
        player.getPlayList().add(playCards);
        player.getUnPlayCardList().removeAll(playCardList);
        cardListRemove(new ArrayList<>(playCardList));
        return Boolean.TRUE;
    }

    @Override
    public Map<Integer, Player> getUserInfo() {
        return playerList.stream().collect(Collectors.toMap(Player::getPlayOrder, y -> y));
    }

    @Override
    public Map<String, Long> surplus() {
        return cardList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    private void cardListRemove(List<String> playCardList) {
        loop:
        for (Iterator<String> playCardListIterator = playCardList.iterator(); playCardListIterator.hasNext(); ) {
            String next = playCardListIterator.next();
            for (Iterator<String> iterator = cardList.iterator(); iterator.hasNext(); ) {
                if (next.equals(iterator.next())) {
                    iterator.remove();
                    playCardListIterator.remove();
                    continue loop;
                }
            }
        }
    }
}
