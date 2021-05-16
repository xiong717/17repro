import java.util.LinkedList;
/*
  约瑟夫问题 链接https://www.nowcoder.com/practice/ff063da83b1a4d91913dd1b1e8b01466?tpId=8&tqId=11045&rp=2&ru=%2Factivity%2Foj&qru=%2Fta%2Fcracking-the-coding-interview%2Fquestion-ranking&tab=answerKey
* 现有n个人围坐一圈，顺时针给大家编号，第一个人编号为1，然后顺时针开始报数。
* 第一轮依次报1，2，1，2...没报1的人出局。
* 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...没报1的人都出局。以此类推直到剩下以后一个人。
* 现给定一个int n，要求返回最后一个人的编号。
*
  思路：1. 由于涉及到频繁的删除操作，故数据结构应该选择链表，这里选择LinkedList，其底层实现是循环双链表。
2. 每一轮报数完毕之后，将链表尾部节点移动到链表首部，开始新一轮的报数。
3. 链表中仅剩一个节点，程序结束。

*
*
* */
class yuesefu {
    public int getResult(int n) {
        // write code here
        if (n < 1) {
            return -1;
        }
        int cur = 0;//报号数 表示还未开始报数
        int round = 2;//下一轮可以报的最大数
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            list.add(i); //给n个人编号
        }
        while (list.size() > 1) {
            int i = 0;//表示list是从0下标开始存储的
            while (list.size() > 1 && i < list.size()) {
                cur = (cur + 1) % round;
                if (cur != 1) {
                    list.remove(i);
                } else {
                    i++;
                }
            }
            round++;
            cur = 0;
            //表示一轮报号结束
            if (list.size() > 1) {
                int last = list.removeLast();
                list.addFirst(last);
            }
            // 将最后报数的元素移动到链表首部，即确保每次报数从链表首部开始
        }
        return list.pop();
    }
}
public class Testqueuehk2 {
    public static void main(String[] args) {
        yuesefu y = new yuesefu();
        int result = y.getResult(5);
        System.out.println(result);
    }
}

