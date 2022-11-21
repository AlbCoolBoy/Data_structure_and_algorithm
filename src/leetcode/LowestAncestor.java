package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/*
 * 给定两个二叉树中的节点node1和node2找出他们的最低的公共祖先节点*/
public class LowestAncestor {
    public static class Node {
        public int value;
        ;
        public Node left;
        public Node right;
    }

    public LowestAncestor(int value) {
        value = value;
    }

    /*找到最低的公共祖先节点，使用最简单的方式实现*/
    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        HashMap<Node, Node> fatherMap = new HashMap<Node, Node>();  //存放节点和他的父节点的映射表
        fatherMap.put(head,head);//默认头节点的父节点是自己
        process(head, fatherMap);
        HashSet<Node> set1=new HashSet<Node>();
        set1.add(o1);
        Node cur=o1;
         while(cur!=fatherMap.get(cur)){    //只有头节点才会出现父节点等于自己的情况
             set1.add(cur);
             cur=fatherMap.get(cur); //cur向上移动
        }
         set1.add(head);


         Node cur2=o2;
         while(!set1.contains(cur2)){
             cur2=fatherMap.get(cur2); //cur2继续向上移动
         }
         return cur2;
    }

    public static void process(Node head, HashMap<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.right, head);
        fatherMap.put(head.left, head);
        process(head.left, fatherMap);  //去左子树处理
        process(head.right, fatherMap); //去右子树处理
    }


    /*使用递归解决 P8 1:38:12 很难理解*/
    public static Node lowestAncestor2(Node head,Node o1,Node o2) {
        if(head==null||head==o1||head==o2){     //这里应对的情况是：o1是 o2的祖先节点或者o2是o1的祖先节点，则直接返回自身即可
            return head;
        }
        Node left=lowestAncestor2(head.left,o1,o2);
        Node right=lowestAncestor2(head.right,o1,o2);
        if(left!=null&&right!=null){
            return head;
        }
        return left!=null?left:right;
    }
}
