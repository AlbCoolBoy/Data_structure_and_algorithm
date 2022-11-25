package algorithm.Classical;

//N皇后问题
//这里使用位图的方式来解决，也就是将二进制数中的0和1视为能够放置皇后
public class NQueens {
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        //如果是n皇后问题，那么limit的最右n个都是1，其他的都是0
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit, 0, 0, 0);
    }

    public static int process(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));   //能够放置皇后的位置全部为1
        int mostRightOne=0;
        int res=0;
        while(pos!=0){
            mostRightOne=pos&(~pos+1);//将一个二进制数中最右侧的1提取出来
            // 每次都从最右边的1开始放置，也就是最右边的能够放置皇后的位置开始放置皇后
            //之所以如此是因为有现成的方法能够一直将最右边的位置找出来，也就是计算二进制数最右边的1
            pos=pos-mostRightOne;
            res+=process(limit,colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);

        }
    return res;
    }
    public static void main(String[] args) {
        int n = 17;

        long start = System.currentTimeMillis();
        System.out.println(num2(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");


    }
}
