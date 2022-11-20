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

    /*使用递归进行解决*/
    /*需要获取，左子树是否是BST，右子树是否是BST，同时左子树的最大值是否小于右子树的最小值*/
    public static class ReturnData{
        public boolean isBST;
        public int min;
        public int max;
        public ReturnData(boolean isBST, int min, int max){
            isBST=isBST;
            min=min;
            max=max;
        }
    }

    public static ReturnData process(Node x){
        if(x==null){
            return null;
        }
        ReturnData leftData=process(x.left);
        ReturnData rightData=process(x.right);

        int min=x.value;
        int max=x.value;;

        if(leftData!=null){
            min=Math.min(min, leftData.min);
            max=Math.max(max, leftData.max);
        }
        if(rightData!=null){
            min=Math.min(min, rightData.min);
            max= Math.max(max,rightData.max);
        }
        boolean isBST=true;
        if(leftData!=null&&(!leftData.isBST||leftData.max>=x.value)){
            isBST=false;
        }
        if (rightData!=null&&(!rightData.isBST||rightData.min<=x.value)){
            isBST=false;
        }
        return new ReturnData(isBST,min,max);
    }


}
