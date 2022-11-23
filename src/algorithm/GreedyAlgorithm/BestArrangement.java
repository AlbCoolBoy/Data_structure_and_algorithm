package algorithm.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

//问题背景
// 问题背景
// 一些项目需要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲
// 给你每一个项目开始的时间和结束的时间（给定一个数组，里面是一个个具体的项目）
// 安排宣讲的日程，要求会议室进行宣讲的场次最多，返回这个最多的宣讲场次
public class BestArrangement {
    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    //写一个比较器，根据会议的结束时间进行排序
    public static class ProgramComparator implements Comparator<Program>{
        public int compare(Program p1,Program p2){
            return p1.end - p2.end;
        }
    }

    /*贪心算法的实现*/
    public static int bestArrangement(Program[] programs){
        if(programs.length==0){
            return 0;
        }
        Arrays.sort(programs, new ProgramComparator()); //已经将所有的项目按照结束时间进行排序了
        int timeLine=0;
        int result=0;
        for (int i = 0; i < programs.length; i++) {
            if(timeLine<programs[i].start){
                result++;
                timeLine=programs[i].end;
            }
        }
        return result;
    }
}

