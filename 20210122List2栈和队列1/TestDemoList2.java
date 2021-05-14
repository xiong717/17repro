import java.util.ArrayList;
import java.util.List;

/*
* 实现杨辉三角
*
* */
public class TestDemoList2 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows <= 0) {
            return ret;
        }
        //第一行数据list
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);//把第一行的list 放到ret中

        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for (int j = 1; j < i; j++) {
                //确定的是 当前行的每个元素 == 上一行的当前列 + 上一行的前一列就是我当前需要添加的数字
                List<Integer> prevRow = ret.get(i-1);
                int num = prevRow.get(j) + prevRow.get(j - 1);
                //int num = ret.get(i-1).get(j)+ret.get(i-1).get(j-1);
                curRow.add(num);
            }
            //手动在一行的后面添加一个1
            curRow.add(1);
            ret.add(curRow);

        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }


}
