package datastruct.Graph;

import java.util.ArrayList;

/*图数据结构中点的结构*/
public class Node {
    public int value;
    public int in;  //入度
    public int out; //出度
    public ArrayList<Node> nexts;   //从自己出发相邻的点
    public ArrayList<Edge> edges;  //自己节点链接的边

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }
}
