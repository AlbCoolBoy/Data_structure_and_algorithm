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

    public static int preValue = Integer.MIN_VALUE;

    public static boolean isBST(Node head) {
        if (head == null) return true;
        boolean isLeftBST = isBST(head.left);
        if (isLeftBST == false) {
            return false;
        }
        if (head.value < preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return isBST(head.right);
    }

    /*使用递归进行解决*/
    /*需要获取，左子树是否是BST，右子树是否是BST，同时左子树的最大值是否小于右子if(树的最小值*/
    public static boolean isBST2(Node head){
        if(head==null) {
            return true;
        }
        return process(head).isBST;
    }

    /*用于收集信息d*/
    public static class Info {
      public boolean isBST;
       public int max;
       public int min;

       public Info(boolean isBST, int max, int min) {
           isBST = isBST;
           max=max;
           min=min;
       }
    }
    public static Info process(Node x){
        if(x==null){
            return null;
        }
        Info leftInfo=process(x.left);
        Info rightInfo=process(x.right);
        int max=x.value;
        if(leftInfo!=null){
            max=Math.max(max, leftInfo.max);
        }
        if(rightInfo!=null){
            max= Math.max(max,rightInfo.max);
        }
        int min=x.value;
        if (leftInfo != null) {
            min=Math.min(min, leftInfo.min);
        }
        if(rightInfo!=null){
            min=Math.min(min, rightInfo.min);
        }
        boolean isBST=true;
        if(leftInfo!=null&&!leftInfo.isBST){
            isBST=false;
        }
        if(rightInfo!=null&&!rightInfo.isBST){
            isBST=false;
        }
        if(leftInfo!=null&leftInfo.max>=x.value){
            isBST=false;
        }
        if(rightInfo!=null&&rightInfo.min<=x.value){
            isBST=false;
        }
        return new Info(isBST,max,min);
    }


}
