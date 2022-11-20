package datastruct.BinaryTree;

import java.util.Stack;


/*主要写了三种遍历的非递归版本，递归版本太简单了*/
public class TreeNode<V> {
    V value;
    TreeNode right;
    TreeNode left;

    //使用非递归的方式进行二叉树的前序遍历
    //先将头节点入栈，然后将其弹出并且打印
    //弹出的同时分别将头节点的右孩子和左孩子入栈，进行while循环
    public static void preOrderUnRecursive(TreeNode<Integer> head) {
        if (head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    //后序遍历的非递归方式
    public static void posOrderUnRecursive(TreeNode<Integer> head) {
        if (head == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();   //设置一个收集栈
        stack1.add(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack2.push(head.left);
            }
            if (head.right != null) {
                stack2.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value + " ");
        }
        System.out.println();
    }

    //中序遍历的非递归方式,先将二叉树的左子树全部进栈
    public static void inoederUnRecursive(TreeNode<Integer> head) {
        if (head == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()||head!=null) {
            if(head.left != null){
                stack.push(head.left);
                head=head.left;
            }else{
                head=stack.pop();
                System.out.println(head.value + " ");
                head=head.right;
            }
        }
    }

}
