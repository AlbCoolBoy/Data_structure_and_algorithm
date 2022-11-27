package leetcode.book;

/**
 * <h3>Data structure and algorithm</h3>
 * <p></p>
 *
 * @author : ALB
 * @date : 2022-11-26 16:00
 **/
//返回二叉树的最小深度
public class GetMinDepth {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value=value;
        }

    }


    public static int getMinDepth(Node root){
        if(root==null){
            return 0;
        }
        return process(root,1);
    }

    private static int process(Node cur, int level) {
        if(cur.right==null&&cur.left==null){
            return level;
        }
        int ans=Integer.MAX_VALUE;
        if(cur.left != null){
            ans=Math.min(ans,process(cur.left,level+1));
        }
        if(cur.right != null){
            ans=Math.min(ans,process(cur.right,level+1));
        }
        return ans;
    }

}
