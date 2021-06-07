import java.util.Scanner;
/*
* https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef?tpId=60&&tqId=29483&rp=1&ru=/activity/oj&qru=/ta/tsing-kaoyan/question-ranking
* */
public class createTree {
        //创建树
        public static int i = 0;
        public static BTNode createtree(String str){
            if(str == null || str.length()<=0){
                return null;
            }
            BTNode root = null;
            if(str.charAt(i)!= '#'){
                root = new BTNode(str.charAt(i));
                i++;
                root.left = createtree(str);
                root.right = createtree(str);
            }else{
                i++;
            }
            return root;
        }
        //中序遍历
        public static void inordertree(BTNode root) {
            if(root == null) {
                return ;
            }
            inordertree(root.left);
            System.out.print(root.val+" ");
            inordertree(root.right);
        }
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            BTNode root = createtree(str);
            inordertree(root);
        }
    }
