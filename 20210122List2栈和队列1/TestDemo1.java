import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;

import java.util.*;

/*
* 扑克牌 ArrayList
* */
class Card{
    public int rank;//牌面值
    public String suit;//花色

    @Override
    public String toString() {
//        return "Card{" +
//                "rank=" + rank +
//                ", suit='" + suit + '\'' +
//                '}';
        return "["+suit+","+rank+"]";
    }
}
class Deckcard {
    public static final String[] SUITS = {"♣", "♦", "♠", "♥"};

    //先买一副牌
    public  List<Card> buydeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 13; j++) {
                String suit = SUITS[i];
                int rank = j;
                Card card = new Card();
                card.rank = rank;
                card.suit = suit;
                deck.add(card);
            }
        }
        return deck;
    }

    public  void swap(List<Card> cardList, int i, int j) {
        Card tmp = cardList.get(i);
        cardList.set(i, cardList.get(j));
        cardList.set(j, tmp);
        //先得到 i 然后把i下标的值设置为j的值，然后把j的值设置为i
    }

    //洗牌
    public  void shuffle(List<Card> cardList) {
        Random random = new Random();
        for (int i = cardList.size() - 1; i > 0; i--) {
            int r = random.nextInt(i);//[0,i)
            swap(cardList, i, r);
        }
    }
}
public class TestDemo1 {

    public static void main(String[] args) {
        Deckcard deckcard = new Deckcard();
        List<Card> cardList =deckcard.buydeck();
        System.out.println("============买牌=======");
        System.out.println(cardList);
        System.out.println("============洗牌=======");
        deckcard.shuffle(cardList);
        System.out.println(cardList);
        System.out.println("============发牌=======");

        //三个人轮流接五张牌
        List<Card> card1 = new ArrayList<>();
        List<Card> card2 = new ArrayList<>();
        List<Card> card3 = new ArrayList<>();
        List<List<Card>> hands = new ArrayList<>();//二维数组
        hands.add(card1);
        hands.add(card2);
        hands.add(card3);

        //轮流揭牌 揭牌相当于取走这张牌 每个人轮流揭牌 相当于取走的是牌的0下标
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cardList.remove(0);
                hands.get(j).add(card);
            }
        }

        System.out.println("第一个人接的牌");
        System.out.println(card1);
        System.out.println("第二个人接的牌");
        System.out.println(card2);
        System.out.println("第三个人接的牌");
        System.out.println(card3);
        System.out.println("剩余的牌");
        System.out.println(cardList);

    }
}
