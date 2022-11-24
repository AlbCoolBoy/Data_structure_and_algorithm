package datastruct.Graph;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//图的深度优先遍历
public class DFS {
    public static void DFS(Node node){
        if(node==null) return;
        Stack<Node> stack = new Stack<Node>();
        HashSet<Node> set = new HashSet<Node>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            for (Node next : cur.nexts) {
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
