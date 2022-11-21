package datastruct.Graph;

//图中边的数据定义，有权重、从哪个点出来，到哪个点去
public class Edge {
    public int weight;
    public Node from;   //当前的边从哪个节点出来
    public Node to;    //当前的边指向哪个节点

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
