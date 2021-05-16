import java.util.LinkedList;
import java.util.Queue;
/*
* hk 最近的请求次数 链接：https://leetcode-cn.com/problems/number-of-recent-calls/
* 题目意思就是往队列里存放元素啊，每次ping就存一个数，然后存的时候看一下之前的数是否在t-3000之外了，是就删除；
*
* */
class RecentCounter {
    private Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {

    }
    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t-3000) {
            q.poll();
        }
        return q.size();
    }
}

public class Testqueuehk1 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(100));// requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(2));// requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001));// requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        int i = recentCounter.ping(3003);
        System.out.println(i);// requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }


}
