/*
https://www.nowcoder.com/practice/6235a76b1e404f748f7c820583125c50?tpId=8&tqId=11010&rp=3&ru=%2Factivity%2Foj&qru=%2Fta%2Fcracking-the-coding-interview%2Fquestion-ranking&tab=answerKey

*  有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
* 第一种为直接收养所有动物中最早进入收容所的，
* 第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
* 给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
* 若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，整数代表狗，负数代表猫；
* 若第一个元素为2，则代表有人收养动物，
* 第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。
* 请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
测试样例：[[1,1],[1,-1],[2,0],[2,-1]]
返回：[1,-1]
————————————————
版权声明：本文为CSDN博主「zdplife」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/zdplife/article/details/48915117
* */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Testqueuehk3 {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        if (ope == null || ope.length == 0) {
            return res;
        }
        Queue<Integer> dogs = new LinkedList<>();
        Queue<Integer> cats = new LinkedList<>();
        Queue<Integer> all = new LinkedList<>();
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) { //有动物进收容所
                if (ope[i][1] > 0) {//狗
                    dogs.add(ope[i][1]);
                    all.add(ope[i][1]);
                } else if (ope[i][1] < 0) {//猫
                    cats.add(ope[i][1]);
                    all.add(ope[i][1]);
                }
            } else if (ope[i][0] == 2) {//有人要收养宠物
                if (ope[i][1] == 0) {
                    //第一种收养方式
                    if (!all.isEmpty()) {
                        int tmp = all.poll();
                        res.add(tmp);
                        if (tmp > 0) {
                            dogs.poll();
                        } else {
                            cats.poll();
                        }
                    }
                } else if (ope[i][1] == 1) {
                    //想要收养狗
                    if (!dogs.isEmpty()) {
                        int temp = dogs.poll();
                        res.add(temp);
                        all.remove(temp);
                    }
                } else if (ope[i][1] == -1) {
                    //收养猫
                    if (!cats.isEmpty()) {
                        int temp = cats.poll();
                        res.add(temp);
                        all.remove(temp);
                    }
                }
            }
        }
        return res;
    }
}


