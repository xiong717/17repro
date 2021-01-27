public class testDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.createTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();


        binaryTree.getSize1(root);
        System.out.println(binaryTree.size);

        System.out.println(binaryTree.getSize2(root));

        binaryTree.getLeafSize1(root);
        System.out.println(binaryTree.leafSize);

        System.out.println(binaryTree.getLeafSize2(root));

        System.out.println(binaryTree.getKLevelSize(root,4));

        System.out.println(binaryTree.getHeight(root));
    }

}
