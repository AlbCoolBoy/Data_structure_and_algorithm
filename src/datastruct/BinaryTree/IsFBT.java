package datastruct.BinaryTree;

/*判断给定二叉树是否是满二叉树*/
/*树形DP就是个套路*/
public class IsFBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    /*方法一：使用树型DP求解，这是这类题型中非常重要的套路*/
    public static boolean isFull1(Node head) {
        if (head == null) {
            return true;
        }
        Info1 info = process(head);
        return (1 << info.height) - 1 == info.nodes;
    }

    /*用于收集需要的信息，总共两个，二叉树的高度和总共的节点的数量*/
    public static class Info1 {
        public int height;  //二叉树的最大高度
        public int nodes;   //节点数量

        public Info1(int height, int nodes) {
            height = height;
            nodes = nodes;
        }
    }

    public static Info1 process(Node head) {
        if (head == null) {
            return new Info1(0, 0);
        }
        Info1 leftInfo = process(head.left);
        Info1 rightInfo = process(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info1(height, nodes);
    }

    /*方法2：收集以下信息
    * 1、收集子树是否都是满二叉树
    * 2、收集子高度
    * 3、如果左子树满&右子树满&左右子树高度相同->是满二叉树*/
    public static boolean isFull2(Node head) {
        if(head==null) {
            return true;
        }
        return process2(head).isFull;
    }
    public static class Info2{
        public boolean isFull;
        public int height;

        public Info2(boolean isFull, int height){
            isFull = isFull;
            height =height;
        }
    }

    public static Info2 process2(Node head) {
        if(head==null){
            return new Info2 (true,0);
        }
        Info2 leftInfo=process2(head.left);
        Info2 rightInfo=process2(head.right);
        boolean isFull= leftInfo.isFull&&rightInfo.isFull&&leftInfo.height==rightInfo.height;
        int height=Math.max(leftInfo.height,rightInfo.height)+1;
        return new Info2(isFull,height);
    }






    /*****************************************************************************************************************************/
    /*for test*/
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }
    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);


    }
    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isFull1(head) != isFull2(head)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }



}
