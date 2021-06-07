import java.util.*;

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

    public BTNode createTree1(){
        BTNode A = new BTNode('1');
        BTNode B = new BTNode('2');
        BTNode C = new BTNode('2');
        BTNode D = new BTNode('3');
        BTNode E = new BTNode('3');
        BTNode F = new BTNode('4');
        BTNode G = new BTNode('4');
        //BTNode H = new BTNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        //E.right = H;
        D.left = F;
        D.right = G;
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

    //查找val所在的节点 没有找到返回null
    BTNode find(BTNode root,char val) {
        if (root == null) return null;
        if (root.val==val) {
            return root;
        }
        BTNode ret = find(root.left,val);//递归左子树
        if (ret != null) {
            return  ret;
        }

        ret = find(root.right,val);//递归右子树
        if (ret != null) {
            return ret;
        }
        return null;
    }
    //比较两棵树是否相同
    boolean sameTree(BTNode p,BTNode q){
     if (p == null && q== null) {
         return true;
     }
     if (p ==null || q == null) {
         return false;
     }
     if (p.val != q.val) {
         return false;
     }
     return sameTree(p.left,q.left)&&sameTree(p.right,q.right);

    }

    //镜像二叉树
    public boolean pd(BTNode leftTree,BTNode rightTree) {
        if(leftTree != null && rightTree == null || leftTree == null&& rightTree!=null) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        if(leftTree.val != rightTree.val) {
            return false;
        }
        return pd(leftTree.left,rightTree.right) &&
                pd(leftTree.right,rightTree.left);
    }
    public boolean isSymmetric(BTNode root) {

        if (root == null) {
            return false;
        }
        return pd(root.left,root.right);

    }


    //判断一颗二叉树是不是平衡二叉树

    public int height(BTNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public boolean isBalanced(BTNode root) {
        if(root == null) {
            return true;
        }
        if (Math.abs(height(root.left)-height(root.right))<=1){
           return isBalanced(root.left) && isBalanced(root.right);
        }else {
            return false;
        }
    }
    /*
    * 这个方法 时间复杂度非常高 因为高度是O(n) 遍历以后 其复杂度为O(n^2)
    * */
    public int height1(BTNode root){
        if (root == null){
            return 0;
        }
        int rightheight = height1(root.right);
        int leftheight = height1(root.left);
        if (leftheight>=0 && rightheight>=0 && Math.abs(leftheight-rightheight)<=1){
            return Math.max(leftheight,rightheight)+1;
        }else {
            return -1;
        }
    }
    public boolean isBalanced1(BTNode root) {
        if (height(root) >=0) {
            return true;
        }else {
            return false;
        }
    }


    //二叉树的层序遍历
    void levelOrderTraversal(BTNode root){
       if (root == null) return;
       Queue<BTNode> queue = new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           BTNode cur = queue.poll();
           System.out.print(cur.val);
           if (cur.left != null || cur.right != null) {
               queue.offer(cur.left);
               queue.offer(cur.right);
           }
       }
       }

       //二叉树的分层遍历(用链表存)
    public List<List<Integer>> levelOrder(BTNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return  ret;
        }
        Queue<BTNode> queue = new LinkedList<>();//分层的
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                BTNode cur = queue.poll();
                list1.add((int)cur.val);
                if (cur.left!=null ) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list1);
        }
        return ret;
    }
    //判断是否是完全二叉树
      boolean isCompleteTree(BTNode root) {
        if (root == null) {
            return true;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
                BTNode cur  = queue.poll();
                if (cur != null){
                  queue.offer(cur.left);
                  queue.offer(cur.right);
                 }else {
                    break;
                }
        }
        while (!queue.isEmpty()){
            //依次弹出队列元素
            BTNode node = queue.poll();
            if (node != null) {
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
      }

    //非递归前序遍历
    void preOrderTree(BTNode root) {
        if (root == null) {
            return;
        }
        BTNode cur = root;
        Stack<BTNode> stack = new Stack<>();
        while (cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val);
                cur = cur.left;
            }
            BTNode top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }

    //非递归中序遍历
    void inOrderTree(BTNode root) {
        if (root == null) {
            return;
        }
        BTNode cur = root;
        Stack<BTNode> stack = new Stack<>();
        while (cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.pop();
            System.out.print(top.val);
            cur = top.right;
        }
        System.out.println();
    }
    //非递归后序遍历
    void postOrder(BTNode root){
        if (root==null) {
            return;
        }
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        BTNode prev = null;
        while (cur!=null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.peek();
            if (top.right == null|| top.right==prev) {
                stack.pop();
                System.out.print(top.val);//左边为null 右边也为null 打印中间
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }
}
