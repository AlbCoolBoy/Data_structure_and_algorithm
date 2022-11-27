package leetcode.book;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * <h3>Data structure and algorithm</h3>
 * <p></p>
 *
 * @author : ALB
 * @date : 2022-11-26 15:25
 **/
//用非递归的方式实现二叉树的三种遍历     p94
public class BinaryTreeTraverse {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value=value;
        }
    }

    public static void preTraverseUnrecur(TreeNode root){
        if(root==null){
            return ;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            System.out.println(cur.value+" ");
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        System.out.println();
    }

    //先将整棵树的左子树入栈
    public static void inorderTraverseUnrecur(TreeNode head){
        if(head==null){
            return ;
        }
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||head!=null){
            if(head!=null){
                stack.push(head);
                head=head.left;
            }else{
                head=stack.pop();
                System.out.println(head.value);
                head=head.right;
            }
        }
        System.out.println();
    }

    public static void postTraverseUnRecur(TreeNode root){
        if(root==null){
            return ;
        }
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode cur=s1.pop();
            s2.push(cur);
            if(cur.left!=null){
                s2.push(cur.left);
            }
            if (cur.right!=null){
                s2.push(cur.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
        System.out.println();
    }





}
