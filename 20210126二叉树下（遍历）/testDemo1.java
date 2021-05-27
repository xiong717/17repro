public class testDemo1 {
    class BTNode {
        public char val;
        public BTNode left;//左子树的引用
        public BTNode right;//右子树的引用
        public BTNode(char val){
            this.val = val;
        }
    }
    BTNode mergeTrees(BTNode t1, BTNode t2) {
        if(t1 != null && t2 == null){
            return t1;
        }
        if(t1 == null && t2 != null){
            return t2;
        }
        t1.val += t2.val; //中，可以对这行代码进行位置调整，实现中序和后序遍历
        t1.left = mergeTrees(t1.left, t2.left);		//左
        t1.right = mergeTrees(t1.right, t2.right);	//右
        return t1;
    }

    public static void main(String[] args) {

    }
}
