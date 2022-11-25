package datastruct.Heap;
/*问题背景：
* 输入：
* 正数数组costs
* 正数数组profiles
* 正数k
* 正数m 初始资金
* 含义：
* cost[i]表示i号项目的花费
* profits[i]表示i号项目再扣除花费之后还能挣到的钱，也就是利润
* k表示只能穿行的最多做k个项目
* 说明：
* 没做完一个项目，马上获得的收益，可以支持去做下一个项目
* 输出：最后获得的最大钱数*/

import java.util.Comparator;
import java.util.PriorityQueue;

/*该题的思路非常的巧妙，创建一个小根堆，根据项目的花费进行排序
* 创建一个大根堆，根据项目能够获得的收益进行排序
* 先将小根堆中能够付得起成本的项目解锁，将其放进大根堆中，然后按照大根堆中的顺序开始做项目
* 就能够再指定的项目数内，不仅能够成功的开始项目，话能够获得最大的收益*/
public class IPO {
    public static class Program{
        public int p;   //利润
        public int c;   //成本

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static int findMaxProfit(int k,int m,int[] Profit,int[] Cost) {
        PriorityQueue<Program> minCostQueue=new PriorityQueue<Program>(new MinCostComparator());         //按照成本排序的小根堆
        PriorityQueue<Program> maxProfitQueue=new PriorityQueue<Program>(new MaxProfitComparator());    //按照利润排序的大根堆
        for (int i = 0; i < Profit.length; i++) {
            minCostQueue.add(new Program(Profit[i],Cost[i]));
        }

        for (int i=0;i<k;i++){
            while(!minCostQueue.isEmpty()&&minCostQueue.peek().c<m){
                maxProfitQueue.add(minCostQueue.poll());
            }
            if(maxProfitQueue.isEmpty()){   //小根堆中成本最小的项目都干不了，直接返回启动资金
                return m;
            }
            m+=maxProfitQueue.poll().p;
        }
        return m;
    }

    public static class MinCostComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.c-o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o2.p-o1.p;
        }
    }
}
/*大根堆与小根堆结合使用的一个非常典型的例子，另一个例子是寻找中位数*/
