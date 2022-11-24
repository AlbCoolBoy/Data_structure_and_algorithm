package algorithm.GreedyAlgorithm;

import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

public class LessMoneySplitGold {
    public static int lessMoney(int[] arr){
        //创建一个小根堆并将数组中的元素全部放进去,也是一种利用哈夫曼树的思想
        PriorityQueue<Integer> pQ=new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum=0;
        int cur=0;
        while (pQ.size()>0){
            cur=pQ.poll()+pQ.poll();
            sum+=cur;
            pQ.add(cur);
        }
        return sum;
    }
}
