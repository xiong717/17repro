class BTNode {
    public char val;
    public BTNode left;//左子树的引用
    public BTNode right;//右子树的引用
    public BTNode(char val){
        this.val = val;
    }
}


public class BinaryTree {

    /*
     我们要首先创建二叉树，但是为了好理解，我们先以穷举的方式
     创建二叉树
     后期我们会以遍历的方式 创建二叉树
     当前只是权宜之计
     */
    public BTNode createTree(){
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return  A;
    }

    //前序遍历
    void preOrderTraversal(BTNode root){
        if(root == null) return;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    void inOrderTraversal(BTNode root){
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }
    //后续遍历
    void postOrderTraversal(BTNode root){
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }
    //遍历思路-求结点个数
    //递归遍历，每次只要不为空 size++
    static int size = 0;
    void getSize1(BTNode root) {
        if (root == null) return;
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数  左树节点+右树节点+1
    int getSize2(BTNode root) {
        if (root == null ){
            return 0;
        }
        return  getSize2(root.right)+getSize2(root.left)+1;
    }
    // 遍历思路-求叶子结点个数 遍历整颗树(前序，中序，后序都可)
    static int leafSize = 0;//静态变量
    void getLeafSize1(BTNode root){
        if (root == null ) return;
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    // 子问题思路-求叶子结点个数 左树的叶子 + 右树叶子
    int getLeafSize2(BTNode root){
        if (root == null) return 0;
        if(root.right == null && root.left == null){
            return 1;
        }
        return (getLeafSize2(root.left)+getLeafSize2(root.right));
        //实现递归
    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(BTNode root,int k) {
        if (root == null) return 0;
        if (k == 1)
        {
            return 1;
        }
        return getKLevelSize(root.left, k-1)+ getKLevelSize(root.right, k-1);
    }
    // 获取二叉树的高度
    int getHeight(BTNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight>= rightHeight){
            return getHeight(root.left)+1;
        }
        return getHeight(root.right)+1;
    }

    //比较两棵树是否相同
    void sameTree(BTNode root){


    }


}
