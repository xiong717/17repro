

class BinarySearchTree {
    static class BSNode {
        public int val;
        public BSNode left;
        public BSNode right;

        public BSNode(int val) {
            this.val = val;
        }
    }

    public BSNode root = null;

    public BSNode search(int val) {
        if (root == null) return null;
        BSNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

    public boolean insert(int val) {

        BSNode bsNode = new BSNode(val);
        if (root == null) {
            root = bsNode;
            return true;
        }
        BSNode cur = root;
        BSNode parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.val > bsNode.val) {
                cur = cur.left;
            } else if (cur.val < bsNode.val) {
                cur = cur.right;
            } else {
                return false;
            }
        }
        if (bsNode.val > parent.val) {
            parent.right = bsNode;
            return true;
        } else {
            parent.left = bsNode;
            return true;
        }
    }

    public void remove(int val) {
       if ( root == null) return;
       BSNode cur = root;
       BSNode parent = null;
       while (cur!=null){
           if (cur.val == val) {
               removenode(parent,cur,val);
           }else if(cur.val<val){
               parent = cur;
               cur = cur.right;
           }else {
               parent = cur;
               cur = cur.left;
           }
       }

    }

    private void removenode(BSNode parent, BSNode cur, int val) {
        if (cur.left==null){
            if (cur == root ){
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else if(cur == parent.right){
                parent.right = cur.right;
            }
        }else if (cur.right == null) {
            if (cur == root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else if(cur == parent.right){
                parent.right = cur.left;
            }
        }else {
            //要删除cur节点 替换法 右树中找最小值 或者左树中找最大值
            BSNode targetParent = cur;
            BSNode target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            //target指向的节点就是 右边的最小值 target.left是null
            cur.val = target.val;
            //删除target
            if (target == targetParent.left){
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
}



public class TestDemo3 {
    public static void preorder(BinarySearchTree.BSNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public  static void inorder(BinarySearchTree.BSNode root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
         binarySearchTree.insert(4);
         binarySearchTree.insert(3);
         binarySearchTree.insert(1);
         binarySearchTree.insert(5);
         binarySearchTree.insert(2);

         preorder(binarySearchTree.root);
        System.out.println();
        inorder(binarySearchTree.root);
        System.out.println();

        try{
            BinarySearchTree.BSNode ret = binarySearchTree.search(8);
            System.out.println(ret.val);
        }catch (NullPointerException e){
            //空指针异常
            System.out.println("没有找到当前节点。。。。");
            e.printStackTrace();
        }

        System.out.println("========================");
        binarySearchTree.remove(4);
        preorder(binarySearchTree.root);
        System.out.println();
        inorder(binarySearchTree.root);
    }

}

