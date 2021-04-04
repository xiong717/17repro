package 常见的三个接口;

import java.util.Comparator;

public class ScoreComparator implements Comparator <Student2>{
    @Override
    public int compare(Student2 o1, Student2 o2) {
        /*if(o1.score > o2.score) {
            return 1;
        }else if(o1.score == o2.score) {
            return 0;
        }else {
            return -1;
        }

         */
        return o1.score-o2.score;//从大到小
    }
}
