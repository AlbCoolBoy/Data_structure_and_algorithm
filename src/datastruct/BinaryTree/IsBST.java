package datastruct.BinaryTree;

import org.hamcrest.core.Is;

/*判断给定的二叉树是否是二叉搜索树*/
public class IsBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static int preValue=Integer.MIN_VALUE;
    public static boolean isBST(Node head){
        if(head==null) return true;
        boolean isLeftBST=isBST(head.left);
        if(isLeftBST==false){
            return false;
        }
        if(head.value<preValue){
            return false;
        }else{
            preValue = head.value;
        }
        return isBST(head.right);
    }
}
