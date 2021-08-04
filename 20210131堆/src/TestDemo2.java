import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;

class Card implements Comparable<Card>{
    public int rank;//数值
    public String suit;//花色

    public Card(int rank,String suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }

    //Alt+insert 选择equals和hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
class Card2 {
    public int rank; // 数值
    public String suit; // 花色
    public Card2(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card2{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}
//自定义比较器
class RankComparator implements Comparator<Card2>{
    @Override
    public int compare(Card2 o1, Card2 o2) {
        return o1.rank-o2.rank;
    }

}
public class TestDemo2 {
    public static void main3(String[] args) {
        Card card1 = new Card(1,"♣");
        Card card2 = new Card(2,"♣");
        Card card3 = new Card(3,"♣");
        Card card4 = new Card(1,"♣");

        System.out.println(card1 == card2);
        System.out.println(card1.compareTo(card3));//-1 表示1小于3
        //System.out.println(card1.equals(card4));
        //false equals 调用的Object的引用 比较的是 card1的引用 和 card4 的引用 的所指向的对象是否相同
        //按理说 这两张牌相同 但结果为false 所以要重写equals方法
        //缺点： equal只能按照相等进行比较，不能按照大于小于的方式比较
        System.out.println(card1.equals(card4));//true
    }

    public static void main2(String[] args) {
        Card2 card21 = new Card2(1,"♣");
        Card2 card22 = new Card2(2,"♣");
        Card2 card23 = new Card2(3,"♣");
        Card2 card24 = new Card2(1,"♣");
         PriorityQueue<Card2> qu3 = new PriorityQueue<>(new RankComparator());
        qu3.offer(card21);
        qu3.offer(card23);
        qu3.offer(card22);
        System.out.println(qu3);

        //基于比较器比较
        RankComparator rankComparator = new RankComparator();
        System.out.println(rankComparator.compare(card21,card22));//小于 <0
        System.out.println(rankComparator.compare(card21,card24));//等于 0
        System.out.println(rankComparator.compare(card23,card21));//大于 >0


    }

    public static void main(String[] args) {
        Card card1 = new Card(1,"♣");
        Card card2 = new Card(2,"♣");
        Card card3 = new Card(3,"♣");
        Card card4 = new Card(1,"♣");
        //基于Comparable接口类的比较
        System.out.println(card1.compareTo(card4));//0 xxd
        System.out.println(card2.compareTo(card3));// -1 <0 小于
        System.out.println(card3.compareTo(card1));//2 >0 大于

    }
    public static void main1(String[] args) {
        Card card1 = new Card(1,"♣");
        Card card2 = new Card(2,"♣");
        Card card3 = new Card(3,"♣");
        PriorityQueue<Card> qu = new PriorityQueue<>();
        qu.offer(card1);
        qu.offer(card3);
        qu.offer(card2);
        System.out.println(qu);

        Card2 card21 = new Card2(1,"♣");
        Card2 card22 = new Card2(2,"♣");
        Card2 card23 = new Card2(3,"♣");
        Card2 card24 = new Card2(4,"♣");

        PriorityQueue<Card2> qu2 = new PriorityQueue<>(new Comparator<Card2>() {
            @Override
            public int compare(Card2 o1, Card2 o2) {
                return o1.rank-o2.rank;
            }
        });
        qu2.offer(card22);
        qu2.offer(card23);
        qu2.offer(card21);
        qu2.offer(card24);
        System.out.println(qu2);

    }
}
