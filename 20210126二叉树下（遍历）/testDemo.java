import java.util.List;

public class testDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.createTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.preOrderTree(root);
        System.out.println("===================");

        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTree(root);
        System.out.println("====================");
        binaryTree.postOrderTraversal(root);
        System.out.println();
        binaryTree.postOrder(root);

        /*binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);

        System.out.println(binaryTree.getSize2(root));

        binaryTree.getLeafSize1(root);
        System.out.println(binaryTree.leafSize);

        System.out.println(binaryTree.getLeafSize2(root));

        System.out.println(binaryTree.getKLevelSize(root,4));

        System.out.println(binaryTree.getHeight(root));*/

       /* System.out.println("=============================");
        BTNode ret = binaryTree.find(root, 'c');
        if (ret == null) {
            System.out.println("没有找到那个节点");
            return;
        }
        System.out.println(ret.val);*/
        //System.out.println("============");
        //binaryTree.levelOrderTraversal(root);

    }

    public static void main2(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.createTree();
        boolean b = binaryTree.isSymmetric(root);
        System.out.println(b);
    }


    public static void main3(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.createTree1();
        boolean b = binaryTree.isBalanced(root);
        System.out.println(b);

    }


}
